HOADecLebedev26{
classvar <hrirFilters;

		*loadHrirFilters {|server|
		hrirFilters = 26.collect({|i|	[Buffer.read(server, Platform.userExtensionDir++"/HOA/FIR/hrir/hrir_lebedev50/"++"hrir_"++i++"_L.wav"),
			                                     Buffer.read(server, Platform.userExtensionDir++"/HOA/FIR/hrir/hrir_lebedev50/"++"hrir_"++i++"_R.wav")] });
	}

	*ar { |order, in, input_gains = 0, output_gains = 0, yes = 1, speakers_radius = 1|
		case{order == 1}
                		{ var in1, // declare variables for the b-format array
			                    in2, in3, in4;
                               #in1, // distribute the channels from the array
			                     in2, in3, in4 = in;
			              ^FaustHOADecLebedev261.ar(in1, // return the Ugen
				                                            in2, in3, in4,
				                                            inputs_gain_5: input_gains, outputs_gain_5: output_gains, yes_5: yes, speakers_radius_5: speakers_radius)}
		       {order == 2}
                		{var in1, // declare variables for the b-format array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9;
                             #in1, // distribute the channels from the array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9 = in;
			              ^FaustHOADecLebedev262.ar(in1,
				                                            in2, in3, in4,
				                                            in5, in6, in7, in8, in9,
				                                              inputs_gain_11: input_gains, outputs_gain_11: output_gains, yes_11: yes, speakers_radius_11: speakers_radius)}
               {order == 3}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16 = in;
			             ^FaustHOADecLebedev263.ar(in1,  // return the Ugen
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                            inputs_gain_19: input_gains, outputs_gain_19: output_gains, yes_19: yes, speakers_radius_19: speakers_radius)}

				{"this order is not implemented".postln}
	}

}