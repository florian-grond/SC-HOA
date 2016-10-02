(
ServerOptions.devices;
s = Server.local;
// Server.supernova;
Server.scsynth;
Server.local = Server.default;
o = Server.local.options; // Get the local server's options

// o.device ="TCAT Dice EVM Platform";     // use the Eigenmike

// o.inDevice ="TCAT Dice EVM Platform";     // use the Eigenmike
// o.outDevice = "MADIface USB (23635751)"; // SatosSphere

// o.outDevice = "HDSPe MADI (23453676)"; // MetaLab

o.numInputBusChannels = 1; // Set Input to number of Mikes
o.numInputBusChannels.postln; // Post the number of input channels
o.numOutputBusChannels = 36;
o.numAudioBusChannels = 2048 * 8;
o.blockSize = 512 ;
o.numWireBufs = 1024 * 16;
o.memSize = 2.pow(18);
o.sampleRate = 48000;
// o.threads_(8);
s.makeWindow;
s.boot;

)

// monitor the signals with the scope
s.scope(50);

~order = 4;
// Pan WhiteNoise with the HOAEncPan
{HOAEncPan.ar(~order, WhiteNoise.ar(1), MouseX.kr(0, 360), MouseY.kr(-90, 90 ) )}.play

// Mirror an auditory scene with HOATransMirror
{HOATransMirror.ar(~order,  HOAEncPan.ar(~order, WhiteNoise.ar(1)), 0, 0, 0 ) }.play // original
{HOATransMirror.ar(~order,  HOAEncPan.ar(~order, WhiteNoise.ar(1)), 1, 0, 0 ) }.play // front-back flip
{HOATransMirror.ar(~order,  HOAEncPan.ar(~order, WhiteNoise.ar(1)), 0, 1, 0 ) }.play // left-right flip
{HOATransMirror.ar(~order,  HOAEncPan.ar(~order, WhiteNoise.ar(1)), 0, 0, 1 ) }.play // up-down flip

// Rotate an auditory scene around z with HOATransRotateAz
{HOATransRotateAz.ar(~order,  HOAEncPan.ar(~order, WhiteNoise.ar(1)), MouseX.kr(0, 360 ) )}.play


// Encode the signals from the Eigenmike (no radial filters)
~order = 4;
{HOAEncEigenMike.ar(~order, WhiteNoise.ar(1.0)!32, filters: 0)}.play // same noise on all 32 chans
{HOAEncEigenMike.ar(~order, {WhiteNoise.ar(1.0)}!32, filters: 0)}.play // different noise on all 32 chans

HOAEncEigenMike.loadRadialFilters(s); // load the radial filters
HOAEncEigenMike.radialFilters;

{HOAEncEigenMike.ar(~order, WhiteNoise.ar(1.0)!32, filters: 1)}.play // same noise on all 32 chans
{HOAEncEigenMike.ar(~order, {WhiteNoise.ar(1.0)}!32, filters: 1)}.play // different noise on all 32 chans


// Encode the signals from the Lebedev06 grid
~order = 1;
{HOAEncLebedev06.ar(~order, WhiteNoise.ar(1.0)!6, filters: 0)}.play
{HOAEncLebedev06.ar(~order, {WhiteNoise.ar(1.0)}!6, filters: 0)}.play

HOAEncLebedev06.loadRadialFilters(s);
HOAEncLebedev06.radialFilters;

{HOAEncLebedev06.ar(~order, WhiteNoise.ar(1.0)!6, filters: 1)}.play
{HOAEncLebedev06.ar(~order, {WhiteNoise.ar(1.0)}!6, filters: 1)}.play


// Encode the signals from the Lebedev26 grid
~order = 3;
{HOAEncLebedev26.ar(~order, WhiteNoise.ar(1.0)!26, filters: 0)}.play
{HOAEncLebedev26.ar(~order, {WhiteNoise.ar(1.0)}!26, filters: 0)}.play

HOAEncLebedev26.loadRadialFilters(s);
HOAEncLebedev26.radialFilters;

{HOAEncLebedev26.ar(~order, WhiteNoise.ar(1.0)!26, filters: 1)}.play
{HOAEncLebedev26.ar(~order, {WhiteNoise.ar(1.0)}!26, filters: 1)}.play


~order = 5;
// Encode the signals from the Lebedev50 grid
{HOAEncLebedev50.ar(~order, WhiteNoise.ar(1.0)!50, filters: 0)}.play
{HOAEncLebedev50.ar(~order, {WhiteNoise.ar(1.0)}!50, filters: 0)}.play

HOAEncLebedev50.loadRadialFilters(s);
HOAEncLebedev50.radialFilters;

{HOAEncLebedev50.ar(~order, WhiteNoise.ar(1.0)!50, filters: 1)}.play
{HOAEncLebedev50.ar(~order, {WhiteNoise.ar(1.0)}!50, filters: 1)}.play


~order = 4; // goes to order 4 only as we use the Eigenmike as input
{HOABeamDirac2Hoa.ar(~order, HOAEncEigenMike.ar(~order, {WhiteNoise.ar(10.0)}!32), MouseX.kr(0, 360), MouseY.kr(-90, 90 ), on:1   )}.play
// could we extract a monosignal?

{HOABeamHCard2Mono.ar(~order, HOAEncEigenMike.ar(~order, {WhiteNoise.ar(10.0)}!32,filters:0), MouseX.kr(0, 360), MouseY.kr(-90, 90 ), beam_order:3   )}.play
// ask Pierre about <:(_,_) output to stereo

// check this in terms of what works
~order = 3;
{HOABeamHCard2Hoa.ar(~order, HOAEncEigenMike.ar(~order, {WhiteNoise.ar(10.0)}!32), MouseX.kr(0, 360), MouseY.kr(-90, 90 ), on:1   )}.play

~order = 1;
{HOADecLebedev06.ar(~order, HOAEncPan.ar(~order, WhiteNoise.ar(1), MouseX.kr(0, 360), MouseY.kr(-90, 90 ) ))}.play
HOADecLebedev06.loadHrirFilters(s);
HOADecLebedev06.hrirFilters;
~order = 1;
{HOADecLebedev06.ar(~order, HOAEncPan.ar(~order, WhiteNoise.ar(1), MouseX.kr(0, 360), MouseY.kr(-90, 90 ) ),    hrir_Filters: 1  )}.play

~order = 3;
{HOADecLebedev26.ar(~order, HOAEncPan.ar(~order, WhiteNoise.ar(1), MouseX.kr(0, 360), MouseY.kr(-90, 90 ) ))}.play
HOADecLebedev26.loadHrirFilters(s);
HOADecLebedev26.hrirFilters;
~order = 3;
{HOADecLebedev26.ar(~order, HOAEncPan.ar(~order, WhiteNoise.ar(1), MouseX.kr(0, 360), MouseY.kr(-90, 90 ) ),    hrir_Filters: 1  )}.play


~order = 5;
{HOADecLebedev50.ar(~order, HOAEncPan.ar(~order, WhiteNoise.ar(1), MouseX.kr(0, 360), MouseY.kr(-90, 90 ) ))}.play
HOADecLebedev50.loadHrirFilters(s);
HOADecLebedev50.hrirFilters;
~order = 2;
{HOADecLebedev50.ar(~order, HOAEncPan.ar(~order, WhiteNoise.ar(1), MouseX.kr(0, 360), MouseY.kr(-90, 90 ) ),    hrir_Filters: 1  )}.play



~orchestra = Buffer.read(s, "/Users/floriangrond/pool/eigen_ACN_N3D_092216_140414_piano.wav");

(
var order = 3;
{HOADecLebedev26.ar(order,
	     HOABeamDirac2Hoa.ar(order,
		                      HPF.ar(
			                    PlayBuf.ar(16, ~orchestra, 1, loop:1 ),
			                      200),
		                       Lag.ar(K2A.ar(MouseX.kr( 0, 360)), 0.5),
		                       Lag.ar(K2A.ar(MouseY.kr(-90, 90 )), 0.5)
		                        , on: 1 ),
	hrir_Filters: 1  )
	}.play;
)



{HOADecLebedev26.ar(~order, HOAEncPan.ar(~order, WhiteNoise.ar(1), MouseX.kr(0, 360), MouseY.kr(-90, 90 ) ),    hrir_Filters: 1  )}.play;



(
{
~order = 3;
~numFlies = 3;
~flyVoices = {arg i;350 + (i * 40) }!~numFlies;
~flyAz = {arg i; (i+1) * 0.1 }!~numFlies;
~flyEle = {arg i; (i+1) * 0.1 }!~numFlies;
~flyDist = {arg i; (i+1) * 0.1 }!~numFlies;
~bForm = HOAEncPan.ar(~order, // Ambisonics order
	                   Saw.ar(~flyVoices, mul: 0.1),  // pitch of the flies
	                   LFSaw.ar(~flyAz,0, 360),  // azimut speed of the flies
	                   SinOsc.ar(~flyEle,0, -180, 90),  // elevation speed of the flies
		              plane_spherical:1,
                      radius:SinOsc.ar(~flyDist,0, 5, 6)
	                ).sum;  // sum all b formats together
HOADecLebedev26.ar(~order, ~bForm,    hrir_Filters: 1  )

}.play
)




HOADecLebedev06.loadHrirFilters(s)
HOADecLebedev06.hrirFilters

HOADecLebedev26.loadHrirFilters(s)
HOADecLebedev26.hrirFilters

HOADecLebedev50.loadHrirFilters(s)
HOADecLebedev50.hrirFilters

HOAEncLebedev06.loadRadialFilters(s)
HOAEncLebedev06.radialFilters

HOAEncLebedev26.loadRadialFilters(s)
HOAEncLebedev26.radialFilters

HOAEncLebedev50.loadRadialFilters(s)
HOAEncLebedev50.radialFilters

HOAEncEigenMike.loadRadialFilters(s);
HOAEncEigenMike.radialFilters;



~hoaPan = NodeProxy.new(s,\audio, 25);
~hoaPan.fadeTime = 0.2; // seconds
~hoaPan.source ={ HOAPan.ar(~order, WhiteNoise.ar(1), MouseX.kr(-180, 180 ), MouseY.kr(-90, 90 ) ) };

~hoaRotate = NodeProxy.new(s,\audio, 25);
~hoaRotate.fadeTime = 0.2; // seconds
~hoaRotate.source = { |angle = 1| var inBus = \in.ar(0!26); HOARotateAz.ar(~order, inBus,  angle )  };


~shDecode = NodeProxy.new(s, \audio, 25); // ATTENTION HERE WE HAVE ONLY 16 or 25 3rd or 4th order busses
~shDecode.source = { |lf_hf = 0, xover = 400, gain = 0| var in; in = \in.ar(0!25);
	FaustSato4allrad2Band.ar(
		in[0],in[1],in[2],in[3],in[4],in[5],in[6],in[7],in[8],in[9],in[10],in[11],in[12],in[13],in[14],in[15],in[16],in[17],in[18],in[19],in[20],in[21],in[22],in[23],in[24],
		gain:gain,	lf_hf: lf_hf, xover: xover) };

~octagonOut = NodeProxy.new(s, \audio, 8);
~octagonOut.play( out:0, numChannels:8, vol:1.0);
	~octagonOut.source = {|vol = 1| var inBus; inBus = \in.ar(0!32);  inBus.collect({|item, i|  Limiter.ar(HPF.ar(inBus[i],80), 0.6, 0.1) }) }; s.sync; //
~octagonOut.set(\vol, 0.5);
