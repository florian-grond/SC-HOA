(
[
	HOADecLebedev26.numChannels == 26,
	HOADecLebedev06.numChannels == 6,
	HOADecLebedev50.numChannels == 50,
	HOADecLebedev06.maxOrder == 1,
	HOADecLebedev26.maxOrder == 3,
	HOADecLebedev50.maxOrder == 5
].detectIndex{|v| v.not}.notNil.if{
	"channel/order mismatch detected.".error;
};

s.options
.numInputBusChannels_(2)
.numOutputBusChannels_(36)
.numAudioBusChannels_(2048) // default is 1024
.blockSize_(512)
.numWireBufs_(1024)
.memSize_(2**16)
.sampleRate_(48000);


// initialise everything for the tests
s.doWhenBooted{
	HOADecLebedev26.loadHrirFilters(s, "/localvol/sound/src/ambitools/FIR/hrir/hrir_christophe_lebedev50");
	HOADecLebedev06.loadHrirFilters(s, "/localvol/sound/src/ambitools/FIR/hrir/hrir_christophe_lebedev50");
	~order = 4;
	~hoaNumChannels = (~order+1).pow(2);

	s.sync;
	Ndef(\hoaSignal).fadeTime = 1;
	Ndef(\hoaSignal, {
		HOAEncoder.ar(
			~order,
			WhiteNoise.ar,
			MouseX.kr(pi, -pi), MouseY.kr(-pi * 0.5, pi * 0.5)
		)
	});

	s.sync;

	Ndef(\decoder).fadeTime = 1;
	Ndef(\decoder, {
		var in = \in.ar(0!(~hoaNumChannels));
		in
	});

	1.wait;
	Ndef(\hoaSignal) <>> Ndef(\decoder); // watch the oscilloscope
};

// reboot server (in case it was booted already, this will trigger evaluation of the above-defined doWhenBooted function
s.reboot;
)

Ndef(\decoder).scope; // scope decoder (no need to listen...)

(
Ndef(\decoder, {
	var order = 2; // reduce order to 2
	var numChans = (order+1).pow(2);
	var in = \in.ar(0!numChans);

	HOADecLebedev26.ar(order, in, hrir_Filters:1)
});
)


(
// reduce order to 1
Ndef(\decoder, {
	var order = 2; // reduce order to 2
	var numChans = (order+1).pow(2);

	var in = \in.ar(0!numChans);

	order = 1; // set order smaller than expected
	HOADecLebedev26.ar(order, in, hrir_Filters:1)
});
)

(
// expand order to more than channels provided
// results in a warning, uses maximum order possible
// reduce order to 1
Ndef(\decoder, {
	var order = 2; // reduce order to 2
	var numChans = (order+1).pow(2);

	var in = \in.ar(0!numChans);

	order = 3; // set order larger than expected
	HOADecLebedev26.ar(order, in, hrir_Filters:1)
});
)


(
// expand order and numChannels to more than possible with UGen
// results in Error
Ndef(\decoder, {
	var order = 4;
	var numChans = (order+1).pow(2);

	var in = \in.ar(0!numChans);
	HOADecLebedev26.ar(order, in, hrir_Filters:1)
});
)

//////// using HOADecLebedev06 instead of HOADecLebedev26

(
Ndef(\decoder, {
	var order = 1;
	var numChans = (order+1).pow(2);

	var in = \in.ar(0!numChans);
	HOADecLebedev06.ar(order, in, hrir_Filters:1)
});
)


/// this works also for HOADecLebedev50