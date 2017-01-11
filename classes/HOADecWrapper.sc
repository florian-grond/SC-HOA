HOADecWrapper{
// classvar <hrirFilters;

	*ar {  |decoderName, in, input_gains = 0, output_gains = 0|

		var order;

		order = decoderName.order;

		case{order == 1}
                		{ var in1, // declare variables for the b-format array
			                    in2, in3, in4, decoded;
                               #in1, // distribute the channels from the array
			                     in2, in3, in4 = in;
			              decoded = decoderName.ar(in1, // return the Ugen
				                                            in2, in3, in4,
				                                            inputs_gain_5: input_gains, outputs_gain_5: output_gains );


		}
		       {order == 2}
                		{var in1, // declare variables for the b-format array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9, decoded;
                             #in1, // distribute the channels from the array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9 = in;
			              decoded = decoderName.ar(in1,
				                                            in2, in3, in4,
				                                            in5, in6, in7, in8, in9,
				                                              inputs_gain_11: input_gains, outputs_gain_11: output_gains);


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
			             decoded = decoderName.ar(in1,  // return the Ugen
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                            inputs_gain_19: input_gains, outputs_gain_19: output_gains);


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
			             decoded = decoderName.ar(in1,  // return the Ugen
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           inputs_gain_29: input_gains, outputs_gain_29: output_gains);


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
			             decoded = decoderName.ar(in1,  // return the Ugen
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36,
				                                            inputs_gain_41: input_gains, outputs_gain_41: output_gains);


		}
				{"this order is not implemented".postln}
	}

}