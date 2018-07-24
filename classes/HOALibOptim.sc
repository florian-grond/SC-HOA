HOALibOptim{

	*ar { |order, in, inPhase_MaxRe|

		// optimize with InPhase
		case{ (inPhase_MaxRe == 0) }
			{ ^HOALibInPhase3D.ar(order, in)}
		// converting with MaxRe
		    { (inPhase_MaxRe == 1) }
			{ ^HOALibMaxRe3D.ar(order, in)}

	}
}