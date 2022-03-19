package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.StartMenuListener;

public class StartMenu extends JFrame{
	private JButton jbStartGame, jbHowToPlay, jbContinue;
	private GameForm gameForm;
	
	public StartMenu(){
		this.init();
	}
	
	public void init() {
		this.setTitle("1010!");
		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		StartMenuListener ac = new StartMenuListener(this);
		JPanel jpListItems  = new JPanel(new GridLayout(3, 1, 100, 100));
		
		jbStartGame = new JButton("Start game");
		jbContinue = new JButton("Continue");
		jbHowToPlay = new JButton("How to play");
		
		jpListItems.add(jbStartGame);
		jbStartGame.addActionListener(ac);
		jpListItems.add(jbContinue);
		jbContinue.addActionListener(ac);
		jpListItems.add(jbHowToPlay);
		jbHowToPlay.addActionListener(ac);
		
		//tao font chu va gan
		setFontForJbutton(jbStartGame);
		setFontForJbutton(jbContinue);
		setFontForJbutton(jbHowToPlay);
		
		this.setLayout(new BorderLayout());
		this.add(jpListItems, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	void setFontForJbutton(JButton jb) {
		Font font = new Font("Arial", Font.BOLD, 30);
		jb.setFont(font);
		jb.setForeground(Color.DARK_GRAY);
		jb.setBackground(Color.orange);
	}
	
	public void creatNewGame() {
		gameForm = new GameForm();
		gameForm.setContinueGame(false);
		gameForm.init();
		this.setVisible(false);
	}
	
	public void playContiueGame() {
		gameForm = new GameForm();
		gameForm.setContinueGame(true);
		gameForm.init();
		this.setVisible(false);
	}
	
	public static void main(String[] args){
		new StartMenu();
	}
}