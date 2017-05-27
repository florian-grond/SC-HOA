FaustITU5001 : MultiOutUGen
{
  *ar { | in1, in2, in3, in4, gain(-10.0), lf_hf(0.0), mute(0.0), xover(400.0) |
      ^this.multiNew('audio', in1, in2, in3, in4, gain, lf_hf, mute, xover)
  }

  *kr { | in1, in2, in3, in4, gain(-10.0), lf_hf(0.0), mute(0.0), xover(400.0) |
      ^this.multiNew('control', in1, in2, in3, in4, gain, lf_hf, mute, xover)
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
      ^this.initOutputs(5, rate)
  }

  name { ^"FaustITU5001" }
}

