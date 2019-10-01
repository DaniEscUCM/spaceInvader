package tp.p1.logic.objects;

import tp.p1.logic.Move;

public class UCMShip {
		private int health=3;
		private int column;
		private boolean canShoot=true;
		private final String draw= "^__^";
		private final int row=7;//nunca se mueve de la ultima fila

		public void move_UCMship (int steps, Move direction) {//ver direccion, tal vez enumerado
			if (direction == Move.RIGHT) {
				column+=steps;
			}
			else column-=steps;
		}
		
		public void shoot () {
			canShoot=false;
		}
		
		public void hurt() {
			health--;
		}
		
		public int getHealth() {
			return health;
		}
		
		public String toStringUCM() {
			return draw;
		}
}