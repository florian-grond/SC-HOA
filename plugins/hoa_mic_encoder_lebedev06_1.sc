FaustHOAEncLebedev061 : MultiOutUGen
{
  *ar { | in1, in2, in3, in4, in5, in6, mute_0(0.0), mute_1(0.0), mute_2(0.0), mute_3(0.0), mute_4(0.0), mute_5(0.0), gain_5(0.0) |
      ^this.multiNew('audio', in1, in2, in3, in4, in5, in6, mute_0, mute_1, mute_2, mute_3, mute_4, mute_5, gain_5)
  }

  *kr { | in1, in2, in3, in4, in5, in6, mute_0(0.0), mute_1(0.0), mute_2(0.0), mute_3(0.0), mute_4(0.0), mute_5(0.0), gain_5(0.0) |
      ^this.multiNew('control', in1, in2, in3, in4, in5, in6, mute_0, mute_1, mute_2, mute_3, mute_4, mute_5, gain_5)
  } 

  checkInputs {
    if (rate == 'audio', {
      6.do({|i|
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
      ^this.initOutputs(4, rate)
  }

  name { ^"FaustHOAEncLebedev061" }
}

