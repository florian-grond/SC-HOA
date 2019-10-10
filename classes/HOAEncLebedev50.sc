HOAEncLebedev50{

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
		5.4977871437822,
			    // LM : 24 Nodes
		0.78539816339745,
		2.3561944901923,
		3.9269908169872,
		5.4977871437821,
		0.32175055439664,
		1.2490457723983,
		1.8925468811915,
		2.8198420991932,
		3.4633432079864,
		4.390638425988,
		5.0341395347813,
		5.9614347527829,
		0.32175055439664,
		1.2490457723983,
		1.8925468811915,
		2.8198420991932,
		3.4633432079864,
		4.390638425988,
		5.0341395347813,
		5.9614347527829,
		0.78539816339745,
		2.3561944901923,
		3.9269908169872,
		5.4977871437821
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
		-0.61547970867039,
				// LM : 24 Nodes
		1.1302856637902,
		1.1302856637902,
		1.1302856637902,
		1.1302856637902,
		0.30627736916967,
		0.30627736916967,
		0.30627736916967,
		0.30627736916967,
		0.30627736916967,
		0.30627736916967,
		0.30627736916967,
		0.30627736916967,
		-0.30627736916967,
		-0.30627736916967,
		-0.30627736916967,
		-0.30627736916967,
		-0.30627736916967,
		-0.30627736916967,
		-0.30627736916967,
		-0.30627736916967,
		-1.1302856637902,
		-1.1302856637902,
		-1.1302856637902,
		-1.1302856637902
			]
		]

	}


	*loadRadialFilters { |server|
		var path;

		if(radialFilters.notNil) { ^radialFilters };

		path = HOA.kernelsDir +/+ "FIR" +/+ "spherical_microphones" +/+ "jconvolver_mic_lebedev50";
		radialFilters = 6.collect { |index|
			Buffer.read(
				server,
				path +/+ "order_" ++ index ++ ".wav"
			)
		}
	}

	*freeRadialFilters {
		radialFilters.do { |buffer|
			buffer.free
		};
		radialFilters = nil;
	}

	*ar { |order, in, gain=0, filters = 1|

		in = in.asAudioRateInput;

		case{order == 1}
                		{var   in1,   in2,   in3,   in4,   in5,   in6,   in7,   in8,   in9, in10,
			                   in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                   in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                   in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
			                   in41, in42, in43, in44, in45, in46, in47, in48, in49, in50,
			                   encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                    in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
			                    in41, in42, in43, in44, in45, in46, in47, in48, in49, in50 = in;

			                    encoded= HOAEncLebedev501.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
				                                                                      in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
				                                                                      in41, in42, in43, in44, in45, in46, in47, in48, in49, in50,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncLebedev50.loadRadialFilters)".postln; ^encoded},

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
			                   in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
			                   in41, in42, in43, in44, in45, in46, in47, in48, in49, in50,
			                   encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                    in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
			                    in41, in42, in43, in44, in45, in46, in47, in48, in49, in50 = in;

			                    encoded= HOAEncLebedev502.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
				                                                                      in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
				                                                                      in41, in42, in43, in44, in45, in46, in47, in48, in49, in50,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncLebedev50.loadRadialFilters)".postln; ^encoded},

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
			                   in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
			                   in41, in42, in43, in44, in45, in46, in47, in48, in49, in50,
			                   encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                    in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
			                    in41, in42, in43, in44, in45, in46, in47, in48, in49, in50 = in;

			                    encoded= HOAEncLebedev503.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
				                                                                      in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
				                                                                      in41, in42, in43, in44, in45, in46, in47, in48, in49, in50,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncLebedev50.loadRadialFilters)".postln; ^encoded},

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
			                   in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
			                   in41, in42, in43, in44, in45, in46, in47, in48, in49, in50,
			                   encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                    in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
			                    in41, in42, in43, in44, in45, in46, in47, in48, in49, in50 = in;

			                    encoded= HOAEncLebedev504.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
				                                                                      in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
				                                                                      in41, in42, in43, in44, in45, in46, in47, in48, in49, in50,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncLebedev50.loadRadialFilters)".postln; ^encoded},

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
		     {order == 5}
                		{var   in1,   in2,   in3,   in4,   in5,   in6,   in7,   in8,   in9, in10,
			                   in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                   in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                   in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
			                   in41, in42, in43, in44, in45, in46, in47, in48, in49, in50,
			                   encoded;

                              #in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
			                    in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
			                    in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
			                    in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
			                    in41, in42, in43, in44, in45, in46, in47, in48, in49, in50 = in;

			                    encoded= HOAEncLebedev505.ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10,
				                                                                      in11, in12, in13, in14, in15, in16, in17, in18, in19, in20,
				                                                                      in21, in22, in23, in24, in25, in26, in27, in28, in29, in30,
				                                                                      in31, in32, in33, in34, in35, in36, in37, in38, in39, in40,
				                                                                      in41, in42, in43, in44, in45, in46, in47, in48, in49, in50,
				                                                                      gain: gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncLebedev50.loadRadialFilters)".postln; ^encoded},

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
				               			 Convolution2.ar(  encoded[24], 	radialFilters[4], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[25], 	radialFilters[5], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[26], 	radialFilters[5], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[27], 	radialFilters[5], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[28], 	radialFilters[5], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[29], 	radialFilters[5], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[30], 	radialFilters[5], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[31], 	radialFilters[5], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[32], 	radialFilters[5], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[33], 	radialFilters[5], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[34], 	radialFilters[5], 0, 4096, 1),
				               			 Convolution2.ar(  encoded[35], 	radialFilters[5], 0, 4096, 1)]}

				          )
				}
			   )
			}
		       {"this order is not implemented".postln}
	}

}
