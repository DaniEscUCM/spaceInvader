package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class Bomb extends Weapon{
	private static int life = 1;
	private int row;
	private int col;	
	private final String draw = ".";

	public Bomb(Game game, int x, int y) {
		super(game, x, y, life);
		//this.row = row;
		//this.col = col;
	}

	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void move() {
		if(this.row < 7) {
			this.row ++; //return true;
		}
		//else return false;
	}
	
	public String toString() {
		return draw;
	}

}
