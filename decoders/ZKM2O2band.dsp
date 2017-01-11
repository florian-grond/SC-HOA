// Faust Decoder Configuration File
// Written by Ambisonic Decoder Toolbox, version 8.0
// run by floriangrond on  (x86_64-apple-darwin14.5.0) at 30-Nov-2016 15:07:19

//------- decoder information -------
// decoder file = ../decoders/ZKM_Kubus_2h2p_allrad_5200_rE_max_2_band.dsp
// speaker array name = ZKM_Kubus
// horizontal order   = 2
// vertical order     = 2
// coefficient order  = acn
// coefficient scale  = N3D
// input scale        = N3D
// mixed-order scheme = HP
// input channel order: W Y Z X V T R S U
// output speaker order: spkr0 spkr1 spkr2 spkr3 spkr4 spkr5 spkr6 spkr7 spkr8 spkr9 spkr10 spkr11 spkr12 spkr13 spkr14 spkr15 spkr16 spkr17 spkr18 spkr19 spkr20 spkr21 spkr22 spkr23 spkr24 spkr25 spkr26 spkr27 spkr28 spkr29 spkr30 spkr31 spkr32 spkr33 spkr34 spkr35 spkr36 spkr37 spkr38 spkr39 spkr40 spkr41 spkr42
//-------


// start decoder configuration
declare name	"ZKM2O2band";

// bands
nbands = 2;

// decoder type
decoder_type = 2;

// crossover frequency in Hz
xover_freq = hslider("xover [unit:Hz]",400,200,800,20): dezipper;

// lfhf_balance
lfhf_ratio = hslider("lf/hf [unit:dB]", 0, -3, +3, 0.1): mu.db2linear : dezipper;


// decoder order
decoder_order = 2;

// ambisonic order of each input component
co = ( 0, 1, 1, 1, 2, 2, 2, 2, 2);

// use full or reduced input set
input_full_set = 1;

// delay compensation
delay_comp = 1;

// level compensation
level_comp = 1;

// nfc on input or output
nfc_output = 1;
nfc_input  = 0;

// enable output gain and muting controls
output_gain_muting = 1;

// number of speakers
ns = 43;

// radius for each speaker in meters
rs = (          8.89,          9.42,          8.05,          6.31,          6.48,          7.57,         10.14,          8.97,         10.16,          7.89,          6.84,          6.72,          8.49,          9.52,          8.01,           8.7,          7.11,          5.66,           6.8,          7.85,           7.5,           7.6,          8.04,          7.02,          6.04,          7.26,          9.91,          8.06,          6.88,          6.02,          5.87,          6.58,          6.74,          5.98,          6.11,          7.08,          5.54,             5,          5.66,           5.7,          5.01,          5.52,          5.15);

// per order gains, 0 for LF, 1 for HF.
//  Used to implement shelf filters, or to modify velocity matrix
//  for max_rE decoding, and so forth.  See Appendix A of BLaH6.
gamma(0) = (             1,             1,             1);
gamma(1) = (             1,  0.7745966692,           0.4);

// gain matrix
s(00,0) = (  0.0416884146,  0.0014956688, -0.0222431515, -0.0619205039, -0.0029165329, -0.0007893481, -0.0164140619,  0.0343718447,  0.0602627729);
s(01,0) = (  0.0462854438, -0.0261281221,  -0.025817903, -0.0631334831,  0.0463963853,  0.0152634023, -0.0176559858,    0.03704432,  0.0464887386);
s(02,0) = (  0.0514336251, -0.0558921849, -0.0279984243, -0.0512074998,  0.0720056841,  0.0314804631,  -0.019957175,  0.0294208751, -0.0063999065);
s(03,0) = (  0.0666668103, -0.0957684105, -0.0247535997, -0.0238888712,  0.0438559154,  0.0343840273, -0.0281799315,  0.0067979952, -0.0821336625);
s(04,0) = (  0.0519485763, -0.0759518911, -0.0221721624,   0.015551553, -0.0295347516,  0.0320591668, -0.0223954372, -0.0063162176, -0.0687905943);
s(05,0) = (   0.043104888, -0.0505180798, -0.0224147064,  0.0393860575,  -0.060420858,  0.0271349567, -0.0171862672,  -0.021134068,    -0.0152444);
s(06,0) = (  0.0545112722, -0.0377921766, -0.0300016715,  0.0705893259, -0.0630194422,  0.0219427587, -0.0208506047, -0.0405878989,  0.0420313126);
s(07,0) = (  0.0503230737, -0.0013111714, -0.0282409746,  0.0739906706, -0.0024750286,  0.0008201096,  -0.018803208, -0.0436381276,  0.0705384324);
s(08,0) = (  0.0517268826,  0.0338352424, -0.0293114366,  0.0679725672,  0.0574069941, -0.0205011319, -0.0193495976, -0.0404536275,   0.043491544);
s(09,0) = (  0.0456406974,  0.0518727523, -0.0231430933,  0.0437603122,  0.0648384521, -0.0272246198, -0.0185916485, -0.0226242574, -0.0111051509);
s(10,0) = (  0.0485132716,  0.0702510561, -0.0221844536,  0.0173741843,  0.0327827021, -0.0322421656, -0.0205584388, -0.0078330879, -0.0620497052);
s(11,0) = (  0.0603200676,    0.08749563, -0.0283403381, -0.0172692637, -0.0321107535, -0.0415358082, -0.0252941689,  0.0078881759, -0.0780098602);
s(12,0) = (  0.0530708996,  0.0601386455, -0.0283719778, -0.0500538442, -0.0732242387, -0.0334795359, -0.0208998333,  0.0277924791, -0.0135010483);
s(13,0) = (  0.0454373624,  0.0278971431, -0.0261960971, -0.0608231705, -0.0486543287, -0.0171507115, -0.0168259129,  0.0370699602,  0.0419486184);
s(14,0) = (  0.0111234702, -0.0038046694,  0.0065072807,  -0.017391624,  0.0074817459, -0.0028813978, -0.0078736218, -0.0130027353,  0.0162981285);
s(15,0) = (  0.0088017133, -0.0075442645,  0.0049507909, -0.0120564384,  0.0131487434, -0.0053819399, -0.0064700266, -0.0086928435,  0.0063682619);
s(16,0) = (  0.0117753657, -0.0138478064,  0.0088106622, -0.0115126794,  0.0171105688, -0.0130055327, -0.0053185505, -0.0111448859, -0.0033053237);
s(17,0) = (  0.0172863279, -0.0254081734,  0.0144107921,  0.0007646917, -0.0014859078, -0.0268699957, -0.0051485107,  0.0006124677, -0.0232217816);
s(18,0) = (  0.0156944387, -0.0201483983,  0.0123462307,  0.0121789732, -0.0195037117, -0.0200951516, -0.0060876089,  0.0122527931,  -0.010274158);
s(19,0) = (  0.0107674156, -0.0100057933,  0.0064311838,  0.0139988419, -0.0164680581, -0.0075292553, -0.0073967663,  0.0107456871,  0.0055874227);
s(20,0) = (  0.0155755473, -0.0055927511,  0.0104170675,  0.0236115412, -0.0107177345,  -0.004789623, -0.0085956462,  0.0198600056,  0.0214515315);
s(21,0) = (  0.0185787953,  0.0038843711,  0.0145674555,  0.0274429044,  0.0075252975,  0.0034234691, -0.0062651643,  0.0267677312,  0.0253020533);
s(22,0) = (  0.0108010338,  0.0093161967,  0.0063002661,  0.0145904051,   0.015901055,  0.0068701955, -0.0076373661,  0.0109186504,  0.0073569075);
s(23,0) = (   0.016298206,  0.0205017503,  0.0122536932,  0.0137615312,  0.0214709147,  0.0195842083, -0.0073413832,  0.0132252519, -0.0088223406);
s(24,0) = (  0.0197748543,   0.029278855,  0.0157899354,  -0.000232086, -0.0003505438,  0.0296954292,  -0.007211946,  -0.000349598, -0.0265831827);
s(25,0) = (  0.0162803784,  0.0208244462,   0.011583671, -0.0137915625,  -0.021883168,  0.0188042723,  -0.008396328, -0.0125840932, -0.0093101754);
s(26,0) = (  0.0086186925,  0.0077016282,  0.0047411616, -0.0116564583, -0.0132514089,  0.0053986686, -0.0064786537, -0.0082125761,  0.0056474852);
s(27,0) = (  0.0132916865,  0.0036009524,  0.0088660759, -0.0204586279, -0.0071051439,  0.0028158411, -0.0076918257, -0.0173801606,  0.0191788148);
s(28,0) = (  0.0241129649, -0.0086747996,  0.0247686943, -0.0304668702,  0.0131421368, -0.0111223377,  0.0023830152, -0.0397240836,  0.0208738066);
s(29,0) = (  0.0241750722, -0.0264298389,  0.0274858433, -0.0136279221,   0.018256732,  -0.037656978,  0.0091164429, -0.0195288844, -0.0130929411);
s(30,0) = (   0.022345416, -0.0240345709,  0.0273112476,  0.0089436722, -0.0115483254, -0.0372140811,  0.0129968442,  0.0137830792, -0.0132485424);
s(31,0) = (  0.0130211087, -0.0101658494,  0.0134214026,  0.0143795198, -0.0140467182, -0.0134518026,  0.0012959208,  0.0187861561,  0.0050971776);
s(32,0) = (  0.0132075414,  0.0101776619,  0.0133450691,  0.0149152693,  0.0143708214,  0.0131946374,  0.0007069341,  0.0191185402,  0.0057385498);
s(33,0) = (  0.0234029587,  0.0253846339,  0.0281625559,  0.0099863085,  0.0130133084,  0.0385909619,  0.0125091749,  0.0151884523, -0.0139661989);
s(34,0) = (  0.0224012006,  0.0241957177,  0.0264347312,  -0.011353916, -0.0148090202,  0.0360687771,  0.0105939223, -0.0169974202, -0.0123410995);
s(35,0) = (  0.0183060578,  0.0108152235,  0.0186327453, -0.0220563365, -0.0160337319,  0.0137944436,   0.001306494, -0.0286420637,  0.0121361219);
s(36,0) = (  0.0183814917, -0.0070874513,  0.0271096194, -0.0134038505,  0.0065879016, -0.0131374139,  0.0245131146, -0.0248732543,   0.004485498);
s(37,0) = (  0.0222816703, -0.0149085456,  0.0342718986, -0.0006728198,  0.0007122522, -0.0290251597,  0.0342848153, -0.0012390312, -0.0053319411);
s(38,0) = (   0.028905828, -0.0095959886,  0.0397837095,  0.0247598357, -0.0088397708, -0.0174784835,  0.0304190149,  0.0413472858,  0.0125770154);
s(39,0) = (  0.0256421733,  0.0096329627,  0.0364350183,  0.0202914181,  0.0090104118,  0.0174900336,  0.0301553924,   0.035512113,  0.0085870989);
s(40,0) = (  0.0234152669,  0.0157511473,  0.0359228019, -0.0005875092, -0.0005790261,  0.0305435228,   0.035730857, -0.0011059182,  -0.005679497);
s(41,0) = (   0.023330617,  0.0074582924,  0.0335646478, -0.0186669078, -0.0070096184,  0.0136832849,  0.0284877375, -0.0336006561,  0.0078782667);
s(42,0) = (  0.0311597776, -0.0001951267,  0.0516123344,  0.0002701649,   7.99246e-05, -0.0003980514,  0.0608684148,  0.0005163673,  0.0019129246);


// ----- do not change anything below here ----

// mask for full ambisonic set to channels in use
input_mask(0) = bus(nc);
input_mask(1) = (_,_,_,_,_,_,_,_,_);


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
