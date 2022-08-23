HOABeamHCard2Mono {

	*ar { |order, in, az=0, ele=0, gain=0|
		// HOABeamHCardio2Mono1: int_float(0.0), order(0.0), output_gain(0.0), azimuth(0.0), elevation(0.0)
		var parameters = [0.0, 0.0, gain, az, ele];
		^switch(order,
			1, { HOABeamHCardio2Mono1.ar(*in.keep(4) ++ parameters) },
			2, { HOABeamHCardio2Mono2.ar(*in.keep(9) ++ parameters) },
			3, { HOABeamHCardio2Mono3.ar(*in.keep(16) ++ parameters) },
			4, {
				"order 4 is not implemented for HOABeamHCardio2Mono. \n returning unaltered bformat.".warn;
				in
			},
			5, { "order 5 is not implemented for HOABeamHCardio2Mono. \n returning unaltered bformat.".warn;
				in
			},
			{ Error("this order is not implemented for HOABeamHCardio2Mono: " ++ order).throw }
		)
	}
}

