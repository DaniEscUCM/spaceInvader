package tp.p1.logic.objects;

public class Bomb {
	private int row;
	private int col;
	//private int harm = 1;
	private final String draw = ".";

	public Bomb(int row, int col) {
		super();//??
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}

/*
	public int getHarm() {
		return harm;
	}


	public void setHarm(int harm) {
		this.harm = harm;
	}*/


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
