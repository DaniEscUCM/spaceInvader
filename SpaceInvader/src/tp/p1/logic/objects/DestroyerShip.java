package tp.p1.logic.objects;

import tp.p1.logic.Move;

public class DestroyerShip {
	private int health=1;
	private int row, column;
	private final int points=10;
	
	public DestroyerShip(int row0, int col) {
		row=row0;
		column=col;
	}
	
	public void destroyerDeath() {
		health--;
	}
	
	public void destroyermove(boolean border, Move dir) {//dir move
		if(border) {row++;}
		else if(dir==Move.RIGHT) {column++;}
		else {column--;}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getPoints() {
		return points;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	
	public String toStringDestructor() {
		return "D["+health+"]";
	}
	
}
