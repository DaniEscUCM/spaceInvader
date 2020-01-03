package tp.p1.logic.objects;
import tp.p1.logic.Game;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.Weapon;



public class SuperMisil extends Weapon {
	
	private static int life = 1;
	private static final int harm=2;
	private final String strfy = "X";
	private final String draw= "^";

	public SuperMisil(Game game, int x, int y) {
		super(game, x, y, life, harm);
	}

	public void move() {
		super.y--;
		if(isOut()) {
			super.life=0;
		}
	}	
	
	public String toString() {
		return draw;
	}
	
	public boolean performAttack(GameObject other) {
		boolean resul=false;
		if(other.isOnPosition(super.getX(), super.getY())&& other!=this) {
			resul=other.receiveMissileAttack(super.getHarm());
			super.life--;
		}		
		return resul;
	}
	
	public void onDelete() {
		game.enableMissileSup();
	}
	
	public String stringify() {
		String s = this.strfy + "," + super.x + "," + super.y;
		return s;
	}

}
