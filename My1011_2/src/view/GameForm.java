package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import controller.GameListener;
import model.*;


public class GameForm extends JFrame{
	private GameModel gameModel;
	
	private JButton[][] squares = new JButton[11][11];
	
	public GameForm() {
		this.gameModel = new GameModel();
		
		this.init();
	}
	public void init() {
		
		this.setTitle("1010!");
		this.setSize(850, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		GameListener ac = new GameListener(this);
		//--------
		JPanel gameInfo;
		//--------Game area
		JPanel gameArea = new JPanel(new GridLayout(10, 10, 5, 5));
		gameArea.setSize(500, 500);
		gameArea.setLayout(new GridLayout(10, 10, 5, 5));
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				squares[i][j] = new JButton();
				gameArea.add(this.squares[i][j]);
				this.squares[i][j].setBackground(Color.white);
				this.squares[i][j].setBorderPainted(false);
				
				this.squares[i][j].addActionListener(ac);
				this.squares[i][j].addMouseListener(ac);
			}
		}
		gameArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		this.add(gameArea, BorderLayout.CENTER);
		
		
		//----------end game area
		
		gameInfo = new JPanel(new BorderLayout());
		gameInfo.setSize(300, 600);
		
		
		gameInfo.add(new JButton("Reset"), BorderLayout.SOUTH);
		
		gameInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.add(gameInfo, BorderLayout.EAST);
		
		this.setVisible(true);
		
	}
	
	public JButton[][] getSquares() {
		return squares;
	}

	public void addBlock(int x, int y) { 
		if(this.gameModel.CheckAvai(x, y)) {
			Point[] shape = gameModel.getCurrBlock().getShape();
			Color color = this.gameModel.getCurrBlock().getColor();
			for(int i=0; i<shape.length; i++) {
				squares[x + shape[i].x][y+shape[i].y].setBackground(color);
			}
			
			this.gameModel.addBlock(x, y); // đổi từng ô từ 0 thành 1
		}
		
		delete();
		
	}
	public GameModel getGameModel() {
		return this.gameModel;
	}
	public void deleteRow(int x) {
		for(int i=0; i<10; i++) {
			squares[x][i].setBackground(Color.white);
		}
	}
	public void deleteCol(int y) {
		for(int i=0; i<10; i++) {
			squares[i][y].setBackground(Color.white);
		}
	}
	public void delete() {
		this.gameModel.delete();
		for(int i:this.gameModel.listFullX) deleteRow(i);
		for(int i:this.gameModel.listFullY) deleteCol(i);
	}
	
	public static void main(String[] args) {
		new GameForm();
	}
}
