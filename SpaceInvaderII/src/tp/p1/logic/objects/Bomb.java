package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class Bomb extends Weapon{
	private static int life = 1;
	private int row;
	private int col;	
	private final String draw = ".";//tendra un destroyer
	private DestroyerShip destroyer;


	public Bomb(Game game, int x, int y) {
		super(game, x, y, life);
		this.destroyer = null;
		//this.row = row;
		//this.col = col;
	}
	
	public void onDelete() {
		this.destroyer = null;
	}

	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void move() {
		this.row ++;
	}
	
	public void computerAction() {
		;
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

}
