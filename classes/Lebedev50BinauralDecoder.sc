Lebedev50BinauralDecoder {
	classvar <hrirFilters;
	classvar <numChannels;
	classvar <maxOrder;

	*initClass {
		numChannels = 50;
		maxOrder = 5;
	}

	*loadHrirFilters { |server, path|
		HOA.pr_checkServerBooted(server);
		// if hrirFilters is not Nil, free buffers and set to Nil
		if(hrirFilters.notNil) { this.freeHrirFilters };
		path = path ?? { HOA.kernelsDir +/+ "FIR" +/+ "hrir" +/+ "hrir_christophe_lebedev50" };
		hrirFilters = numChannels.collect { |chan|
			[$L, $R].collect { |side|
				Buffer.read(
					server,
					path +/+ "hrir_" ++ (chan+1) ++ "_" ++ side ++ ".wav"
				)
			}
		}
	}

	*freeHrirFilters {
		hrirFilters.do { |buffers|
			buffers.do { |buffer|
				buffer.free
			}
		};
		hrirFilters = nil;
	}

	*ar { |in, output_gains = 0|
		var decoded;

		if(in.size < 50, {
			"need 50 input channels".inform;
		});

		if(this.hrirFilters == nil, {
			"hrirFilters are not loaded".error;
			^nil;
		});

		in = in.asAudioRateInput;

		decoded = in.collect{|item,i|
			[	// left channel
				Convolution2.ar( item, this.hrirFilters[i][0], 0, 1024, 1),
				// right channel
				Convolution2.ar( item, this.hrirFilters[i][1], 0, 1024, 1)
			]
		}.sum; // sum the [[L,R],[L,R],[L,R],...[L,R]] array
		^decoded;

	}

}
