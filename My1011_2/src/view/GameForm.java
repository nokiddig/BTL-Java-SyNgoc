package view;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import controller.GameListener;
import java.awt.event.ActionListener;
import model.*;
/* ----- code moi them -----
variable: 
add code:
	- import input-outputStream line 7-8-9
	- throws IOException (GameForm(), init(), gameSave(), main())
method:
	- saveGame()
*/
public class GameForm extends JFrame{
	private GameModel gameModel;
	private GameInfo gameInfo;
	private JButton[][] squares = new JButton[11][11];
	private JPanel gameArea;
	public boolean isSaveGame;
	private boolean isContinueGame;

	public GameForm() {
		this.gameModel = new GameModel();
		this.gameInfo = new GameInfo(this);
		//this.init();
	}

	public void init() {
		this.setTitle("1010!");
		this.setSize(1200, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//GridLayout - ko phải borderLayout
		this.setLayout(new GridLayout());
		
		GameListener ac = new GameListener(this);
		//--------
		//JPanel gameInfo;
		//--------Game area
		gameArea = new JPanel(new GridLayout(10, 10, 5, 5));
		gameArea.setSize(600, 600);
		gameArea.setLayout(new GridLayout(10, 10, 5, 5));
		
		//========setup game play=========
		if(isContinueGame)
			setupContinueGame(ac);
		else setupNewGame(ac);
		//====================
		
		gameArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		this.add(gameArea);
		//----------end game area
		
//		gameInfo = new JPanel(new BorderLayout());
//		gameInfo.setSize(300, 600);
		
//		JButton jbSave = new JButton("Save");
//		jbSave.addActionListener(ac);
//		jbSave.addMouseListener(ac);
//		gameInfo.add(jbSave, BorderLayout.SOUTH);
		
		this.add(gameInfo);
//		gameInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//		this.add(gameInfo, BorderLayout.EAST);
		
		this.setVisible(true);
	}
	
	public void setContinueGame(boolean isContinueGame) {
		this.isContinueGame = isContinueGame;
	}

	public void setupContinueGame(GameListener ac) {
		//====== set up game continue =====
		try {
			File f = new File("E:\\HK2_2021_2022_HienTai\\Java\\BTL-Java-SyNgoc\\fileOutputGame.txt");
			String status;
			BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					squares[i][j] = new JButton();
					gameArea.add(this.squares[i][j]);
					status = br.readLine();
					int a = Integer.parseInt(status);
					if (a<1) 
						this.squares[i][j].setBackground(Color.white);
					else {
						this.squares[i][j].setBackground(gameModel.getListBlockColor()[a]);
						this.gameModel.addGridPoint(i, j);
					}
					this.squares[i][j].setBorderPainted(false);
					this.squares[i][j].addActionListener(ac);
					this.squares[i][j].addMouseListener(ac);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void setupNewGame(GameListener ac){
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
	}
	
	public void saveGame(){
		try {
			int status = 0;
			String content = "";
			String path = "E:\\HK2_2021_2022_HienTai\\Java\\BTL-Java-SyNgoc\\fileOutputGame.txt";
			for (int i=0; i<10; i++)
				for (int j=0; j<10; j++) {
					status=0;
					for (int pos=0; pos<19; pos++)
						if (this.squares[i][j].getBackground().equals(gameModel.getListBlockColor()[pos]) == true)
							status = pos;
					content += String.valueOf(status);
					content += "\n";
				}
			Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8));
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public JButton[][] getSquares() {
		return squares;
	}

	public void addBlock(int x, int y){ 
		if(this.gameModel.CheckAvai(x, y)) {
			Point[] shape = gameModel.getCurrBlock().getShape();
			Color color = this.gameModel.getCurrBlock().getColor();
			for(int i=0; i<shape.length; i++) {
				squares[x + shape[i].x][y+shape[i].y].setBackground(color);
			}
			
			this.gameModel.addBlock(x, y); // đổi từng ô từ 0 thành 1
			this.gameInfo.reDrawBlock();
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
	
	public void resetBoard() {
		// TODO Auto-generated method stub
		this.gameModel.resetBoard();
		for (int i=0; i<10; i++)
			deleteRow(i);
			
	}
}
