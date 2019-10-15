package tp.p1.logic.objects;

import tp.p1.logic.Move;

public class UCMShip {
		private int health=3;
		private int column=4;
		private String draw= "^__^";
		private final int row=7;//nunca se mueve de la ultima fila
		public UCMShipLaser laser=null;//no se si va aqui, ni si es publico<--preguntar, quiero quitarlo de aqui, revisar el martes

		public void move_UCMship (int steps, Move direction) {//ver direccion, tal vez enumerado
			if (direction == Move.RIGHT) {
				column+=steps;
			}
			else {column-=steps;}
		}
		public boolean getCanShoot() {
			return this.laser==null;
		}
		
		public void shoot() {//si puede disparar, dispara
			if(this.getCanShoot()) {
				this.laser= new UCMShipLaser(this.column);
			}
		}
		
		public void laserDestroyed() {
			this.laser=null;
		}
		
		public void hurt() {
			health--;
		}
		
		public int getHealth() {
			return health;
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
		
		public void setDraw(String newD) {
			this.draw=newD;
		}
}