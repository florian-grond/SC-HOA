HOAConverterAcnN3d2AcnSn3d {

	*ar { |order, in|

		^switch(order,
			1, { HOAConverterAcnN3d2AcnSn3d1.ar(*in.keep(4)) },
			2, { HOAConverterAcnN3d2AcnSn3d2.ar(*in.keep(9)) },
			3, { HOAConverterAcnN3d2AcnSn3d3.ar(*in.keep(16)) },
			4, { HOAConverterAcnN3d2AcnSn3d4.ar(*in.keep(25)) },
			5, { HOAConverterAcnN3d2AcnSn3d5.ar(*in.keep(36)) },
			{ Error("this order is not implemented for HOAConverterAcnN3d2AcnSn3d: " ++ order).throw }
		)
	}

}

