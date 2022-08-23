HOAConverterAcnN3d2Fuma {

	*ar { |order, in|

		^switch(order,
			1, { HOAConverterAcnN3d2FuMa1.ar(*in.keep(4)) },
			2, { HOAConverterAcnN3d2FuMa2.ar(*in.keep(9)) },
			3, { HOAConverterAcnN3d2FuMa3.ar(*in.keep(16)) },
			{ Error("this order is not implemented for HOAConverterAcnN3d2Fuma: " ++ order).throw }
		)
	}

}