HOAEncEigenMike{

	classvar <radialFilters;
	classvar <>grid;

	*initClass {
		grid =
		[ // azimuth of the capsule position
			[	0,
				0.5535743589,
				0,
				5.729610948,
				0,
				0.7853981634,
				1.205932499,
				0.7853981634,
				0,
				5.497787144,
				5.077252808,
				5.497787144,
				1.570796327,
				1.570796327,
				1.570796327,
				1.570796327,
				3.141592654,
				3.695167012,
				3.141592654,
				2.588018295,
				3.141592654,
				3.926990817,
				4.347525152,
				3.926990817,
				3.141592654,
				2.356194490,
				1.935660155,
				2.356194490,
				4.712388980,
				4.712388980,
				4.712388980,
				4.712388980,
			],
			[ // elevation of the capsule position
				0.3648638281,
				0,
				-0.3648638281,
				0,
				1.017221968,
				0.6154797087,
				0,
				-0.6154797087,
				-1.017221968,
				-0.6154797087,
				0,
				0.6154797087,
				1.205932499,
				0.5535743589,
				-0.5535743589,
				-1.205932499,
				0.3648638281,
				0,
				-0.3648638281,
				0,
				1.017221968,
				0.6154797087,
				0,
				-0.6154797087,
				-1.017221968,
				-0.6154797087,
				0,
				0.6154797087,
				1.205932499,
				0.5535743589,
				-0.5535743589,
				-1.205932499,
			]
		]
	}


	*loadRadialFilters { |server|
		var path;

		if(radialFilters.notNil) { ^radialFilters };
		HOA.pr_checkServerBooted(server);

		path = HOA.kernelsDir +/+ "FIR" +/+ "spherical_microphones" +/+ "jconvolver_mic_eigenmike32";
		radialFilters = 5.collect { |index|
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
                		{var in1,   in2,   in3,   in4,   in5,   in6,   in7,   in8,   in9, in10,
			                   in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                   in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                   in31, in32, encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                    in31, in32 = in;

			                    encoded= HOAEncEigenMike1.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
				                                                                      in31, in32,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncEigenMike.loadRadialFilters)".postln; ^encoded},

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
			                   in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                   in31, in32, encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                    in31, in32 = in;

			                    encoded= HOAEncEigenMike2.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
				                                                                      in31, in32,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncEigenMike.loadRadialFilters)".postln; ^encoded},

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
			                   in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                   in31, in32, encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                    in31, in32 = in;

                                encoded= HOAEncEigenMike3.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
				                                                                      in31, in32,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncEigenMike.loadRadialFilters)".postln; ^encoded},

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
               {order == 4}
                		{var   in1,   in2,   in3,   in4,   in5,   in6,   in7,   in8,   in9, in10,
			                   in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                   in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                   in31, in32, encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                    in31, in32 = in;

			                    encoded= HOAEncEigenMike4.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
				                                                                      in31, in32,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncEigenMike.loadRadialFilters)".postln; ^encoded},

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
						                 Convolution2.ar(  encoded[15], 	radialFilters[3], 0, 4096, 1),
								         Convolution2.ar(  encoded[16], 	radialFilters[4], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[17], 	radialFilters[4], 0, 4096, 1),
		                                 Convolution2.ar(  encoded[18], 	radialFilters[4], 0, 4096, 1),
								         Convolution2.ar(  encoded[19], 	radialFilters[4], 0, 4096, 1),
								         Convolution2.ar(  encoded[20], 	radialFilters[4], 0, 4096, 1),
						                 Convolution2.ar(  encoded[21], 	radialFilters[4], 0, 4096, 1),
									     Convolution2.ar(  encoded[22], 	radialFilters[4], 0, 4096, 1),
									     Convolution2.ar(  encoded[23], 	radialFilters[4], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[24], 	radialFilters[4], 0, 4096, 1)]}
				          )
				}
			   )
			}
		       {"this order is not implemented".postln}
	}

}
