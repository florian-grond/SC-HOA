FaustAcnPan4 : MultiOutUGen
{
  *ar { | in1, azi(0.0), ele(0.0), test(0.0) |
      ^this.multiNew('audio', in1, azi, ele, test)
  }

  *kr { | in1, azi(0.0), ele(0.0), test(0.0) |
      ^this.multiNew('control', in1, azi, ele, test)
  } 

  checkInputs {
    if (rate == 'audio', {
      1.do({|i|
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
      ^this.initOutputs(25, rate)
  }

  name { ^"FaustAcnPan4" }
}

