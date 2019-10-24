package tp.p1.logic.objects;

public class UCMShipLaser {
	
	private int row, column;
	private final int harm=1;//herencia?
	private final String draw= "oo";
	
	public UCMShipLaser(int ucmColumn) {
		row=7;
		column=ucmColumn;
	}
	
	public boolean move() {
		if(this.row==0) {
			return false;
		}
		else {
			row --;
			return true;
		}
	}
	
	public int getHarm() {
		return harm;
	}
	
	public String toString() {
		return draw;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}

}
