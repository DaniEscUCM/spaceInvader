package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class Bomb extends Weapon{
	private static int life = 1;	
	private final String draw = ".";//tendra un destroyer
	private DestroyerShip destroyer;
	private static final int harm=1;
	private static String strfy = "B";
	boolean move = false;


	public Bomb(Game game, int x, int y,DestroyerShip destroyer) {
		super(game, x, y, life,harm);
		this.destroyer = destroyer;
		
	}
	
	public void onDelete() {
		this.destroyer.setCanShootBomb(true);
		this.destroyer = null;
	}
	
	public void move() {
		if(move) {
			super.y++;
			if(isOut()) {
				super.live=0;
			}
		}
		else this.move = true;
	}
	
	public void computerAction() {
	}
	
	public DestroyerShip getDestroyer() {
		return destroyer;
	}

	public void setDestroyer(DestroyerShip destroyer) {
		this.destroyer = destroyer;
	}
	public String toString() {
		return draw;
	}
	
	public  boolean performAttack(GameObject other) {
		boolean resul=false;
		if(other.isOnPosition(this.getX(), this.getY())&& other!=this) {
			resul=other.receiveBombAttack(super.getHarm());
			super.live--;
		}
		
		return resul;
	}
	
	public String stringify() {
		String s = this.strfy + "," + this.x + "," + this.y+ ";" + this.live 
				+ ";";/* + this.game.cyclesNextAlien + this.dir;*/
		return s;
	}


}
