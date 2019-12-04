package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class UCMShipLaser extends Weapon{
	
	private static int life = 1;
	private int row, column;
	private static final int harm=1;//herencia?
	private final String draw= "oo";
	private final String strfy = "M";
	
	public UCMShipLaser(Game game, int x, int y) {
		super(game, x, y, life,harm);
		//row=7;
		//column=ucmColumn;
	}
	
	public void move()  {
		super.y--;
		this.row --;
		if(isOut()) {//is out no funciona?
			super.life=0;
		}
	}	
	
	public String toString() {
		return draw;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
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
		game.enableMissile();
	}
	
	public String stringify() {
		String s = this.strfy + "," + super.x + "," + super.y;
		return s;
	}

}
