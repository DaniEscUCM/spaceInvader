package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class UCMShip extends Ship{
	

	private static int life=3;
	private int column=4;
	private String draw= "^__^";
	private final int row=7;//nunca se mueve de la ultima fila
	
	public UCMShip(Game game, int x, int y) {
		super(game, x, y, life);
		// TODO Auto-generated constructor stub
	}

	public boolean move_UCMship (int steps, Move direction) {//ver direccion, tal vez enumerado
		boolean ret = true;
		if (direction == Move.RIGHT && ((column + steps) < 8)) {
			column+=steps;
		}
		else if (direction == Move.RIGHT && ((column + steps) >= 8)) {
			column = 8; 
		}
		else if (direction == Move.LEFT && ((column - steps) >= 0)) {
			column-=steps;
		}
		else if (direction == Move.LEFT && ((column - steps) < 0)) {
			column = 0; 
		}
		else ret = false;
		return ret;
	}
	
	public void hurt() {
		life--;
	}
	
	public int getLife() {
		return life;
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
	
	public void setDraw(String newD) {
		this.draw=newD;
	}

}
