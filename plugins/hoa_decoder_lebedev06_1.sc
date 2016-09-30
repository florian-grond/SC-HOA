FaustHOADecLebedev061 : MultiOutUGen
{
  *ar { | in1, in2, in3, in4, mute_0(0.0), mute_1(0.0), mute_2(0.0), mute_3(0.0), mute_4(0.0), mute_5(0.0), inputs_gain_5(0.0), outputs_gain_5(0.0), yes_5(0.0), speakers_radius_5(1.07) |
      ^this.multiNew('audio', in1, in2, in3, in4, mute_0, mute_1, mute_2, mute_3, mute_4, mute_5, inputs_gain_5, outputs_gain_5, yes_5, speakers_radius_5)
  }

  *kr { | in1, in2, in3, in4, mute_0(0.0), mute_1(0.0), mute_2(0.0), mute_3(0.0), mute_4(0.0), mute_5(0.0), inputs_gain_5(0.0), outputs_gain_5(0.0), yes_5(0.0), speakers_radius_5(1.07) |
      ^this.multiNew('control', in1, in2, in3, in4, mute_0, mute_1, mute_2, mute_3, mute_4, mute_5, inputs_gain_5, outputs_gain_5, yes_5, speakers_radius_5)
  } 

  checkInputs {
    if (rate == 'audio', {
      4.do({|i|
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
      ^this.initOutputs(6, rate)
  }

  name { ^"FaustHOADecLebedev061" }
}

