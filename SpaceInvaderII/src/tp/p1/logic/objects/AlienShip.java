package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class AlienShip extends EnemyShip{
	
	protected static int REMAINING_ALIENS = 0;
	private static boolean IS_IN_FINAL_ROW;
	private static int SHIPS_ON_BORDER;
	protected int cyclesToMove;

	public AlienShip(Game game, int x, int y, int life) {
		super(game, x, y, life);
		REMAINING_ALIENS ++;
		SHIPS_ON_BORDER = 0;
		//cycleToMove se inicializa con el numero ciclos(segun level) en el que se mueve, en move decrece
	}

	public static String getRemainingAliens() {
		return null;
	}

	public static boolean haveLanded() {//hacen falta en main
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean allDead() {//hacen falta en main
		// TODO Auto-generated method stub
		return false;
	}
	
	public void move() {//no sobre escribe si se quita ship
		/*
		  	Si (cyclesToMove == 0)
				Actualizar cyclesToMove
				Hacer el movimiento a la izquierda o a la derecha
				Actualizar IS_IN_FINAL_ROW
				Si está en el borde, SHIPS_ON_BORDER = REMAINING_ALIENS
			Sino si (SHIPS_ON_BORDER > 0) y !IS_IN_FINAL_ROW
				Aumentar la fila
				Cambiar el sentido del movimiento
				SHIPS_ON_BORDER -= 1
			Sino cyclesToMove--
		 */
	}

}
