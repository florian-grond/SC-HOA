HOADecLebedev50 {
	classvar <hrirFilters;

	*loadHrirFilters {|server, path|

		path = path ?? {HOA.userKernelDir++"/FIR/hrir/hrir_lebedev50/"};

		hrirFilters = 50.collect({|i|	[
			Buffer.read(server, path ++"/hrir_"++(i+1)++"_L.wav"),
			Buffer.read(server, path ++"/hrir_"++(i+1)++"_R.wav")
		] });
	}

	*ar {  |order, in, input_gains = 0, output_gains = 0, yes = 1, speakers_radius = 1, hrir_Filters = 0|
		case{order == 1}
		{ var in1, // declare variables for the b-format array
			in2, in3, in4, decoded;
			#in1, // distribute the channels from the array
			in2, in3, in4 = in;
			decoded = FaustHOADecLebedev501.ar(in1, // return the Ugen
				in2, in3, in4,
				inputs_gain: input_gains, outputs_gain: output_gains, yes: yes, speakers_radius: speakers_radius );

			if(hrir_Filters == 0,
				{ ^decoded},
				{if(hrirFilters == nil,{"please load the HRIR filters into buffers first (HOADecLebedev06.loadHrirFilters(s))".postln; ^decoded},
					{// return the HRIR convolved binaural signal
						decoded = decoded.collect({|item,i|
							[ Convolution2.ar(  item, 	hrirFilters[i][0], 0, 4096, 1), // left channel
								Convolution2.ar( item, 	hrirFilters[i][1], 0, 4096, 1)] // right channel
						}).sum; // sum the [[L,R],[L,R],[L,R],...[L,R]] array
						^decoded}
				)
			} ) // endif
		}
		{order == 2}
		{var in1, // declare variables for the b-format array
			in2, in3, in4,
			in5, in6, in7, in8, in9, decoded;
			#in1, // distribute the channels from the array
			in2, in3, in4,
			in5, in6, in7, in8, in9 = in;
			decoded = FaustHOADecLebedev502.ar(in1,
				in2, in3, in4,
				in5, in6, in7, in8, in9,
				inputs_gain: input_gains, outputs_gain: output_gains, yes: yes, speakers_radius: speakers_radius);

			if(hrir_Filters == 0,
				{ ^decoded},
				{if(hrirFilters == nil,{"please load the HRIR filters into buffers first (HOADecLebedev06.loadHrirFilters(s))".postln; ^decoded},
					{// return the HRIR convolved binaural signal
						decoded = decoded.collect({|item,i|
							[ Convolution2.ar(  item, 	hrirFilters[i][0], 0, 4096, 1), // left channel
								Convolution2.ar( item, 	hrirFilters[i][1], 0, 4096, 1)] // right channel
						}).sum; // sum the [[L,R],[L,R],[L,R],...[L,R]] array
						^decoded}
				)
			} ) // endif
		}
		{order == 3}
		{var in1, // declare variables for the b-format array
			in2,   in3,   in4,
			in5,   in6,   in7,   in8,   in9,
			in10, in11, in12, in13, in14, in15, in16, decoded;
			#in1, // distribute the channels from the array
			in2, in3, in4,
			in5, in6, in7, in8, in9,
			in10, in11, in12, in13, in14, in15, in16 = in;
			decoded = FaustHOADecLebedev503.ar(in1,  // return the Ugen
				in2, in3, in4,
				in5, in6, in7, in8, in9,
				in10, in11, in12, in13, in14, in15, in16,
				inputs_gain: input_gains, outputs_gain: output_gains, yes: yes, speakers_radius: speakers_radius);

			if(hrir_Filters == 0,
				{ ^decoded},
				{if(hrirFilters == nil,{"please load the HRIR filters into buffers first (HOADecLebedev06.loadHrirFilters(s))".postln; ^decoded},
					{// return the HRIR convolved binaural signal
						decoded = decoded.collect({|item,i|
							[ Convolution2.ar(  item, 	hrirFilters[i][0], 0, 4096, 1), // left channel
								Convolution2.ar( item, 	hrirFilters[i][1], 0, 4096, 1)] // right channel
						}).sum; // sum the [[L,R],[L,R],[L,R],...[L,R]] array
						^decoded}
				)
			} ) // endif
		}

		{order == 4}
		{var in1, // declare variables for the b-format array
			in2,   in3,   in4,
			in5,   in6,   in7,   in8,   in9,
			in10, in11, in12, in13, in14, in15, in16,
			in17, in18, in19, in20, in21, in22, in23, in24, in25, decoded;
			#in1, // distribute the channels from the array
			in2, in3, in4,
			in5, in6, in7, in8, in9,
			in10, in11, in12, in13, in14, in15, in16,
			in17, in18, in19, in20, in21, in22, in23, in24, in25 = in;
			decoded = FaustHOADecLebedev504.ar(in1,  // return the Ugen
				in2, in3, in4,
				in5, in6, in7, in8, in9,
				in10, in11, in12, in13, in14, in15, in16,
				in17, in18, in19, in20, in21, in22, in23, in24, in25,
				inputs_gain: input_gains, outputs_gain: output_gains, yes: yes, speakers_radius: speakers_radius);

			if(hrir_Filters == 0,
				{ ^decoded},
				{if(hrirFilters == nil,{"please load the HRIR filters into buffers first (HOADecLebedev06.loadHrirFilters(s))".postln; ^decoded},
					{// return the HRIR convolved binaural signal
						decoded = decoded.collect({|item,i|
							[ Convolution2.ar(  item, 	hrirFilters[i][0], 0, 4096, 1), // left channel
								Convolution2.ar( item, 	hrirFilters[i][1], 0, 4096, 1)] // right channel
						}).sum; // sum the [[L,R],[L,R],[L,R],...[L,R]] array
						^decoded}
				)
			} ) // endif
		}
		{order == 5}
		{var in1, // declare variables for the b-format array
			in2,   in3,   in4,
			in5,   in6,   in7,   in8,   in9,
			in10, in11, in12, in13, in14, in15, in16,
			in17, in18, in19, in20, in21, in22, in23, in24, in25,
			in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36, decoded;
			#in1, // distribute the channels from the array
			in2, in3, in4,
			in5, in6, in7, in8, in9,
			in10, in11, in12, in13, in14, in15, in16,
			in17, in18, in19, in20, in21, in22, in23, in24, in25,
			in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36 = in;
			decoded = FaustHOADecLebedev505.ar(in1,  // return the Ugen
				in2, in3, in4,
				in5, in6, in7, in8, in9,
				in10, in11, in12, in13, in14, in15, in16,
				in17, in18, in19, in20, in21, in22, in23, in24, in25,
				in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36,
				inputs_gain: input_gains, outputs_gain: output_gains, yes: yes, speakers_radius: speakers_radius);

			if(hrir_Filters == 0,
				{ ^decoded},
				{if(hrirFilters == nil,{"please load the HRIR filters into buffers first (HOADecLebedev06.loadHrirFilters(s))".postln; ^decoded},
					{// return the HRIR convolved binaural signal
						decoded = decoded.collect({|item,i|
							[ Convolution2.ar(  item, 	hrirFilters[i][0], 0, 4096, 1), // left channel
								Convolution2.ar( item, 	hrirFilters[i][1], 0, 4096, 1)] // right channel
						}).sum; // sum the [[L,R],[L,R],[L,R],...[L,R]] array
						^decoded}
				)
			} ) // endif
		}
		{"this order is not implemented".postln}
	}

}