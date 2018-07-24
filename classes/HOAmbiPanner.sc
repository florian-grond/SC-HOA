HOAmbiPanner{
	*ar { |order=1, in, az=0, elev=0, gain=0|
		case
		{order == 1}
		{^HOAmbiPanner1.ar( in1:in, azi:az, ele:elev ) * gain.dbamp}
		{order == 2}
		{^HOAmbiPanner2.ar( in1:in, azi:az, ele:elev ) * gain.dbamp}
		{order == 3}
		{^HOAmbiPanner3.ar( in1:in, azi:az, ele:elev ) * gain.dbamp}
		{order == 4}
		{^HOAmbiPanner4.ar( in1:in, azi:az, ele:elev ) * gain.dbamp}
		{order == 5}
		{^HOAmbiPanner5.ar( in1:in, azi:az, ele:elev ) * gain.dbamp}
		{"this order is not implemented for AmbiPanner".postln;}
	}
}