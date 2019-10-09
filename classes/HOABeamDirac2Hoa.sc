HOABeamDirac2Hoa{

	*ar { |order, in, az, ele, level, on = 1, timer_manual = 0, crossfade = 1, focus = 0|
		// az = az * -1; ele = ele * -1;  // the Faust Ugens seem to have those reversed
		case{order == 1}
                		{ var in1, // declare variables for the b-format array
			                    in2, in3, in4;
                               #in1, // distribute the channels from the array
			                     in2, in3, in4 = in;
			              ^HOABeamDirac2HOA1.ar(in1, // return the Ugen with the b-format channels
				                                            in2, in3, in4,
				                                            azimuth: az, elevation: ele, gain: level, on: on, timer_manual: timer_manual, crossfade: crossfade, focus: focus)} // and with the args from the *ar method
		       {order == 2}
                		{var in1, // declare variables for the b-format array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9;
                             #in1, // distribute the channels from the array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9 = in;
			              ^HOABeamDirac2HOA2.ar(in1, // return the Ugen with the b-format channels
				                                            in2, in3, in4,
				                                            in5, in6, in7, in8, in9,
				                                            azimuth: az, elevation: ele, gain: level, on: on, timer_manual: timer_manual, crossfade: crossfade, focus: focus)} // and with the args from the *ar method
               {order == 3}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16 = in;
			             ^HOABeamDirac2HOA3.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           azimuth: az, elevation: ele, gain: level, on: on, timer_manual: timer_manual, crossfade: crossfade, focus: focus)} // and with the args from the *ar method
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
			             ^HOABeamDirac2HOA4.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           azimuth: az, elevation: ele, gain: level, on: on, timer_manual: timer_manual, crossfade: crossfade, focus: focus)} // and with the args from the *ar method
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
			             ^HOABeamDirac2HOA5.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36,
				                                           azimuth: az, elevation:  ele, gain:level, on: on, timer_manual: timer_manual, crossfade: crossfade, focus: focus)} // and with the args from the *ar method
				{"this order is not implemented".postln}
	}

}