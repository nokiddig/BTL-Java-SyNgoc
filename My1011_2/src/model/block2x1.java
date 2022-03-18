package model;

import java.awt.Color;
import java.awt.Point;

public class block2x1 extends Block {
	
	// shape
	// [x]
	// [ ]

	public block2x1 () {
		super(new Color(255, 255, 0));
		shape = new Point[2];
		shape[0] = new Point(0, 0);
		shape[1] = new Point(1, 0);
	}
}
