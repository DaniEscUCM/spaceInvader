package tp.p1.logic.objects;

public class Ovni {
	
	private final int fila = 0;
	private int columna=8;
	int life = 1;
	int puntos = 25;
	private final String draw = "O";
	
	public void move () {
		columna --;
	}
	
	public void hurt() {
		life--;
	}
	
	public String toString() {
		return draw + "["+ life + "]"; 
	}
	public int getLife() {
		return life;
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
