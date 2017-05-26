HOADecLebedev06{
classvar <hrirFilters;

		*loadHrirFilters {|server|
		hrirFilters = 6.collect({|i|	[Buffer.read(server, HOA.userKernelDir++"/FIR/hrir/hrir_lebedev50/"++"hrir_"++(i+1)++"_L.wav"),
			                                     Buffer.read(server, HOA.userKernelDir++"/FIR/hrir/hrir_lebedev50/"++"hrir_"++(i+1)++"_R.wav")] });
	}

	*ar { |order, in, input_gains = 0, output_gains = 0, yes = 1, speakers_radius = 1, hrir_Filters = 0|
		case{order == 1}
                		{ var in1, // declare variables for the b-format array
			                    in2, in3, in4, decoded;
                               #in1, // distribute the channels from the array
			                     in2, in3, in4 = in;
			              decoded = FaustHOADecLebedev061.ar(in1, // return the Ugen
				                                            in2, in3, in4,
				                                            inputs_gain: input_gains, outputs_gain: output_gains, yes: yes, speakers_radius: speakers_radius );

			if(hrir_Filters == 0,
				{ ^decoded},
				{if(hrirFilters == nil,{"please load the HRIR filters into buffers first (HOADecLebedev06.loadHrirFilters(s))".postln; ^decoded},
					      {// return the HRIR convolved binaural signal
						    decoded = decoded.collect({|item,i|
							                               [ Convolution2.ar(  item, 	hrirFilters[i][0], 0, 4096, 1), // left channel
								                             Convolution2.ar( item, 	hrirFilters[i][1], 0, 4096, 1)] // right channel
						                        }).sum; // sum the [[L,R],[L,R],[L,R],...[L,R]] array
						^decoded
						}
				     )
				}
			   )
		}
				{"this order is not implemented".postln}
	}

}
