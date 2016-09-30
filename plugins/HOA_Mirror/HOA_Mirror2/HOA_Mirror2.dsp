declare name        "HOAMirror2";
declare version     "1.0";
declare author      "Pierre Lecomte";
declare license     "GPL";
declare copyright   "(c) Pierre Lecomte 2015";

// Description: This tool mirros an HOA scene: Axes left-right, front-back, up-down can be reversed by changing a the sign of particular spherical harmonics [1,p.46-47]

// References: 
// [1] Kronlachner, M. (2014). Spatial Transformations for the Alteration of Ambisonic Recordings. Graz University Of Technology, Austria.

// Inputs: (M+1)^2
// Outputs: (M+1)^2

import("math.lib");

ud=checkbox("up-down");
lr=checkbox("left-right");
fb=checkbox("front-back");

M=2;

//up-down switching: all spherical harmonics with order and degree as m+n odd
updown = par(m,M+1,par(i,2*m+1,term
	  with{	term	=	_<:if((ud==1) & (i%2==1),_*-1,_); // i+m^2 = m^2+m+n
	  })
	  );
	
	
//left-right switching : all spherical harmonics of degree n<0
leftright = par(m,M+1,par(i,2*m+1,term
	  with{	term	=	_<:if((lr==1) & ((i-m)<0),_*-1,_); // i+m^2 = m^2+m+n
	  })
	  );
	  
	  
//front-back switching : all spherical harmonics of degree (n<0 & n even) or (n>0 & n odd)
frontback = par(m,M+1,par(i,2*m+1,term
	  with{	term	=	_<:
	  if(
	    ((fb==1)
	    &
	    (
		(
		 ((i-m)<0)
		 &
		 ((i-m)%2==0)
	      )
	      |
	      (
		 ((i-m)>0)
		 &
		 ((i-m)%2==1)
	      )
	    )
	    )
	  ,_*-1,_); // i+m^2 = m^2+m+n
	  })
	  );	  
	    
process=vgroup("HOA scene mirroring",updown:leftright:frontback);

//EXAMPLE AT ORDER 5
//up-down switching : all spherical harmonics with order and degree as m+n odd
// updown=(
//           _,
//         _,u,_,
//       _,u,_,u,_,
//     _,u,_,u,_,u,_,
//   _,u,_,u,_,u,_,u,_,
// _,u,_,u,_,u,_,u,_,u,_
// )
// with { u = (_<:if(ud==1,_*-1,_)); };


//left-right switching : all spherical harmonics of degree n<0
// leftright=(
//           _,
//         l,_,_,
//       l,l,_,_,_,
//     l,l,l,_,_,_,_,
//   l,l,l,l,_,_,_,_,_,
// l,l,l,l,l,_,_,_,_,_,_
// )
// with { l = (_<:if(lr==1,_*-1,_)); };

//front-back switching : all spherical harmonics of degree (n<0 & n even) and (n>0 & n odd)
// frontback=(
//           _,
//         _,_,f,
//       f,_,_,f,_,
//     _,f,_,_,f,_,f,
//   f,_,f,_,_,f,_,f,_,
// _,f,_,f,_,_,f,_,f,_,f
// )
// with { f = (_<:if(fb==1,_*-1,_)); };