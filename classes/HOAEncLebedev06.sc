HOAEncLebedev06{

		classvar <radialFilters;
		classvar <>grid;

	*initClass {
		grid =
		[
		[
				// Vertex : 6 Nodes
		0,
		0,
		1.5707963267949,
		3.1415926535898,
		4.7123889803847,
		0
			],
			[
			    // Vertex : 6 Nodes
		1.5707963267949,
		0,
		0,
		0,
		0,
		-1.5707963267949
		]
		]

	}


	*loadRadialFilters { |server|
		var path;

		if(radialFilters.notNil) { ^radialFilters };
		HOA.pr_checkServerBooted(server);

		path = HOA.kernelsDir +/+ "FIR" +/+ "spherical_microphones" +/+ "jconvolver_mic_lebedev50";
		radialFilters = 2.collect { |index|
			Buffer.read(
				server,
				path +/+ "order_" ++ index ++ ".wav"
			)
		};
		ServerQuit.add(server: server, object: this);
	}

	*freeRadialFilters {
		radialFilters.do { |buffer|
			buffer.free
		};
		radialFilters = nil;
	}

	*doOnServerQuit { |server|
		if(radialFilters.notNil) {
			this.freeRadialFilters
		};
		ServerQuit.remove(server: server, object: this);
	}

	*ar { |order = 1, in, gain=0, filters = 1|

		in = in.asAudioRateInput;

		case{order == 1}
                		{var   in1,   in2,   in3,   in4,   in5,   in6,  encoded;

                              #in1, in2, in3, in4, in5, in6 = in;

			                    encoded= HOAEncLebedev061.ar(in1, in2, in3, in4, in5, in6,
				                                                                      gain:gain);

			in = in.asAudioRateInput;

			if(filters == 0,
				{ ^encoded },
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncLebedev06.loadRadialFilters), \n retuning unfiltered bformat".postln; ^encoded},
					                {// return the encoded b-format convolved with the correct radial filter
				  	                 ^[ Convolution2.ar(  encoded[0], 	radialFilters[0], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[1], 	radialFilters[1], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[2], 	radialFilters[1], 0, 4096, 1),
							             Convolution2.ar(  encoded[3], 	radialFilters[1], 0, 4096, 1)]}
				     )
				}
			   )
			}
		 {"this order is not implemented".postln}
	}

}
