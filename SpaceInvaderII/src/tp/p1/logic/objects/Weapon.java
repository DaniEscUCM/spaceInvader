package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class Weapon extends GameObject{
	
	private int harm;

	public Weapon(Game game, int x, int y, int life, int harm) {
		super(game, x, y, life);
		this.harm=harm;
	}

	@Override
	public void computerAction() {
	}
	@Override
	public void move() {
		//this.move();
	}

	@Override
	public void onDelete() {
		//this.onDelete();
	}
	@Override
	public String toString() {
		return " ";
	}
	public int getHarm() {
		return harm;
	}

	@Override
	public String stringify() {
		return null;
	}


}
