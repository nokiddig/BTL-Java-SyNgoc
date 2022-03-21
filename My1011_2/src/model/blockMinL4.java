package model;

import java.awt.Color;
import java.awt.Point;

public class blockMinL4 extends Block {
	
	// shape
	// [ ][x]
	//    [ ]

	public blockMinL4 () {
		super(new Color(255, 246, 143));
		shape = new Point[3];
		shape[0] = new Point(-1, 0);
		shape[1] = new Point(0, 0);
		shape[2] = new Point(0, 1);
	}
}
