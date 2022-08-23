HOADecBinaural {

	*ar { |order, in, in_gain, out_gain|
		// HOADecBinaural1: inputs_gain(0.0), outputs_gain(0.0)
		^switch(order,
			1, { HOADecBinaural1.ar(*in.keep(4) ++ [in_gain, out_gain]) },
			2, { HOADecBinaural2.ar(*in.keep(9) ++ [in_gain, out_gain]) },
			3, { HOADecBinaural3.ar(*in.keep(16) ++ [in_gain, out_gain]) },
			4, { HOADecBinaural4.ar(*in.keep(25) ++ [in_gain, out_gain]) },
			5, { HOADecBinaural5.ar(*in.keep(36) ++ [in_gain, out_gain]) },
			{ Error("this order is not implemented for HOAConverterFuma2AcnN3d: " ++ order).throw }
		)
	}

}

