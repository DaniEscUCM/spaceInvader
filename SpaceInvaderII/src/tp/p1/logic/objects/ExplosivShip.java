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

	public String toString(){
		return this.draw+"[" + super.live + "]";
	}
	
}
