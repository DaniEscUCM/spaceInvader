package tp.p1.logic.objects;

import tp.p1.logic.Game;
//import tp.p1.logic.Move;

public class UCMShip extends Ship{
	

	private static int life=3;
	//private int column=4;
	private String draw= "^__^";
	private String losedraw="!xx!";
	//private final int row=7;//nunca se mueve de la ultima fila
	private static int points=0;
	private boolean hasShockWave;//segun diapositivas
	private boolean canShootLaser;//no se si boolean o laser
	
	public UCMShip(Game game, int x, int y) {
		super(game, x, y, life,points);
		this.hasShockWave=false;
		this.canShootLaser=true;
	}

	public boolean isHasShockWave() {
		return hasShockWave;
	}

	public void setHasShockWave() {
		this.hasShockWave = false;
	}

	public boolean isCanShootLaser() {
		return canShootLaser;
	}

	public void setCanShootLaser() {
		this.canShootLaser = !this.canShootLaser;
	}

	public boolean move (int steps) {//ver direccion, tal vez enumerado, Move direction, como ya no nos dan dirección se cambiara a -/+ segun la dirccecion
		boolean ret = true;
		if((x + steps)<game.DIM_X && (x + steps) >= 0) {x+=steps;}//no va a dejar dar mas pasos de los que necesita
		/*
		if (direction == Move.RIGHT && ((column + steps) < 8)) {
			column+=steps;
		}
		else if (direction == Move.RIGHT && ((column + steps) >= 8)) {
			column = 8; 
		}
		else if (direction == Move.LEFT && ((column - steps) >= 0)) {
			column-=steps;
		}
		else if (direction == Move.LEFT && ((column - steps) < 0)) {
			column = 0; 
		}*/
		else ret = false;
		return ret;
	}
	
	public void hurt() {
		life--;
	}
	
	public int getLife() {
		return life;
	}
	
	public String toString() {
		if( super.live==0 || AlienShip.haveLanded()) {
			return this.losedraw;
		}
		return draw;
	}
	public int getRow() {
		return y;
	}
	public int getColumn() {
		return x;
	}
	
	public void setDraw(String newD) {
		this.draw=newD;
	}

	public String stateToString() {	
		return "Life: "+this.live+"\n"+"Points: "+points+"\n";//he puesto points en ship
	}
	
	public boolean shootLaser() {//no se como hacer con el laser
		// TODO implement
		return false;
	}

}
