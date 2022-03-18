package model;

import java.awt.Color;
import java.awt.Point;

public class block1x1 extends Block {
	
	// shape
	// [x]

	public block1x1 () {
		super(new Color(255, 105, 180));
		shape = new Point[1];
		shape[0] = new Point(0, 0);
	}

}
