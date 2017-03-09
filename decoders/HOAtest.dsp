// Faust Decoder Configuration File
// Written by Ambisonic Decoder Toolbox, version 8.0
// run by fgrond on  (x86_64-apple-darwin13.0.0) at 11-Oct-2016 16:08:07

//------- decoder information -------
// decoder file = ../decoders/CIRMMT_22_2_3h3p_allrad_5200_rE_max_2_band.dsp
// speaker array name = CIRMMT_22_2
// horizontal order   = 3
// vertical order     = 3
// coefficient order  = acn
// coefficient scale  = N3D
// input scale        = N3D
// mixed-order scheme = HP
// input channel order: W Y Z X V T R S U Q O M K L N P
// output speaker order: FL FR FC BL BR FLc FRc BC SiL SiR TpFL TpFR TpC TpC TpBL TpBR TpSiL TpSiR TpBC BtFC BtFL BtFR
//-------


// start decoder configuration
declare name	"HOAtest";

// bands
nbands = 2;

// decoder type
decoder_type = 2;

// crossover frequency in Hz
xover_freq = hslider("xover [unit:Hz]",400,200,800,20): dezipper;

// lfhf_balance
lfhf_ratio = hslider("lf/hf [unit:dB]", 0, -3, +3, 0.1): mu.db2linear : dezipper;


// decoder order
decoder_order = 3;

// ambisonic order of each input component
co = ( 0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3);

// use full or reduced input set
input_full_set = 1;

// delay compensation
delay_comp = 1;

// level compensation
level_comp = 1;

// nfc on input or output
nfc_output = 0;
nfc_input  = 1;

// enable output gain and muting controls
output_gain_muting = 1;

// number of speakers
ns = 22;

// radius for each speaker in meters
rs = (          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03,          2.03);

// per order gains, 0 for LF, 1 for HF.
//  Used to implement shelf filters, or to modify velocity matrix
//  for max_rE decoding, and so forth.  See Appendix A of BLaH6.
gamma(0) = (             1,             1,             1,             1);
gamma(1) = (             1,  0.8611363116,  0.6123336207,   0.304746985);

// gain matrix
s(00,0) = (  0.0536711653, -0.0724946014, -0.0203115105,  0.0348421053, -0.0607612517,  0.0265480634,  -0.024467239, -0.0128207849, -0.0482531308,  0.0152559548,  0.0210502168,   0.015188054,  0.0051332066, -0.0086550994,  0.0163928537, -0.0692030888);
s(01,0) = (  0.0536453811,  0.0724913632, -0.0202620363,  0.0348376843,  0.0607650647, -0.0265337984, -0.0245149592, -0.0128046664, -0.0482555527, -0.0152547351, -0.0210372754, -0.0151834487,  0.0051927384, -0.0086624494,   0.016392559, -0.0692180367);
s(02,0) = (  0.0181671828,    3.5986e-06,  0.0029021015,  0.0305378159,    7.1848e-06,    -7.577e-07, -0.0185314971,  0.0061396431,  0.0321614347,    9.4409e-06,   -1.7829e-06,    -3.735e-06, -0.0057204269, -0.0245064143,  0.0075171572,  0.0317234147);
s(03,0) = (   0.096449557, -0.1009469224, -0.0434142019, -0.0933841919,  0.1171569351,  0.0411758745, -0.0377391602,  0.0463681971,  -0.009906678, -0.0526870403,  -0.050316197,  0.0157773167,  0.0149576426,  0.0126342851, -0.0079286647,  0.0698192662);
s(04,0) = (  0.0904560651,  0.0918700505, -0.0467837124, -0.0902856041, -0.1112223772, -0.0476586038, -0.0335441092,  0.0486196737, -0.0022070536,  0.0578538602,  0.0553331207, -0.0123476679,  0.0207031304,  0.0115224001, -0.0015814193,  0.0620650312);
s(05,0) = (  0.0341918702, -0.0272294073,  0.0086155951,  0.0487606379, -0.0476154576,   -0.00884645, -0.0311439407,  0.0148061348,   0.029399648, -0.0512477111, -0.0170293882,  0.0179129677, -0.0148274783, -0.0323455379,  0.0091057656,  0.0023652974);
s(06,0) = (  0.0341847952,  0.0272279374,  0.0086151221,  0.0487489377,  0.0476123239,  0.0088406934, -0.0311391359,  0.0148088664,  0.0293854265,  0.0512400278,  0.0170222633,  -0.017917784, -0.0148287727, -0.0323380232,  0.0091166286,  0.0023483518);
s(07,0) = (  0.1084054264,    9.5024e-06, -0.0355107745, -0.1548401552,  -1.14219e-05,    1.9485e-06, -0.0443763193,  0.0472971405,  0.1309031479,    7.8911e-06,   -8.1048e-06,    9.5025e-06,  0.0032571247,   0.023111028, -0.0365374581, -0.0945984204);
s(08,0) = (  0.0729744807, -0.1048626904, -0.0399771849, -0.0092198538,   0.016240347,   0.059649956, -0.0263739208,  0.0058118154, -0.0937712602,   0.076601002, -0.0101136526,  0.0128405443,  0.0193355219,  0.0008850525,  0.0514407532,  0.0193587349);
s(09,0) = (  0.0782946183,  0.1129002502, -0.0371094844, -0.0121047333, -0.0217805567, -0.0540569712, -0.0302416952,  0.0039544588, -0.1004341027, -0.0807478899,  0.0059146325, -0.0161171247,  0.0142992003,  0.0022310835,  0.0458654333,  0.0265421971);
s(10,0) = (  0.0474411871, -0.0447267582,  0.0485391087,   0.039290676, -0.0466665114, -0.0541805774,  0.0098625753,  0.0471921052, -0.0061209035, -0.0191693464, -0.0607574827, -0.0285463719, -0.0216750252,  0.0243468105, -0.0086900495,  -0.028950534);
s(11,0) = (  0.0474467845,  0.0447270139,  0.0485516467,  0.0392871184,  0.0466662423,  0.0541825022,  0.0098840953,  0.0471887167, -0.0061238118,  0.0191691736,  0.0607569627,  0.0285543175, -0.0216468475,  0.0243482809, -0.0086924307, -0.0289549314);
s(12,0) = (  0.0679816323,     2.122e-06,  0.0675394237,  0.0833514417,    3.5284e-06,     9.799e-07,   0.010395274,  0.0968878978,   0.059590477,     8.591e-07,    4.5882e-06,   -4.5754e-06, -0.0324445279,  0.0453788498,  0.0738081946,  0.0360695397);
s(13,0) = (  0.0952607878,   0.000581116,  0.1444201564,  0.0035289995, -0.0003398577,  0.0009462579,  0.1408792112,  0.0061096424, -0.0043721326,    -7.086e-05, -0.0006402669,  0.0009201378,  0.1047381846,   0.006694218, -0.0085689116,  0.0014287151);
s(14,0) = (  0.0715238991,  -0.039208255,   0.074486714, -0.0740697766,  0.0468636075, -0.0479393892,  0.0180130974, -0.0899507831,   0.030710083, -0.0317772438,  0.0601904074, -0.0259542697, -0.0294670088, -0.0485468731,  0.0380305376, -0.0013646539);
s(15,0) = (   0.058343835,  0.0247552706,  0.0597295679, -0.0666857159, -0.0358804175,  0.0282144925,  0.0127781569, -0.0803613993,  0.0382781049,  0.0326745351,  -0.044130375,  0.0122136853, -0.0247399564, -0.0425966129,  0.0502032222, -0.0120915023);
s(16,0) = (  0.0504499794, -0.0665052931,   0.045858549, -0.0067054236,  0.0108319726,   -0.07109941, -0.0006788278, -0.0069651007, -0.0533713992,  0.0376436492,  0.0124012811, -0.0236646787,  -0.028553418,  -0.002004787, -0.0630533811,  0.0114492659);
s(17,0) = (  0.0335740471,  0.0438493832,  0.0329929916,    0.00287469,  0.0057446332,  0.0509432447,  0.0042614444,  0.0019218169,  -0.037028457, -0.0296028906,  0.0044560728,  0.0235722144, -0.0169094278, -0.0012657655, -0.0473707616, -0.0080234996);
s(18,0) = (  0.0300229324,  0.0373682241,  0.0272139152, -0.0168594322, -0.0274338637,  0.0397107919, -0.0005807694, -0.0180871524, -0.0242836131, -0.0093593764, -0.0322520218,  0.0128063867, -0.0171561774, -0.0060970118, -0.0281200001,  0.0300159011);
s(19,0) = (  0.0637316778,  -1.24472e-05, -0.0561401019,  0.0839689922,  -2.33218e-05,    1.6716e-06, -0.0026014965,   -0.08502799,  0.0675867801,   -2.9809e-05,     8.027e-07,    8.9048e-06,  0.0326477444,  0.0232582794, -0.0734727131,  0.0480096699);
s(20,0) = (  0.0411776519, -0.0321784765, -0.0368904624,  0.0452705879, -0.0460672972,  0.0327099963, -0.0007728387, -0.0472562753,  0.0155037392, -0.0383739096,  0.0509660376, -0.0090675881,  0.0212504922,  0.0146994603, -0.0187820598,  -0.012637029);
s(21,0) = (  0.0412038011,  0.0321785192, -0.0369296977,  0.0452814678,  0.0460681336, -0.0327116722, -0.0007248383, -0.0472628994,  0.0155177947,  0.0383838173, -0.0509602261,  0.0090764014,  0.0211865255,  0.0147034459, -0.0187882734, -0.0126223062);


// ----- do not change anything below here ----

// mask for full ambisonic set to channels in use
input_mask(0) = bus(nc);
input_mask(1) = (_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_);


// Start of decoder implementation.  No user serviceable parts below here!
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

//declare name		"Fill in name in configuration section below";
declare version 	"1.0";
declare author 		"AmbisonicDecoderToolkit";
declare license 	"BSD 3-Clause License";
declare copyright	"(c) Aaron J. Heller 2013";

/*
Copyright (c) 2013, Aaron J. Heller
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are
met:

1. Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright
notice, this list of conditions and the following disclaimer in the
documentation and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its
contributors may be used to endorse or promote products derived from
this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/*
  Author: Aaron J. Heller <heller@ai.sri.com>
  $Id: 83d0916e8278c38a4c0bf9b5db526238004bca53 $
*/

m = library("math.lib");
mu = library("music.lib");

// m.SR from math.lib is an integer, we need a float
SR = float(m.SR);

// descriptive statistics
total(c) = c:>_;

average(c) = total(c)/count(c);

count(c) = R(c) :>_ with {
 R((c,cl)) = R(c),(R(cl));
 R(c)      = 1;
};

rms(c) = R(c) :> /(count(c)) : sqrt with {
 R((c,cl)) = R(c),R(cl);
 R(c)      = (c*c);
};

sup(c) = R(c) with {
 R((c,cl)) = max(R(c),R(cl));
 R(c)      = c;
};

inf(c) = R(c) with {
 R((c,cl)) = min(R(c),R(cl));
 R(c)      = c;
};

// bus
bus(n)   = par(i,n,_);

// bus with gains
gain(c) = R(c) with {
  R((c,cl)) = R(c),R(cl);
  R(1)      = _;
  R(0)      = !:0;  // need to preserve number of outputs, faust will optimize away
  R(float(0)) = R(0);
  R(float(1)) = R(1);
  R(c)      = *(c);
};

// fir filter  (new improved, better behaved)
fir(c) = R(c) :>_ with {
  R((c,lc)) = _<: R(c), (mem:R(lc));
  R(c)      = gain(c);
};

// --- phase-matched bandsplitter from BLaH3
xover(freq,n) = par(i,n,xover1) with {

	sub(x,y) = y-x;

	k = tan(m.PI*float(freq)/m.SR);
	k2 = k^2;
	d =  (k2 + 2*k + 1);
	//d = (k2,2*k,1):>_;
	// hf numerator
	b_hf = (1/d,-2/d,1/d);
	// lf numerator
	b_lf = (k2/d, 2*k2/d, k2/d);
	// denominator
	a = (2 * (k2-1) / d, (k2 - 2*k + 1) / d);
	//
	xover1 = _:sub ~ fir(a) <: fir(b_lf),fir(b_hf):_,*(-1);
};

shelf(freq,g_lf,g_hf) = xover(freq,1) : gain(g_lf),gain(g_hf):>_;

// from http://old.nabble.com/Re%3A--Faudiostream-devel---ANN--Faust-0.9.24-p28597267.html
//   (not used currently, do we need to worry about denormals?)
anti_denormal = pow(10,-20);
anti_denormal_ac = 1 - 1' : *(anti_denormal) : + ~ *(-1);

// UI "dezipper"
smooth(c) = *(1-c) : +~*(c);
dezipper = smooth(0.999);

// physical constants

temp_celcius = 20;
c = 331.3 * sqrt(1.0 + (temp_celcius/273.15)); // speed of sound m/s


// ---- NFC filters ----
//  see BesselPoly.m for coefficient calculations
//
// [1] J. Daniel, “Spatial Sound Encoding Including Near Field Effect:
//     Introducing Distance Coding Filters and a Viable, New Ambisonic
//     Format ,” Preprints 23rd AES International Conference, Copenhagen,
//     2003.
// [2] Weisstein, Eric W. "Bessel Polynomial." From MathWorld--A Wolfram
//     Web Resource. http://mathworld.wolfram.com/BesselPolynomial.html
// [3] F. Adriaensen, “Near Field filters for Higher Order
//     Ambisonics,” Jul. 2006.
// [4] J. O. Smith, “Digital State-Variable Filters,” CCRMA, May 2013.

// first and second order state variable filters see [4]
//   FIXME FIXME this code needs to be refactored, so that the roots are
//               passed in rather then hardwired in the code, or another
//               API layer, or ...
svf1(g,d1)    = _ : *(g) :       (+      <: +~_, _ ) ~ *(d1)                   : !,_ ;
svf2(g,d1,d2) = _ : *(g) : (((_,_,_):> _ <: +~_, _ ) ~ *(d1) : +~_, _) ~ *(d2) : !,_ ;

//  these are Bessel filters, see [1,2]
nfc1(r,gain) = svf1(g,d1)  // r in meters
 with {
   omega = c/(float(r)*SR);
   //  1  1
   b1 = omega/2.0;
   g1 = 1.0 + b1;
   d1 = 0.0 - (2.0 * b1) / g1;
   g = gain/g1;
};

nfc2(r,gain) = svf2(g,d1,d2)
 with {
   omega = c/(float(r)*SR);
   r1 = omega/2.0;
   r2 = r1 * r1;

   // 1.000000000000000   3.00000000000000   3.00000000000000
   b1 = 3.0 * r1;
   b2 = 3.0 * r2;
   g2 = 1.0 + b1 + b2;

   d1 = 0.0 - (2.0 * b1 + 4.0 * b2) / g2;  // fixed
   d2 = 0.0 - (4.0 * b2) / g2;
   g = gain/g2;
};

nfc3(r,gain) = svf2(g,d1,d2):svf1(1.0,d3)
 with {
   omega = c/(float(r)*SR);

   r1 = omega/2.0;
   r2 = r1 * r1;

   // 1.000000000000000   3.677814645373914   6.459432693483369
   b1 = 3.677814645373914 * r1;
   b2 = 6.459432693483369 * r2;
   g2 = 1.0 + b1 + b2;
   d1 = 0.0 - (2.0 * b1 + 4.0 * b2) / g2;  // fixed
   d2 = 0.0 - (4.0 * b2) / g2;

   // 1.000000000000000   2.322185354626086
   b3 = 2.322185354626086 * r1;
   g3 = 1.0 + b3;
   d3 = 0.0 - (2.0 * b3) / g3;

   g = gain/(g3*g2);
};

nfc4(r,gain) = svf2(g,d1,d2):svf2(1.0,d3,d4)
 with {
   omega = c/(float(r)*SR);

   r1 = omega/2.0;
   r2 = r1 * r1;

   // 1.000000000000000   4.207578794359250  11.487800476871168
   b1 =  4.207578794359250 * r1;
   b2 = 11.487800476871168 * r2;
   g2 = 1.0 + b1 + b2;
   d1 = 0.0 - (2.0 * b1 + 4.0 * b2) / g2;  // fixed
   d2 = 0.0 - (4.0 * b2) / g2;

   // 1.000000000000000   5.792421205640748   9.140130890277934
   b3 = 5.792421205640748 * r1;
   b4 = 9.140130890277934 * r2;
   g3 = 1.0 + b3 + b4;
   d3 = 0.0 - (2.0 * b3 + 4.0 * b4) / g3;  // fixed
   d4 = 0.0 - (4.0 * b4) / g3;

   g = gain/(g3*g2);
};

nfc5(r,gain) = svf2(g,d1,d2):svf2(1.0,d3,d4):svf1(1.0,d5)
 with {
   omega = c/(float(r)*SR);

   r1 = omega/2.0;
   r2 = r1 * r1;

   // 1.000000000000000   4.649348606363304  18.156315313452325
   b1 =  4.649348606363304 * r1;
   b2 = 18.156315313452325 * r2;
   g2 = 1.0 + b1 + b2;
   d1 = 0.0 - (2.0 * b1 + 4.0 * b2) / g2;  // fixed
   d2 = 0.0 - (4.0 * b2) / g2;

   // 1.000000000000000   6.703912798306966  14.272480513279568
   b3 =  6.703912798306966 * r1;
   b4 = 14.272480513279568 * r2;
   g3 = 1.0 + b3 + b4;
   d3 = 0.0 - (2.0 * b3 + 4 * b4) / g3;  // fixed
   d4 = 0.0 - (4.0 * b4) / g3;

   // 1.000000000000000   3.646738595329718
   b5 = 3.646738595329718 * r1;
   g4 = 1.0 + b5;
   d5 = 0.0 - (2.0 * b5) / g4;

   g = gain/(g4*g3*g2);
 };

// ---- End NFC filters ----

nfc(0,r,g) = gain(g);
nfc(1,r,g) = nfc1(r,g);
nfc(2,r,g) = nfc2(r,g);
nfc(3,r,g) = nfc3(r,g);
nfc(4,r,g) = nfc4(r,g);
nfc(5,r,g) = nfc5(r,g);

//declare name "nfctest";
//process = bus(6):(nfc(0,2,1),nfc(1,2,1),nfc(2,2,1),nfc(3,2,1),nfc(4,2,1),nfc(5,2,1)):bus(6);


// top level api to NFC filters
nfc_out(1,order,r,g) = nfc(order,r,g);
nfc_out(0,order,r,g) = _;

nfc_inp(1,order,r,g) = nfc(order,r,g);
nfc_inp(0,order,r,g) = _;



// ---- delay and level
delay(dc,r)  = R(dc,r) with {
 R(0,r) = _;  // delay_comp off
 R(1,0) = _;  // delay_comp on, but no delay
 R(1,float(0)) = R(1,0);
 R(1,r) = @(meters2samples(r));
 meters2samples(r) = int(m.SR * (float(r)/float(c)) + 0.5);
};

level(lc,r,rmax) = R(lc,r,rmax) with{
 R(0,r,rmax) = _;  // level_comp off
 R(1,r,rmax) = gain(float(r)/float(rmax));
};


delay_level(r) = R(r) with {  // delay_comp and level_comp are free variables (fix?)
 R((r,rl)) =   R(r), R(rl);
 R(r)      =   delay(delay_comp,(r_max-r)) : level(level_comp,r,r_max);
};

// ---- gates
gate(0) = !;
gate(1) = _;
dirac(i,j) = i==j;
gate_bus(order,(o,oss)) = (gate(order==o),gate_bus(order,oss));
gate_bus(order,o)       =  gate(order==o);


// route (not used)
route(n_inputs,n_outputs,outs) = m.bus(n_inputs)
                               <: par(i,n_outputs,(0,gate_bus(i,outs)):>_)
                               : m.bus(n_outputs);

//process = route(4,4,(3,1,1,2)); // test


// deinterleave
deinterleave(n,span) = par(i,n,_) <: par(i,span, par(j,n,gate(%(j,span)==i)));


// 1 band speaker chain
speaker_chain(i) = gain(s(i,0)) <: par(i,no,gate_bus(i,co):>nfc_out(nfc_output,i,m.take(i+1,rs),1.0)):>_;

// near field correction at input, nfc_input = 1
nfc_input_bus(nc) = par(i,nc, nfc_inp(nfc_input, m.take(i+1,co), r_bar, 1.0));

// per order gains
gamma_bus(n) = par(i,nc, gain( m.take(m.take(i+1,co)+1, gamma(n))));

// output gain and muting
output_gain = hslider("gain [unit:dB]", -10, -30, +10, 1): mu.db2linear :*(checkbox("mute")<0.5): dezipper;

gain_muting_bus(0,n) = bus(n);
gain_muting_bus(1,n) = par(i,n,*(output_gain));


// one band decoder
decoder(1,nc,ns) = nfc_input_bus(nc)
                :  gamma_bus(0)
                <: par(is,ns, speaker_chain(is))
                : delay_level(rs);


// two band decoder
//   there are two variants of the two-band decoder
//     1. classic, with shelf-filters and one matrix
//     2. vienna,  bandsplitting filters and separate LF and HF matricies.

// classic shelf filter decoder
decoder(2,nc,ns) = nfc_input_bus(nc)
                :  par(i,nc, shelf(xover_freq,m.take(m.take(i+1,co)+1, gamma(0))/lfhf_ratio,
                                              m.take(m.take(i+1,co)+1, gamma(1))*lfhf_ratio))
                <: par(is,ns, speaker_chain(is))
                :  delay_level(rs);

// vienna decoder
//   FIXME FIXME  need to incorporate lfhf_ratio
decoder(3,nc,ns) = bus(nc)
                   : nfc_input_bus(nc)
                   : xover(xover_freq,nc) : deinterleave(2*nc,2)
                   : (gamma_bus(0),gamma_bus(1)) : bus(2*nc)
                   <: par(j, ns, speaker_chain2(j,nc))
                   : delay_level(rs)
;
// 2 band speaker chain for vienna decoder
speaker_chain2(i,nc) = gain(s(i,0)), gain(s(i,1))
                       :> bus(nc)
                       <: par(i,no,gate_bus(i,co):>nfc_out(nfc_output,i,m.take(i+1,rs),1.0))
                       :>_ ;

//process = speaker_chain2(1,16); // test



// --------------------------------------
//  things calculated from decoder config

// maximum and average speaker distance
r_max = sup(rs);
r_bar = (rs :> float) / float(count(rs));

// number of ambisonic orders, including 0
no = decoder_order+1;

// number of input component signals
nc = count(co);



// the top-level process
process = input_mask(input_full_set):decoder(decoder_type,nc,ns):gain_muting_bus(output_gain_muting,ns);


// End of decoder implementation.  No user serviceable parts above here!
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------

//EOF!
