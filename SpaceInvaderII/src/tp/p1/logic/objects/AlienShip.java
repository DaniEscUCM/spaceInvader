package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class AlienShip extends EnemyShip{
	
	protected static int REMAINING_ALIENS ;
	

	private static boolean IS_IN_FINAL_ROW;
	protected static int SHIPS_ON_BORDER;
	
	protected int cyclesToMove;
	protected Move dir;

	public AlienShip(Game game, int x, int y, int life, int points) {
		super(game, x, y, life, points);
		REMAINING_ALIENS ++;	
		SHIPS_ON_BORDER = 0;
		this.dir=Move.LEFT;
		if (game !=null) {
			cyclesToMove=game.getLevel().getNumCyclesToMoveOneCell();
	
		}
	}
	
	public static void setREMAINING_ALIENS() {
		REMAINING_ALIENS --;
	}

	public static void setREMAINING_ALIENS(int n) {
		REMAINING_ALIENS = n;
	}

	public int getcyclesToMove() {
		return this.cyclesToMove;
	}
	
	public static int getRemainingAliens() {
		return REMAINING_ALIENS;
	}

	public static boolean haveLanded() {
		return IS_IN_FINAL_ROW;
	}

	public static boolean allDead() {
		return REMAINING_ALIENS==0;
	}
	
	@SuppressWarnings("static-access")
	public void move() {
		if(cyclesToMove==0) {
			cyclesToMove=game.getLevel().getNumCyclesToMoveOneCell();			
			if(dir==Move.RIGHT) {this.x++;}
			else if(dir==Move.LEFT) {this.x--;}	
			this.border();						
		}
		else if(SHIPS_ON_BORDER>0) {
				this.y++;
				if(dir==Move.RIGHT) {dir=Move.LEFT;}
				else if(dir==Move.LEFT) {dir=Move.RIGHT;}
				SHIPS_ON_BORDER --;
				if(!IS_IN_FINAL_ROW && y==game.DIM_Y-1) {
					IS_IN_FINAL_ROW=true;
				}					
			}
		else cyclesToMove--;
	}
	
	@SuppressWarnings("static-access")
	public void border() {
		if((dir==Move.LEFT && x==0)||(dir==Move.RIGHT && x==game.DIM_X-1)) {
			SHIPS_ON_BORDER=REMAINING_ALIENS;
		}
	}
	
	public static int getSHIPS_ON_BORDER() {
		return SHIPS_ON_BORDER;
	}

	public static void setSHIPS_ON_BORDER() {
		SHIPS_ON_BORDER --;
	}
	
	public boolean receiveBombAttack(int damage) {return false;};

	
}
