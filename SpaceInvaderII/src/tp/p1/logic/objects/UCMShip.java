package tp.p1.logic.objects;

import exceptions.OffWorldException;
import tp.p1.logic.Game;
//import tp.p1.logic.Move;

public class UCMShip extends Ship{
	

	private static final String strfy = "P";
	private static int life=3;
	//private int column=4;
	private String draw= "^__^";
	private String losedraw="!xx!";
	//private final int row=7;//nunca se mueve de la ultima fila
	private static int points=0;
	private boolean hasShockWave;//segun diapositivas
	private boolean canShootLaser;//no se si boolean o laser
	private int numofSuper;
	
	public int getNumofSuper() {
		return numofSuper;
	}

	public void setNumofSuper() {
		this.points-=20;
		this.numofSuper++;
	}
	
	public void useSuper() {
		this.numofSuper--;
	}

	public UCMShip(Game game, int x, int y) {
		super(game, x, y, life,points);
		this.hasShockWave=false;
		this.canShootLaser=true;
		numofSuper=0;
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
	
	
	public void receivePoints(int points) {
		this.points+=points;
	}

	public boolean move (int steps) throws OffWorldException{//ver direccion, tal vez enumerado, Move direction, como ya no nos dan direcci�n se cambiara a -/+ segun la dirccecion
		boolean ret = false;
		if((x + steps)<game.DIM_X && (x + steps) >= 0) {x+=steps;ret=true;}//no va a dejar dar mas pasos de los que necesita
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
		else {
			OffWorldException ex= new OffWorldException();
			throw ex;
			}
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
	
	public String stringify() {
		String s = this.strfy + ";" + this.x + "," + this.y + ";" + this.live + ";"
				+ points + ";" + this.numofSuper;
	
		return s;
	}
	

}
