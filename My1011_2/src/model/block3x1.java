package model;

import java.awt.Color;
import java.awt.Point;

public class block3x1 extends Block {
	
	// shape
	// [ ]
	// [x]
	// [ ]

	public block3x1 () {
		super(new Color(255, 165, 0));
		shape = new Point[3];
		shape[0] = new Point(0, -1);
		shape[1] = new Point(0, 0);
		shape[2] = new Point(0, 1);
	}
}
