package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class RegularShip extends AlienShip{
	
	private static int life = 2;
	private int row;
	private int col;
	private final String draw = "R";
	private static int points=5;
	
	public RegularShip(Game game, int x, int y) {
		super(game, x, y, life, points);
		//this.row = row;
		//this.col = col;
	}

	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	public int getLife() {//tal vez con herencia, ya que todos tienen vida
		return life;
	}
/*
	public void move(Move dir) {
		if(dir==Move.DOWN) {this.row++;}
		else if(dir==Move.RIGHT) {this.col++;}
		else if(dir==Move.LEFT) {this.col--;}
	}*/
	/*
	public void hurt() {
		life--;
	}*/
	
	public void hurt() {
		super.live--;
	}
	
	public String toString(){
		return this.draw+"[" + super.live + "]";
	}
	
	@Override
	public void onDelete() {
		super.REMAINING_ALIENS--;
		if(super.getSHIPS_ON_BORDER()>0) {
			super.setSHIPS_ON_BORDER();
		}
	}

}
