package tp.p1.logic.objects;

public class Ovni {
	
	private final int fila = 0;
	private int columna;
	int health = 1;
	int puntos = 10;
	private int harm = 0;
	private final String draw = "O";
	
	private void move (int steps) {
		columna += steps;
	}
	
	private void hurt() {
		health--;
	}
	
	private boolean shockWave() {
		if(health == 0)
			return true;
		else return false;
	}
	
	public String toString() {
		return draw + "["+ health + "]"; 
	}
	public int getRow() {
		return fila;
	}
	public int getColumn() {
		return columna;
	}
}
