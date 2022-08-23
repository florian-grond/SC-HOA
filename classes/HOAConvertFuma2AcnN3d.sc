HOAConverterFuma2AcnN3d {

	*ar { |order, in|
		^switch(order,
			1, { HOAConverterFuma2AcnN3d1.ar(*in.keep(4)) },
			2, { HOAConverterFuma2AcnN3d2.ar(*in.keep(9)) },
			3, { HOAConverterFuma2AcnN3d3.ar(*in.keep(16)) },
			{ Error("this order is not implemented for HOAConverterFuma2AcnN3d: " ++ order).throw }
		)
	}

}
