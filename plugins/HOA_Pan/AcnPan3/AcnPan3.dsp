declare name		"AcnPan3";
declare version 	"1.0";
declare author 		"AmbisonicDecoderToolkit";
declare license 	"GPL";
declare copyright	"(c) Aaron J. Heller 2013";
declare copyright	"(c) Florian Grond 2015";

// This AmbiPanner5 is based on Aaron Hellers's AmbiPanner3 and implements the Ambix standard until the 5th order
// to compare and verify channel ordering and equations lok at:
// http://ambisonics.ch/standards/channels/index 

math = library("math.lib");    // for PI
music = library("music.lib");  // for "noise"

process = acn_panner(3);

//acn_panner(N) = _,test_sig : select2(test_ui) <: gain( par(i,(N+1)^2, acn(i)) ) 
acn_panner(N) = _,test_sig : select2(test_ui) <: gain( par(i,(N+1)^2, acn_dirCosine(i)) )  
with {

  // button for pink noise test signal
  test_ui = button("[99]test");
  test_sig = pink(music.noise):gain(1/4);

  // azimuth and elevation panners, smooth to "dezipper" controls.
  azi = (math.PI/180.0)*hslider("[1]azi[unit:deg]", 0, -180, 180, 1) : dezipper;
  elev = (math.PI/180.0)*hslider("[2]ele[unit:deg]", 0,  -90,  90, 1) : dezipper;

  // spherical to cartesian
  // r = 1;
  x = 1 * cos(azi) * cos(elev);
  y = 1 * sin(azi) * cos(elev);
  z = 1 * sin(elev);


  // These are the coefficients for N3D normalization

  N3D_1_1 = sqrt(3);
  N3D_1_0 = sqrt(3);

  N3D_2_2 = sqrt(15)/2;
  N3D_2_1 = sqrt(15)/2;
  N3D_2_0 = sqrt(5)/2;

  N3D_3_3 = sqrt(35/8);
  N3D_3_2 = sqrt(105)/2;
  N3D_3_1 = sqrt(21/8);
  N3D_3_0 = sqrt(7)/2;

  N3D_4_4 = sqrt(35)  *(3/8);
  N3D_4_3 = sqrt(35/2)*(3/2);
  N3D_4_2 = sqrt(5)   *(3/4);
  N3D_4_1 = sqrt(5/2) *(3/4);
  N3D_4_0 = (3/8);

  N3D_5_5 = sqrt(77/2) *(3/8);
  N3D_5_4 = sqrt(385)  *(3/8);
  N3D_5_3 = sqrt(385/2)*(1/8);
  N3D_5_2 = sqrt(1155) *(1/4);
  N3D_5_1 = sqrt(165)  *(1/8);
  N3D_5_0 = sqrt(11)   *(1/8);


  // These are the coefficients for SN3D normalization (ACN + SN3D == AMBIX format)
  // clearly they can be simplified but the compiler does that anyway
  // like this it is easier to compare with: 
  // // http://ambisonics.ch/standards/channels/index 

  SN3D_1_1 = N3D_1_1 * (1/sqrt(3));
  SN3D_1_0 = N3D_1_0 * (1/sqrt(3));

  SN3D_2_2 = N3D_2_2 * (1/sqrt(5));
  SN3D_2_1 = N3D_2_1 * (1/sqrt(5));
  SN3D_2_0 = N3D_2_0 * (1/sqrt(5));

  SN3D_3_3 = N3D_3_3 * (1/sqrt(7));
  SN3D_3_2 = N3D_3_2 * (1/sqrt(7));
  SN3D_3_1 = N3D_3_1 * (1/sqrt(7));
  SN3D_3_0 = N3D_3_0 * (1/sqrt(7));

  SN3D_4_4 = N3D_4_4 * (1/3); // 1/sqrt(9)
  SN3D_4_3 = N3D_4_3 * (1/3);
  SN3D_4_2 = N3D_4_2 * (1/3);
  SN3D_4_1 = N3D_4_1 * (1/3);
  SN3D_4_0 = N3D_4_0 * (1/3);

  SN3D_5_5 = N3D_5_5 * (1/sqrt(11));
  SN3D_5_4 = N3D_5_4 * (1/sqrt(11));
  SN3D_5_3 = N3D_5_3 * (1/sqrt(11));
  SN3D_5_2 = N3D_5_2 * (1/sqrt(11));
  SN3D_5_1 = N3D_5_1 * (1/sqrt(11));
  SN3D_5_0 = N3D_5_0 * (1/sqrt(11));



  // ambisonics channel order Set in Cartesian coordinates
  // assume x^2 + y^2 + z^2 = 1
  // To double check the equations for each channel compare with:
  // http://ambisonics.ch/standards/channels/ACN0 
  //             .
  //             .
  //             .
  // http://ambisonics.ch/standards/channels/ACN35 
  

  // Note that the SN3D and N3D factors are not the same for cartesian coordinates


  // degree = 0
  acn_dirCosine( 0) = 1; //W
  // degree = 1
  acn_dirCosine( 1) =     SN3D_1_1 * y; //Y
  acn_dirCosine( 2) =     SN3D_1_0 * z; //Z
  acn_dirCosine( 3) =     SN3D_1_1 * x; //X
  // degree = 2
  acn_dirCosine( 4) = 2 * SN3D_2_2 * x * y;                     // V
  acn_dirCosine( 5) = 2 * SN3D_2_1 * y * z;                     // T
  acn_dirCosine( 6) =     SN3D_2_0 * ( (3*pow(z,2))  -1);       // R
  acn_dirCosine( 7) = 2 * SN3D_2_1 * x * z;                     // S
  acn_dirCosine( 8) =     SN3D_2_2 * ( pow(x,2) - pow(y,2) );   // U
  // degree = 3
  acn_dirCosine( 9) =     SN3D_3_3 * y * ( (3*pow(x,2)) - pow(y,2) );      // Q
  acn_dirCosine(10) = 2 * SN3D_3_2 * z * x * y;                            // O
  acn_dirCosine(11) =     SN3D_3_1 * y * ( (5*pow(z,2)) - 1);              // M
  acn_dirCosine(12) =     SN3D_3_0 * z * ( (5*pow(z,2)) - 3);              // K
  acn_dirCosine(13) =     SN3D_3_1 * x * ( (5*pow(z,2)) - 1);              // L
  acn_dirCosine(14) =     SN3D_3_2 * z * ( pow(x,2) - pow(y,2) );          // N
  acn_dirCosine(15) =     SN3D_3_3 * x * ( pow(x,2) - (3*pow(y,2)) );      // P
  // degree = 4
  acn_dirCosine(16) = 4 * SN3D_4_4 * x * y * ( pow(x,2) - pow(y,2) );                       //                
  acn_dirCosine(17) =     SN3D_4_3 * y * z * ( (3*pow(x,2) ) - pow(y,2));                   //                
  acn_dirCosine(18) = 2 * SN3D_4_2 * x * y * ( (7*pow(z,2)) - 1 );                          //                   
  acn_dirCosine(19) = 2 * SN3D_4_1 * y * z * ( (7*pow(z,2)) - 3 );                          //                
  acn_dirCosine(20) =     SN3D_4_0 * ( (35*pow(z,4)) - (30*pow(z,2)) + 3 );                 // 
  acn_dirCosine(21) = 2 * SN3D_4_1 * x * z * ( (7*pow(z,2)) - 3);                           // 
  acn_dirCosine(22) =     SN3D_4_2 * ( pow(x,2) - pow(y,2) ) * ( (7*pow(z,2)) - 1 );        //  
  acn_dirCosine(23) =     SN3D_4_3 * x * z * ( pow(x,2) -  (3*pow(y,2)) );                  //  
  acn_dirCosine(24) =     SN3D_4_4 * ( pow(x,4)  -  (6*pow(x,2)*pow(y,2))  +  pow(y,4) );   // 
  // degree = 5

  acn_dirCosine(25) =     SN3D_5_5 * y * ( (5*pow(x,4)) - (10*pow(x,2)*pow(y,2)) + pow(y,4) );
  acn_dirCosine(26) = 4 * SN3D_5_4 * x * y * z * (pow(x,2) - pow(y,2));
  acn_dirCosine(27) =     SN3D_5_3 * y * ( pow(y,4) - (2*pow(x,2)*pow(y,2)) - (3*pow(x,4))  -  (8*pow(y,2)*pow(z,2))   +  (24*pow(x,2)*pow(z,2)) );
  acn_dirCosine(28) = 2 * SN3D_5_2 * x * y * z * ( (2*pow(z,2)) - pow(x,2)  -  pow(y,2)  );
  acn_dirCosine(29) =     SN3D_5_1 * y * ( pow(x,4)  +  (2*pow(x,2)*pow(y,2))  +  pow(y,4)  -  (12*pow(x,2)*pow(z,2))  -  (12*pow(y,2)*pow(z,2))  +  (8*pow(z,4)) );
  acn_dirCosine(30) =     SN3D_5_0 * z * ( (63*pow(z,4))  -   (70*pow(z,2))   +  15);
  acn_dirCosine(31) =     SN3D_5_1 * x * ( pow(x,4)  +  (2*pow(x,2)*pow(y,2))  +  pow(y,4)  -  (12*pow(x,2)*pow(z,2))  -  (12*pow(y,2)*pow(z,2))  +  (8*pow(z,4)) );
  acn_dirCosine(32) =     SN3D_5_2 * z * ( (2*pow(x,2)*pow(z,2)) - (2*pow(y,2)*pow(z,2)) - pow(x,4) + pow(y,4) );
  acn_dirCosine(33) =     SN3D_5_3 * x * ( (2*pow(x,2)*pow(y,2)) + (8*pow(x,2)*pow(z,2)) - (24*pow(y,2)*pow(z,2)) - pow(x,4) + (3*pow(y,4)) ) ;
  acn_dirCosine(34) =     SN3D_5_4 * z * ( pow(x,4) - (6*pow(x,2)*pow(y,2)) + pow(y,4) );
  acn_dirCosine(35) =     SN3D_5_5 * x * ( pow(x,4) - (10*pow(x,2)*pow(y,2)) + (5*pow(y,4)) ) ;



// degree = 0
  acn( 0) = 1; //W
  // degree = 1
  acn( 1) = SN3D_1_1 * sin(azi) * cos(elev);  //Y
  acn( 2) = SN3D_1_0 * sin(elev);              //Z
  acn( 3) = SN3D_1_1 * cos(azi) * cos(elev);   //X
  // degree = 2
  acn( 4) = SN3D_2_2 * sin(2*azi) * pow(cos(elev),2);    // V
  acn( 5) = SN3D_2_1 * sin(azi)   * sin(2*elev);         // T
  acn( 6) = SN3D_2_0 * (3 * pow(sin(elev),2)  - 1);      // R
  acn( 7) = SN3D_2_1 * cos(azi)   * sin(2*elev);         // S
  acn( 8) = SN3D_2_2 * cos(2*azi) * pow(cos(elev),2);    // U
  // degree = 3
  acn( 9) = SN3D_3_3 * sin(3*azi) * pow(cos(elev),3);                             // Q
  acn(10) = SN3D_3_2 * sin(2*azi) * pow(cos(elev),2) * sin(elev);                 // O
  acn(11) = SN3D_3_1 * sin(  azi) * cos(elev) * (5*pow(sin(elev),2) -1);          // M
  acn(12) = SN3D_3_0 * (5 * pow(sin(elev),2)  - 3) * sin(elev);                   // K
  acn(13) = SN3D_3_1 * cos(  azi) * cos(elev) * (5*pow(sin(elev),2) -1);          // L
  acn(14) = SN3D_3_2 * cos(2*azi) * pow(cos(elev),2) * sin(elev);                 // N
  acn(15) = SN3D_3_3 * cos(3*azi) * pow(cos(elev),3);                             // P
  // degree = 4
  acn(16) = SN3D_4_4 * sin(4*azi) * pow(cos(elev),4);                                        //                
  acn(17) = SN3D_4_3 * sin(3*azi) * pow(cos(elev),3) * sin(elev);                            //                
  acn(18) = SN3D_4_2 * sin(2*azi) * pow(cos(elev),2) * (7* pow(sin(elev),2) -1);             //                   
  acn(19) = SN3D_4_1 * sin(  azi) * sin(2 * elev) * (7 * pow(sin(elev),2)  - 3);             //                
  acn(20) = SN3D_4_0 * (35 * pow(sin(elev),4)  - 30 * pow(sin(elev),2) + 3);                 // 
  acn(21) = SN3D_4_1 * cos(  azi) * sin(2 * elev) * (7 * pow(sin(elev),2)  - 3);             // 
  acn(22) = SN3D_4_2 * cos(2*azi) * pow(cos(elev),2) * (7* pow(sin(elev),2) -1);             //  
  acn(23) = SN3D_4_3 * cos(3*azi) * pow(cos(elev),3) * sin(elev);                            //  
  acn(24) = SN3D_4_4 * cos(4*azi) * pow(cos(elev),4);                                        // 
  // degree = 5

  acn(25) = SN3D_5_5 * sin(5*azi) * pow(cos(elev),5);
  acn(26) = SN3D_5_4 * sin(4*azi) * pow(cos(elev),4) * sin(elev);
  acn(27) = SN3D_5_3 * sin(3*azi) * pow(cos(elev),3) * (9* pow(sin(elev),2) -1);
  acn(28) = SN3D_5_2 * sin(2*azi) * pow(cos(elev),2) * sin(elev) * (3* pow(sin(elev),2) -1);
  acn(29) = SN3D_5_1 * sin(  azi) *     cos(elev) * (21 * pow(sin(elev),4)  - 14 * pow(sin(elev),2) + 1);
  acn(30) = SN3D_5_0 * (63 * pow(sin(elev),5)  - 70 * pow(sin(elev),3) + (15*sin(elev)));
  acn(31) = SN3D_5_1 * cos(  azi) *     cos(elev) * (21 * pow(sin(elev),4)  - 14 * pow(sin(elev),2) + 1);
  acn(32) = SN3D_5_2 * cos(2*azi) * pow(cos(elev),2) * sin(elev) * (3* pow(sin(elev),2) -1);
  acn(33) = SN3D_5_3 * cos(3*azi) * pow(cos(elev),3) * (9* pow(sin(elev),2) -1);
  acn(34) = SN3D_5_4 * cos(4*azi) * pow(cos(elev),4) * sin(elev);
  acn(35) = SN3D_5_5 * cos(5*azi) * pow(cos(elev),5);


};



// gain bus
gain(c) = R(c) with {
  R((c,cl)) = R(c),R(cl);
  R(1)      = _;
  R(0)      = !;
  R(float(0)) = R(0);
  R(float(1)) = R(1);
  R(c)      = *(c);
};

pink = f : (+ ~ g) with {
  f(x) = 0.04957526213389*x - 0.06305581334498*x' + 0.01483220320740*x'';
  g(x) = 1.80116083982126*x - 0.80257737639225*x';
};

// UI "dezipper"
smooth(c) = *(1-c) : +~*(c);
dezipper = smooth(0.999);


