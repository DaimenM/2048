
public class Block {
	private int value;
	private int x;
	private int y;
	private boolean isMerged;
	public Block(int value,int x,int y) {
		this.value = value;
		this.x=x;
		this.y=y;
		this.isMerged = false;
		 
	}
	public Block(int x,int y) {
		value = 0;
		this.x=x;
		this.y=y;
		this.isMerged = false;
	}
	public int getX() {
		return x;
	}
	public void setX(int newX) {
		this.x=newX;
	}
	public int getY() {
		return y;
	}
	public void setY(int newY) {
		this.y=newY;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int newValue) {
		value = newValue;
	}
	public boolean getIsMerged() {
		return isMerged;
	}
	public void setIsMerged(Boolean isMerged) {
		this.isMerged = isMerged;
	}
	public boolean isEmpty() {
		if(value==0) return true;
		return false;
	}
	public boolean equals(Block other) {
		return value == other.value;
	}
	public String toString() {
		if(value==0)return "[ ]";
		else return "["+value+"]";
	}
	
}
