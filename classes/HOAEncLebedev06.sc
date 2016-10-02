HOAEncLebedev06{

		classvar <radialFilters;

	*loadRadialFilters {|server|
		radialFilters = 	[Buffer.read(server,Platform.userExtensionDir++"/HOA/FIR/spherical_microphones/jconvolver_mic_lebedev50"++"/order_0.wav"),
		                         Buffer.read(server,Platform.userExtensionDir++"/HOA/FIR/spherical_microphones/jconvolver_mic_lebedev50"++"/order_1.wav")];
	}

	*ar { |order = 1, in, gain=0, filters = 1|
		case{order == 1}
                		{var   in1,   in2,   in3,   in4,   in5,   in6,  encoded;

                              #in1, in2, in3, in4, in5, in6 = in;

			                    encoded= FaustHOAEncLebedev061.ar(in1, in2, in3, in4, in5, in6,
				                                                                      gain_5:gain);

			if(filters == 0,
				{ ^encoded},
				{if(radialFilters == nil,{"please load the radial filters into buffers first (HOAEncLebedev06.loadRadialFilters)".postln; ^encoded},

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