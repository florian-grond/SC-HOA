HOAConvert{

	*ar { |order, in, inFormat, outFormat|
		case{order == 1}
                		{ var in1, // declare variables for the b-format array
			                    in2, in3, in4;
                               #in1, // distribute the channels from the array
			                     in2, in3, in4 = in;
			              ^FaustHOAConvert1.ar(in1, // return the Ugen with the b-format channels
				                                            in2, in3, in4,
				                                            inFormat, outFormat)} // and with the args from the *ar method
		       {order == 2}
                		{var in1, // declare variables for the b-format array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9;
                             #in1, // distribute the channels from the array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9 = in;
			              ^FaustHOAConvert2.ar(in1, // return the Ugen with the b-format channels
				                                            in2, in3, in4,
				                                            in5, in6, in7, in8, in9,
				                                            inFormat, outFormat)} // and with the args from the *ar method
               {order == 3}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16 = in;
			             ^FaustHOAConvert3.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           inFormat, outFormat)} // and with the args from the *ar method
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
			             ^FaustHOAConvert4.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           inFormat, outFormat)} // and with the args from the *ar method
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
			             ^FaustHOAConvert5.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36,
				                                           inFormat, outFormat)} // and with the args from the *ar method
				{"this order is not implemented for HOAConvert".postln}
	}

}