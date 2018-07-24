HOALibEnc3D{
	*ar { |order=1, in, az=0, elev = 0, gain=0|
		case
		{order == 1}
		{^HOALibEnc3D1.ar( in1:in, azi:az, ele:elev )  * gain.dbamp}
		       {order == 2}
		{^HOALibEnc3D2.ar( in1:in, azi:az, ele:elev )  * gain.dbamp}
               {order == 3}
		{^HOALibEnc3D3.ar( in1:in, azi:az, ele:elev )  * gain.dbamp}
               {order == 4}
		{^HOALibEnc3D4.ar( in1:in, azi:az, ele:elev ) * gain.dbamp}
               {order == 5}
		{^HOALibEnc3D5.ar( in1:in, azi:az, ele:elev )  * gain.dbamp}
		       {"this order is not implemented for HOALibEnc3D".postln;}
	}
}
