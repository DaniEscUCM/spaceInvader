package tp.p1.logic.objects;

public class Bomb {
	private int row;
	private int col;
	private int harm = 1;
	private final String draw = ".";

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


	public int getHarm() {
		return harm;
	}


	public void setHarm(int harm) {
		this.harm = harm;
	}


	public Bomb(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}


	private void move(int fila, int col) {
		this.row = fila;
		this.col = col;
	}
	
	public String toString() {
		return draw;
	}
}
