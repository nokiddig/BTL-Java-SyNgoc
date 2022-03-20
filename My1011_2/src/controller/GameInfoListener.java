package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import view.GameInfo;

import java.io.IOException;
public class GameInfoListener implements ActionListener, MouseListener {
	private GameInfo gameInfo;
	
	public GameInfoListener(GameInfo gameInfo){
		this.gameInfo = gameInfo;
	}

	@Override
	public void actionPerformed(ActionEvent e){ //Exception ioException is not compatible with throws
		// TODO Auto-generated method stub
		// ===== save game =====
		String textAction = e.getActionCommand();
		if (textAction.equals("Save")) {
			this.gameInfo.saveGame();
			System.out.println("Save thanh cong!!!");
		}
		if (textAction.equals("Reset")) {
			gameInfo.resetGame();
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
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}