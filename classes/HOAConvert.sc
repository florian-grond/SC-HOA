HOAConvert{

	*ar { |order, in, inFormat, outFormat|
		var inputFormat, outputFormat, unconverted;

		unconverted = 0;
		case{inFormat == \ACN_N3D}{inputFormat = 1}
			   {inFormat == \ACN_SN3D}{inputFormat = 2}
		       {inFormat == \FuMa}{inputFormat = 3}
		{ "not a proper input format. \n choose from \\ACN_N3D \\ACN_SN3D or \\FuMa. \n Returning b-format as is.".postln; unconverted = 1; };

		case{outFormat == \ACN_N3D}{outputFormat = 1}
			   {outFormat == \ACN_SN3D}{outputFormat = 2}
		       {outFormat == \FuMa}{outputFormat = 3}
		{ "not a proper output format. \n choose from \\ACN_N3D \\ACN_SN3D or \\FuMa. \n Returning b-format as is.".postln; unconverted = 1; };

		case{outFormat == 3 && order > 3 }
		{ "Conversion TO FuMa only supported up to order 3 \n Returning b-format as is.".postln; unconverted = 1; };

		case{inFormat == 3 && order > 3 }
		{ "Conversion FROM FuMa only supported up to order 3 \n Returning b-format as is.".postln; unconverted = 1; };

		case{unconverted == 1}
		{^in}
/*
		// converting ACN_N3D  to \ACN_SN3D
	    case{inputFormat == 1 && outputFormat == 2}
			{ ^HOAConverterAcnN3d2AcnSn3d.ar(order, in)}

		// converting ACN_N3D  to \FuMa
	    case{inputFormat == 1 && outputFormat == 3}
			{ ^HOAConverterAcnN3d2Fuma.ar(order, in)}

		// converting ACN_SN3D  to \ACN_N3D
	    case{inputFormat == 2 && outputFormat == 1}
			{ ^HOAConverterAcnSn3d2AcnN3d.ar(order, in)}

		// converting ACN_SN3D  to \FuMa
	    case{inputFormat == 2 && outputFormat == 3}
			{ ^HOAConverterAcnSn3d2Fuma.ar(order, in)}

		// converting FuMa  to \ACN_N3D
	    case{inputFormat == 3 && outputFormat == 1}
			{ ^HOAConverterFuma2AcnN3d.ar(order, in)}

		// converting FuMa  to \ACN_SN3D
	    case{inputFormat == 3 && outputFormat == 2}
			{ ^HOAConverterFuma2AcnSn3d.ar(order, in)}

		*/


				// converting ACN_N3D  to \ACN_SN3D
	    case{inputFormat == 1 && outputFormat == 2}
			{ ^in}

		// converting ACN_N3D  to \FuMa
	    case{inputFormat == 1 && outputFormat == 3}
			{ ^in}

		// converting ACN_SN3D  to \ACN_N3D
	    case{inputFormat == 2 && outputFormat == 1}
			{ ^in}

		// converting ACN_SN3D  to \FuMa
	    case{inputFormat == 2 && outputFormat == 3}
			{ ^in}

		// converting FuMa  to \ACN_N3D
	    case{inputFormat == 3 && outputFormat == 1}
			{ ^in}

		// converting FuMa  to \ACN_SN3D
	    case{inputFormat == 3 && outputFormat == 2}
			{ ^in}



	}
}