package tp.p1.logic.objects;
import tp.p1.logic.Game;
import tp.p1.logic.Move;
import tp.p1.logic.lists.GameObjectBoard;

public class DestroyerShip extends AlienShip implements IExecuteRandomActions{
	private static int life=1;
	private boolean canShootBomb;
	private static int points=10;
	private final String draw = "D";
	
	
	public DestroyerShip(Game game, int x, int y) {
		super(game, x, y, life, points);
		this.canShootBomb =true;
	}
	
	public int getLife() {
		return life;
	}
	
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomBomb(game) 
				&& canShootBomb) {
			Bomb b = new Bomb(this.game, super.x, super.y+1, this);
			b.setDestroyer(this);
			game.addObject(b);
			this.canShootBomb = false;
		}
	}
	
	public String toString() {
		return "D["+life+"]";
	}
	/*
	public Bomb shoot() {
		this.bomb= new Bomb(this.game, this.row + 1, this.column);
		//this.bomb= new Bomb(this.row+1, this.column);
		return bomb;
	}*/
	
	
	public void enableBomb() {
		this.canShootBomb = false;
	}
	
	public void setCanShootBomb(boolean canShoot) {
		this.canShootBomb = canShoot;
	}
	

	public void hurt() {
		super.live--;
	}
	
	/*
	public boolean equalsbomb(Bomb bomb) {
		return this.bomb==bomb;
	}*/
	
	@Override
	public void onDelete() {
		super.REMAINING_ALIENS--;
		game.receivePoints(this.getPoints());
		if(super.getSHIPS_ON_BORDER()>0) {
			super.setSHIPS_ON_BORDER();
		}
	}
	
	public String stringify() {
		String s = this.draw + "," + this.x + "," + this.y+ ";" + this.live 
				+ ";" + this.game.cyclesNextAlien + this.dir;
		return s;
	}

}
