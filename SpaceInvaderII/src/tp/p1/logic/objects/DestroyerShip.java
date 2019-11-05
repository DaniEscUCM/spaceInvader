package tp.p1.logic.objects;
import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class DestroyerShip extends AlienShip{
	private static int life=1;
	private int row, column;
	private Bomb bomb=null;
	
	
	public DestroyerShip(Game game, int x, int y) {
		super(game, x, y, life);
		//this.row=row;
		//this.column=col;
	}
	
	public void move( Move dir) {//dir move
		if(dir==Move.DOWN) {this.row++;}
		else if(dir==Move.RIGHT) {this.column++;}
		else if(dir==Move.LEFT) {this.column--;}
	}
	
	public int getLife() {
		return life;
	}
	
	
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	
	public String toString() {
		return "D["+life+"]";
	}
	
	public Bomb shoot() {
		this.bomb= new Bomb(this.game, this.row + 1, this.column);
		//this.bomb= new Bomb(this.row+1, this.column);
		return bomb;
	}
	
	public boolean getCanShoot() {
		return this.bomb==null;
	}
	
	public void nullBomb() {
		this.bomb=null;
	}
	

	public void hurt() {
		life--;
	}
	
	public boolean equalsbomb(Bomb bomb) {
		return this.bomb==bomb;
	}
	

}
