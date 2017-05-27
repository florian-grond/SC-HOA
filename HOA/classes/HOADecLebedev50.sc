HOADecLebedev50 : HOADecLebedev {
	classvar <>hrirFilters;
	classvar <numChannels;
	classvar <maxOrder;

	*initClass {
		numChannels = 50;
		maxOrder = 5;

	}


	*ar { |order, in, input_gains = 0, output_gains = 0, yes = 1, speakers_radius = 1, hrir_Filters = 0|
		var decoded;
		var maxChannels = min((order+1).squared, (this.maxOrder+1).squared);

		if(in.size < maxChannels, {
			order = in.size.sqrt - 1;
			"%.ar: in.size does not match order. Reducing order to %.".format(this.class, order).inform;
		});

		if(order > this.maxOrder, {
			"%:ar: order % is not implemented".format(this.class, order).error;
			^nil;
		});

		decoded = switch(order,
			1, {
				FaustHOADecLebedev501.ar(
					in[0], in[1], in[2], in[3],
					inputs_gain: input_gains,
					outputs_gain: output_gains,
					yes: yes,
					speakers_radius: speakers_radius
				);
			},
			2, {
				FaustHOADecLebedev502.ar(
					in[0], in[1], in[2], in[3], in[4],
					in[5], in[6], in[7], in[8],
					inputs_gain: input_gains,
					outputs_gain: output_gains,
					yes: yes,
					speakers_radius: speakers_radius
				)
			},
			3, {
				FaustHOADecLebedev503.ar(
					in[ 0], in[ 1], in[ 2], in[ 3],
					in[ 4], in[ 5], in[ 6], in[ 7],
					in[ 8], in[ 9], in[10], in[11],
					in[12], in[13], in[14], in[15],
					inputs_gain: input_gains,
					outputs_gain: output_gains,
					yes: yes,
					speakers_radius: speakers_radius
				)
			},
			4, {
				FaustHOADecLebedev504.ar(
					in[ 0], in[ 1], in[ 2], in[ 3],
					in[ 4], in[ 5], in[ 6], in[ 7],
					in[ 8], in[ 9], in[10], in[11],
					in[12], in[13], in[14], in[15],
					in[16], in[17], in[18], in[19],
					in[20], in[21], in[22], in[23], in[24],
					inputs_gain: input_gains,
					outputs_gain: output_gains,
					yes: yes,
					speakers_radius: speakers_radius
				)
			},
			5, {
				FaustHOADecLebedev505.ar(
					in[ 0], in[ 1], in[ 2], in[ 3],
					in[ 4], in[ 5], in[ 6], in[ 7],
					in[ 8], in[ 9], in[10], in[11],
					in[12], in[13], in[14], in[15],
					in[16], in[17], in[18], in[19],
					in[20], in[21], in[22], in[23],
					in[24], in[25], in[26], in[27],
					in[28], in[29], in[30], in[31],
					in[32], in[33], in[34], in[35],
					inputs_gain: input_gains,
					outputs_gain: output_gains,
					yes: yes,
					speakers_radius: speakers_radius
				)
			}
		);

		^this.pr_applyHrir(decoded);
	}
}