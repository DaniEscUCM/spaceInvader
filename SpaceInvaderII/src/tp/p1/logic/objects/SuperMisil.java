package tp.p1.logic.objects;
import tp.p1.logic.Game;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.Weapon;

public class SuperMisil extends Weapon {
	
	private static int life = 1;
	private static final int harm=2;
	private final String draw= "^";

	public SuperMisil(Game game, int x, int y, int life, int harm) {
		super(game, x, y, life, harm);
	}

	public void move() {
		super.y--;
		if(isOut()) {//is out no funciona?
			super.live=0;
		}
	}	
	
	public String toString() {
		return draw;
	}
	
	public boolean performAttack(GameObject other) {
		boolean resul=false;
		if(other.isOnPosition(super.getX(), super.getY())&& other!=this) {
			resul=other.receiveMissileAttack(super.getHarm());
			super.live--;
		}		
		return resul;
	}
	
	public void onDelete() {
		game.enableMissile();
	}
}
