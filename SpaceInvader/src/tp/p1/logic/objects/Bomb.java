package tp.p1.logic.objects;

public class Bomb {
	private int fila;
	private int columna;
	private int harm = 1;
	
	private void move(int fila, int col) {
		this.fila = fila;
		this.columna = col;
	}
}
