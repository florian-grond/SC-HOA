FaustHOADecLebedev502 : MultiOutUGen
{
  *ar { | in1, in2, in3, in4, in5, in6, in7, in8, in9, mute_0(0.0), mute_1(0.0), mute_2(0.0), mute_3(0.0), mute_4(0.0), mute_5(0.0), mute_6(0.0), mute_7(0.0), mute_8(0.0), mute_9(0.0), mute_10(0.0), mute_11(0.0), inputs_gain_11(0.0), outputs_gain_11(0.0), yes_11(0.0), speakers_radius_11(1.07) |
      ^this.multiNew('audio', in1, in2, in3, in4, in5, in6, in7, in8, in9, mute_0, mute_1, mute_2, mute_3, mute_4, mute_5, mute_6, mute_7, mute_8, mute_9, mute_10, mute_11, inputs_gain_11, outputs_gain_11, yes_11, speakers_radius_11)
  }

  *kr { | in1, in2, in3, in4, in5, in6, in7, in8, in9, mute_0(0.0), mute_1(0.0), mute_2(0.0), mute_3(0.0), mute_4(0.0), mute_5(0.0), mute_6(0.0), mute_7(0.0), mute_8(0.0), mute_9(0.0), mute_10(0.0), mute_11(0.0), inputs_gain_11(0.0), outputs_gain_11(0.0), yes_11(0.0), speakers_radius_11(1.07) |
      ^this.multiNew('control', in1, in2, in3, in4, in5, in6, in7, in8, in9, mute_0, mute_1, mute_2, mute_3, mute_4, mute_5, mute_6, mute_7, mute_8, mute_9, mute_10, mute_11, inputs_gain_11, outputs_gain_11, yes_11, speakers_radius_11)
  } 

  checkInputs {
    if (rate == 'audio', {
      9.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  init { | ... theInputs |
      inputs = theInputs
      ^this.initOutputs(50, rate)
  }

  name { ^"FaustHOADecLebedev502" }
}

