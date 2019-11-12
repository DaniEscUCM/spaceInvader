package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class Weapon extends GameObject{

	public Weapon(Game game, int x, int y, int life) {
		super(game, x, y, life);
	}

	@Override
	public void computerAction() {
		
	}
	

	@Override
	public void move() {
		this.move();
	}

	@Override
	public void onDelete() {
		this.onDelete();
	}
	@Override
	public String toString() {
		return this.toString();
	}


}
