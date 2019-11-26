package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class RegularShip extends AlienShip{
	
	private static int life = 2;
	private final String draw = "R";
	private static int points=5;
	
	public RegularShip(Game game, int x, int y) {
		super(game, x, y, life, points);
	}
	public int getLife() {//tal vez con herencia, ya que todos tienen vida
		return life;
	}
	
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomExplosiv(game)) {
			ExplosivShip explosiv = new ExplosivShip(this.game, super.x, super.y+1, this.life, 1);
			this.game.addObject(explosiv);
			this.game.deleteOnlist(this);
		}
	}
	
	public void hurt() {
		super.live--;
	}
	
	public String toString(){
		return this.draw+"[" + super.live + "]";
	}
	
	@Override
	public void onDelete() {
		super.REMAINING_ALIENS--;
		game.receivePoints(this.getPoints());
		if(super.getSHIPS_ON_BORDER()>0) {
			super.setSHIPS_ON_BORDER();
		}
	}

}
