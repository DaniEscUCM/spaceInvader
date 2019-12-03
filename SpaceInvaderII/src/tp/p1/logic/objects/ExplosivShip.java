package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class ExplosivShip extends AlienShip{

	private static int life = 2;
	private final String draw = "E";
	private static int points=5;
	
	public ExplosivShip(Game game, int x, int y, int life, int hurt) {
		super(game, x, y, life, hurt);
		// TODO Auto-generated constructor stub
	}

	public String toString(){
		return this.draw+"[" + super.live + "]";
	}
	
	public String stringify() {
		String s = this.draw + "," + this.x + "," + this.y + ";"+ this.live
				+ ";" + this.game.cyclesNextAlien + ";" + this.dir;
		return s;
	}
	
}
