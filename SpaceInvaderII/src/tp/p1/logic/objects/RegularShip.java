package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class RegularShip extends AlienShip{
	
	
	private static int life = 2;
	private final String draw = "R";
	private static int points=5;
	
	public RegularShip(Game game, int x, int y) {
		super(game, x, y, life, points);
	}
	public int getLife() {
		return super.life;
	}
	
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomExplosiv(game)) {
			@SuppressWarnings("static-access")
			/*pasar remaining aliens en la constructora de explosiv*/
			ExplosivShip explosiv = new ExplosivShip(this.game, super.x, super.y, super.life, this.getcyclesToMove(),this.getSHIPS_ON_BORDER(),this.dir, super.getRemainingAliens());
			this.game.addObject(explosiv);
			this.game.deleteOnlist(this);
			explosiv.setREMAINING_ALIENS();
		}
	}
	
	public void hurt() {
		super.life--;
	}
	
	public String toString(){
		return this.draw+"[" + super.life + "]";
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void onDelete() {
		super.REMAINING_ALIENS--;
		game.receivePoints(this.getPoints());
		if(super.getSHIPS_ON_BORDER()>0) {
			super.setSHIPS_ON_BORDER();
		}
	}
	
	public String stringify() {
		String s = this.draw + ";" + super.x + "," + super.y + ";" + super.life 
				+ ";" + super.cyclesToMove + super.dir.toString();
		return s;
	}

}
