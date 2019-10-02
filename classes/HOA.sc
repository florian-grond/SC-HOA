/*
This class is based on the ATK class
Thank you ATK!

additions and alterations by Till Bovermann ( http://tai-studio.org )
*/


HOA {
	classvar <resourceDir;
	classvar <soundsSubdir, <kernelsSubdir;

	*initClass {
		// find the path to this file, then move up one level and append "resources/"
		resourceDir = this.class.filenameSymbol.asString.dirname.dirname +/+ "resources";

		soundsSubdir = "sounds";
		kernelsSubdir = "kernels";
	}

	*soundsDir {
		^resourceDir +/+ soundsSubdir
	}

	*kernelsDir {
		^resourceDir +/+ kernelsSubdir
	}

	*openResourceDir {
		resourceDir.openOS
	}

	// not really a good idea, we cannot populate it from within SC anyhow...
	// *createUserSupportDir {
	// 	"%: creating directory at %"
	// 	.format(this, userSupportDir).inform
	// 	File.mkdir(userSupportDir);
	// 	//		("mkdir \"" ++ HOA.userSupportDir ++ "\"").unixCmd;
	// }

	*pr_dirsFor {|keyword, subdir, subPaths|
		^(resourceDir +/+ subdir +/+ subPaths +/+ keyword).pathMatch
	}

	*kernelDirsFor {|keyword, subPaths|
		^this.pr_dirsFor(keyword, kernelsSubdir, subPaths);
	}
	*soundsDirsFor {|keyword, subPaths|
		^this.pr_dirsFor(keyword, soundsSubdir, subPaths);
	}

	*o2c {|n|
		^((n+1).squared)
	}

	*c2o {|n|
		^(n.sqrt - 1)
	}

}
