package tp.p1.logic.objects;

public class RegularShip {

	private int health = 2;
	private int row;
	private int col;
	private int puntos = 5;
	private int harm = 0;//what
	private final String draw = "C";
	
	public RegularShip(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getHarm() {
		return harm;//what
	}

	public void setHarm(int harm) {
		this.harm = harm;//what
	}

	private void move(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	private void hurt() {
		health--;
	}
	
	public String toString(){
		return "C[" + health + "]";
	}
}
