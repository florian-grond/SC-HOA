HOADecLebedev50{
classvar <hrirFilters;

		*loadHrirFilters {|server|
		hrirFilters = 50.collect({|i|	[Buffer.read(server, Platform.userExtensionDir++"/HOA/FIR/hrir/hrir_lebedev50/"++"hrir_"++i++"_L.wav"),
			                                     Buffer.read(server, Platform.userExtensionDir++"/HOA/FIR/hrir/hrir_lebedev50/"++"hrir_"++i++"_R.wav")] });
	}

	*ar {  |order, in, input_gains = 0, output_gains = 0, yes = 1, speakers_radius = 1|
		case{order == 1}
                		{ var in1, // declare variables for the b-format array
			                    in2, in3, in4;
                               #in1, // distribute the channels from the array
			                     in2, in3, in4 = in;
			              ^HOADecLebedev50.ar(in1, // return the Ugen
				                                            in2, in3, in4,
				                                            inputs_gain_41: input_gains, outputs_gain_41: output_gains, yes_41: yes, speakers_radius_41: speakers_radius)}
		       {order == 2}
                		{var in1, // declare variables for the b-format array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9;
                             #in1, // distribute the channels from the array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9 = in;
			              ^HOADecLebedev50.ar(in1,
				                                            in2, in3, in4,
				                                            in5, in6, in7, in8, in9,
				                                            inputs_gain_41: input_gains, outputs_gain_41: output_gains, yes_41: yes, speakers_radius_41: speakers_radius)}
               {order == 3}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16 = in;
			             ^HOADecLebedev50.ar(in1,  // return the Ugen
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           inputs_gain_41: input_gains, outputs_gain_41: output_gains, yes_41: yes, speakers_radius_41: speakers_radius)}
               {order == 4}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16,
			                   in17, in18, in19, in20, in21, in22, in23, in24, in25;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16,
			                    in17, in18, in19, in20, in21, in22, in23, in24, in25 = in;
			             ^HOADecLebedev50.ar(in1,  // return the Ugen
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           inputs_gain_41: input_gains, outputs_gain_41: output_gains, yes_41: yes, speakers_radius_41: speakers_radius)}
               {order == 5}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16,
			                   in17, in18, in19, in20, in21, in22, in23, in24, in25,
			                   in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16,
			                    in17, in18, in19, in20, in21, in22, in23, in24, in25,
			                    in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36 = in;
			             ^HOADecLebedev50.ar(in1,  // return the Ugen
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36,
				                                            inputs_gain_41: input_gains, outputs_gain_41: output_gains, yes_41: yes, speakers_radius_41: speakers_radius)}
				{"this order is not implemented".postln}
	}

}