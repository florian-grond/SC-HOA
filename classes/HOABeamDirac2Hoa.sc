HOABeamDirac2Hoa {

	*ar { |order, in, az, ele, level, on = 1, timer_manual = 0, crossfade = 1, focus = 0|
		// az = az * -1; ele = ele * -1;  // the Faust Ugens seem to have those reversed
		// HOABeamDirac2HOA1:
		// on(0.0), crossfade(1.0), gain(0.0), azimuth(0.0), elevation(0.0), timer_manual(0.0), focus(0.0)
		var parameters = [on, crossfade, 0.0, az, ele, timer_manual, focus];
		^switch(order,
			1, { HOABeamDirac2HOA1.ar(*in.keep(4) ++ parameters) },
			2, { HOABeamDirac2HOA2.ar(*in.keep(9) ++ parameters) },
			3, { HOABeamDirac2HOA3.ar(*in.keep(16) ++ parameters) },
			4, { HOABeamDirac2HOA4.ar(*in.keep(25) ++ parameters) },
			5, { HOABeamDirac2HOA5.ar(*in.keep(36) ++ parameters) },
			{ Error("this order is not implemented for HOABeamDirac2Hoa: " ++ order).throw }
		)
	}

}

