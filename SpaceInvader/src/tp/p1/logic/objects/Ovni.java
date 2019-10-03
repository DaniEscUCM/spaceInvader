package tp.p1.logic.objects;

public class Ovni {
	
	private final int fila = 0;
	private int columna=8;
	int health = 1;
	int puntos = 25;
	private final String draw = "O";
	
	private void move () {
		columna --;
	}
	
	private void hurt() {
		health--;
	}
	
	private boolean shockWave() {//tal vez en otro lado??
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
