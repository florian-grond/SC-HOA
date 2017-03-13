(
Server.local = Server.default;
o = Server.local.options;
o.numInputBusChannels = 1;
o.numOutputBusChannels = 36;
o.numAudioBusChannels = 2048 * 8;
o.memSize_(8192 * 10);
o.blockSize = 512 ;
o.numWireBufs = 1024;
o.sampleRate = 48000;
s.makeWindow;
s.boot;
s.scope(4);
)


// HOA Encoder
( ~order = 5; s.scope((~order+1).pow(2));
{HOAEncoder.ar(~order, WhiteNoise.ar(1.0),  az: MouseX.kr(-pi, pi ) , elev: MouseY.kr(-pi * 0.5, pi * 0.5) )}.play )

// HOA Rotate Az
( ~order = 2; s.scope((~order+1).pow(2));
{ HOATransRotateAz.ar(~order,  HOAEncoder.ar(~order, WhiteNoise.ar(1.0)),  MouseX.kr(-pi, pi ) )}.play )


// HOA Mirror
( ~order = 2; s.scope((~order+1).pow(2));
{ HOATransMirror.ar(~order,  HOAEncoder.ar(~order, SinOsc.ar(48000 /  512), pi * 0.25, pi * 0.25),  0 , 0 , 0 )}.play )

( ~order = 2; s.scope((~order+1).pow(2));
{ HOATransMirror.ar(~order,  HOAEncoder.ar(~order, SinOsc.ar(48000 /  512), pi * 0.25, pi * 0.25),  1 , 0 , 0 )}.play )

( ~order = 2; s.scope((~order+1).pow(2));
{ HOATransMirror.ar(~order,  HOAEncoder.ar(~order, SinOsc.ar(48000 /  512), pi * 0.25, pi * 0.25),  0 , 1 , 0 )}.play )

( ~order = 2; s.scope((~order+1).pow(2));
{ HOATransMirror.ar(~order,  HOAEncoder.ar(~order, SinOsc.ar(48000 /  512), pi * 0.25, pi * 0.25),  0 , 0 , 1 )}.play )


// HOA Rotate XYZ
( ~order = 2; s.scope((~order+1).pow(2));
{ HOATransRotateXYZ.ar(~order,  HOAEncoder.ar(~order, WhiteNoise.ar(1.0)),  LFTri.ar(0.1, 0, pi),  LFTri.ar(0.1, 0, pi),  LFTri.ar(0.1, 0, pi)  ) }.play )


// HOA Convert
~order = 2;

( s.scope((~order+1).pow(2));
{ HOAConvert.ar(~order,  HOAEncoder.ar(~order, WhiteNoise.ar(1.0)),  \ACN_N3D , \ACN_SN3D  ) }.play )

( s.scope((~order+1).pow(2));
{ HOAConvert.ar(~order,  HOAEncoder.ar(~order, WhiteNoise.ar(1.0)),  \ACN_N3D , \ACN_N3D  ) }.play )

( s.scope((~order+1).pow(2));
{ HOAConvert.ar(~order,  HOAEncoder.ar(~order, WhiteNoise.ar(1.0)),  \ACN_N3D , \FuMa  ) }.play )


// Decoding

//  HOADecLebedev06 goes up to order 1
( ~order = 1; s.scope((~order+1).pow(2));
 HOADecLebedev06.loadHrirFilters(s); )

{ HOADecLebedev06.ar( ~order, HOAEncoder.ar(1, WhiteNoise.ar(1.0)) )}.play
{ HOADecLebedev06.ar( ~order, HOAEncoder.ar(1, WhiteNoise.ar(1.0)), hrir_Filters:1 )}.play

//  HOADecLebedev26 goes up to order 3
( ~order = 1; s.scope((~order+1).pow(2));
 HOADecLebedev26.loadHrirFilters(s); )

{ HOADecLebedev26.ar( ~order, HOAEncoder.ar(1, WhiteNoise.ar(1.0)) )}.play
{ HOADecLebedev26.ar( ~order, HOAEncoder.ar(1, WhiteNoise.ar(1.0)), hrir_Filters:1 )}.play

//  HOADecLebedev06 goes up to order 5
( ~order = 1; s.scope((~order+1).pow(2));
 HOADecLebedev50.loadHrirFilters(s); )

{ HOADecLebedev50.ar( 1, HOAEncoder.ar(1, WhiteNoise.ar(1.0)) )}.play
{ HOADecLebedev50.ar( 1, HOAEncoder.ar(1, WhiteNoise.ar(1.0)), hrir_Filters:1 )}.play



// Beamforming Dirac2HOA
(~order = 3;
s.scope((~order+1).pow(2));
{ HOABeamDirac2Hoa.ar(~order,
	HOAEncLebedev50.ar(~order, {|i| SinOsc.ar( 50* (i+1) )}!50, filters: 0),
	         az: MouseX.kr(-pi, pi ) , ele: MouseY.kr(-pi * 0.5, pi * 0.5), on:1) }.play
)



// Beamforming HCardio2HOA

~order = 5; s.scope((~order+1).pow(2));

(~order = 3; // 1 to 3
~cardiodOrder = 2; // 1 to 3
{ HOABeamHCard2Hoa.ar(~order,
	                HOAEncLebedev50.ar(~order, {|i| SinOsc.ar( 50* (i+1) )}!50, filters: 0),
	                    az: MouseX.kr(-pi, pi ) , ele: MouseY.kr(-pi * 0.5, pi * 0.5), cardOrder:~cardiodOrder) }.play
)




// Beamforming HCardio2Mono

(~order = 3; // 1 to 3
{ HOABeamHCard2Mono.ar(~order,
	                HOAEncLebedev50.ar(~order, {|i| SinOsc.ar( 50* (i+1) )}!50, filters: 0),
	                    az: MouseX.kr(-pi, pi ) , ele: MouseY.kr(-pi * 0.5, pi * 0.5)) }.play
)

// Eigenmike Encoding
~order = 3;
{HOAEncEigenMike.ar(~order, WhiteNoise.ar(1.0)!32, filters: 0)}.play // same noise on all 32 chans
{HOAEncEigenMike.ar(~order, {WhiteNoise.ar(1.0)}!32, filters: 0)}.play // decorrelated noise on all 32 chans

HOAEncEigenMike.loadRadialFilters(s); // load the radial filters
HOAEncEigenMike.radialFilters;

{HOAEncEigenMike.ar(~order, WhiteNoise.ar(1.0)!32, filters: 1)}.play // same noise on all 32 chans
{HOAEncEigenMike.ar(~order, {WhiteNoise.ar(1.0)}!32, filters: 1)}.play // different noise on all 32 chans


// Lebedev 06 grid encoding
//  HOAEncLebedev06 goes up to order 1
( ~order = 1; s.scope((~order+1).pow(2));)
{HOAEncLebedev06.ar(~order, WhiteNoise.ar(1.0)!6, filters: 0)}.play // same noise on all 32 chans
{HOAEncLebedev06.ar(~order, {WhiteNoise.ar(1.0)}!6, filters: 0)}.play // decorrelated noise on all 32 chans

HOAEncLebedev06.loadRadialFilters(s); // load the radial filters
HOAEncLebedev06.radialFilters;

{HOAEncLebedev06.ar(~order, WhiteNoise.ar(1.0)!6, filters: 1)}.play // same noise on all 32 chans
{HOAEncLebedev06.ar(~order, {WhiteNoise.ar(1.0)}!6, filters: 1)}.play // different noise on all 32 chans

// Lebedev 26 grid encoding
//  HOAEncLebedev26 goes up to order 3
( ~order = 1; s.scope((~order+1).pow(2));)
{HOAEncLebedev26.ar(~order, WhiteNoise.ar(1.0)!26, filters: 0)}.play // same noise on all 32 chans
{HOAEncLebedev26.ar(~order, {WhiteNoise.ar(1.0)}!26, filters: 0)}.play // decorrelated noise on all 32 chans

HOAEncLebedev26.loadRadialFilters(s); // load the radial filters
HOAEncLebedev26.radialFilters;

{HOAEncLebedev26.ar(~order, WhiteNoise.ar(1.0)!26, filters: 1)}.play // same noise on all 32 chans
{HOAEncLebedev26.ar(~order, {WhiteNoise.ar(1.0)}!26, filters: 1)}.play // different noise on all 32 chans

// Lebedev 50 grid encoding
//  HOAEncLebedev50 goes up to order 5
( ~order = 1; s.scope((~order+1).pow(2));
{HOAEncLebedev50.ar(~order, WhiteNoise.ar(1.0)!50, filters: 0)}.play // same noise on all 32 chans
{HOAEncLebedev50.ar(~order, {WhiteNoise.ar(1.0)}!50, filters: 0)}.play // decorrelated noise on all 32 chans

HOAEncLebedev50.loadRadialFilters(s); // load the radial filters
HOAEncLebedev50.radialFilters;

{HOAEncLebedev50.ar(~order, WhiteNoise.ar(1.0)!50, filters: 1)}.play // same noise on all 32 chans
{HOAEncLebedev50.ar(~order, {WhiteNoise.ar(1.0)}!50, filters: 1)}.play // different noise on all 32 chans

