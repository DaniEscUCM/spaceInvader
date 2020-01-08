package tp.p1.logic.objects;

import tp.p1.logic.Game;

public abstract class GameObject implements IAttack {
	protected int x;
	protected int y;
	protected int life;
	protected Game game;
	public static final String labelRefSeparator = " - ";
	protected int label = 0;
	
	public GameObject( Game game, int x, int y, int life) {
		this. x = x;
		this. y = y;
		this. game = game;
		this.life = life;
	}	
	
	public int getLabel() {
		return label;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isAlive() {
		return this.life > 0;
	}
	
	public int getLive() {
		return this.life;
	}
	
	public boolean isOnPosition(int x, int y) {
		return this.x == x && this.y == y;
	}
	
	public void getDamage (int damage) {
		this.life = damage >= this.life ? 0 : this.life - damage;
	}
	
	public boolean isOut() {//metodos move, si se sale del tablero
		return !game.isOnBoard(x, y);
	}
	
	public int getHarm() {
		return 0;
	}
	
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	public abstract String stringify();
	
	public boolean receiveMissileAttack(int damage) {
		this.life-=damage;
		return true;
		}
	public boolean receiveBombAttack(int damage) {
		this.life-=damage;
		return true;
		}
	public boolean receiveShockWaveAttack(int damage) {
		this.life-=damage;
		return true;
		}
	
	public boolean receiveExplosiveAttack(int damage) {
		 this.life-=damage;
		 return true;
		 }
	
	
}
