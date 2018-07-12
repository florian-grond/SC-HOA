HOAReduceOrder{
*ar { |order, in|
		var returnChannels = (order + 1).pow(2).asInteger;
		if( returnChannels > in.size ,{returnChannels = in.size; "order can only be reduced to <= the nuber of b-format input channels".postln;});
		^in.keep(returnChannels);
}
}