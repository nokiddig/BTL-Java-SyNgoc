package view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import controller.StartMenuListener;

public class StartMenu extends JFrame{
	private JButton jbStartGame, jbHowToPlay, jbContinue;
	private GameForm gameForm;
	
	public StartMenu(){
		this.init();
	}
	
	public void init() {
		this.setTitle("1010!");
		this.setLayout(new BorderLayout());
//		try {
//            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\SN\\Desktop\\files_cua_toi\\IMG_20201226_2s01150.jpg")))));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        this.pack();
		this.setSize(400, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		StartMenuListener ac = new StartMenuListener(this);
		JPanel jpListItems  = new JPanel(new GridLayout(3, 1, 100, 100));
		jpListItems.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		
		jbStartGame = new JButton("New game!");
		jbContinue = new JButton("Continue");
		jbHowToPlay = new JButton("How to play");
		
		jpListItems.add(jbStartGame);
		jbStartGame.addActionListener(ac);
		jpListItems.add(jbContinue);
		jbContinue.addActionListener(ac);
		jpListItems.add(jbHowToPlay);
		jbHowToPlay.addActionListener(ac);
		jbContinue.setBounds(50, 50, 50, 50);
		//tao font chu va gan
		setFontForJbutton(jbStartGame);
		setFontForJbutton(jbContinue);
		setFontForJbutton(jbHowToPlay);
		
		this.add(jpListItems, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	void setFontForJbutton(JButton jb) {
		Font font = new Font("Serif", Font.BOLD, 30);
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