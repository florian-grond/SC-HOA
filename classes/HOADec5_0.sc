HOADec5_0{
// classvar <hrirFilters;

	*ar {  |order, in, gain = 1, lf_hf = 0, xover=400, mute=0|

		case{order == 1}
                		{ var in1, // declare variables for the b-format array
			                    in2, in3, in4, decoded;
                               #in1, // distribute the channels from the array
			                     in2, in3, in4 = in;
			              ^ITU5001.ar(in1, // return the Ugen
				                                            in2, in3, in4,
				                                            gain: gain.ampdb, lf_hf: lf_hf, mute:mute, xover:xover );

		}
		       {order == 2}
                		{var in1, // declare variables for the b-format array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9, decoded;
                             #in1, // distribute the channels from the array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9 = in;
			              ^ITU5002.ar(in1,
				                                            in2, in3, in4,
				                                            in5, in6, in7, in8, in9,
				                                            gain: gain.ampdb, lf_hf: lf_hf, mute:mute, xover:xover );

		}
               {order == 3}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16, decoded;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16 = in;
			             ^ITU5003.ar(in1,  // return the Ugen
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                            gain: gain.ampdb, lf_hf: lf_hf, mute:mute, xover:xover );


		}

               {order == 4}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16,
			                   in17, in18, in19, in20, in21, in22, in23, in24, in25, decoded;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16,
			                    in17, in18, in19, in20, in21, in22, in23, in24, in25 = in;
			             ^ITU5004.ar(in1,  // return the Ugen
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                            gain: gain.ampdb, lf_hf: lf_hf, mute:mute, xover:xover );


		}
               {order == 5}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16,
			                   in17, in18, in19, in20, in21, in22, in23, in24, in25,
			                   in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36, decoded;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16,
			                    in17, in18, in19, in20, in21, in22, in23, in24, in25,
			                    in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36 = in;
			"this order is not implemented, returning the first 5 channels of the b-format".postln;
			^[in1, in2, in3, in4, in5];


		}
				{"this order is not implemented".postln}
	}

}