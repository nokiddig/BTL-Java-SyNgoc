package model;

import java.awt.Color;
import java.awt.Point;

public class block1x4 extends Block {	

	// shape
	// [ ][x][ ][ ]

	public block1x4 () {
		super(new Color(240, 128, 128));
		shape = new Point[4];
		shape[0] = new Point(-1, 0);
		shape[1] = new Point(0, 0);
		shape[2] = new Point(1, 0);
		shape[3] = new Point(2, 0);
		
	}
}
