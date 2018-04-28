/*
2016/2017 Florian Grond
*/


HOAAmbiDecoderHelper {

	var   <>ambiToolboxPath; //,   <userSoundsDir,   <userKernelDir;
	var   <>speakerArrayName; //,  <userSoundsDir,   <userKernelDir;
	var   <>speakerPositions; //,
	var   <>sweeterPositions; //,
	var   <>speakerLabels; //
	var   <>centerOfGravity;
	var   <>decoderPath;
	var   <>sweetSpot;

	initClass {|path|
	}


	setAmbiToolboxPath{|path|
		this.ambiToolboxPath = path;
		// File.mkdir(this.ambiToolboxPath);
		// This is to get the dir name;
		this.decoderPath =  this.ambiToolboxPath;

	}

    setSpeakerArrayName{|name|
        this.speakerArrayName = name;
		// this.decoderPath = thisProcess.platform.userExtensionDir++"/HOAdecoders/";
		// File.mkdir(this.decoderPath);
	}


	specifySpeakersAsXYZ{|speakers|
		this.speakerPositions = [];
		this.speakerLabels = [];
		this.speakerPositions = speakers.collect({|item,i| Cartesian(item[0], item[1], item[2] ) });

		this.speakerLabels = speakers.collect({|item,i| item[3] });
		this.speakerLabels.do({|item,i|  if(this.speakerLabels[i] == nil, {this.speakerLabels[i] =i},{this.speakerLabels[i]})  });
		this.calculateCenterOfGravity();
		this.sweeterPositions = this.speakerPositions.deepCopy;

	}

	specifySpeakersAsRadAzEl{|speakers|
		this.speakerPositions = [];
		this.speakerLabels = [];
		this.speakerPositions = speakers.collect({|item,i| Spherical(item[0], item[1].linlin(-180, 180, -pi, pi),
			item[2].linlin(-180, 180, -pi, pi) ).asCartesian.trunc(0.00000001) });

		this.speakerLabels = speakers.collect({|item,i| item[3] });
		this.speakerLabels.do({|item,i|  if(this.speakerLabels[i] == nil, {this.speakerLabels[i] =i})  });
		this.calculateCenterOfGravity();
		this.sweeterPositions = this.speakerPositions.deepCopy;
	}


	calculateCenterOfGravity{
		var array, size;
		size = speakerPositions.size;
		array = speakerPositions.collect({|item,i|   item.asArray   }).deepCopy;
		centerOfGravity = array.sum / size;
	}

    setSweetSpot{|sweet|
		this.sweetSpot = Cartesian(sweet[0],sweet[1],sweet[2]);

		this.sweeterPositions = this.speakerPositions.deepCopy;
		this.speakerPositions.do({|item,i| this.sweeterPositions[i] = this.speakerPositions[i]  -  this.sweetSpot;    });
	}

	makeAmbiDecoderSpeakerPositionFile
	{this.speakerPositionFile(this.ambiToolboxPath++"examples/"++this.speakerArrayName++".m")}

	speakerPositionFile{|path|
		var file;

		file = File.open(path ,"w");

		file.write("function [ val ] =" ++ this.speakerArrayName++"() \n");
        file.write("val.name = '"++this.speakerArrayName++"';\n\n\n");

        file.write("S=[\n");
        sweeterPositions.do({|item,i|
			file.write(  "\t"++"\t"++item.x.trunc(0.0001).asString++"\t"++item.y.trunc(0.0001).asString++"\t"++item.z.trunc(0.0001).asString++"\n"  )    });
        file.write("];\n\n\n");

        file.write("    [val.az val.el val.r] = cart2sph(S(:,1),S(:,2),S(:,3)); \n");
        file.write("    [val.x val.y val.z] = sph2cart(val.az, val.el, 1); \n\n\n");

        file.write("val.id = {");
		speakerLabels.do({|item,i|  file.write("'"++item.asString++"'"); if(i<(speakerPositions.size-1),  {file.write(",")});         } );
        file.write("}; \n\n\n end");
        file.close;
	}


	makeAmbiDecoderAllradRunFile{|order=2, chanOrder='ACN', chanNorm='N3D'|
		this.ambiDecoderAllradRunFile(this.ambiToolboxPath, order, chanOrder, chanNorm);
	}

	ambiDecoderAllradRunFile{|path_ADT, order , chanOrder , chanNorm |
		var file;

		file = File.open(path_ADT++"examples/"++"run_dec_"++this.speakerArrayName++".m" ,"w");

		file.write("function [ output_args ] ="++"run_dec_"++this.speakerArrayName++"( ) \n");
		file.write("\n\n");
		file.write("\t % set the correct paths to be added to the MatLab searchpaths\n");

		file.write("\t cd '"++path_ADT++"examples/'; \n");
		file.write("\t addpath('"++path_ADT++"examples/"++"'); \n");
	    file.write("\t addpath('"++path_ADT++"matlab/"++"'); \n");
	    file.write("\t addpath('"++this.decoderPath++"decoders/"++"'); \n");

		file.write("\n\n");
		file.write("\t % set the variables from the arguments\n");
		file.write("\t S = "++this.speakerArrayName++"(); % the speaker struct \n");
		file.write("\t h_order = "++ order.asString ++"; % horizontal order \n");
		file.write("\t v_order = "++ order.asString ++"; % vertical order \n");
		file.write("\t mixed_order_scheme = 'HP'; % mixed order scheme HV or HP \n");
		file.write("\t chanOrder = '"++chanOrder++"' ; % the channel order convention AMBIX or FUMA \n");
		file.write("\t chanNorm = '"++chanNorm++"' ; % the channel order normalization N3D or SN3D \n");
		file.write("\t imgSpeakers = [0 0 -1]; \n");
		//file.write("\t decoder_type = 2; % (1) 1 band (2) 2 band one matrix (3) 2 band 2 matricies \n");
		file.write("\t out_path = '"++ this.decoderPath++"decoders/"++this.speakerArrayName++"'; \n");

        file.write("\n");
		file.write("\t% set the correct path for the execution of the faust scripts\n");
		file.write("\t PATH = getenv('PATH'); \n");
		file.write("\t setenv('PATH', [PATH ':/usr/local/bin']); \n");

		file.write("\n\n");
		file.write("\t% looping up to the order set above \n");

		file.write("\t for order = 1:h_order \n");
		file.write("\n \t % set the channel definition first\n");
    	file.write("\t\t C = ambi_channel_definitions(order, order, mixed_order_scheme, chanOrder, chanNorm); \n");

		file.write("\t\t% execute the ambi_run_allrad() function with the parameters from above\n");
		file.write("\t\t ambi_run_allrad(...\n");
		file.write("\t\t\t S, ...  % speaker array struct\n");
		file.write("\t\t\t C, ...  % ambisonic order as definded in the channel struct C\n");
		file.write("\t\t\t imgSpeakers, ... % imaginary speakers, none in this case\n");
		file.write("\t\t\t strcat(out_path,num2str(order,0)), ... % outpath where the files are written to, [] = default\n");
		file.write("\t\t\t true, ... % do plots, default is true for MATLAB, false for Octave\n");
		// file.write("\t\t\t mixed_order_scheme ...% mixed order scheme HV or HP\n");
		// file.write("\t\t\t decoder_type ...% decoder type 1, 2 or 3\n");
		file.write("\t\t\t mixed_order_scheme ...% mixed order scheme HV or HP\n");
		// file.write("\t\t\t decoder_type ...% decoder type 1, 2 or 3\n");
		file.write("\t\t);\n");
		file.write("\n");
		file.write("\t% convert the faustfile generated with the abisonics decoder toolkit from above into scsynth and supernova Ugens\n");

		file.write("\t unix(strcat(\"faust2supercollider -sn -ks \",out_path,num2str(order,0),\".dsp\"));\n");

		file.write("\t end \n");

		file.write("end \n");

		file.close;
	}

	makeWrapperClass{|path_ADT, order|
		var file, path, counter;
		counter = 1;
		path = path_ADT++"decoders/HOADec"++this.speakerArrayName++".sc";
		path.postln;
		file = File.open(path,"w");
		file.write("HOADec"++this.speakerArrayName++"{\n\n");

		file.write("classvar <>speakerPositions;\n");
		file.write("classvar <>sweeterPositions;\n");
		file.write("classvar <>speakerLabels;\n");
		file.write("classvar <>sweetSpot;\n\n");

		file.write("*initClass { \n");
		file.write("speakerPositions = [\n");
		this.speakerPositions.do({|item,i| if(i<(this.speakerPositions.size-1),
			{file.write("\t\t\t\t\t"++item.asCompileString++",  //"++this.speakerLabels[i]++"\n")},
			{file.write("\t\t\t\t\t"++item.asCompileString++"  //"++this.speakerLabels[i]++"\n")})}
		      );
		file.write("\t\t\t\t\t];\n\n");

		file.write("sweeterPositions = [\n");
		this.sweeterPositions.do({|item,i| if(i<(this.sweeterPositions.size-1),
			{file.write("\t\t\t\t\t"++item.trunc(0.001).asCompileString++",  //"++this.speakerLabels[i]++"\n")},
			{file.write("\t\t\t\t\t"++item.trunc(0.001).asCompileString++"  //"++this.speakerLabels[i]++"\n")})}
		     );
		file.write("\t\t\t\t\t];\n\n");

		file.write("speakerLabels = [\n");
		this.speakerLabels.do({|item,i| if(i<(this.speakerLabels.size-1),
			{file.write("\t\t\t\t\t"++item.asCompileString++",\n")},
			{file.write("\t\t\t\t\t"++item.asCompileString++"\n")})}
		     );
		file.write("\t\t\t\t\t];\n\n");

		file.write("sweetSpot = "++this.sweetSpot.trunc(0.001).asCompileString++";\n\n");

		file.write("}\n\n");

		file.write("*ar { |order, in, gain(-10.0), lf_hf(0.0), mute(0.0), xover(400.0)|\n");
		if(counter <= order,
		{
        file.write("// declare variables for the b-format array in\n");
        file.write("// distribute the channels from the array over in1 ... inN\n");
        file.write("// return the Ugen with the b-format channels and with the args from the *ar method\n");
        file.write("case\n{order == 1}\n");
        file.write("\t{ var in1, in2, in3, in4; \n");
        file.write("\t#in1,in2, in3, in4 = in; \n");
		file.write("\t^Faust"++this.speakerArrayName++counter.asString++".ar(in1, in2, in3, in4, gain, lf_hf, mute, xover)}\n\n");
		});
		counter = counter + 1;
		if(counter <= order,
		{
	    file.write("{order == 2}\n");
        file.write("\t{ var in1, in2, in3, in4, in5, in6, in7, in8, in9; \n");
        file.write("\t#in1, in2, in3, in4, in5, in6, in7, in8, in9 = in; \n");
        file.write("\t^Faust"++this.speakerArrayName++counter.asString++".ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, gain, lf_hf, mute, xover)}\n\n");
		}
		);
		counter = counter + 1;
		if(counter <= order,
		{
	    file.write("{order == 3}\n");
        file.write("\t{ var in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16; \n");
        file.write("\t#in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16 = in; \n");
        file.write("\t^Faust"++this.speakerArrayName++counter.asString++".ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, gain, lf_hf, mute, xover)}\n\n");
		}
		);
		counter = counter + 1;
		if(counter <= order,
		{
	    file.write("{order == 4}\n");
        file.write("\t{ var in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25; \n");
        file.write("\t#in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25 = in; \n");
        file.write("\t^Faust"++this.speakerArrayName++counter.asString++".ar(in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25, gain, lf_hf, mute, xover)} \n\n");
		}
		);
		counter = counter + 1;
		if(counter <= order,
		{
	    file.write("{order == 5}\n");
        file.write("\t{var in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25, in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36; \n");
        file.write("\t#in1, in2, in3, in4, in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25, in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36 = in; \n");
        file.write("\t^Faust"++this.speakerArrayName++counter.asString++".ar(in1,in2, in3, in4,in5, in6, in7, in8, in9, in10, in11, in12, in13, in14, in15, in16, in17, in18, in19, in20, in21, in22, in23, in24, in25, in26, in27, in28, in29, in30, in31, in32, in33, in34, in35, in36, gain, lf_hf, mute, xover)} \n\n");

				file.write("{\"Order "++counter.asString++" is not implemented for HOADec"++this.speakerArrayName++"\".postln} \n } } \n\n");
		}
		);



		file.write("\n\n}");

		file.close
	}

	install{
		File.mkdir(thisProcess.platform.userExtensionDir++"/HOAdecoders/");
		File.copy(this.decoderPath++"/decoders/", thisProcess.platform.userExtensionDir++"/HOAdecoders/"++this.speakerArrayName )
	}

	makeDecoderDocumentation{
		this.decoderDocumentation(this.ambiToolboxPath);
	}

	decoderDocumentation{|path_ADT|
		var file, helpSourcePath;
		helpSourcePath = this.decoderPath++"/decoders/HelpSource/";
		File.mkdir(helpSourcePath);
		file = File.open(helpSourcePath++this.speakerArrayName++".schelp" ,"w");
		file.write("class:: Faust"++this.speakerArrayName++" \n");
		file.write("summary:: This is a HOA decoder for a speaker Array compiled using the Abisonics decoder toolkit\n");
		file.write("CATEGORIES:: Libraries>HOA");
		file.write("related:: Tutorials/HOA_Tutorial_Overview \n");
		file.write("categories:: Files \n");
		file.write("description:: This is a Higher Order Ambisonics Converter compiled from a Faust file generated with the Abisonics decoder toolkit (ADT) \n");

		file.write("ClassMethods:: \n");

		file.write("method::new \n");
		file.write("argument::commandLine \n");

		file.write("code::\n
// this pipes in stdout from ls \n
( \n
var p, l; \n
p.close;					// close the pipe to avoid that nasty buildup \n
) \n
::\n");

		file.close;
	}


	/*
	export PATH=$PATH:/Applications/MATLAB_R2017b.app/bin
	matlab
	*/


	matLab{ Pipe.new("matlab -nodesktop "++
			"cd "++  this.ambiToolboxPath++"examples/"  ++" -r \""++
		this.ambiToolboxPath++"examples/"++"run_dec_"++this.speakerArrayName++".m\"",
		"r");

	}

}





		//file.write("\n");
		//file.write("\t% create a directory with the speaker array name \n");
		//file.write("\t unix('mkdir "++this.ambiToolboxPath++this.speakerArrayName++"');\n");

		/*
		file.write("\n");
		file.write("\t% move all files the files into it\n");
		file.write("\t unix('mv "++
			       path_ADT++"decoders "++
			       path_ADT++this.speakerArrayName++"');\n");

		file.write("\t unix('mv "++
			       path_ADT++"examples/"++"run_dec_"++this.speakerArrayName++".m "++
			       path_ADT++this.speakerArrayName++"/run_dec_"++this.speakerArrayName++".m""');\n");

	    file.write("\t unix('mv "++
			       path_ADT++"examples/"++this.speakerArrayName++".m "++
			       path_ADT++this.speakerArrayName++"/"++this.speakerArrayName++".m""');\n");

	    file.write("\t unix('mv "++
			       path_ADT++"examples/"++this.speakerArrayName++".schelp "++
			       path_ADT++this.speakerArrayName++"/"++this.speakerArrayName++".schelp""');\n");
        */
	