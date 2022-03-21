package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Block;

public class DrawBlock extends JPanel {
	Block bl;
	public DrawBlock() {
		//this.setSize(50, 50);
		
		this.setBounds(100, 100, 200, 200);
	}
	public DrawBlock(Block bl) {
		//this.setSize(50, 50);
		this.bl = bl;
		this.setBounds(100, 100, 300, 300);
		
	}
	private void draw (Graphics g) {
		for(int i=0; i<bl.getShape().length; i++) {
			g.setColor(bl.getColor());
			g.fillRect(90 + bl.getShape()[i].y*40, 120 + bl.getShape()[i].x*40, 40, 40);
			g.setColor(Color.gray);
			g.drawRect(90 + bl.getShape()[i].y*40, 120 + bl.getShape()[i].x*40, 40, 40);
		}
	}
	
	public void setBl(Block bl) {
		this.bl = bl;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		draw(g);
	}

}
