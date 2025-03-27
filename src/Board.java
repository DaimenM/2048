import java.util.Random;
public class Board {
	private static final int size = 4;
	private Block[][] gameBoard;
	public Board() {
		gameBoard = new Block[size][size];
		int x1 = obtainRandom(0,3);
		int y1 = obtainRandom(0,3);
		int x2 = obtainRandom(0,3);
		int y2 = obtainRandom(0,3);
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++) {
				if((i==x1&&j==y1)||(i==x2&&j==y2)) gameBoard[i][j] = new Block(2,i,j);
				else gameBoard[i][j] = new Block(0,i,j);
			}
	}
    public int getSize() {
        return size;
    } 
    public Block[][] getBoard() {
        return gameBoard;
    }
	public boolean canMove(Block b1,Block b2) {
		return b1.equals(b2)||b2.getValue()==0;
	}
	public void moveRight() {
		boolean availableMove = false;
		setMergedFalse();
		for(int i=0;i<size;i++) {
			for(int j=size-2;j>=0;j--) {
				for(int k=j;k<size-1;k++) {
					if(!gameBoard[i][k].isEmpty()) {
					if(this.canMove(gameBoard[i][k], gameBoard[i][k+1])) {
						if(gameBoard[i][k].equals(gameBoard[i][k+1])&&(!gameBoard[i][k+1].getIsMerged()&&!gameBoard[i][k].getIsMerged())) {
							merge("right",gameBoard[i][k],gameBoard[i][k+1]);
							availableMove = true;
						}
					
					else if(gameBoard[i][k+1].isEmpty()) {
						gameBoard[i][k+1].setValue(gameBoard[i][k].getValue());
						gameBoard[i][k].setValue(0);
						availableMove = true;
					}
					}
					}
		}
			}
		}
		
		if(availableMove) generateValue();
	}
	public void moveLeft() {
		setMergedFalse();
		boolean availableMove = false;
		for(int i=0;i<size;i++) {
			for(int j=1;j<size;j++) {
				for (int k=j;k>0;k--) {
					if(!gameBoard[i][k].isEmpty()) {
						if(this.canMove(gameBoard[i][k], gameBoard[i][k-1])) {
							if(gameBoard[i][k].equals(gameBoard[i][k-1])&&(!gameBoard[i][k-1].getIsMerged()&&!gameBoard[i][k].getIsMerged())) {
								merge("left",gameBoard[i][k],gameBoard[i][k-1]);
								availableMove = true;
							}
						
						else if(gameBoard[i][k-1].isEmpty()) {
							gameBoard[i][k-1].setValue(gameBoard[i][k].getValue());
							gameBoard[i][k].setValue(0);
							availableMove = true;
						}
						}
						}

				}
			}
		}
		if(availableMove) generateValue();
	}
	public void moveUp() {
		boolean availableMove = false;
		setMergedFalse();
		for(int i=0;i<size;i++) {
			for(int j=1;j<size;j++) {
				for(int k=j;k>0;k--) {
					if(!gameBoard[k][i].isEmpty()) {
						if(this.canMove(gameBoard[k][i], gameBoard[k-1][i])) {
							if(gameBoard[k][i].equals(gameBoard[k-1][i])&&(!gameBoard[k-1][i].getIsMerged()&&!gameBoard[k][i].getIsMerged())) {
								merge("upward",gameBoard[k][i],gameBoard[k-1][i]);
								availableMove = true;
							}
						
						else if(gameBoard[k-1][i].isEmpty()) {
							gameBoard[k-1][i].setValue(gameBoard[k][i].getValue());
							gameBoard[k][i].setValue(0);
							availableMove = true;
						}
						}
						}
				}
			}
				}
		if(availableMove) generateValue();
	}
	public void moveDown() {
		setMergedFalse();
		boolean availableMove = false;
		for(int i=0;i<size;i++) {
			for(int j=size-2;j>=0;j--) {
				for(int k=j;k<size-1;k++) {
					if(!gameBoard[k][i].isEmpty()) {
					if(this.canMove(gameBoard[k][i], gameBoard[k+1][i])) {
						if(gameBoard[k][i].equals(gameBoard[k+1][i])&&(!gameBoard[k+1][i].getIsMerged()&&!gameBoard[k][i].getIsMerged())) {
							merge("downward",gameBoard[k][i],gameBoard[k+1][i]);
							availableMove = true;
						}
					
					else if(gameBoard[k+1][i].isEmpty()) {
						gameBoard[k+1][i].setValue(gameBoard[k][i].getValue());
						gameBoard[k][i].setValue(0);
						availableMove = true;
					}
					}
					}
		}
			}
		}
		if(availableMove) generateValue();
	}
	public void merge(String direction, Block b1, Block b2 ) {
		if(b1.equals(b2)) {
				gameBoard[b2.getX()][b2.getY()].setValue(b2.getValue()*2);
				gameBoard[b1.getX()][b1.getY()].setValue(0);
				gameBoard[b2.getX()][b2.getY()].setIsMerged(true);
		}
	}
	public void setMergedFalse() {
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				gameBoard[i][j].setIsMerged(false);
	}
	
	public void generateValue() {
		int value = obtainRandom(0,10);
		if(value<=8) value = 2;
		else value = 4;
		while(true){
		int x = obtainRandom(0,3);
		int y = obtainRandom(0,3);
		if(gameBoard[x][y].isEmpty()) {
			gameBoard[x][y].setValue(value);
			return;
		}
		}
	}
	public boolean isGameOver() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(gameBoard[i][j].isEmpty()) return false;
				else {
					if(i>0)
						if(canMove(gameBoard[i][j],gameBoard[i-1][j])) return false;
					if(i<size-1)
						if(canMove(gameBoard[i][j],gameBoard[i+1][j])) return false;
					if(j>0)
						if(canMove(gameBoard[i][j],gameBoard[i][j-1])) return false;
					if(j<size-1)
						if(canMove(gameBoard[i][j],gameBoard[i][j+1])) return false;
				}
			}
		}
		return true;
	}
	public String toString() {
		String result = "";
		for(int i=0;i<size;i++) {
			if(i>0) result+="\n";
			for(int j=0;j<size;j++) {
				result+=gameBoard[i][j]+" ";
			}
		}
		return result;
	}
	public static int obtainRandom(int low,int high) {
		Random rand = new Random();
		return rand.nextInt(high-low+1)+low;
	}
	
}
