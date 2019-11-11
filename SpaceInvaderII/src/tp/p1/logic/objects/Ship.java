package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class Ship extends GameObject {// se puede quitar que no hace nada, sino esta vacia. talvez dejarla por los points
	
	private int points;
	
	public Ship(Game game, int x, int y, int life, int points) {
		super(game, x, y, life);
		this.points=points;
	}

	public int getPoints() {
		return points;
	}

	@Override
	public void computerAction() {	}

	@Override
	public void onDelete() {	}

	@Override
	public void move() {	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
