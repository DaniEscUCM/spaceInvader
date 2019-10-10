package tp.p1.logic.objects;

public class Ovni {
	
	private final int fila = 0;
	private int columna=8;
	int health = 1;
	int puntos = 25;
	private final String draw = "O";
	
	public void move () {
		columna --;
	}
	
	public boolean hurt(int row,int col) {
		boolean resul=false;
		if(row==fila & col==columna) {
			health--;
		}
		return resul;
	}
	
	public boolean shockWave() {//tal vez en otro lado??
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
	
	public int getPoint() {
		return this.puntos;
	}
}
