package tp.p1.logic.objects;
import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class DestroyerShip extends AlienShip implements IExecuteRandomActions{
	private static int life=1;
	private int row, column;
	//private Bomb bomb=null;
	private boolean canShootBomb;
	private static int points=10;
	
	
	public DestroyerShip(Game game, int x, int y) {
		super(game, x, y, life, points);
		this.canShootBomb=true;
		//this.row=row;
		//this.column=col;
	}
	/*
	public void move( Move dir) {//dir move
		if(dir==Move.DOWN) {this.row++;}
		else if(dir==Move.RIGHT) {this.column++;}
		else if(dir==Move.LEFT) {this.column--;}
	}*/
	
	public int getLife() {
		return life;
	}
	
	public void computerAction() {
		if(IExecuteRandomActions.canGenerateRandomBomb(game))
		this.canShootBomb = false;
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
	/*
	public Bomb shoot() {
		this.bomb= new Bomb(this.game, this.row + 1, this.column);
		//this.bomb= new Bomb(this.row+1, this.column);
		return bomb;
	}*/
	
	public void shoot() {
		this.canShootBomb=false;
	}
	
	public boolean getCanShoot() {
		return this.canShootBomb;
	}
	
	public void enableBomb() {
		this.canShootBomb=false;
	}
	

	public void hurt() {
		life--;
	}
	/*
	public boolean equalsbomb(Bomb bomb) {
		return this.bomb==bomb;
	}*/
	

}
