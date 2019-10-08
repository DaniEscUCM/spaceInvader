package tp.p1.logic.objects;

import tp.p1.logic.Move;

public class DestroyerShip {
	private int health=1;
	private int row, column;
	private final int points=10;
	
	public DestroyerShip(int row, int col) {
		this.row=row;
		this.column=col;
	}
	/*
	public void destroyerDeath() {
		health--;
	}*/
	
	public void destroyermove( Move dir) {//dir move
		switch (dir){
		case DOWN:row++;
		case RIGHT:column++;
		default: column--;
		}
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
