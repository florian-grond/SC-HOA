

~sampRate = 10;



~impulse = ({|i| case{i==0}{1}{0}  }!0)  ++  ( {|i| case{i==0}{1}{0}  }!10);


Array


~buf = Buffer.loadCollection(s, ~impulse, 2)



~buf.plot