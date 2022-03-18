package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import view.GameForm;

public class GameListener implements ActionListener, MouseListener {
	private GameForm gameForm;
	
	public GameListener(GameForm gameForm) {
		this.gameForm = gameForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(e.getSource()==this.gameForm.getSquares()[i][j]) {
					if(this.gameForm.getGameModel().CheckAvai(i, j))
						this.delPaint(i, j);
					this.gameForm.addBlock(i, j);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(e.getSource()==this.gameForm.getSquares()[i][j]) {
					if(this.gameForm.getGameModel().CheckAvai(i, j)) {
						this.paintBlock(i, j);
					}
				}
			}
		}
	}
	public void paintBlock(int x, int y) {
		Point[] shape = this.gameForm.getGameModel().getCurrBlock().getShape();
		Color color = this.gameForm.getGameModel().getCurrBlock().getColor();
		for(int i=0; i<shape.length; i++) {
			this.gameForm.getSquares()[x+shape[i].x][y+shape[i].y].setBorderPainted(true);
			this.gameForm.getSquares()[x+shape[i].x][y+shape[i].y].setBorder(BorderFactory.createLineBorder(color));
		}
		
	}
	public void delPaint(int x, int y) {
		Point[] shape = this.gameForm.getGameModel().getCurrBlock().getShape();
		for(int i=0; i<shape.length; i++) {
			this.gameForm.getSquares()[x+shape[i].x][y+shape[i].y].setBorderPainted(false);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(e.getSource()==this.gameForm.getSquares()[i][j]) {
					if(this.gameForm.getGameModel().CheckAvai(i, j)) delPaint(i, j);
				}
			}
		}
	}
	
}
