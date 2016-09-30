HOADecLebedev06{
classvar <hrirFilters;

		*loadHrirFilters {|server|
		hrirFilters = 6.collect({|i|	[Buffer.read(server, Platform.userExtensionDir++"/HOA/FIR/hrir/hrir_lebedev50/"++"hrir_"++i++"_L.wav"),
			                                     Buffer.read(server, Platform.userExtensionDir++"/HOA/FIR/hrir/hrir_lebedev50/"++"hrir_"++i++"_R.wav")] });
	}

	*ar { |order, in, input_gains = 0, output_gains = 0, yes = 1, speakers_radius = 1|
		case{order == 1}
                		{ var in1, // declare variables for the b-format array
			                    in2, in3, in4;
                               #in1, // distribute the channels from the array
			                     in2, in3, in4 = in;
			              ^HOADecLebedev06.ar(in1, // return the Ugen
				                                            in2, in3, in4,
				                                            inputs_gain_5: input_gains, outputs_gain_5: output_gains, yes_5: yes, speakers_radius_5: speakers_radius )}

				{"this order is not implemented".postln}
	}

}