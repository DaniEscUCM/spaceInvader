package tp.p1.logic.objects;

import tp.p1.logic.Move;

public class RegularShip {

	private int health = 2;
	private int row;
	private int col;
	private final String draw = "C";
	
	public RegularShip(int row, int col) {
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
	
	public int getHealth() {
		return this.health;
	}

	public void move(Move dir) {
		switch (dir){
		case DOWN:row++;
		case RIGHT:col++;
		default: col--;
		}
	}
	
	public void hurt() {
		health--;
	}
	
	public String toString(){
		return this.draw+"[" + health + "]";
	}
}
