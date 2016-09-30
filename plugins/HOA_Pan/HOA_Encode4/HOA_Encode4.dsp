declare name        "HOA_Encode4";
declare version     "1.0";
declare author      "Pierre Lecomte";
declare license     "GPL";
declare copyright   "(c) Pierre Lecomte 2014";

// Description: This tool creates an HOA scene from N inputs. Each input is encoded as a source in space. Source types are plane or spherical waves.

// References: 
//[1] Lecomte, P., & Gauthier, P.-A. (2015). Real-Time 3D Ambisonics using Faust, Processing, Pure Data, And OSC. In 15th International Conference on Digital Audio Effects (DAFx-15). Trondheim, Norway.

// Inputs: N
// Outputs: (M+1)^2

import("lib/nfc.lib");
import("lib/ymn.lib");
import("lib/gui.lib");
import("filter.lib");

M	=	4; // maximum order for Ambisonics components
N	=	1; // number of inputs (number of sources to encoder)

g(i)	=	hslider("[%i+1][osc:/gain_%i -20 20][style:knob]Gain %2i",0,-20,20,0.1): db2linear : smooth(0.999); // gain
r(i)	=	hslider("[%i+2][osc:/radius_%i 0.5 50][style:knob]Radius %2i", 2, 0.5, 50, 0.01); // radius
t(i)	=	hslider("[%i+3][osc:/azimuth_%i 0 360][style:knob]Azimuth %2i", 0, 0, 360, 0.1)*PI/180; // azimuth
d(i)	=	hslider("[%i+4][osc:/delta_%i -90 90][style:knob]Elevation %2i", 0, -90, 90, 0.1)*PI/180; // elevation

spherical(i)	=	hgroup("[%i+5]Spherical Wave",checkbox("Yes"));
// Spherical restitution speaker layout radius r2 is needeed to stabilize near-field filters, see [1]
r2(i)	=	nentry("[~]Speaker Radius %2i", 1.07, 0.5, 10, 0.01); // louspeaker radius

selecteur(i)	=	hgroup("Source %2i",_*(g(i))<:(*(spherical(i)),*(1-spherical(i)))<:(*(r2(i)/r(i))<:par(m,M+1,nf(m,r(i),r2(i))<:par(i,2*m+1,_))),(_<:bus((M+1)^2)):>yvec((M+1)^2,t(i),d(i)));

process	=	hgroup("",vgroup("Parameters",par(i,N,_<:selecteur(i))):>bus((M+1)^2):vgroup("[~]Outputs",par(i,M+1,metermute(i))));