package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.GameInfoListener;
import controller.GameListener;
import java.awt.event.ActionListener;
public class GameInfo extends JPanel {
	private GameForm gameForm;
	private JPanel block;
	private DrawBlock currBlock;
	private DrawBlock nextBlock;
	private JPanel jpPlayerInfo;
	private JLabel jlScore;
	private JLabel jlNameOfPlayer;
	public GameInfo() {
		this.gameForm = new GameForm();
		this.init();
	}
	public GameInfo(GameForm gameForm) {
		this.gameForm = gameForm;
		this.init();
	}
	public void init() {
//		this.setTitle("Game Info");
//		this.setSize(500, 600);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setLayout(new BorderLayout(10, 10));
//		this.setLocationRelativeTo(null);

		this.setLayout(new BorderLayout(10, 10));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//		GridBagConstraints gb = new GridBagConstraints();
		Border border = BorderFactory.createLineBorder(Color.black, 1);
		// Top
		
		// jpanel score
		this.setupJpPlayerInfo(border);
		
		this.add(this.jpPlayerInfo, BorderLayout.NORTH);
		//Center
		
		block = new JPanel(new GridLayout(1, 2, 10, 10));
		currBlock = new DrawBlock(this.gameForm.getGameModel().getCurrBlock());
		nextBlock = new DrawBlock(this.gameForm.getGameModel().getNextBlock());
		
		Font font = new Font("Serif", Font.ITALIC, 20);
		
		currBlock.setBorder(BorderFactory.createTitledBorder(border, "Current Block", TitledBorder.CENTER , TitledBorder.DEFAULT_POSITION, font));
		nextBlock.setBorder(BorderFactory.createTitledBorder(border, "Next Block", TitledBorder.CENTER , TitledBorder.DEFAULT_POSITION, font));
		
		
//		block.setBorder(BorderFactory.createTitledBorder(border, "Setting", TitledBorder.LEFT , TitledBorder.DEFAULT_POSITION, font1));
//		block.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		block.add(currBlock);
		block.add(nextBlock);
		
		this.add(block, BorderLayout.CENTER);
		
		// South
		JPanel GameButton = new JPanel(new GridLayout(1, 2, 12, 10));
		
		GameInfoListener ac = new GameInfoListener(this);
		JButton reset = new JButton("Reset");
		reset.addActionListener(ac);
		reset.addMouseListener(ac);
		JButton saveAndQuit = new JButton("Save");
		saveAndQuit.addActionListener(ac);
		saveAndQuit.addMouseListener(ac);
		
		reset.setBorder(BorderFactory.createLineBorder(Color.black));
		saveAndQuit.setBorder(BorderFactory.createLineBorder(Color.black));
		Font font2 = new Font("Serif", Font.ITALIC + Font.BOLD, 24);
		reset.setFont(font2);
		saveAndQuit.setFont(font2);
		
		saveAndQuit.setBackground(Color.white);
		reset.setBackground(Color.white);
		
		GameButton.add(reset);
		GameButton.add(saveAndQuit);
		GameButton.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		this.add(GameButton, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void setupJpPlayerInfo(Border border) {
		Font font = new Font("Arial", Font.ITALIC, 20);
		Font font1 = new Font("Serif", Font.ITALIC|Font.BOLD, 25);
		jpPlayerInfo = new JPanel(new GridLayout(2, 1, 10, 10));
		jpPlayerInfo.setBorder(BorderFactory.createTitledBorder(border, "Information", TitledBorder.CENTER , TitledBorder.DEFAULT_POSITION, font1));
		
		jlNameOfPlayer = new JLabel("     - Player: First player");
		jlNameOfPlayer.setFont(font);
		jpPlayerInfo.add(jlNameOfPlayer);
		
		jlScore = new JLabel(String.valueOf("     - Your score: " + gameForm.getGameModel().getScore()) + " Point");
		jlScore.setFont(font);
		jpPlayerInfo.add(jlScore);
	}
	
	public void updateScore(int x) {
		jlScore.setText("     - Your score: " + String.valueOf(x) + " Point.");
	}
	
	public void reDrawBlock() {
		currBlock.setBl(this.gameForm.getGameModel().getCurrBlock());
		nextBlock.setBl(this.gameForm.getGameModel().getNextBlock());
		currBlock.repaint();
		nextBlock.repaint();
	}
	
	public void saveGame()
	{
		gameForm.saveGame();
	}
	
	public void resetGame()
	{
		gameForm.resetBoard();
	}
}
