package tp.p1.logic.objects;

public class Ovni {
	
	private final int fila = 0;
	private int columna;
	int vida = 1;
	int puntos = 10;
	private int harm = 0;
	
	private void move (int steps) {
		columna += steps;
	}
	
	private void hurt() {
		vida--;
	}
	
	private boolean shockWave() {
		if(vida == 0)
			return true;
		else return false;
	}
	
	
}
