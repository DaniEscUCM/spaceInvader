package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class ExplosivShip extends AlienShip{

	//private static int life = 2;
	private final String draw = "E";
	private static int points=5;
	private int damage=1;
	
	@SuppressWarnings("static-access")
	public ExplosivShip(Game game, int x, int y, int life,int cy, int shipsOnBorder,  Move dir) {//quite hurt???
		super(game, x, y, life, points);
		cyclesToMove=cy;
		this.SHIPS_ON_BORDER=shipsOnBorder;
		this.dir=dir;
	}
	
	public int getLife() {//tal vez con herencia, ya que todos tienen vida
		return super.life;
	}
	
	public void hurt() {
		super.life--;
	}

	public String toString(){
		return this.draw+"[" + super.life + "]";
	}
	
	@SuppressWarnings("static-access")
	public void onDelete() {
		super.REMAINING_ALIENS--;
		game.receivePoints(this.getPoints());
		game.explosiveDeath(super.x, super.y);
		if(super.getSHIPS_ON_BORDER()>0) {
			super.setSHIPS_ON_BORDER();
		}
	}
	
	public String stringify() {
		String s = this.draw + "," + super.x + "," + super.y + ";"+ super.life
				+ ";" + super.cyclesToMove + ";" + super.dir.toString();
		return s;
	}
	
	public boolean performAttack(GameObject other) {
		if(! this.isAlive()){
			return other.receiveExplosiveAttack(this.damage);
		}
		else return false;
	}
	
}
