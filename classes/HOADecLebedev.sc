/*
2016/2017 Florian Grond
additions by Till Bovermann ( http://tai-studio.org )
*/

HOADecLebedev06 : HOADecLebedev {
	classvar <>hrirFilters;
	classvar <numChannels;
	classvar <maxOrder;

	*initClass {
		numChannels = 6;
		maxOrder = 1;
	}
}


HOADecLebedev26 : HOADecLebedev {
	classvar <>hrirFilters;
	classvar <numChannels;
	classvar <maxOrder;

	*initClass {
		numChannels = 26;
		maxOrder = 3;
	}
}


// virtual class

HOADecLebedev {
	*loadHrirFilters { |server, path|
		HOA.pr_checkServerBooted(server);
		if(this.hrirFilters.notNil) { this.freeHrirFilters };
		path = path ?? { HOA.kernelsDir +/+ "FIR" +/+ "hrir" +/+ "hrir_christophe_lebedev50" };
		this.hrirFilters = this.numChannels.collect { |chan|
			[$L, $R].collect { |side|
				Buffer.read(
					server,
					path +/+ "hrir_" ++ (chan+1) ++ "_" ++ side ++ ".wav"
				)
			}
		}
	}

	*freeHrirFilters {
		this.hrirFilters.do { |buffers|
			buffers.do { |buffer|
				buffer.free
			}
		};
		this.hrirFilters = nil;
	}

	*ar { |order, in, input_gains = 0, output_gains = 0, yes = 1, speakers_radius = 1, hrir_Filters = 0|
		var decoded;
		var maxChannels = min((order+1).squared, (this.maxOrder+1).squared);

		if(in.size < maxChannels, {
			order = in.size.sqrt - 1;
			"%.ar: in.size does not match order. Reducing order to %.".format(this.class, order).inform;
		});

		if(order > this.maxOrder, {
			"%:ar: order % is not implemented".format(this.class, order).error;
			^nil;
		});

		in = in.asAudioRateInput;

		decoded = switch(order.asInt,
			1, {
				HOADecLebedev061.ar(
					in[0], in[1], in[2], in[3],
					inputs_gain: input_gains,
					outputs_gain: output_gains,
					yes: yes,
					speakers_radius: speakers_radius
				);
			},
			2, {
				HOADecLebedev262.ar(
					in[0], in[1], in[2], in[3], in[4],
					in[5], in[6], in[7], in[8],
					inputs_gain: input_gains,
					outputs_gain: output_gains,
					yes: yes,
					speakers_radius: speakers_radius
				);
			},
			3, {
				HOADecLebedev263.ar(
					in[ 0], in[ 1], in[ 2], in[ 3],
					in[ 4], in[ 5], in[ 6], in[ 7],
					in[ 8], in[ 9], in[10], in[11],
					in[12], in[13], in[14], in[15],
					inputs_gain: input_gains,
					outputs_gain: output_gains,
					yes: yes,
					speakers_radius: speakers_radius
				);
			}
		);

		^this.pr_applyHrir(decoded);
	}

	*pr_applyHrir {|decoded, hrir_Filters|
		if (hrir_Filters == 0, {
			^decoded
		});

		if (this.hrirFilters.isNil, {
			"%: no filters loaded, ignoring hrir_Filters argument.\nLoad HRIR filters with  %.loadHrirFilters(s)".format(this.class, this.class).warn;
			^decoded
		});

		// convolve with the HRIR's
		// we end up here only, if none of the ifs above register to true
		decoded = decoded.collect{|item,i|
			[
				// left channel
				Convolution2.ar( item, this.hrirFilters[i][0], 0, 4096, 1),
				// right channel
				Convolution2.ar( item, this.hrirFilters[i][1], 0, 4096, 1)
			]
		}.sum; // sum the [[L,R],[L,R],[L,R],...[L,R]] array
		^decoded;
	}
}
