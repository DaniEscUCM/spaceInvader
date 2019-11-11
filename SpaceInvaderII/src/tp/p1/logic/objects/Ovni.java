package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class Ovni extends EnemyShip{
	

	private final int row = 0;
	private int column=8;
	private int life = 1;
	//private int points = 25;
	private final String draw = "O";
	private boolean enable;//ya no se crea y se quita
	private static int points=25;


	private static int x=0;
	private static int y=8;
	private static int live=1;
	
	public Ovni(Game game) {
		super(game, x, y, live,points);
		enable=false;
	}
	
	public void move () {
		//if(this.column==0) {
			//return false;
		//}
		//else {
			column --;
			//return true;
		//}
		
	}
	
	public boolean hurt(int row,int col) {
		boolean resul=false;
		if(row==this.row & col==this.column) {
			life--;
			resul=true;
		}
		return resul;
	}
	
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
	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable() {
		this.enable = false;
	}
}
