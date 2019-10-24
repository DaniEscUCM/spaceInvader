package tp.p1.logic.objects;

public class Bomb {
	private int row;
	private int col;	
	private final String draw = ".";

	public Bomb(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public boolean move() {
		if(this.row < 7) {
			this.row ++; return true;
		}
		else return false;
	}
	
	public String toString() {
		return draw;
	}

}
