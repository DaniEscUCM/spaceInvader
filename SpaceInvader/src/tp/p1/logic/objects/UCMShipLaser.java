package tp.p1.logic.objects;

public class UCMShipLaser {
	private int row, column;
	private final int harm=1;
	private final String draw= "oo";
	
	public UCMShipLaser(int ucmColumn) {
		row=6;
		column=ucmColumn;
	}
	
	public boolean move() {
		if(row > 0) {
			row--; return true;
		}
		else return false;
	}
	
	public int getHarm() {
		return harm;
	}
	
	public String toStringLaser() {
		return draw;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	
}
