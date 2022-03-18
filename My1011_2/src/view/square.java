package view;

import java.awt.Color;

import javax.swing.*;

public class square extends JButton {
	public boolean isBlock = false;
	// thêm 
	//private Color color = this.getBackground();
	public square() {
		isBlock = false;
		this.setBackground(Color.white);
	}
	public void addBlock() {
		isBlock = true;
	}
	public void delBlock() {
		isBlock = false;
		setColor(Color.white);
	}
	public void setColor(Color cl) {
		this.setBackground(cl);
	}
}
