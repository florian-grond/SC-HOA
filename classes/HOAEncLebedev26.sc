HOAEncLebedev26{

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
		0,
				// Edge : 12 Nodes
		0,
		1.5707963267949,
		3.1415926535898,
		4.7123889803847,
		0.78539816339745,
		2.3561944901924,
		3.9269908169873,
		5.4977871437822,
		0,
		1.5707963267949,
		3.1415926535898,
		4.7123889803847,
				// Face : 8 Nodes
		0.78539816339745,
		2.3561944901924,
		3.9269908169873,
		5.4977871437822,
		0.78539816339745,
		2.3561944901924,
		3.9269908169873,
		5.4977871437822

			],
			[
			    // Vertex : 6 Nodes
		1.5707963267949,
		0,
		0,
		0,
		0,
		-1.5707963267949,
			    // Edge : 12 Nodes
		0.78539816339745,
		0.78539816339745,
		0.78539816339745,
		0.78539816339745,
		0,
		0,
		0,
		0,
		-0.78539816339745,
		-0.78539816339745,
		-0.78539816339745,
		-0.78539816339745,
				// Face : 8 Nodes
		0.61547970867039,
		0.61547970867039,
		0.61547970867039,
		0.61547970867039,
		-0.61547970867039,
		-0.61547970867039,
		-0.61547970867039,
		-0.61547970867039
			]
		]

	}


	*loadRadialFilters { |server|
		var path;

		if(radialFilters.notNil) { ^radialFilters };
		HOA.pr_checkServerBooted(server);

		path = HOA.kernelsDir +/+ "FIR" +/+ "spherical_microphones" +/+ "jconvolver_mic_lebedev50";
		radialFilters = 4.collect { |index|
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

	*ar { |order, in, gain=0, filters = 1|

		in = in.asAudioRateInput;

		case{order == 1}
                		{var   in1,   in2,   in3,   in4,   in5,   in6,   in7,   in8,   in9, in10,
			                   in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                   in21, in22, in23, in24, in25, in26, encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26 = in;

			                    encoded= HOAEncLebedev261.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncLebedev26.loadRadialFilters)".postln; ^encoded},

					                {// return the encoded b-format convolved with the correct radial filter
				  	                 ^[ Convolution2.ar(  encoded[0], 	radialFilters[0], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[1], 	radialFilters[1], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[2], 	radialFilters[1], 0, 4096, 1),
							             Convolution2.ar(  encoded[3], 	radialFilters[1], 0, 4096, 1)]}
				     )
				}
			   )
			}


		       {order == 2}
                		{var   in1,   in2,   in3,   in4,   in5,   in6,   in7,   in8,   in9, in10,
			                   in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                   in21, in22, in23, in24, in25, in26, encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26 = in;

			                    encoded= HOAEncLebedev262.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncLebedev26.loadRadialFilters)".postln; ^encoded},

					                {// return the encoded b-format convolved with the correct radial filter
				  	                 ^[ Convolution2.ar(  encoded[0], 	radialFilters[0], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[1], 	radialFilters[1], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[2], 	radialFilters[1], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[3], 	radialFilters[1], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[4], 	radialFilters[2], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[5], 	radialFilters[2], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[6], 	radialFilters[2], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[7], 	radialFilters[2], 0, 4096, 1),
							             Convolution2.ar(  encoded[8], 	radialFilters[2], 0, 4096, 1)]}
				)
				}
			   )
			}



               {order == 3}
                		{var   in1,   in2,   in3,   in4,   in5,   in6,   in7,   in8,   in9, in10,
			                   in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                   in21, in22, in23, in24, in25, in26, encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26 = in;

			                    encoded= HOAEncLebedev263.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26,
				                                                                      gain: gain);
			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncLebedev26.loadRadialFilters)".postln; ^encoded},

					                {// return the encoded b-format convolved with the correct radial filter
				  	                 ^[ Convolution2.ar(  encoded[0], 	    radialFilters[0], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[1], 	    radialFilters[1], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[2], 	    radialFilters[1], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[3], 	    radialFilters[1], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[4], 	    radialFilters[2], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[5], 	    radialFilters[2], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[6], 	    radialFilters[2], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[7], 	    radialFilters[2], 0, 4096, 1),
						                 Convolution2.ar(  encoded[8], 	    radialFilters[2], 0, 4096, 1),
							             Convolution2.ar(  encoded[9], 	    radialFilters[3], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[10], 	radialFilters[3], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[11], 	radialFilters[3], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[12], 	radialFilters[3], 0, 4096, 1),
								         Convolution2.ar(  encoded[13], 	radialFilters[3], 0, 4096, 1),
								         Convolution2.ar(  encoded[14], 	radialFilters[3], 0, 4096, 1),
							             Convolution2.ar(  encoded[15], 	radialFilters[3], 0, 4096, 1)]}
				                 )
				}
			   )
			}

		       {"this order is not implemented".postln}
	}

}
