HOASphericalHarmonics {

	classvar n3D_0_0,
			 n3D_1_1,
			 n3D_1_0,
			 n3D_2_2,
			 n3D_2_1,
			 n3D_2_0,
			 n3D_3_3,
			 n3D_3_2,
			 n3D_3_1,
			 n3D_3_0,
			 n3D_4_4,
			 n3D_4_3,
			 n3D_4_2,
			 n3D_4_1,
			 n3D_4_0,
			 n3D_5_5,
			 n3D_5_4,
			 n3D_5_3,
			 n3D_5_2,
			 n3D_5_1,
			 n3D_5_0;

	classvar sn3D_0_0,
			 sn3D_1_1,
			 sn3D_1_0,
			 sn3D_2_2,
			 sn3D_2_1,
			 sn3D_2_0,
			 sn3D_3_3,
			 sn3D_3_2,
			 sn3D_3_1,
			 sn3D_3_0,
			 sn3D_4_4,
			 sn3D_4_3,
			 sn3D_4_2,
			 sn3D_4_1,
			 sn3D_4_0,
			 sn3D_5_5,
			 sn3D_5_4,
			 sn3D_5_3,
			 sn3D_5_2,
			 sn3D_5_1,
			 sn3D_5_0;

	*initClass {

		n3D_0_0 = 1;

		n3D_1_1 = sqrt(3);
		n3D_1_0 = sqrt(3);

		n3D_2_2 = sqrt(15)/2;
		n3D_2_1 = sqrt(15)/2;
		n3D_2_0 = sqrt(5)/2;

		n3D_3_3 = sqrt(35/8);
		n3D_3_2 = sqrt(105)/2;
		n3D_3_1 = sqrt(21/8);
		n3D_3_0 = sqrt(7)/2;

		n3D_4_4 = sqrt(35)  *(3/8);
		n3D_4_3 = sqrt(35/2)*(3/2);
		n3D_4_2 = sqrt(5)   *(3/4);
		n3D_4_1 = sqrt(5/2) *(3/4);
		n3D_4_0 = (3/8);

		n3D_5_5 = sqrt(77/2) *(3/8);
		n3D_5_4 = sqrt(385)  *(3/8);
		n3D_5_3 = sqrt(385/2)*(1/8);
		n3D_5_2 = sqrt(1155) *(1/4);
		n3D_5_1 = sqrt(165)  *(1/8);
		n3D_5_0 = sqrt(11)   *(1/8);


		sn3D_0_0 = n3D_0_0;

		sn3D_1_1 = n3D_1_1 * (1/sqrt(3));
		sn3D_1_0 = n3D_1_0 * (1/sqrt(3));

		sn3D_2_2 = n3D_2_2 * (1/sqrt(5));
		sn3D_2_1 = n3D_2_1 * (1/sqrt(5));
		sn3D_2_0 = n3D_2_0 * (1/sqrt(5));

		sn3D_3_3 = n3D_3_3 * (1/sqrt(7));
		sn3D_3_2 = n3D_3_2 * (1/sqrt(7));
		sn3D_3_1 = n3D_3_1 * (1/sqrt(7));
		sn3D_3_0 = n3D_3_0 * (1/sqrt(7));

		sn3D_4_4 = n3D_4_4 * (1/3); // 1/sqrt(9)
		sn3D_4_3 = n3D_4_3 * (1/3);
		sn3D_4_2 = n3D_4_2 * (1/3);
		sn3D_4_1 = n3D_4_1 * (1/3);
		sn3D_4_0 = n3D_4_0 * (1/3);

		sn3D_5_5 = n3D_5_5 * (1/sqrt(11));
		sn3D_5_4 = n3D_5_4 * (1/sqrt(11));
		sn3D_5_3 = n3D_5_3 * (1/sqrt(11));
		sn3D_5_2 = n3D_5_2 * (1/sqrt(11));
		sn3D_5_1 = n3D_5_1 * (1/sqrt(11));
		sn3D_5_0 = n3D_5_0 * (1/sqrt(11));

	}


	/* --------- N3D formula ---------

	// degree = 0
		n3D_0_0;    //W
	// degree = 1
		n3D_1_1 * sin(az) * cos(ele);    //Y
		n3D_1_0 * sin(ele);              //Z
		n3D_1_1 * cos(az) * cos(ele);    //X
	// degree = 2
		n3D_2_2 * sin(2*az) * pow(cos(ele),2);    // V
		n3D_2_1 * sin(az)   * sin(2*ele);         // T
		n3D_2_0 * ((3 * pow(sin(ele),2))  - 1);   // R
		n3D_2_1 * cos(az)   * sin(2*ele);         // S
		n3D_2_2 * cos(2*az) * pow(cos(ele),2);    // U
	// degree = 3
		n3D_3_3 * sin(3*az) * pow(cos(ele),3);                         // Q
		n3D_3_2 * sin(2*az) * pow(cos(ele),2) * sin(ele);              // O
		n3D_3_1 * (sin(  az) * cos(ele) * ((5*pow(sin(ele),2)) -1));   // M
		n3D_3_0 * ((5 * pow(sin(ele),2))  - 3) * sin(ele);             // K
		n3D_3_1 * (cos(  az) * cos(ele) * ((5*pow(sin(ele),2)) -1));   // L
		n3D_3_2 * cos(2*az) * pow(cos(ele),2) * sin(ele);              // N
		n3D_3_3 * cos(3*az) * pow(cos(ele),3);                         // P
	// degree = 4
		n3D_4_4 *  sin(4*az) * pow(cos(ele),4);
		n3D_4_3 *  sin(3*az) * pow(cos(ele),3) * sin(ele);
		n3D_4_2 * (sin(2*az) * pow(cos(ele),2) * ( (7 * pow(sin(ele),2)) - 1) );
		n3D_4_1 * (sin(  az) * sin(2 * ele) *    ( (7 * pow(sin(ele),2)) - 3) );
		n3D_4_0 * ((35 * pow(sin(ele),4))  - (30 * pow(sin(ele),2)) + 3);
		n3D_4_1 * (cos(  az) * sin(2 * ele) *    (  (7 * pow(sin(ele),2)) - 3 ) );
		n3D_4_2 * (cos(2*az) * pow(cos(ele),2) * (  (7 * pow(sin(ele),2)) - 1 ) );
		n3D_4_3 *  cos(3*az) * pow(cos(ele),3) * sin(ele);
		n3D_4_4 *  cos(4*az) * pow(cos(ele),4);
	// degree = 5
		n3D_5_5 *  sin(5*az) * pow(cos(ele),5);
		n3D_5_4 *  sin(4*az) * pow(cos(ele),4) * sin(ele);
		n3D_5_3 * (sin(3*az) * pow(cos(ele),3) * ((9* pow(sin(ele),2)) -1));
		n3D_5_2 * (sin(2*az) * pow(cos(ele),2) * sin(ele) * ((3* pow(sin(ele),2)) -1));
		n3D_5_1 * (sin(  az) *     cos(ele) * ((21 * pow(sin(ele),4))  - ((14 * pow(sin(ele),2)) + 1)));
		n3D_5_0 * ((63 * pow(sin(ele),5))  - (70 * pow(sin(ele),3)) + (15*sin(ele)));
		n3D_5_1 * (cos(  az) *     cos(ele) * ((21 * pow(sin(ele),4))  - ((14 * pow(sin(ele),2)) + 1)));
		n3D_5_2 * (cos(2*az) * pow(cos(ele),2) * sin(ele) * ((3* pow(sin(ele),2)) -1));
		n3D_5_3 * (cos(3*az) * pow(cos(ele),3) * ((9* pow(sin(ele),2)) -1));
		n3D_5_4 *  cos(4*az) * pow(cos(ele),4) * sin(ele);
		n3D_5_5 *  cos(5*az) * pow(cos(ele),5);

	------------ N3D formula ------ */

	*coefN3D { |order, az, el|
		switch(order)
		{0} { ^[ n3D_0_0 ] }
		{1} { ^this.pr_N3D_order1(az, el) }
		{2} { ^this.pr_N3D_order2(az, el) }
		{3} { ^this.pr_N3D_order3(az, el) }
		{4} { ^this.pr_N3D_order4(az, el) }
		{5} { ^this.pr_N3D_order5(az, el) }
		{ "Invalid argument: Order must be an integer within the range 0-5.".warn }
	}

	*pr_N3D_order1 { |az, el|
		^[
			// order 0
			n3D_0_0,
			// order 1
			n3D_1_1 * sin(az) * cos(el),
			n3D_1_0 * sin(el),
			n3D_1_1 * cos(az) * cos(el)
		]
	}

	*pr_N3D_order2 { |az, el|

		// order 1
		var sin_az = sin(az);
		var sin_el = sin(el);
		var cos_az = cos(az);
		var cos_el = cos(el);

		// order 2
		var sin_2az = sin(2*az);
		var pow2_cos_el = pow(cos_el, 2);
		var sin_2el = sin(2*el);
		var pow2_sin_el = pow(sin_el, 2);
		var cos_2az = cos(2*az);

		^[
			// order 0
			n3D_0_0,
			// order 1
			n3D_1_1 * sin_az * cos_el,
			n3D_1_0 * sin_el,
			n3D_1_1 * cos_az * cos_el,
			// order 2
			n3D_2_2 * sin_2az * pow2_cos_el,
			n3D_2_1 * sin_az * sin_2el,
			n3D_2_0 * ((3 * pow2_sin_el) - 1),
			n3D_2_1 * cos_az * sin_2el,
			n3D_2_2 * cos_2az * pow2_cos_el,
		]
	}

	*pr_N3D_order3 { |az, el|

		// order 1
		var sin_az = sin(az);
		var sin_el = sin(el);
		var cos_az = cos(az);
		var cos_el = cos(el);

		// order 2
		var sin_2az = sin(2*az);
		var pow2_cos_el = pow(cos_el, 2);
		var sin_2el = sin(2*el);
		var pow2_sin_el = pow(sin_el, 2);
		var cos_2az = cos(2*az);

		// order 3
		var sin_3az = sin(3*az);
		var pow3_cos_el = pow(cos_el, 3);
		var cos_3az = cos(3*az);

		^[
			// order 0
			n3D_0_0,
			// order 1
			n3D_1_1 * sin_az * cos_el,
			n3D_1_0 * sin_el,
			n3D_1_1 * cos_az * cos_el,
			// order 2
			n3D_2_2 * sin_2az * pow2_cos_el,
			n3D_2_1 * sin_az * sin_2el,
			n3D_2_0 * ((3 * pow2_sin_el) - 1),
			n3D_2_1 * cos_az * sin_2el,
			n3D_2_2 * cos_2az * pow2_cos_el,
			// order 3
			n3D_3_3 * sin_3az * pow3_cos_el,
			n3D_3_2 * sin_2az * pow2_cos_el * sin_el,
			n3D_3_1 * (sin_az * cos_el * ((5 * pow2_sin_el) - 1)),
			n3D_3_0 * ((5 * pow2_sin_el) - 3) * sin_el,
			n3D_3_1 * (cos_az * cos_el * ((5 * pow2_sin_el) - 1)),
			n3D_3_2 * cos_2az * pow2_cos_el * sin_el,
			n3D_3_3 * cos_3az * pow3_cos_el,
		]
	}

	*pr_N3D_order4 { |az, el|

		// order 1
		var sin_az = sin(az);
		var sin_el = sin(el);
		var cos_az = cos(az);
		var cos_el = cos(el);

		// order 2
		var sin_2az = sin(2*az);
		var pow2_cos_el = pow(cos_el, 2);
		var sin_2el = sin(2*el);
		var pow2_sin_el = pow(sin_el, 2);
		var cos_2az = cos(2*az);

		// order 3
		var sin_3az = sin(3*az);
		var pow3_cos_el = pow(cos_el, 3);
		var cos_3az = cos(3*az);

		// order 4
		var sin_4az = sin(4*az);
		var pow4_cos_el = pow(cos_el, 4);
		var pow4_sin_el = pow(sin_el, 4);
		var cos_4az = cos(4*az);

		^[
			// order 0
			n3D_0_0,
			// order 1
			n3D_1_1 * sin_az * cos_el,
			n3D_1_0 * sin_el,
			n3D_1_1 * cos_az * cos_el,
			// order 2
			n3D_2_2 * sin_2az * pow2_cos_el,
			n3D_2_1 * sin_az * sin_2el,
			n3D_2_0 * ((3 * pow2_sin_el) - 1),
			n3D_2_1 * cos_az * sin_2el,
			n3D_2_2 * cos_2az * pow2_cos_el,
			// order 3
			n3D_3_3 * sin_3az * pow3_cos_el,
			n3D_3_2 * sin_2az * pow2_cos_el * sin_el,
			n3D_3_1 * (sin_az * cos_el * ((5 * pow2_sin_el) - 1)),
			n3D_3_0 * ((5 * pow2_sin_el) - 3) * sin_el,
			n3D_3_1 * (cos_az * cos_el * ((5 * pow2_sin_el) - 1)),
			n3D_3_2 * cos_2az * pow2_cos_el * sin_el,
			n3D_3_3 * cos_3az * pow3_cos_el,
			// order 4
			n3D_4_4 * sin_4az * pow4_cos_el,
			n3D_4_3 * sin_3az * pow3_cos_el * sin_el,
			n3D_4_2 * (sin_2az * pow2_cos_el * ((7 * pow2_sin_el) - 1)),
			n3D_4_1 * (sin_az * sin_2el * ((7 * pow2_sin_el) - 3)),
			n3D_4_0 * ((35 * pow4_sin_el) - (30 * pow2_sin_el) + 3),
			n3D_4_1 * (cos_az * sin_2el * ((7 * pow2_sin_el) - 3)),
			n3D_4_2 * (cos_2az * pow2_cos_el * ((7 * pow2_sin_el) - 1)),
			n3D_4_3 * cos_3az * pow3_cos_el * sin_el,
			n3D_4_4 * cos_4az * pow4_cos_el,
		]
	}

	*pr_N3D_order5 { |az, el|

		// order 1
		var sin_az = sin(az);
		var sin_el = sin(el);
		var cos_az = cos(az);
		var cos_el = cos(el);

		// order 2
		var sin_2az = sin(2*az);
		var pow2_cos_el = pow(cos_el, 2);
		var sin_2el = sin(2*el);
		var pow2_sin_el = pow(sin_el, 2);
		var cos_2az = cos(2*az);

		// order 3
		var sin_3az = sin(3*az);
		var pow3_cos_el = pow(cos_el, 3);
		var cos_3az = cos(3*az);

		// order 4
		var sin_4az = sin(4*az);
		var pow4_cos_el = pow(cos_el, 4);
		var pow4_sin_el = pow(sin_el, 4);
		var cos_4az = cos(4*az);

		// order 5
		var pow5_cos_el = pow(cos_el, 5);

		^[
			// order 0
			n3D_0_0,
			// order 1
			n3D_1_1 * sin_az * cos_el,
			n3D_1_0 * sin_el,
			n3D_1_1 * cos_az * cos_el,
			// order 2
			n3D_2_2 * sin_2az * pow2_cos_el,
			n3D_2_1 * sin_az * sin_2el,
			n3D_2_0 * ((3 * pow2_sin_el) - 1),
			n3D_2_1 * cos_az * sin_2el,
			n3D_2_2 * cos_2az * pow2_cos_el,
			// order 3
			n3D_3_3 * sin_3az * pow3_cos_el,
			n3D_3_2 * sin_2az * pow2_cos_el * sin_el,
			n3D_3_1 * (sin_az * cos_el * ((5 * pow2_sin_el) - 1)),
			n3D_3_0 * ((5 * pow2_sin_el) - 3) * sin_el,
			n3D_3_1 * (cos_az * cos_el * ((5 * pow2_sin_el) - 1)),
			n3D_3_2 * cos_2az * pow2_cos_el * sin_el,
			n3D_3_3 * cos_3az * pow3_cos_el,
			// order 4
			n3D_4_4 * sin_4az * pow4_cos_el,
			n3D_4_3 * sin_3az * pow3_cos_el * sin_el,
			n3D_4_2 * (sin_2az * pow2_cos_el * ((7 * pow2_sin_el) - 1)),
			n3D_4_1 * (sin_az * sin_2el * ((7 * pow2_sin_el) - 3)),
			n3D_4_0 * ((35 * pow4_sin_el) - (30 * pow2_sin_el) + 3),
			n3D_4_1 * (cos_az * sin_2el * ((7 * pow2_sin_el) - 3)),
			n3D_4_2 * (cos_2az * pow2_cos_el * ((7 * pow2_sin_el) - 1)),
			n3D_4_3 * cos_3az * pow3_cos_el * sin_el,
			n3D_4_4 * cos_4az * pow4_cos_el,
			// order 5
			n3D_5_5 * sin(5*az) * pow5_cos_el,
			n3D_5_4 * sin_4az * pow4_cos_el * sin_el,
			n3D_5_3 * (sin_3az * pow3_cos_el * ((9* pow2_sin_el) -1)),
			n3D_5_2 * (sin_2az * pow2_cos_el * sin_el * ((3 * pow2_sin_el) - 1)),
			n3D_5_1 * (sin_az * cos_el * ((21 * pow4_sin_el) - ((14 * pow2_sin_el) + 1))),
			n3D_5_0 * ((63 * pow(sin_el, 5)) - (70 * pow(sin_el, 3)) + (15 * sin_el)),
			n3D_5_1 * (cos_az * cos_el * ((21 * pow4_sin_el) - ((14 * pow2_sin_el) + 1))),
			n3D_5_2 * (cos_2az * pow2_cos_el * sin_el * ((3 * pow2_sin_el) - 1)),
			n3D_5_3 * (cos_3az * pow3_cos_el * ((9 * pow2_sin_el) - 1)),
			n3D_5_4 * cos_4az * pow4_cos_el * sin_el,
			n3D_5_5 * cos(5*az) * pow5_cos_el,
		]
	}


	/* ------ SN3D formula ---------

	The SN3D formula is the same as for N3D, only it uses the 'sn3D_*_*' classvars instead.

	--------- SN3D formula ------ */

	*coefSN3D { |order, az, el|
		switch(order)
		{0} { ^[ n3D_0_0 ] }
		{1} { ^this.pr_SN3D_order1(az, el) }
		{2} { ^this.pr_SN3D_order2(az, el) }
		{3} { ^this.pr_SN3D_order3(az, el) }
		{4} { ^this.pr_SN3D_order4(az, el) }
		{5} { ^this.pr_SN3D_order5(az, el) }
		{ "Invalid argument: Order must be an integer within the range 0-5.".warn }
	}

	*pr_SN3D_order1 { |az, el|
		^[
			// order 0
			n3D_0_0,
			// order 1
			sn3D_1_1 * sin(az) * cos(el),
			sn3D_1_0 * sin(el),
			sn3D_1_1 * cos(az) * cos(el)
		]
	}

	*pr_SN3D_order2 { |az, el|

		// order 1
		var sin_az = sin(az);
		var sin_el = sin(el);
		var cos_az = cos(az);
		var cos_el = cos(el);

		// order 2
		var sin_2az = sin(2*az);
		var pow2_cos_el = pow(cos_el, 2);
		var sin_2el = sin(2*el);
		var pow2_sin_el = pow(sin_el, 2);
		var cos_2az = cos(2*az);

		^[
			// order 0
			n3D_0_0,
			// order 1
			sn3D_1_1 * sin_az * cos_el,
			sn3D_1_0 * sin_el,
			sn3D_1_1 * cos_az * cos_el,
			// order 2
			sn3D_2_2 * sin_2az * pow2_cos_el,
			sn3D_2_1 * sin_az * sin_2el,
			sn3D_2_0 * ((3 * pow2_sin_el) - 1),
			sn3D_2_1 * cos_az * sin_2el,
			sn3D_2_2 * cos_2az * pow2_cos_el,
		]
	}

	*pr_SN3D_order3 { |az, el|

		// order 1
		var sin_az = sin(az);
		var sin_el = sin(el);
		var cos_az = cos(az);
		var cos_el = cos(el);

		// order 2
		var sin_2az = sin(2*az);
		var pow2_cos_el = pow(cos_el, 2);
		var sin_2el = sin(2*el);
		var pow2_sin_el = pow(sin_el, 2);
		var cos_2az = cos(2*az);

		// order 3
		var sin_3az = sin(3*az);
		var pow3_cos_el = pow(cos_el, 3);
		var cos_3az = cos(3*az);

		^[
			// order 0
			n3D_0_0,
			// order 1
			sn3D_1_1 * sin_az * cos_el,
			sn3D_1_0 * sin_el,
			sn3D_1_1 * cos_az * cos_el,
			// order 2
			sn3D_2_2 * sin_2az * pow2_cos_el,
			sn3D_2_1 * sin_az * sin_2el,
			sn3D_2_0 * ((3 * pow2_sin_el) - 1),
			sn3D_2_1 * cos_az * sin_2el,
			sn3D_2_2 * cos_2az * pow2_cos_el,
			// order 3
			sn3D_3_3 * sin_3az * pow3_cos_el,
			sn3D_3_2 * sin_2az * pow2_cos_el * sin_el,
			sn3D_3_1 * (sin_az * cos_el * ((5 * pow2_sin_el) - 1)),
			sn3D_3_0 * ((5 * pow2_sin_el) - 3) * sin_el,
			sn3D_3_1 * (cos_az * cos_el * ((5 * pow2_sin_el) - 1)),
			sn3D_3_2 * cos_2az * pow2_cos_el * sin_el,
			sn3D_3_3 * cos_3az * pow3_cos_el,
		]
	}

	*pr_SN3D_order4 { |az, el|

		// order 1
		var sin_az = sin(az);
		var sin_el = sin(el);
		var cos_az = cos(az);
		var cos_el = cos(el);

		// order 2
		var sin_2az = sin(2*az);
		var pow2_cos_el = pow(cos_el, 2);
		var sin_2el = sin(2*el);
		var pow2_sin_el = pow(sin_el, 2);
		var cos_2az = cos(2*az);

		// order 3
		var sin_3az = sin(3*az);
		var pow3_cos_el = pow(cos_el, 3);
		var cos_3az = cos(3*az);

		// order 4
		var sin_4az = sin(4*az);
		var pow4_cos_el = pow(cos_el, 4);
		var pow4_sin_el = pow(sin_el, 4);
		var cos_4az = cos(4*az);

		^[
			// order 0
			n3D_0_0,
			// order 1
			sn3D_1_1 * sin_az * cos_el,
			sn3D_1_0 * sin_el,
			sn3D_1_1 * cos_az * cos_el,
			// order 2
			sn3D_2_2 * sin_2az * pow2_cos_el,
			sn3D_2_1 * sin_az * sin_2el,
			sn3D_2_0 * ((3 * pow2_sin_el) - 1),
			sn3D_2_1 * cos_az * sin_2el,
			sn3D_2_2 * cos_2az * pow2_cos_el,
			// order 3
			sn3D_3_3 * sin_3az * pow3_cos_el,
			sn3D_3_2 * sin_2az * pow2_cos_el * sin_el,
			sn3D_3_1 * (sin_az * cos_el * ((5 * pow2_sin_el) - 1)),
			sn3D_3_0 * ((5 * pow2_sin_el) - 3) * sin_el,
			sn3D_3_1 * (cos_az * cos_el * ((5 * pow2_sin_el) - 1)),
			sn3D_3_2 * cos_2az * pow2_cos_el * sin_el,
			sn3D_3_3 * cos_3az * pow3_cos_el,
			// order 4
			sn3D_4_4 * sin_4az * pow4_cos_el,
			sn3D_4_3 * sin_3az * pow3_cos_el * sin_el,
			sn3D_4_2 * (sin_2az * pow2_cos_el * ((7 * pow2_sin_el) - 1)),
			sn3D_4_1 * (sin_az * sin_2el * ((7 * pow2_sin_el) - 3)),
			sn3D_4_0 * ((35 * pow4_sin_el) - (30 * pow2_sin_el) + 3),
			sn3D_4_1 * (cos_az * sin_2el * ((7 * pow2_sin_el) - 3)),
			sn3D_4_2 * (cos_2az * pow2_cos_el * ((7 * pow2_sin_el) - 1)),
			sn3D_4_3 * cos_3az * pow3_cos_el * sin_el,
			sn3D_4_4 * cos_4az * pow4_cos_el,
		]
	}

	*pr_SN3D_order5 { |az, el|

		// order 1
		var sin_az = sin(az);
		var sin_el = sin(el);
		var cos_az = cos(az);
		var cos_el = cos(el);

		// order 2
		var sin_2az = sin(2*az);
		var pow2_cos_el = pow(cos_el, 2);
		var sin_2el = sin(2*el);
		var pow2_sin_el = pow(sin_el, 2);
		var cos_2az = cos(2*az);

		// order 3
		var sin_3az = sin(3*az);
		var pow3_cos_el = pow(cos_el, 3);
		var cos_3az = cos(3*az);

		// order 4
		var sin_4az = sin(4*az);
		var pow4_cos_el = pow(cos_el, 4);
		var pow4_sin_el = pow(sin_el, 4);
		var cos_4az = cos(4*az);

		// order 5
		var pow5_cos_el = pow(cos_el, 5);

		^[
			// order 0
			n3D_0_0,
			// order 1
			sn3D_1_1 * sin_az * cos_el,
			sn3D_1_0 * sin_el,
			sn3D_1_1 * cos_az * cos_el,
			// order 2
			sn3D_2_2 * sin_2az * pow2_cos_el,
			sn3D_2_1 * sin_az * sin_2el,
			sn3D_2_0 * ((3 * pow2_sin_el) - 1),
			sn3D_2_1 * cos_az * sin_2el,
			sn3D_2_2 * cos_2az * pow2_cos_el,
			// order 3
			sn3D_3_3 * sin_3az * pow3_cos_el,
			sn3D_3_2 * sin_2az * pow2_cos_el * sin_el,
			sn3D_3_1 * (sin_az * cos_el * ((5 * pow2_sin_el) - 1)),
			sn3D_3_0 * ((5 * pow2_sin_el) - 3) * sin_el,
			sn3D_3_1 * (cos_az * cos_el * ((5 * pow2_sin_el) - 1)),
			sn3D_3_2 * cos_2az * pow2_cos_el * sin_el,
			sn3D_3_3 * cos_3az * pow3_cos_el,
			// order 4
			sn3D_4_4 * sin_4az * pow4_cos_el,
			sn3D_4_3 * sin_3az * pow3_cos_el * sin_el,
			sn3D_4_2 * (sin_2az * pow2_cos_el * ((7 * pow2_sin_el) - 1)),
			sn3D_4_1 * (sin_az * sin_2el * ((7 * pow2_sin_el) - 3)),
			sn3D_4_0 * ((35 * pow4_sin_el) - (30 * pow2_sin_el) + 3),
			sn3D_4_1 * (cos_az * sin_2el * ((7 * pow2_sin_el) - 3)),
			sn3D_4_2 * (cos_2az * pow2_cos_el * ((7 * pow2_sin_el) - 1)),
			sn3D_4_3 * cos_3az * pow3_cos_el * sin_el,
			sn3D_4_4 * cos_4az * pow4_cos_el,
			// order 5
			sn3D_5_5 * sin(5*az) * pow5_cos_el,
			sn3D_5_4 * sin_4az * pow4_cos_el * sin_el,
			sn3D_5_3 * (sin_3az * pow3_cos_el * ((9* pow2_sin_el) -1)),
			sn3D_5_2 * (sin_2az * pow2_cos_el * sin_el * ((3 * pow2_sin_el) - 1)),
			sn3D_5_1 * (sin_az * cos_el * ((21 * pow4_sin_el) - ((14 * pow2_sin_el) + 1))),
			sn3D_5_0 * ((63 * pow(sin_el, 5)) - (70 * pow(sin_el, 3)) + (15 * sin_el)),
			sn3D_5_1 * (cos_az * cos_el * ((21 * pow4_sin_el) - ((14 * pow2_sin_el) + 1))),
			sn3D_5_2 * (cos_2az * pow2_cos_el * sin_el * ((3 * pow2_sin_el) - 1)),
			sn3D_5_3 * (cos_3az * pow3_cos_el * ((9 * pow2_sin_el) - 1)),
			sn3D_5_4 * cos_4az * pow4_cos_el * sin_el,
			sn3D_5_5 * cos(5*az) * pow5_cos_el,
		]
	}


/*

	    *dirCosinecoef { |order, az, ele|

		var x,y,z;

		x = 1 * cos(az) * cos(ele);
        y = 1 * sin(az) * cos(ele);
        z = 1 * sin(ele);

  // degree = 0
		acn[ 0] = 1; //W
  // degree = 1
		acn[ 1] =     sn3D_1_1 * y; //Y
		acn[ 2] =     sn3D_1_0 * z; //Z
		acn[ 3] =     sn3D_1_1 * x; //X
  // degree = 2
		acn[ 4] = 2 * sn3D_2_2 * x * y;                     // V
		acn[ 5] = 2 * sn3D_2_1 * y * z;                     // T
		acn[ 6] =     sn3D_2_0 * ( (3*pow(z,2))  -1);       // R
		acn[ 7] = 2 * sn3D_2_1 * x * z;                     // S
		acn[ 8] =     sn3D_2_2 * ( pow(x,2) - pow(y,2) );   // U
  // degree = 3
		acn[ 9] =     sn3D_3_3 * y * ( (3*pow(x,2)) - pow(y,2) );      // Q
		acn[10] = 2 * sn3D_3_2 * z * x * y;                            // O
		acn[11] =     sn3D_3_1 * y * ( (5*pow(z,2)) - 1);              // M
		acn[12] =     sn3D_3_0 * z * ( (5*pow(z,2)) - 3);              // K
		acn[13] =     sn3D_3_1 * x * ( (5*pow(z,2)) - 1);              // L
		acn[14] =     sn3D_3_2 * z * ( pow(x,2) - pow(y,2) );          // N
		acn[15] =     sn3D_3_3 * x * ( pow(x,2) - (3*pow(y,2)) );      // P
  // degree = 4
		acn[16] = 4 * sn3D_4_4 * x * y * ( pow(x,2) - pow(y,2) );                       //
		acn[17] =     sn3D_4_3 * y * z * ( (3*pow(x,2) ) - pow(y,2));                   //
		acn[18] = 2 * sn3D_4_2 * x * y * ( (7*pow(z,2)) - 1 );                          //
		acn[19] = 2 * sn3D_4_1 * y * z * ( (7*pow(z,2)) - 3 );                          //
		acn[20] =     sn3D_4_0 * ( (35*pow(z,4)) - (30*pow(z,2)) + 3 );                 //
		acn[21] = 2 * sn3D_4_1 * x * z * ( (7*pow(z,2)) - 3);                           //
		acn[22] =     sn3D_4_2 * ( pow(x,2) - pow(y,2) ) * ( (7*pow(z,2)) - 1 );        //
		acn[23] =     sn3D_4_3 * x * z * ( pow(x,2) -  (3*pow(y,2)) );                  //
		acn[24] =     sn3D_4_4 * ( pow(x,4)  -  (6*pow(x,2)*pow(y,2))  +  pow(y,4) );   //
  // degree = 5
		acn[25] =     sn3D_5_5 * y * ( (5*pow(x,4)) - (10*pow(x,2)*pow(y,2)) + pow(y,4) );
		acn[26] = 4 * sn3D_5_4 * x * y * z * (pow(x,2) - pow(y,2));
		acn[27] =     sn3D_5_3 * y * ( pow(y,4) - (2*pow(x,2)*pow(y,2)) - (3*pow(x,4))  -  (8*pow(y,2)*pow(z,2))   +  (24*pow(x,2)*pow(z,2)) );
		acn[28] = 2 * sn3D_5_2 * x * y * z * ( (2*pow(z,2)) - pow(x,2)  -  pow(y,2)  );
		acn[29] =     sn3D_5_1 * y * ( pow(x,4)  +  (2*pow(x,2)*pow(y,2))  +  pow(y,4)  -  (12*pow(x,2)*pow(z,2))  -  (12*pow(y,2)*pow(z,2))  +  (8*pow(z,4)) );
		acn[30] =     sn3D_5_0 * z * ( (63*pow(z,4))  -   (70*pow(z,2))   +  15);
		acn[31] =     sn3D_5_1 * x * ( pow(x,4)  +  (2*pow(x,2)*pow(y,2))  +  pow(y,4)  -  (12*pow(x,2)*pow(z,2))  -  (12*pow(y,2)*pow(z,2))  +  (8*pow(z,4)) );
		acn[32] =     sn3D_5_2 * z * ( (2*pow(x,2)*pow(z,2)) - (2*pow(y,2)*pow(z,2)) - pow(x,4) + pow(y,4) );
		acn[33] =     sn3D_5_3 * x * ( (2*pow(x,2)*pow(y,2)) + (8*pow(x,2)*pow(z,2)) - (24*pow(y,2)*pow(z,2)) - pow(x,4) + (3*pow(y,4)) ) ;
		acn[34] =     sn3D_5_4 * z * ( pow(x,4) - (6*pow(x,2)*pow(y,2)) + pow(y,4) );
		acn[35] =     sn3D_5_5 * x * ( pow(x,4) - (10*pow(x,2)*pow(y,2)) + (5*pow(y,4)) ) ;


		case{order == 1} {^acn.copyRange(0,3)}
		    {order == 2} {^acn.copyRange(0,8)}
		    {order == 3} {^acn.copyRange(0,15)}
		    {order == 4} {^acn.copyRange(0,24)}
		    {order == 5} {^acn.copyRange(0,35)}

	}




*gains_ACN_SN3D_cart{ |order, az, ele|

		var x,y,z, acn;

		x = 1 * cos(az) * cos(ele);
        y = 1 * sin(az) * cos(ele);
        z = 1 * sin(ele);

		acn =
        [ 1,
        y,
        z,
        x,
        sqrt(3)*x*y,
        sqrt(3)*y*z,
        (1/2)*(3*pow(z, 2) - 1),
        sqrt(3)*x*z,
        (1/2)*sqrt(3)*(pow(x, 2) - pow(y, 2)),
        (1/4)*sqrt(10)*(3*pow(x, 2)*y - pow(y, 3)),
        sqrt(15)*x*y*z,
        (1/4)*sqrt(6)*y*(5*pow(z, 2) - 1),
        (1/2)*z*(5*pow(z, 2) - 3),
        (1/4)*sqrt(6)*x*(5*pow(z, 2) - 1),
        (1/2)*sqrt(15)*z*(pow(x, 2) - pow(y, 2)),
        (1/4)*sqrt(10)*(pow(x, 3) - 3*x*pow(y, 2)),
        (1/8)*sqrt(35)*(4*pow(x, 3)*y - 4*x*pow(y, 3)),
        (1/4)*sqrt(70)*z*(3*pow(x, 2)*y - pow(y, 3)),
        (1/2)*sqrt(5)*x*y*(7*pow(z, 2) - 1),
        (1/4)*sqrt(10)*y*z*(7*pow(z, 2) - 3),
        (1/8)*(35*pow(z, 4) - 30*pow(z, 2) + 3),
        (1/4)*sqrt(10)*x*z*(7*pow(z, 2) - 3),
        (1/4)*sqrt(5)*(pow(x, 2) - pow(y, 2))*(7*pow(z, 2) - 1),
        (1/4)*sqrt(70)*z*(pow(x, 3) - 3*x*pow(y, 2)),
        (1/8)*sqrt(35)*(pow(x, 4) - 6*pow(x, 2)*pow(y, 2) + pow(y, 4)),
        (3/16)*sqrt(14)*(5*pow(x, 4)*y - 10*pow(x, 2)*pow(y, 3) + pow(y, 5)),
        (3/8)*sqrt(35)*z*(4*pow(x, 3)*y - 4*x*pow(y, 3)),
        (1/16)*sqrt(70)*(9*pow(z, 2) - 1)*(3*pow(x, 2)*y - pow(y, 3)),
        (1/2)*sqrt(105)*x*y*z*(3*pow(z, 2) - 1),
        (1/8)*sqrt(15)*y*(21*pow(z, 4) - 14*pow(z, 2) + 1),
        (1/8)*z*(63*pow(z, 4) - 70*pow(z, 2) + 15),
        (1/8)*sqrt(15)*x*(21*pow(z, 4) - 14*pow(z, 2) + 1),
        (1/4)*sqrt(105)*z*(pow(x, 2) - pow(y, 2))*(3*pow(z, 2) - 1),
        (1/16)*sqrt(70)*(pow(x, 3) - 3*x*pow(y, 2))*(9*pow(z, 2) - 1),
        (3/8)*sqrt(35)*z*(pow(x, 4) - 6*pow(x, 2)*pow(y, 2) + pow(y, 4)),
        (3/16)*sqrt(14)*(pow(x, 5) - 10*pow(x, 3)*pow(y, 2) + 5*x*pow(y, 4))
		];


		case{order == 1} {^acn.copyRange(0,3)}
		    {order == 2} {^acn.copyRange(0,8)}
		    {order == 3} {^acn.copyRange(0,15)}
		    {order == 4} {^acn.copyRange(0,24)}
		    {order == 5} {^acn.copyRange(0,35)}

	}


*gains_ACN_SN3D_sph  { |order, az, ele|

		acn =
		[ 1,
        sin(az)*cos(ele),
        sin(ele),
        cos(ele)*cos(az),
        sqrt(3)*sin(az)*pow(cos(ele), 2)*cos(az),
        (1/4)*sqrt(3)*(cos(2*ele - az) - cos(2*ele + az)),
        (3/2)*pow(sin(ele), 2) - 1/2,
        (1/4)*sqrt(3)*(sin(2*ele - az) + sin(2*ele + az)),
        (1/2)*sqrt(3)*pow(cos(ele), 2)*cos(2*az),
        (1/4)*sqrt(10)*(-4*pow(sin(az), 2) + 3)*sin(az)*pow(cos(ele), 3),
        sqrt(15)*sin(ele)*sin(az)*pow(cos(ele), 2)*cos(az),
        (1/4)*sqrt(6)*(5*pow(sin(ele), 2) - 1)*sin(az)*cos(ele),
        (1/2)*(5*pow(sin(ele), 2) - 3)*sin(ele),
        (1/4)*sqrt(6)*(5*pow(sin(ele), 2) - 1)*cos(ele)*cos(az),
        (1/2)*sqrt(15)*sin(ele)*pow(cos(ele), 2)*cos(2*az),
        (1/4)*sqrt(10)*(-4*pow(sin(az), 2) + 1)*pow(cos(ele), 3)*cos(az),
        (1/32)*sqrt(35)*pow(cos(2*ele) + 1, 2)*sin(4*az),
        (1/4)*sqrt(70)*(-4*pow(sin(az), 2) + 3)*sin(ele)*sin(az)*pow(cos(ele), 3),
        (1/2)*sqrt(5)*(7*pow(sin(ele), 2) - 1)*sin(az)*pow(cos(ele), 2)*cos(az),
        (1/4)*sqrt(10)*(7*pow(sin(ele), 2) - 3)*sin(ele)*sin(az)*cos(ele),
        (35/8)*pow(sin(ele), 4) - 15/4*pow(sin(ele), 2) + 3/8,
        (1/4)*sqrt(10)*(7*pow(sin(ele), 2) - 3)*sin(ele)*cos(ele)*cos(az),
        (1/4)*sqrt(5)*(7*pow(sin(ele), 2) - 1)*pow(cos(ele), 2)*cos(2*az),
        (1/4)*sqrt(70)*(-4*pow(sin(az), 2) + 1)*sin(ele)*pow(cos(ele), 3)*cos(az),
        sqrt(35)*(pow(sin(az), 4) - pow(sin(az), 2) + 1/8)*pow(cos(ele), 4),
        (3/16)*sqrt(14)*(16*pow(sin(az), 4) - 20*pow(sin(az), 2) + 5)*sin(az)*pow(cos(ele), 5),
        (3/64)*sqrt(35)*pow(cos(2*ele) + 1, 2)*(cos(ele - 4*az) - cos(ele + 4*az)),
        -1/16*sqrt(70)*(9*pow(sin(ele), 2) - 1)*(4*pow(sin(az), 2) - 3)*sin(az)*pow(cos(ele), 3),
        (1/2)*sqrt(105)*(3*pow(sin(ele), 2) - 1)*sin(ele)*sin(az)*pow(cos(ele), 2)*cos(az),
        (1/8)*sqrt(15)*(21*pow(sin(ele), 4) - 14*pow(sin(ele), 2) + 1)*sin(az)*cos(ele),
        (1/8)*(63*pow(sin(ele), 4) - 70*pow(sin(ele), 2) + 15)*sin(ele),
        (1/8)*sqrt(15)*(21*pow(sin(ele), 4) - 14*pow(sin(ele), 2) + 1)*cos(ele)*cos(az),
        (1/4)*sqrt(105)*(3*pow(sin(ele), 2) - 1)*sin(ele)*pow(cos(ele), 2)*cos(2*az),
        -1/16*sqrt(70)*(9*pow(sin(ele), 2) - 1)*(4*pow(sin(az), 2) - 1)*pow(cos(ele), 3)*cos(az),
        (3/8)*sqrt(35)*(8*pow(sin(az), 4) - 8*pow(sin(az), 2) + 1)*sin(ele)*pow(cos(ele), 4),
        (3/128)*sqrt(14)*pow(cos(2*ele) + 1, 2)*(cos(ele - 5*az) + cos(ele + 5*az))
		];


		case{order == 1} {^acn.copyRange(0,3)}
		    {order == 2} {^acn.copyRange(0,8)}
		    {order == 3} {^acn.copyRange(0,15)}
		    {order == 4} {^acn.copyRange(0,24)}
		    {order == 5} {^acn.copyRange(0,35)}
	}


*gains_ACN_N3D_cart{ |order, az, ele|

		var x,y,z, acn;

		x = 1 * cos(az) * cos(ele);
        y = 1 * sin(az) * cos(ele);
        z = 1 * sin(ele);

		acn =
		[ 1,
        sqrt(3)*y,
        sqrt(3)*z,
        sqrt(3)*x,
        sqrt(15)*x*y,
        sqrt(15)*y*z,
        (1/2)*sqrt(5)*(3*pow(z, 2) - 1),
        sqrt(15)*x*z,
        (1/2)*sqrt(15)*(pow(x, 2) - pow(y, 2)),
        (1/4)*sqrt(70)*(3*pow(x, 2)*y - pow(y, 3)),
        sqrt(105)*x*y*z,
        (1/4)*sqrt(42)*y*(5*pow(z, 2) - 1),
        (1/2)*sqrt(7)*z*(5*pow(z, 2) - 3),
        (1/4)*sqrt(42)*x*(5*pow(z, 2) - 1),
        (1/2)*sqrt(105)*z*(pow(x, 2) - pow(y, 2)),
        (1/4)*sqrt(70)*(pow(x, 3) - 3*x*pow(y, 2)),
        (3/8)*sqrt(35)*(4*pow(x, 3)*y - 4*x*pow(y, 3)),
        (3/4)*sqrt(70)*z*(3*pow(x, 2)*y - pow(y, 3)),
        (3/2)*sqrt(5)*x*y*(7*pow(z, 2) - 1),
        (3/4)*sqrt(10)*y*z*(7*pow(z, 2) - 3),
        (3/8)*(35*pow(z, 4) - 30*pow(z, 2) + 3),
        (3/4)*sqrt(10)*x*z*(7*pow(z, 2) - 3),
        (3/4)*sqrt(5)*(pow(x, 2) - pow(y, 2))*(7*pow(z, 2) - 1),
        (3/4)*sqrt(70)*z*(pow(x, 3) - 3*x*pow(y, 2)),
        (3/8)*sqrt(35)*(pow(x, 4) - 6*pow(x, 2)*pow(y, 2) + pow(y, 4)),
        (3/16)*sqrt(154)*(5*pow(x, 4)*y - 10*pow(x, 2)*pow(y, 3) + pow(y, 5)),
        (3/8)*sqrt(385)*z*(4*pow(x, 3)*y - 4*x*pow(y, 3)),
        (1/16)*sqrt(770)*(9*pow(z, 2) - 1)*(3*pow(x, 2)*y - pow(y, 3)),
        (1/2)*sqrt(1155)*x*y*z*(3*pow(z, 2) - 1),
        (1/8)*sqrt(165)*y*(21*pow(z, 4) - 14*pow(z, 2) + 1),
        (1/8)*sqrt(11)*z*(63*pow(z, 4) - 70*pow(z, 2) + 15),
        (1/8)*sqrt(165)*x*(21*pow(z, 4) - 14*pow(z, 2) + 1),
        (1/4)*sqrt(1155)*z*(pow(x, 2) - pow(y, 2))*(3*pow(z, 2) - 1),
        (1/16)*sqrt(770)*(pow(x, 3) - 3*x*pow(y, 2))*(9*pow(z, 2) - 1),
        (3/8)*sqrt(385)*z*(pow(x, 4) - 6*pow(x, 2)*pow(y, 2) + pow(y, 4)),
        (3/16)*sqrt(154)*(pow(x, 5) - 10*pow(x, 3)*pow(y, 2) + 5*x*pow(y, 4))
			];


		case{order == 1} {^acn.copyRange(0,3)}
		    {order == 2} {^acn.copyRange(0,8)}
		    {order == 3} {^acn.copyRange(0,15)}
		    {order == 4} {^acn.copyRange(0,24)}
		    {order == 5} {^acn.copyRange(0,35)}

		}

*gains_ACN_N3D_sph{ |order, az, ele|

		acn =
		[1,
         sqrt(3) * sin(az) * cos(ele),
         sqrt(3) * sin(ele),
         sqrt(3) * cos(ele) * cos(az),

         sqrt(15)*sin(az)*pow(cos(ele), 2)*cos(az),
		 (1/4)*sqrt(15)*(cos((2*ele) - az) - cos((2*ele) + az)),
		 (1/2)*sqrt(5)*((3*pow(sin(ele), 2)) - 1),
		 (1/4)*sqrt(15)*(sin((2*ele) - az) + sin((2*ele) + az)),
         (1/2)*sqrt(15)*pow(cos(ele), 2)*cos(2*az),

         (1/4)*sqrt(70)*(-4*pow(sin(az), 2) + 3)*sin(az)*pow(cos(ele), 3),
         sqrt(105)*sin(ele)*sin(az)*pow(cos(ele), 2)*cos(az),
         (1/4)*sqrt(42)*(5*pow(sin(ele), 2) - 1)*sin(az)*cos(ele),
         (1/2)*sqrt(7)*(5*pow(sin(ele), 2) - 3)*sin(ele),
         (1/4)*sqrt(42)*(5*pow(sin(ele), 2) - 1)*cos(ele)*cos(az),
         (1/2)*sqrt(105)*sin(ele)*pow(cos(ele), 2)*cos(2*az),
         (1/4)*sqrt(70)*(-4*pow(sin(az), 2) + 1)*pow(cos(ele), 3)*cos(az),

         (3/32)*sqrt(35)*pow(cos(2*ele) + 1, 2)*sin(4*az),
         (3/4)*sqrt(70)*(-4*pow(sin(az), 2) + 3)*sin(ele)*sin(az)*pow(cos(ele), 3),
         (3/2)*sqrt(5)*(7*pow(sin(ele), 2) - 1)*sin(az)*pow(cos(ele), 2)*cos(az),
         (3/4)*sqrt(10)*(7*pow(sin(ele), 2) - 3)*sin(ele)*sin(az)*cos(ele),
         (105/8)*pow(sin(ele), 4) - 45/4*pow(sin(ele), 2) + 9/8,
         (3/4)*sqrt(10)*(7*pow(sin(ele), 2) - 3)*sin(ele)*cos(ele)*cos(az),
         (3/4)*sqrt(5)*(7*pow(sin(ele), 2) - 1)*pow(cos(ele), 2)*cos(2*az),
         (3/4)*sqrt(70)*(-4*pow(sin(az), 2) + 1)*sin(ele)*pow(cos(ele), 3)*cos(az),
         sqrt(35)*(3*pow(sin(az), 4) - 3*pow(sin(az), 2) + 3/8)*pow(cos(ele), 4),

         (3/16)*sqrt(154)*(16*pow(sin(az), 4) - 20*pow(sin(az), 2) + 5)*sin(az)*pow(cos(ele), 5),
         (3/64)*sqrt(385)*pow(cos(2*ele) + 1, 2)*(cos(ele - 4*az) - cos(ele + 4*az)),
         -1/16*sqrt(770)*(9*pow(sin(ele), 2) - 1)*(4*pow(sin(az), 2) - 3)*sin(az)*pow(cos(ele), 3),
         (1/2)*sqrt(1155)*(3*pow(sin(ele), 2) - 1)*sin(ele)*sin(az)*pow(cos(ele), 2)*cos(az),
         (1/8)*sqrt(165)*(21*pow(sin(ele), 4) - 14*pow(sin(ele), 2) + 1)*sin(az)*cos(ele),
         (1/8)*sqrt(11)*(63*pow(sin(ele), 4) - 70*pow(sin(ele), 2) + 15)*sin(ele),
         (1/8)*sqrt(165)*(21*pow(sin(ele), 4) - 14*pow(sin(ele), 2) + 1)*cos(ele)*cos(az),
         (1/4)*sqrt(1155)*(3*pow(sin(ele), 2) - 1)*sin(ele)*pow(cos(ele), 2)*cos(2*az),
         -1/16*sqrt(770)*(9*pow(sin(ele), 2) - 1)*(4*pow(sin(az), 2) - 1)*pow(cos(ele), 3)*cos(az),
         (3/8)*sqrt(385)*(8*pow(sin(az), 4) - 8*pow(sin(az), 2) + 1)*sin(ele)*pow(cos(ele), 4),
         (3/128)*sqrt(154)*pow(cos(2*ele) + 1, 2)*(cos(ele - 5*az) + cos(ele + 5*az))
		];

		case{order == 1} {^acn.copyRange(0,3)}
		    {order == 2} {^acn.copyRange(0,8)}
		    {order == 3} {^acn.copyRange(0,15)}
		    {order == 4} {^acn.copyRange(0,24)}
		    {order == 5} {^acn.copyRange(0,35)}

			}


 // spherical to cartesian
  // r = 1;
  x = 1 * cos(az) * cos(ele);
  y = 1 * sin(az) * cos(ele);
  z = 1 * sin(ele);


  // These are the coefficients for n3D normalization

  n3D_1_1 = sqrt(3);
  n3D_1_0 = sqrt(3);

  n3D_2_2 = sqrt(15)/2;
  n3D_2_1 = sqrt(15)/2;
  n3D_2_0 = sqrt(5)/2;

  n3D_3_3 = sqrt(35/8);
  n3D_3_2 = sqrt(105)/2;
  n3D_3_1 = sqrt(21/8);
  n3D_3_0 = sqrt(7)/2;

  n3D_4_4 = sqrt(35)  *(3/8);
  n3D_4_3 = sqrt(35/2)*(3/2);
  n3D_4_2 = sqrt(5)   *(3/4);
  n3D_4_1 = sqrt(5/2) *(3/4);
  n3D_4_0 = (3/8);

  n3D_5_5 = sqrt(77/2) *(3/8);
  n3D_5_4 = sqrt(385)  *(3/8);
  n3D_5_3 = sqrt(385/2)*(1/8);
  n3D_5_2 = sqrt(1155) *(1/4);
  n3D_5_1 = sqrt(165)  *(1/8);
  n3D_5_0 = sqrt(11)   *(1/8);


  // These are the coefficients for sn3D normalization (ACN + sn3D == AMBIX format)
  // clearly they can be simplified but the compiler does that anyway
  // like this it is easier to compare with:
  // // http://ambisonics.ch/standards/channels/index

  sn3D_1_1 = n3D_1_1 * (1/sqrt(3));
  sn3D_1_0 = n3D_1_0 * (1/sqrt(3));

  sn3D_2_2 = n3D_2_2 * (1/sqrt(5));
  sn3D_2_1 = n3D_2_1 * (1/sqrt(5));
  sn3D_2_0 = n3D_2_0 * (1/sqrt(5));

  sn3D_3_3 = n3D_3_3 * (1/sqrt(7));
  sn3D_3_2 = n3D_3_2 * (1/sqrt(7));
  sn3D_3_1 = n3D_3_1 * (1/sqrt(7));
  sn3D_3_0 = n3D_3_0 * (1/sqrt(7));

  sn3D_4_4 = n3D_4_4 * (1/3); // 1/sqrt(9)
  sn3D_4_3 = n3D_4_3 * (1/3);
  sn3D_4_2 = n3D_4_2 * (1/3);
  sn3D_4_1 = n3D_4_1 * (1/3);
  sn3D_4_0 = n3D_4_0 * (1/3);

  sn3D_5_5 = n3D_5_5 * (1/sqrt(11));
  sn3D_5_4 = n3D_5_4 * (1/sqrt(11));
  sn3D_5_3 = n3D_5_3 * (1/sqrt(11));
  sn3D_5_2 = n3D_5_2 * (1/sqrt(11));
  sn3D_5_1 = n3D_5_1 * (1/sqrt(11));
  sn3D_5_0 = n3D_5_0 * (1/sqrt(11));



  // ambisonics channel order Set in Cartesian coordinates
  // assume x^2 + y^2 + z^2 = 1
  // To double check the equations for each channel compare with:
  // http://ambisonics.ch/standards/channels/ACN0
  //             .
  //             .
  //             .
  // http://ambisonics.ch/standards/channels/ACN35


  // Note that the sn3D and n3D factors are not the same for cartesian coordinates


  // degree = 0
  acn[ 0) = 1; //W
  // degree = 1
  acn[ 1) =     sn3D_1_1 * y; //Y
  acn[ 2) =     sn3D_1_0 * z; //Z
  acn[ 3) =     sn3D_1_1 * x; //X
  // degree = 2
  acn[ 4) = 2 * sn3D_2_2 * x * y;                     // V
  acn[ 5) = 2 * sn3D_2_1 * y * z;                     // T
  acn[ 6) =     sn3D_2_0 * ( (3*pow(z,2))  -1);       // R
  acn[ 7) = 2 * sn3D_2_1 * x * z;                     // S
  acn[ 8) =     sn3D_2_2 * ( pow(x,2) - pow(y,2) );   // U
  // degree = 3
  acn[ 9) =     sn3D_3_3 * y * ( (3*pow(x,2)) - pow(y,2) );      // Q
  acn[10) = 2 * sn3D_3_2 * z * x * y;                            // O
  acn[11) =     sn3D_3_1 * y * ( (5*pow(z,2)) - 1);              // M
  acn[12) =     sn3D_3_0 * z * ( (5*pow(z,2)) - 3);              // K
  acn[13) =     sn3D_3_1 * x * ( (5*pow(z,2)) - 1);              // L
  acn[14) =     sn3D_3_2 * z * ( pow(x,2) - pow(y,2) );          // N
  acn[15) =     sn3D_3_3 * x * ( pow(x,2) - (3*pow(y,2)) );      // P
  // degree = 4
  acn[16) = 4 * sn3D_4_4 * x * y * ( pow(x,2) - pow(y,2) );                       //
  acn[17) =     sn3D_4_3 * y * z * ( (3*pow(x,2) ) - pow(y,2));                   //
  acn[18) = 2 * sn3D_4_2 * x * y * ( (7*pow(z,2)) - 1 );                          //
  acn[19) = 2 * sn3D_4_1 * y * z * ( (7*pow(z,2)) - 3 );                          //
  acn[20) =     sn3D_4_0 * ( (35*pow(z,4)) - (30*pow(z,2)) + 3 );                 //
  acn[21) = 2 * sn3D_4_1 * x * z * ( (7*pow(z,2)) - 3);                           //
  acn[22) =     sn3D_4_2 * ( pow(x,2) - pow(y,2) ) * ( (7*pow(z,2)) - 1 );        //
  acn[23) =     sn3D_4_3 * x * z * ( pow(x,2) -  (3*pow(y,2)) );                  //
  acn[24) =     sn3D_4_4 * ( pow(x,4)  -  (6*pow(x,2)*pow(y,2))  +  pow(y,4) );   //
  // degree = 5

  acn[25) =     sn3D_5_5 * y * ( (5*pow(x,4)) - (10*pow(x,2)*pow(y,2)) + pow(y,4) );
  acn[26) = 4 * sn3D_5_4 * x * y * z * (pow(x,2) - pow(y,2));
  acn[27) =     sn3D_5_3 * y * ( pow(y,4) - (2*pow(x,2)*pow(y,2)) - (3*pow(x,4))  -  (8*pow(y,2)*pow(z,2))   +  (24*pow(x,2)*pow(z,2)) );
  acn[28) = 2 * sn3D_5_2 * x * y * z * ( (2*pow(z,2)) - pow(x,2)  -  pow(y,2)  );
  acn[29) =     sn3D_5_1 * y * ( pow(x,4)  +  (2*pow(x,2)*pow(y,2))  +  pow(y,4)  -  (12*pow(x,2)*pow(z,2))  -  (12*pow(y,2)*pow(z,2))  +  (8*pow(z,4)) );
  acn[30) =     sn3D_5_0 * z * ( (63*pow(z,4))  -   (70*pow(z,2))   +  15);
  acn[31) =     sn3D_5_1 * x * ( pow(x,4)  +  (2*pow(x,2)*pow(y,2))  +  pow(y,4)  -  (12*pow(x,2)*pow(z,2))  -  (12*pow(y,2)*pow(z,2))  +  (8*pow(z,4)) );
  acn[32) =     sn3D_5_2 * z * ( (2*pow(x,2)*pow(z,2)) - (2*pow(y,2)*pow(z,2)) - pow(x,4) + pow(y,4) );
  acn[33) =     sn3D_5_3 * x * ( (2*pow(x,2)*pow(y,2)) + (8*pow(x,2)*pow(z,2)) - (24*pow(y,2)*pow(z,2)) - pow(x,4) + (3*pow(y,4)) ) ;
  acn[34) =     sn3D_5_4 * z * ( pow(x,4) - (6*pow(x,2)*pow(y,2)) + pow(y,4) );
  acn[35) =     sn3D_5_5 * x * ( pow(x,4) - (10*pow(x,2)*pow(y,2)) + (5*pow(y,4)) ) ;

*/

}

