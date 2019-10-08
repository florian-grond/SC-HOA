/*
This Binaura Decoder implements symetrized KU100 IRs
They were created using KU100 HRIR measurements presented in [1] and the rendering approach proposed in [2].

[1] Bernschütz, Benjamin. "A Spherical Far Field HRIR/HRTF Compilation of the Neumann KU 100", Proceedings of the 40th Italian (AIA) Annual Conference on Acoustics and the 39th German Annual Conference on Acoustics (DAGA) Conference on Acoustics. 2013. http://audiogroup.web.th-koeln.de/ku100hrir.html
[2] Schoerkhuber, Christian; Zaunschirm, Markus; Hoeldrich, Robert. "Binaural Rendering of Ambisonic Signals via Magnitude Least Squares", Fortschritte der Akustik, DAGA, 2018

For the  headphone correction filters:
The impulse responses were created by Benjamin Bernschuetz.
[1] Bernschuetz, B. (2013. A Spherical Far Field HRIR/HRTF Compilation of the Neumann KU 100.
AIA-DAGA 2013 Merano. http://audiogroup.web.th-koeln.de/ku100hrir.html


Note: the W-chanal is symmetric with respect to the y-axis (left-right axis) -> Mid-Signal
Y-Signal: asymmetrisch -> Side
Z-Signal: symmetrisch -> Mid
Y-Signal: symmetrisch -> Mid
and so on and so on…

You end up with a mid-summ and a side-summ after convolution.
addition yields the left Signal,
substraction yields the right signal for the ears.
*/


HOABinaural{
	classvar <binauralIRs;
	classvar <headPhoneIRs;
	classvar <headPhones;

	classvar <numChannels;
	classvar <maxOrder;
	classvar <midChannels;
	classvar <sideChannels;

	*initClass {
		numChannels = 50;
		maxOrder = 5;
		midChannels = [ 0, 2, 3, 6, 7, 8, 12, 13, 14, 15, 20, 21, 22, 23, 24, 30, 31, 32, 33, 34, 35, 42, 43, 44, 45, 46, 47, 48, 56, 57, 58, 59, 60, 61, 62, 63 ];
		sideChannels = [ 1, 4, 5, 9, 10, 11, 16, 17, 18, 19, 25, 26, 27, 28, 29, 36, 37, 38, 39, 40, 41, 49, 50, 51, 52, 53, 54, 55 ];
	}


	// Read the symmetric b-format extracting each channel of the multichannel file individually
	*loadbinauralIRs { |server|
		var path, orders;

		if(binauralIRs.notNil) { ^binauralIRs };

		path = HOA.kernelsDir +/+ "binauralIRs";
		orders = (1..maxOrder);
		binauralIRs = ((orders+1).squared).collect { |channels, index|
			channels.collect { |chan|
				Buffer.readChannel(
					server,
					path +/+ "irsOrd" ++ orders[index] ++ ".wav",
					channels: chan
				)
			}
		}
	}

	*loadHeadphoneCorrections { |server|
		var pathname, files;

		if(headPhoneIRs.notNil) { ^headPhoneIRs };

		pathname = PathName(HOA.kernelsDir +/+ "headphoneEQ");
		// keep only files with .wav extension. counterintuitive, but correct.
		files = pathname.files.takeThese { |file| file.extension != "wav" };
		headPhones = Array.newClear(files.size);
		headPhoneIRs = files.collect { |file, index|
			headPhones.put(index, file.fileNameWithoutExtension);
			2.collect { |index|
				Buffer.readChannel(
					server,
					file.fullPath,
					channels: index
				)
			}
		}
	}

	*listHeadphones {
		headPhones.do { |item, index|
			[index, item].postln
		}
	}

	*freeBinauralIRs {
		this.pr_freeBinauralBuffers(binauralIRs);
		binauralIRs = nil;
	}

	*freeHeadphoneCorrections {
		this.pr_freeBinauralBuffers(headPhoneIRs);
		headPhoneIRs = nil;
		headPhones = nil;
	}

	*pr_freeBinauralBuffers { |binauralBuffers|
		binauralBuffers.do { |buffers|
			buffers.do { |buffer|
				buffer.free
			}
		}
	}

    *ar { |order, in, input_gains = 0, output_gains = 0, headphoneCorrection = nil|
		var decoded;
		var maxChannels = min((order+1).squared, (this.maxOrder+1).squared);
		var mids, mid, sides, side, conv, numChan;

		if(in.size < maxChannels, {
			order = in.size.sqrt - 1;
			"%.ar: in.size does not match order. Reducing order to %.".format(this.class, order).inform;
		});

		if(order > this.maxOrder, {
			"%:ar: order % is not implemented".format(this.class, order).error;
			^nil;
		});

		if(headphoneCorrection != nil,
			{
				if(headphoneCorrection > headPhones.size, {
					"no suitable headphone corection selected, execute HOABinaural.listHeadphones for correct indices".error;
					headphoneCorrection =  nil;
				},
				{	"Correcting for headphone model:  %.".format(headPhones[headphoneCorrection]).inform; }
				);
			}
		);

		numChan = (order+1).squared;
				mids = midChannels.collect({|item,i| if (item < numChan,{item}) }).removeAllSuchThat({|item| item != nil});
				sides = sideChannels.collect({|item,i| if (item < numChan,{item}) }).removeAllSuchThat({|item| item != nil});
				conv = (numChan.collect({|i|   Convolution2.ar(  in[i], 	binauralIRs[order-1][i], 0, 512, 1)       }));
				mid = mids.collect({|item,i| conv[item]}).sum;
				side = sides.collect({|item,i| conv[item]}).sum;
				if( headphoneCorrection == nil,
			    // return the right - left signal
				{^[mid - side, mid + side]},
			    // if with headphone correction then convolve with the respective kernels
				{^[mid - side, mid + side].collect({|item,i|  Convolution2.ar(  item, headPhoneIRs[headphoneCorrection][i], 0, 2048, 1)      })}
			     );
	}

}



