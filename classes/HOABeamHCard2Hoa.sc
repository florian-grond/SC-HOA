HOABeamHCard2Hoa {

	*ar { |order, in, az, ele, int_float = 0, cardOrder = 1|
		// 	az = az.neg; ele = ele.neg; // the Faust Ugens seem to have those reversed
		// HOABeamHCardio2HOA1: azimuth(0.0), elevation(0.0), int_float(0.0), order(0.0)
		var parameters = [az, ele, int_float, cardOrder];
		^switch(order,
			1, { HOABeamHCardio2HOA1.ar(*in.keep(4) ++ parameters) },
			2, { HOABeamHCardio2HOA2.ar(*in.keep(9) ++ parameters) },
			3, { HOABeamHCardio2HOA3.ar(*in.keep(16) ++ parameters) },
			4, {
				"order 4 is not implemented for HOABeamHCardio2HOA. \n returning unaltered bformat.".warn;
				in
			},
			5, { "order 5 is not implemented for HOABeamHCardio2HOA. \n returning unaltered bformat.".warn;
				in
			},
			{ Error("this order is not implemented for HOABeamHCard2Hoa: " ++ order).throw }
		)
	}
}

