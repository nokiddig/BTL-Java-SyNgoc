package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;

import view.GameForm;
import view.StartMenu;

public class StartMenuListener implements ActionListener, MouseListener {
	private StartMenu startMenu;
	
	public StartMenuListener(StartMenu startMenu){
		this.startMenu = startMenu;
	}
	@Override
	public void actionPerformed(ActionEvent e){ //Exception ioException is not compatible with throws
		// TODO Auto-generated method stub
		// ===== save game =====
		String textAction = e.getActionCommand();
		if(textAction.equals("New game!") == true) {
			startMenu.creatNewGame();
		}
		if(textAction.equals("How to play") == true) {
			
		}
		if(textAction.equals("Continue") == true) {
			startMenu.playContiueGame();
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
		// TODO Auto-generated method stub
	}

}
