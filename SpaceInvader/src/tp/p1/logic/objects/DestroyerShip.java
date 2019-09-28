package tp.p1.logic.objects;

public class DestroyerShip {
	private int health=1;
	private int row, column;//creo que cicle ya no hará falta, iria en move?
	private final int points=10;
	
	public void destroyerDeath() {
		health--;
	}
	public void iniRowColum(int fil, int colum) {
		row=fil;
		column=colum;
	}
	
	public void destroyermove(boolean border, int dir) {//dir move
		if(border) {row++;}
		else column+=dir;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getPoints() {
		return points;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	
	public String toStringDestructor() {
		return "D["+health+"]";
	}
	
}
