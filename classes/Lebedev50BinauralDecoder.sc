Lebedev50BinauralDecoder {
	classvar <>hrirFilters;
	classvar <numChannels;
	classvar <maxOrder;

	*initClass {
		numChannels = 50;
		maxOrder = 5;
	}

	*loadHrirFilters {|server, path|

		// make path contain something usable
		path = if (path.isNil, {
			HOA.kernelDirsFor("*lebedev50", "FIR/hrir")
		}, {
			path.pathMatch;
		}).first;

		if (path.isNil, {
			"%: specified path is nil".format(this).error;
			^this;
		});

		this.hrirFilters = this.numChannels.collect({|i|	[
			Buffer.read(server, path ++"/hrir_"++(i+1)++"_L.wav"),
			Buffer.read(server, path ++"/hrir_"++(i+1)++"_R.wav")
		] });
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