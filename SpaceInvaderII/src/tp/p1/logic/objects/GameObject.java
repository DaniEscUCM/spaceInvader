package tp.p1.logic.objects;

import tp.p1.logic.Game;

public abstract class GameObject implements IAttack {
	protected int x;
	protected int y;
	protected int live;//la profesora dice quitarlo pq no todos tienen vida
	protected Game game;
	
	public GameObject( Game game, int x, int y, int life) {
		this. x = x;
		this. y = y;
		this. game = game;
		this.live = life;
	}
	

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isAlive() {//se pondria en los que tienen vida
		return this.live > 0;
	}
	
	public int getLive() {//se pondria en los que tienen vida
		return this.live;
	}
	
	public boolean isOnPosition(int x, int y) {
		return this.x == x && this.y == y;
	}
	
	public void getDamage (int damage) {
		this.live = damage >= this.live ? 0 : this.live - damage;
	}
	
	public boolean isOut() {//metodos move, si se sale del tablero
		return !game.isOnBoard(x, y);
	}
	
	public abstract void computerAction();//quien no lo haga se deja vacio
	public abstract void onDelete();//ej: enable la bomba en destroyer 
	public abstract void move();//quien no lo haga se deja vacio
	public abstract String toString();
}
