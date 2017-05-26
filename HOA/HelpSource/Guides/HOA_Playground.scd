s.quit; // quit the server first if it is still running with another configuration.
(
ServerOptions.devices;
s = Server.local;
Server.local = Server.default;
o = Server.local.options; // Get the local server's options
o.numInputBusChannels = 2; // Set Input to number of Inputs
o.numOutputBusChannels = 36; // lets start after chan 36 so as not to see the mic input
o.numAudioBusChannels = 2048;
o.blockSize = 512;
o.numWireBufs = 1024 * 16;
o.memSize = 2.pow(18);
o.sampleRate = 48000;
s.makeWindow;
s.boot;
)


(
~order = 3;
~hoaNumChannels = (~order+1).pow(2);
s.scope(~hoaNumChannels); // to monitor the b-format
// s.scope(2); // to monitor 2 binaural channels


// We pack all the proxy creation into a Routine so that we can s.sync it with assynchronous processes

Routine.run{
~hoaScene = NodeProxy.new(s, \audio, ~hoaNumChannels);
~hoaScene.source = {HOAEncoder.ar(~order, Decay.ar( Impulse.ar(1), 0.1, PinkNoise.ar(0.1) ), az: Saw.ar(0.5, pi )    )};
~hoaScene.fadeTime = 1;
s.sync;

~hoaTransformer =  RecNodeProxy.new(s, \audio, ~hoaNumChannels);
~hoaTransformer.source = {var in; in = \in.ar(0!~hoaNumChannels); in  };
~hoaTransformer.fadeTime = 2;
s.sync;

HOADecLebedev26.loadHrirFilters(s);
s.sync;

~decoder = NodeProxy.new(s, \audio, 2);
~decoder.source = {var in; in = \in.ar(0!~hoaNumChannels); Limiter.ar( HOADecLebedev26.ar(3, in, hrir_Filters:1), 1.0, 0.01   ) };
s.sync;
~decoder.fadeTime = 1;
~decoder.play(0, 2);
s.sync;

~hoaScene <>> ~hoaTransformer  <>>  ~decoder;
}
)

~hoaTransformer.open( thisProcess.platform.userHomeDir++"/HOAPlayGroundRecording.wav", "wav", "float" ); // lets record it in float
~hoaTransformer.record // start recording (paused)
~hoaTransformer.unpause // unpause
~hoaTransformer.pause // pause again
~hoaTransformer.close // close the file


~buffer2Normalize = Buffer.read(s, thisProcess.platform.userHomeDir++"/HOAPlayGroundRecording.wav");
~buffer2Normalize.normalize.write(thisProcess.platform.userHomeDir++"/HOAPlayGroundRecordingN.wav", "wav", "int16"); // and safe it as "int16" to safe space

// Distribute some sine sources in space that move slowly
~hoaScene[0] = {var freq = 53.midicps; HOAEncoder.ar(~order, SinOsc.ar(freq)  , az: LFSaw.ar(0.01, pi ), elev: LFTri.ar(0.01, pi * 0.5 )    )};
~hoaScene[1] = {var freq = 56.01.midicps; HOAEncoder.ar(~order, SinOsc.ar(freq)  , az: LFSaw.ar(0.011, pi ), elev: LFTri.ar(0.0101, pi * 0.5 )    )};
~hoaScene[2] = {var freq = 59.02.midicps; HOAEncoder.ar(~order, SinOsc.ar(freq)  , az: LFSaw.ar(0.012, pi ), elev: LFTri.ar(0.0102, pi * 0.5 )    )};
~hoaScene[3] = {var freq = 62.03.midicps; HOAEncoder.ar(~order, SinOsc.ar(freq)  , az: LFSaw.ar(0.013, pi ), elev: LFTri.ar(0.0103, pi * 0.5 )    )};

~hoaScene[0] = {HOAEncoder.ar(~order, 0.asAudioRateInput   )}; // mute each of the slots
~hoaScene[1] = {HOAEncoder.ar(~order, 0.asAudioRateInput   )}; // mute each of the slots
~hoaScene[2] = {HOAEncoder.ar(~order, 0.asAudioRateInput   )}; // mute each of the slots
~hoaScene[3] = {HOAEncoder.ar(~order, 0.asAudioRateInput   )}; // mute each of the slots

// place 3 formants in space
~hoaScene[0] = {var fundamental = 43.midicps, formantfreq =  60.midicps, bandwidth = 200; HOAEncoder.ar(~order, Formant.ar(fundamental, formantfreq, bandwidth)  , az: pi * 0.3 )};
~hoaScene[1] = {var fundamental = 51.midicps, formantfreq =  68.midicps, bandwidth = 400; HOAEncoder.ar(~order, Formant.ar(fundamental, formantfreq, bandwidth)  , az: -pi * 0.3 )};
~hoaScene[2] = {var fundamental = 59.midicps, formantfreq =  76.midicps, bandwidth = 800; HOAEncoder.ar(~order, Formant.ar(fundamental, formantfreq, bandwidth)  , az: pi  )};

// place 4 filtered noise sources in space
~hoaScene[0] = {var fundamental = 40.midicps,  bandwidth = 200; HOAEncoder.ar(~order, BPF.ar(WhiteNoise.ar(1), fundamental, 0.5) , az: pi * 0.3333 )};
~hoaScene[1] = {var fundamental = 55.midicps,  bandwidth = 400; HOAEncoder.ar(~order, BPF.ar(WhiteNoise.ar(1), fundamental, 1)  , az: -pi * 0.3333 )};
~hoaScene[2] = {var fundamental = 70.midicps,  bandwidth = 800; HOAEncoder.ar(~order, BPF.ar(WhiteNoise.ar(1), fundamental, 2)  , az: pi * 0.6666  )};
~hoaScene[3] = {var fundamental = 85.midicps,  bandwidth = 1600; HOAEncoder.ar(~order, BPF.ar(WhiteNoise.ar(1), fundamental, 3)  , az: -pi * 0.6666  )};

// transform the b-format e.g. rotation, beamforming
~hoaTransformer.source = {var in; in = \in.ar(0!~hoaNumChannels); HOATransRotateAz.ar(~order, in, MouseX.kr(-pi, pi) )  };
~hoaTransformer.source = {var in; in = \in.ar(0!~hoaNumChannels); HOABeamDirac2Hoa.ar(~order, in, MouseX.kr(pi, -pi).lag(1) )  };
~hoaTransformer.source = {var in; in = \in.ar(0!~hoaNumChannels); HOABeamDirac2Hoa.ar(~order, in, LFTri.ar(0.1, pi), LFTri.ar(0.06, pi * 0.5) )  };

~hoaTransformer.source = {var in; in = \in.ar(0!~hoaNumChannels); in  };


