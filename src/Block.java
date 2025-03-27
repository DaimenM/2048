
import javafx.scene.paint.Color;
public class Block {
	private int value;
	private int x;
	private int y;
	private boolean isMerged;
	private Color color;
	public Block(int value,int x,int y) {
		this.value = value;
		this.x=x;
		this.y=y;
		this.isMerged = false;
		this.color = getColor(value);
	}
	public Block(int x,int y) {
		value = 0;
		this.x=x;
		this.y=y;
		this.isMerged = false;
		this.color = getColor(value);
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
	public Color getColor(int value) {
		switch(value){
			case 0:
				return new Color(0.6149, 0.625, 0.6169, 1.0);
			case 2:
			 	return new Color(1.0, 0.8823, 0.2153, 1.0);
			case 4:
				return new Color(1.0, 0.6382, 0.22, 1.0);
			case 8:
				return new Color(1.0, 0.2377, 0.22, 1.0);
			case 16:
				return new Color(0.6601, 0.22, 1.0, 1.0);
			case 32:
				return new Color(0.22, 0.3297, 1.0, 1.0);
			case 64:
				return new Color(0.188, 0.94, 0.2489, 1.0);
			case 128:
				return new Color(0.8533, 0.1254, 0.9342, 1.0);
			case 256:
				return new Color(0.8243, 1.0, 0.0417, 1.0);
			case 512:
				return new Color(0.2105, 0.0234, 0.0234, 1.0);
			case 1024:
				return new Color(0.4583, 0.8826, 1.0, 1.0);
			case 2048:
				return new Color(0.1842, 0.0802, 0.0802, 1.0);
			case 4096:
				return new Color(0.0, 0.0, 0.0, 1.0);
			default:
				return new Color(0.3816, 0.3816, 0.3816, 1.0);
		}
	}
	public void setColor(Color color) {
		this.color = color;
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
