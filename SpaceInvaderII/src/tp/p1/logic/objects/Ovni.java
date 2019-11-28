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
	private static int y=-1;
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
			super.x--;
			if(isOut()) {
				this.enable=false;
				super.x=9;}
			
			}
			//return true;
		//}
		
	}
	/*
	public boolean hurt(int row,int col) {
		boolean resul=false;
		if(this.enable) {
			if(row==super.y & col==super.x) {
				this.enable=false;
				super.x=x;
				super.y=y;
				game.receivePoints(this.getPoints());
				resul=true;
				
			}
		}
		return resul;
	}*/
	
	public String toString() {
		return draw + "["+ live + "]"; 
	}/*
	public int getRow() {
		return this.y;
	}
	public int getColumn() {
		return this.x;
	}*/
	
	public int getPoint() {
		return this.points;
	}
	
	public void computerAction() {
		if(!this.enable && IExecuteRandomActions.canGenerateRandomOvni(game)) {
			this.enable = true;super.y=0;}
	}
	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable() {
		this.enable = false;
	}
	/*
	public void onDelete() {
		super.live=live;
		this.enable=false;
		super.x=x;
		super.y=y;
		game.receivePoints(this.getPoints());
	}*/
	
	public boolean receiveMissileAttack(int damage) {
		this.enable=false;
		super.x=x;
		super.y=y;
		game.receivePoints(this.getPoints());
		return true;
		}
	
	public boolean receiveShockWaveAttack(int damage) {
		this.enable=false;
		super.x=x;
		super.y=y;
		game.receivePoints(this.getPoints());
		return false;
		}
}
