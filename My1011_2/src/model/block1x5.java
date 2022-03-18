package model;

import java.awt.Color;
import java.awt.Point;

public class block1x5 extends Block {

	// shape
	// [ ][ ][x][ ][ ]

	public block1x5 () {
		super(new Color(255, 69, 0));
		shape = new Point[5];
		shape[0] = new Point(-2, 0);
		shape[1] = new Point(-1, 0);
		shape[2] = new Point(0, 0);
		shape[3] = new Point(1, 0);
		shape[4] = new Point(2, 0);
	}
}
