HOABeamHCard2Hoa{

	*ar { |order, in, az, ele, int_float = 0, cardOrder = 1|
		var numInputs, argList, ugen;

		numInputs = switch(order)
		{ 1 } { 4 }
		{ 2 } { 9 }
		{ 3 } { 16 }
		{ 4 } { 25 }
		{ 5 } { 36 };
		{ 36 } // default

		if(order > 3) {
			"order % is not implemented for HOABeamHCardio2HOA. \n returning unaltered bformat.".format(order).postln;
			^in.keep(numInputs)
		}:

		ugen = switch(order)
		{ 1 } { HOABeamHCardio2HOA1 }
		{ 2 } { HOABeamHCardio2HOA2 }
		{ 3 } { HOABeamHCardio2HOA3 };

		argList = in.keep(numInputs) ++ [az, ele, int_float, cardOrder];

		^ugen.ar(*argList)
	}

}