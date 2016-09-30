FaustHOABeamHCard2Mono1 : MultiOutUGen
{
  *ar { | in1, in2, in3, in4, mute_0(0.0), mute_1(0.0), mute_2(0.0), mute_3(0.0), mute_4(0.0), mute_5(0.0), output_gain_5(0.0), azimuth_5(0.0), elevation_5(0.0) |
      ^this.multiNew('audio', in1, in2, in3, in4, mute_0, mute_1, mute_2, mute_3, mute_4, mute_5, output_gain_5, azimuth_5, elevation_5)
  }

  *kr { | in1, in2, in3, in4, mute_0(0.0), mute_1(0.0), mute_2(0.0), mute_3(0.0), mute_4(0.0), mute_5(0.0), output_gain_5(0.0), azimuth_5(0.0), elevation_5(0.0) |
      ^this.multiNew('control', in1, in2, in3, in4, mute_0, mute_1, mute_2, mute_3, mute_4, mute_5, output_gain_5, azimuth_5, elevation_5)
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
      ^this.initOutputs(2, rate)
  }

  name { ^"FaustHOABeamHCard2Mono1" }
}

