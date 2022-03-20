package model;
/* ====== code moi them ======
variable: 
	- listBlockColor
add code:
 	- color cho listBlockColor tai gameModel()
method:
	- getListBlockColor
	- addPoint
*/

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel {
	private int[][] grid = new int[11][11];
	private int score;
	private Block[] listBlock = { new block1x1(), 
								  new block1x2(),
								  new block1x3(), 
								  new block1x4(), 
								  new block1x5(), 
								  new block2x1(), 
								  new block2x2(), 
								  new block3x1(), 
								  new block3x3(), 
								  new block4x1(), 
								  new block5x1(), 
								  new blockL1(), 
								  new blockL2(),
								  new blockL3(),
								  new blockL4(),
								  new blockMinL1(),
								  new blockMinL2(),
								  new blockMinL3(),
								  new blockMinL4()};
	private Color[] listBlockColor = new Color[19];
	private Random r = new Random();
	private Block currBlock =  listBlock[r.nextInt(listBlock.length)];
	private Block nextBlock =  listBlock[r.nextInt(listBlock.length)];
	
	public GameModel() {
//		for(int i=0; i<10; i++) {
//			for(int j=0; j<10; j++) {
//				grid[i][j] = 0;
//			}
//		}
		score = 0;
		for (int i=0; i<19; i++) 
			listBlockColor[i] = listBlock[i].getColor();
	}
	
	public Color[] getListBlockColor(){
		return this.listBlockColor;
	}
	
	public Block getCurrBlock() {
		return currBlock;
	}

	public void setCurrBlock(Block currBlock) {
		this.currBlock = currBlock;
	}

	public Block getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(Block nextBlock) {
		this.nextBlock = nextBlock;
	}

	public boolean checkFullX(int x) {
		for(int i=0; i<10; i++) {
			if(grid[x][i] == 0) return false;
		}
		return true;
	}
	
	public boolean checkFullY(int y) {
		for(int i=0; i<10; i++) {
			if(grid[i][y] == 0) return false;
		}
		return true;
	}

	public boolean CheckAvai(int x, int y) {
		Point[] shape = currBlock.getShape();
		for(int i=0; i<shape.length; i++) {
			if(shape[i].x + x < 0 ||  shape[i].x + x > 9 || 
			   shape[i].y + y < 0 || shape[i].y + y > 9)    return false;
			if(grid[x + shape[i].x][y+shape[i].y] == 1) return false;
		}
		return true;
	}
	
	public void addBlock(int x, int y) { 
		Point[] shape = currBlock.getShape();
		for(int i=0; i<shape.length; i++) {
			grid[x + shape[i].x][y+shape[i].y] = 1;
		}
		this.currBlock = this.nextBlock;
		this.nextBlock =  listBlock[r.nextInt(listBlock.length)];
	}
	
	public void addGridPoint(int x, int y) {
		this.grid[x][y] = 1;
	}
	
	public void deleteRow(int x) {
		for(int i=0; i<10; i++) {
			grid[x][i] = 0;
		}
	}
	public void deleteCol(int y) {
		for(int i=0; i<10; i++) {
			grid[i][y] = 0;
		}
	}
	public ArrayList<Integer> listFullX, listFullY;
	public void delete() {
		listFullX = new ArrayList<Integer>();
		listFullY = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			if(checkFullX(i)) 
				listFullX.add(i);
			if(checkFullY(i))
				listFullY.add(i);
		}
		for(int i:listFullX) deleteRow(i);
		for(int i:listFullY) deleteCol(i);
		int n = listFullX.size() + listFullY.size();
		score += 5*n*n + 5*n;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void resetBoard() {
		// TODO Auto-generated method stub
		this.score = 0;
		for (int i=0; i<10; i++)
			this.deleteRow(i);
	}
}
