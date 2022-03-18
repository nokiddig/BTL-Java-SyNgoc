package model;

import java.awt.Color;
import java.awt.Point;

public class block3x3 extends Block {
	
	// shape
	// [ ][ ][ ]
	// [ ][x][ ]
	// [ ][ ][ ]
	public block3x3 () {
		super(new Color(127, 255, 212));
		shape = new Point[9];
		shape[0] = new Point(-1, -1);
		shape[1] = new Point(0, -1);
		shape[2] = new Point(1, -1);
		shape[3] = new Point(-1, 0);
		shape[4] = new Point(0, 0);
		shape[5] = new Point(1, 0);
		shape[6] = new Point(-1, 1);
		shape[7] = new Point(0, 1);
		shape[8] = new Point(1, 1);
	}
}
