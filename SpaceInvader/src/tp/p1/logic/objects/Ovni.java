package tp.p1.logic.objects;

public class Ovni {
	
	private final int row = 0;
	private int column=8;
	private int life = 1;
	private int points = 25;
	private final String draw = "O";
	
	public boolean move () {
		if(this.column==0) {
			return false;
		}
		else {
			column --;
			return true;
		}
		
	}
	
	public boolean hurt(int row,int col) {
		boolean resul=false;
		if(row==this.row & col==this.column) {
			life--;
			resul=true;
		}
		return resul;
	}
	/*
	public boolean shockWave() {//tal vez en otro lado??
		if(live == 0)
			return true;
		else return false;
	}*/
	
	public String toString() {
		return draw + "["+ life + "]"; 
	}
	public int getRow() {
		return this.row;
	}
	public int getColumn() {
		return this.column;
	}
	
	public int getPoint() {
		return this.points;
	}
}
