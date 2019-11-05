package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class UCMShipLaser extends Weapon{
	
	private static int life = 1;
	private int row, column;
	private final int harm=1;//herencia?
	private final String draw= "oo";
	
	public UCMShipLaser(Game game, int x, int y) {
		super(game, x, y, life);
		//row=7;
		//column=ucmColumn;
	}
	
	public void move() {
		//if(this.row==0) {
			//return false;
		//}
		//else {
			row --;
			//return true;
		//}
	}
	
	public int getHarm() {
		return harm;
	}
	
	public String toString() {
		return draw;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}

}
