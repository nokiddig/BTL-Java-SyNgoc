package model;

import java.awt.Color;
import java.awt.Point;

public class block2x2 extends Block {
	// shape
	// [x][ ]
	// [ ][ ]

	public block2x2 () {
		super(new Color(84, 255, 159));
		shape = new Point[4];
		shape[0] = new Point(0, 0);
		shape[1] = new Point(0, 1);
		shape[2] = new Point(1, 0);
		shape[3] = new Point(1, 1);
	}
}
