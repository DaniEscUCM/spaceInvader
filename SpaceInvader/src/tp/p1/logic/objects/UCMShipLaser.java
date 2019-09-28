package tp.p1.logic.objects;

public class UCMShipLaser {
	private int row, column;
	private final int harm=1;
	private final String draw= "oo";
	
	public void move() {
		row--;
	}
	
	public int getHarm() {
		return harm;
	}
	
	public void inipos(int ucmRow, int ucmColumn) {
		row=ucmRow;
		column=ucmColumn-1;
	}
	
	public String toStringLaser() {
		return draw;
	}
	
}
