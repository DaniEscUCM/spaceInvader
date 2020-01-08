package tp.p1.logic.objects;

import exceptions.OffWorldException;
import tp.p1.logic.Game;

public class UCMShip extends Ship{
	

	private final String strfy = "P";
	private static int life=3;
	private String draw= "^__^";
	private String losedraw="!xx!";
	private static int points=0;
	private boolean hasShockWave;
	private boolean canShootLaser;
	private int numofSuper;
	private int numLasers;
	
	public int getNumofSuper() {
		return numofSuper;
	}

	public void setNumofSuper() {
		super.points-=20;
		this.numofSuper++;
	}
	
	public void useSuper() {
		this.numofSuper--;
	}

	public UCMShip(Game game, int x, int y) {
		super(game, x, y, life,points);
		this.hasShockWave=false;
		this.canShootLaser=true;
		numofSuper = 0;
		numLasers = 0;
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
		if(canShootLaser) this.numLasers++;
		else this.numLasers--;
		this.canShootLaser = !this.canShootLaser;
	}
	
	
	public void receivePoints(int points) {
		super.points+=points;
	}

	@SuppressWarnings("static-access")
	public boolean move (int steps) throws OffWorldException{
		boolean ret = false;
		if((x + steps)<game.DIM_X && (x + steps) >= 0) {x+=steps;ret=true;}//no va a dejar dar mas pasos de los que necesita
		else {
			OffWorldException ex= new OffWorldException();
			throw ex;
		}
		return ret;
	}
	
	public void hurt() {
		super.life--;
	}
	
	public int getLife() {
		return super.life;
	}
	
	public String toString() {
		if( super.life==0 || AlienShip.haveLanded()) {
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
		return "Life: "+super.life+"\n"+"Points: "+super.points+"\n";//he puesto points en ship
	}
	
	public String stringify() {
		String s = this.strfy + ";" + super.x + "," + super.y + ";" + super.life + ";"
				+ super.points + ";";
		
		if(this.numofSuper > 0) s+= "supermissile;";
		if(game.getShockWave()) s+= "shockwave;";
		s+= this.numLasers;
	
		return s;
	}
	
	@Override
	public boolean isAlive() {
		return true;
	}
	
	@Override
	public boolean receiveShockWaveAttack(int damage) {return false;};
	

}
