/*
This class is based on the ATK class
Thank you ATK!

additions and alterations by Till Bovermann ( http://tai-studio.org )
*/


HOA {
	classvar   <>userSupportDir; //,   <userSoundsDir,   <userKernelDir;
	classvar <>systemSupportDir; //, <systemSoundsDir, <systemKernelDir;
	classvar <>soundsSubdir, <>kernelSubdir;

	*initClass {
		systemSupportDir = Platform.systemAppSupportDir.dirname ++ "/HOA";
		userSupportDir   = Platform.userAppSupportDir  .dirname ++ "/HOA";

		soundsSubdir     = "sounds";
		kernelSubdir     = "kernels";

	}


	*userSoundsDir {
		userSupportDir +/+ soundsSubdir;
	}
	*systemSoundsDir {
		systemSupportDir +/+ soundsSubdir;
	}

	*userKernelDir {
		userSupportDir +/+ kernelSubdir;
	}
	*systemKernelDir {
		systemSupportDir +/+ kernelSubdir;
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

	*openSystemSupportDir {
		if (File.exists(systemSupportDir).not, {
			"%: HOA System Support directory does not exist.".format(this).warn;
			^this;
		});

		systemSupportDir.openOS;
	}

	*pr_dirsFor {|keyword, subdir, subPaths|
		var paths;
		// user directory takes precedence
		paths = [userSupportDir, systemSupportDir].collect{|dir|
			(dir +/+ subdir +/+ subPaths +/+ keyword).pathMatch;
		}.flatten;

		^paths;

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
