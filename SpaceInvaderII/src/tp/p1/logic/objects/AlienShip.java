package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class AlienShip extends EnemyShip{
	
	protected static int REMAINING_ALIENS = -2;
	private static boolean IS_IN_FINAL_ROW;
	private static int SHIPS_ON_BORDER;
	protected int cyclesToMove;
	private Move dir;

	public AlienShip(Game game, int x, int y, int life, int points) {
		super(game, x, y, life, points);
		REMAINING_ALIENS ++;
		SHIPS_ON_BORDER = 0;
		this.dir=Move.LEFT;
		if (game !=null) {
			cyclesToMove=game.getLevel().getNumCyclesToMoveOneCell();
		}
		//cycleToMove se inicializa con el numero ciclos(segun level) en el que se mueve, en move decrece
	}

	public static int getRemainingAliens() {
		return REMAINING_ALIENS;
	}

	public static boolean haveLanded() {//hacen falta en main
	
		return IS_IN_FINAL_ROW;
	}

	public static boolean allDead() {//hacen falta en main
		// TODO Auto-generated method stub
		return false;
	}
	
	public void move() {//no sobre escribe si se quita ship
		if(cyclesToMove==0) {
			cyclesToMove=game.getLevel().getNumCyclesToMoveOneCell();			
			if(dir==Move.RIGHT) {this.y++;}
			else if(dir==Move.LEFT) {this.y--;}	
			this.border();						
		}
		else if(SHIPS_ON_BORDER>0) { //&& !IS_IN_FINAL_ROW
				this.x++;
				if(dir==Move.RIGHT) {dir=Move.LEFT;}
				else if(dir==Move.LEFT) {dir=Move.RIGHT;}
				SHIPS_ON_BORDER --;
				if(!IS_IN_FINAL_ROW && x==game.DIM_Y-1) {
					IS_IN_FINAL_ROW=true;
					}
					
			}
		else cyclesToMove--;
		/*
		  	Si (cyclesToMove == 0)
				Actualizar cyclesToMove
				Hacer el movimiento a la izquierda o a la derecha
				Actualizar IS_IN_FINAL_ROW
				Si est� en el borde, SHIPS_ON_BORDER = REMAINING_ALIENS
			Sino si (SHIPS_ON_BORDER > 0) y !IS_IN_FINAL_ROW
				Aumentar la fila
				Cambiar el sentido del movimiento
				SHIPS_ON_BORDER -= 1
			Sino cyclesToMove--
		 */
	}
	
	public void border() {
		if((dir==Move.LEFT && y==0)||(dir==Move.RIGHT && y==game.DIM_X-1)) {
			SHIPS_ON_BORDER=REMAINING_ALIENS;
		}
	}

}
