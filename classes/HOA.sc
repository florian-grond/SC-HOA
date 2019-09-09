/*
This class is based on the ATK class
Thank you ATK!

additions and alterations by Till Bovermann ( http://tai-studio.org )
*/


HOA {
	classvar   <>userSupportDir; //,   <userSoundsDir,   <userKernelDir;
	classvar <>soundsSubdir, <>kernelSubdir;

	*initClass {
		userSupportDir   = Platform.userAppSupportDir  .dirname ++ "/HOA";

		soundsSubdir     = "sounds";
		kernelSubdir     = "kernels";

	}


	*userSoundsDir {
		^userSupportDir   +/+ soundsSubdir
	}

	*userKernelDir {
		^userSupportDir   +/+ kernelSubdir
	}

	*openUserSupportDir {
		if (File.exists(Atk.userSupportDir).not, {
			HOA.userSupportDir.openOS;
		}, {
			"\n%: User Support directory does not exist. Run\n"
			"\tthis.createUserSupportDir\nto create it".format(this, this).warn;
			^this;
		})
	}

	// not really a good idea, we cannot populate it from within SC anyhow...
	// *createUserSupportDir {
	// 	"%: creating directory at %"
	// 	.format(this, userSupportDir).inform
	// 	File.mkdir(userSupportDir);
	// 	//		("mkdir \"" ++ HOA.userSupportDir ++ "\"").unixCmd;
	// }

	*pr_dirsFor {|keyword, subdir, subPaths|
		^(userSupportDir +/+ subdir +/+ subPaths +/+ keyword).pathMatch
	}

	*kernelDirsFor {|keyword, subPaths|
		^this.pr_dirsFor(keyword, kernelSubdir, subPaths);
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
