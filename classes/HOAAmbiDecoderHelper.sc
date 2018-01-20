/*
2016/2017 Florian Grond
additions by Till Bovermann ( http://tai-studio.org )
*/


HOAAmbiDecoderHelper {

	var   <>ambiToolboxPath; //,   <userSoundsDir,   <userKernelDir;
	var   <>speakerArrayName; //,  <userSoundsDir,   <userKernelDir;
	var   <>speakerPositions; //,
	var   <>sweeterPositions; //,
	var   <>speakerLabels; //
	var   <>listenerPosition;
	var   <>centerOfGravity;

	initClass {|path|
		// this.ambiToolboxPath     = path;
	}


	setAmbiToolboxPath{|path|
		this.ambiToolboxPath = path;
	}

    setSpeakerArrayName{|name|
		this.speakerArrayName = name;
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
		var sweetSpot = Cartesian(sweet[0],sweet[1],sweet[2]);

		this.sweeterPositions = this.speakerPositions.deepCopy;
		this.speakerPositions.do({|item,i| this.sweeterPositions[i] = this.speakerPositions[i]  -  sweetSpot;    });
	}


	makeAmbiDecoderSpeakerPositionFile{
		var file;

		file = File.open(this.ambiToolboxPath++"SPKR_ARRAY_"++this.speakerArrayName++".m" ,"w");

		file.write("function [ val ] =" ++"SPKR_ARRAY_"++this.speakerArrayName++"() \n");
        file.write("val.name = '"++"SATOSPHERE"++"';\n\n\n");

        file.write("S=[\n");
        sweeterPositions.do({|item,i|  file.write(  "\t"++"\t"++item.x.trunc(0.0001).asString++"\t"++item.y.trunc(0.0001).asString++"\t"++item.z.trunc(0.0001).asString++"\n"  )    });
        file.write("];\n\n\n");

        file.write("    [val.az val.el val.r] = cart2sph(S(:,1),S(:,2),S(:,3)); \n");
        file.write("    [val.x val.y val.z] = sph2cart(val.az, val.el, 1); \n\n\n");

        file.write("val.id = {");
		speakerLabels.do({|item,i|  file.write("'"++item.asString++"'"); if(i<(speakerPositions.size-1),  {file.write(",")});         } );
        file.write("}; \n\n\n end");
        file.close;
	}
}
	