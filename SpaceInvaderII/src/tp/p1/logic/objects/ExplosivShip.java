package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class ExplosivShip extends AlienShip{

	private static int life = 2;
	private final String draw = "E";
	private static int points=5;
	
	public ExplosivShip(Game game, int x, int y, int life,int cy) {//quite hurt???
		super(game, x, y, life, points);
		super.setcyclesToMove(cy);
	}
	
	public int getLife() {//tal vez con herencia, ya que todos tienen vida
		return life;
	}
	
	public void hurt() {
		super.live--;
	}

	public String toString(){
		return this.draw+"[" + super.live + "]";
	}
	
	public void onDelete() {
		super.REMAINING_ALIENS--;
		game.receivePoints(this.getPoints());
		if(super.getSHIPS_ON_BORDER()>0) {
			super.setSHIPS_ON_BORDER();
		}
	}
	
	public String stringify() {
		String s = this.draw + "," + this.x + "," + this.y + ";"+ this.live
				+ ";";/* + this.game.cyclesNextAlien + ";" + this.dir;*/
		return s;
	}
	
}
