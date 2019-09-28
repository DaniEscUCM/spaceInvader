package tp.p1.logic.objects;

public class UCMShipLaser {
	private int fila, columna;
	private final int harm=1;
	private final String dibujo= "oo";
	
	public void move() {
		fila--;
	}
	
	public int getHarm() {
		return harm;
	}
	
	public void inipos(int x, int y) {
		fila=x;
		columna=y-1;
	}
	
	public String toStringLaser() {
		return dibujo;
	}
	
}
