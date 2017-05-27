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
	*loadHrirFilters {|server, path|

		path = path ?? {HOA.userKernelDir++"/FIR/hrir/hrir_lebedev50/"};

		this.hrirFilters = this.numChannels.collect({|i|	[
			Buffer.read(server, path ++"/hrir_"++(i+1)++"_L.wav"),
			Buffer.read(server, path ++"/hrir_"++(i+1)++"_R.wav")
		] });
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


		decoded = switch(order.asInt,
			1, {
				FaustHOADecLebedev061.ar(
					in[0], in[1], in[2], in[3],
					inputs_gain: input_gains,
					outputs_gain: output_gains,
					yes: yes,
					speakers_radius: speakers_radius
				);
			},
			2, {
				FaustHOADecLebedev262.ar(
					in[0], in[1], in[2], in[3], in[4],
					in[5], in[6], in[7], in[8],
					inputs_gain: input_gains,
					outputs_gain: output_gains,
					yes: yes,
					speakers_radius: speakers_radius
				);
			},
			3, {
				FaustHOADecLebedev263.ar(
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