package model;

import java.awt.Color;
import java.awt.Point;

public class  Block {
	
	protected Color color;
	protected Point[] shape;
	
	public Block() {
    	color = Color.black;
    }
    
    public Block(Color clr) {
    	color = clr;
    }
    
	public Color getColor() {
		return color;
	}
	public Point[] getShape() {
		return shape;
	}
}
