HOAConvert{

	*ar { |order, in, inFormat, outFormat|
		var inputFormat, outputFormat, unconverted;

		unconverted = 0;
		case{inFormat == \ACN_N3D}{inputFormat = 1}
			   {inFormat == \ACN_SN3D}{inputFormat = 2}
		       {inFormat == \FuMa}{inputFormat = 3}
		{ "not a proper input format. \n choose from \\ACN_N3D \\ACN_SN3D or \\FuMa. \n Returning b-format as is.".postln; unconverted = 1; };

		case{outFormat == \ACN_N3D}{outputFormat = 1}
			   {outFormat == \ACN_SN3D}{outputFormat = 2}
		       {outFormat == \FuMa}{outputFormat = 3}
		{ "not a proper output format. \n choose from \\ACN_N3D \\ACN_SN3D or \\FuMa. \n Returning b-format as is.".postln; unconverted = 1; };

		case{order == 1}
                		{ var in1, // declare variables for the b-format array
			                    in2, in3, in4;
                               #in1, // distribute the channels from the array
			                     in2, in3, in4 = in;
			case{unconverted == 0}
			            {  ^FaustHOAConverter1.ar(in1, // return the Ugen with the b-format channels
				                                            in2, in3, in4,
				                                            inputFormat, outputFormat)} // and with the args from the *ar method
		                { ^[in1, in2, in3, in4] };
		                }

		       {order == 2}
                		{var in1, // declare variables for the b-format array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9;
                             #in1, // distribute the channels from the array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9 = in;
			case{unconverted == 0}
			            {    ^FaustHOAConverter2.ar(in1, // return the Ugen with the b-format channels
				                                            in2, in3, in4,
				                                            in5, in6, in7, in8, in9,
				                                            inputFormat, outputFormat)} // and with the args from the *ar method
		                { ^[in1, in2, in3, in4,  in5, in6, in7, in8, in9] };
		                }

		      {order == 3}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16 = in;
			case{unconverted == 0}
                        {    ^FaustHOAConverter3.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           inputFormat, outputFormat)} // and with the args from the *ar method
		                { ^[in1, in2, in3, in4,  in5, in6, in7, in8, in9,  in10, in11, in12, in13, in14, in15, in16] };
		                }

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

	             case{unconverted == 0}
                        {    ^FaustHOAConverter4.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           inputFormat, outputFormat)  } // and with the args from the *ar method
					                { ^[in1, in2, in3, in4,  in5, in6, in7, in8, in9,  in10, in11, in12, in13, in14, in15, in16] };
		                }
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
			"order 5 is not implemented for HOAConvert,\n returning unconverted bformat.".postln;
			^[ in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25, in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36 ]
		/*
			^FaustHOAConverter5.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36,
				                                           inputFormat, outputFormat)
		*/
		} // and with the args from the *ar method
				{"this order is not implemented for HOAConvert".postln}
	}

}