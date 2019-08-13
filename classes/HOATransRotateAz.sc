HOATransRotateAz{
*ar { |order, in, az|
		case{(order == 1)     && (\HOAAzimuthRotator1.asClass.notNil)}  { ^HOAAzimuthRotator1.arBFormatInput(in, az)}
		    {(order == 2)     && (\HOAAzimuthRotator2.asClass.notNil)}  { ^HOAAzimuthRotator2.arBFormatInput(in, az)}
		    {(order == 3)     && (\HOAAzimuthRotator3.asClass.notNil)}  { ^HOAAzimuthRotator3.arBFormatInput(in, az)}
		    {(order == 4)     && (\HOAAzimuthRotator4.asClass.notNil)}  { ^HOAAzimuthRotator4.arBFormatInput(in, az)}
		    {(order == 5)     && (\HOAAzimuthRotator5.asClass.notNil)}  { ^HOAAzimuthRotator5.arBFormatInput(in, az)}
		    {"this order is not implemented for HOATransRotateAz".postln}
	}
}

// We add methods to the Ugens which distribute the b-format correctly
// so that we can call these methods in the case statement avoiding variable declaration (compiler can then inline the code)


+ HOAAzimuthRotator1 {
    *arBFormatInput {|in, az|
     ^this.ar(in[0], in[1], in[2], in[3], az)
    }
}

+ HOAAzimuthRotator2 {
    *arBFormatInput {|in, az|
     ^this.ar(in[0], in[1], in[2], in[3], in[4], in[5], in[6], in[7], in[8], az)
    }
}

+ HOAAzimuthRotator3 {
    *arBFormatInput {|in, az|
     ^this.ar(in[0], in[1], in[2], in[3], in[4], in[5], in[6], in[7], in[8], in[9], in[10], in[11], in[12], in[13], in[14], in[15], az)
    }
}

+ HOAAzimuthRotator4 {
    *arBFormatInput {|in, az|
     ^this.ar(in[0], in[1], in[2], in[3], in[4], in[5], in[6], in[7], in[8], in[9], in[10], in[11], in[12], in[13], in[14], in[15],
			  in[16], in[17], in[18], in[19], in[20], in[21], in[22], in[23], in[24], az)
    }
}

+ HOAAzimuthRotator5 {
    *arBFormatInput {|in, az|
     ^this.ar(in[0], in[1], in[2], in[3], in[4], in[5], in[6], in[7], in[8], in[9], in[10], in[11], in[12], in[13], in[14], in[15],
			  in[16], in[17], in[18], in[19], in[20], in[21], in[22], in[23], in[24], in[25], in[26], in[27], in[28], in[29], in[30], in[31], in[32], in[33], in[34], in[35], az)
    }
}


/*



Klasse {


        *new { |order ... args|
                ^this.classOfOrder(order).new(*args)
        }

        *classOfOrder { |order|
                var class = classesForOrders.at(order);
                if(class.isNil) { Error("no class for this order: %".format(order)).throw };
                ^class
        }

        classesForOrders {
                ^#[KlasseFirstOrder, KlasseSecondOrder]
        }

}










*ar { |order, in, az|
		case{order == 1}
                		{

			               var in1, // declare variables for the b-format array
			                    in2, in3, in4;
                               #in1, // distribute the channels from the array
			                     in2, in3, in4 = in;
			              ^HOAAzimuthRotator1.ar(in1, // return the Ugen with the b-format channels
				                                            in2, in3, in4,
				                                            az)
			              } // and with the args from the *ar method
		       {order == 2}
                		{var in1, // declare variables for the b-format array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9;
                             #in1, // distribute the channels from the array
			                   in2, in3, in4,
			                   in5, in6, in7, in8, in9 = in;
			              ^HOAAzimuthRotator2.ar(in1, // return the Ugen with the b-format channels
				                                            in2, in3, in4,
				                                            in5, in6, in7, in8, in9,
				                                            az)} // and with the args from the *ar method
               {order == 3}
                		{var in1, // declare variables for the b-format array
			                   in2,   in3,   in4,
			                   in5,   in6,   in7,   in8,   in9,
			                   in10, in11, in12, in13, in14, in15, in16;
                              #in1, // distribute the channels from the array
			                    in2, in3, in4,
			                    in5, in6, in7, in8, in9,
			                    in10, in11, in12, in13, in14, in15, in16 = in;
			             ^HOAAzimuthRotator3.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           az)} // and with the args from the *ar method
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
			             ^HOAAzimuthRotator4.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           az)} // and with the args from the *ar method
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
			             ^HOAAzimuthRotator5.ar(in1,  // return the Ugen with the b-format channels
				                                           in2, in3, in4,
				                                           in5, in6, in7, in8, in9,
				                                           in10, in11, in12, in13, in14, in15, in16,
				                                           in17, in18, in19, in20, in21, in22, in23, in24, in25,
				                                           in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36,
				                                           az)} // and with the args from the *ar method
				{"this order is not implemented for HOATransRotateAz".postln}
	}



*/