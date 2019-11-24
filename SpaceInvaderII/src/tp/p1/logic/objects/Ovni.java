package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class Ovni extends EnemyShip implements IExecuteRandomActions{
	

	//private final int row = 0;
	//private int column=8;
	//private int life = 1;
	//private int points = 25;
	private final String draw = "O";
	private boolean enable;//ya no se crea y se quita
	private static int points=25;


	private static int x=9;
	private static int y=0;
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
		if(this.enable) {
			this.x --;
			super.x--;
			if(isOut()) {
				this.enable=false;
				super.x=9;
				this.x=9;}
			
			}
			//return true;
		//}
		
	}
	
	public boolean hurt(int row,int col) {
		boolean resul=false;
		if(this.enable) {
			if(row==this.y & col==this.x) {
				live--;
				super.live--;
				resul=true;
				
			}
		}
		return resul;
	}
	
	public String toString() {
		if(this.enable) {return draw + "["+ live + "]"; }
		return "";
	}
	public int getRow() {
		return this.y;
	}
	public int getColumn() {
		return this.x;
	}
	
	public int getPoint() {
		return this.points;
	}
	
	public void computerAction() {
		if(!this.enable && IExecuteRandomActions.canGenerateRandomOvni(game)) {
			this.enable = true;}
	}
	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable() {
		this.enable = false;
	}
}
