package tp.p1.logic.objects;

import tp.p1.logic.Move;

public class UCMShip {
		private int life=3;
		private int column=4;
		private String draw= "^__^";
		private final int row=7;//nunca se mueve de la ultima fila

		public boolean move_UCMship (int steps, Move direction) {//ver direccion, tal vez enumerado
			boolean ret = true;
			if (direction == Move.RIGHT && ((column + steps) < 8)) {
				column+=steps;
			}
			else if (direction == Move.RIGHT && ((column + steps) >= 8)) {
				column = 8; 
			}
			else if (direction == Move.LEFT && ((column - steps) >= 0)) {
				column-=steps;
			}
			else if (direction == Move.LEFT && ((column - steps) < 0)) {
				column = 0; 
			}
			else ret = false;
			return ret;
		}
		/*
		public void shoot() {//si puede disparar, dispara
			if(this.getCanShoot()) {
				this.laser= new UCMShipLaser(this.column);
			}
		}*/
		
		public void hurt() {
			life--;
		}
		
		public int getLife() {
			return life;
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