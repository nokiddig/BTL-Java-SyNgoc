package model;

import java.awt.Color;
import java.awt.Point;

public class blockL4 extends Block {
	
	// shape
	//       [ ]
	//       [ ]
	// [ ][ ][x]

	public blockL4 () {
		super(new Color(0, 245, 255));
		shape = new Point[5];
		shape[0] = new Point(0, -2);
		shape[1] = new Point(0, -1);
		shape[2] = new Point(0, 0);
		shape[3] = new Point(-1, 0);
		shape[4] = new Point(-2, 0);
	}
}

