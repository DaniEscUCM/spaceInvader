package tp.p1.logic.objects;

public class UCMShip {
		private int vida=3;
		private int columna;
		private boolean puede_disparar=true;
		private final String dibujo= "^__^";
		private final int fila=7;//nunca se mueve de la ultima fila

		public void move_UCMship (int steps, String direction) {//ver direccion, tal vez enumerado
			if (direction == "righ" | direction=="r") {
				columna+=steps;
			}
			else columna-=steps;
		}
		
		public void shoot () {
			puede_disparar=false;
		}
		
		public void hurt() {
			vida--;
		}
		
		public int getVida() {
			return vida;
		}
		
		public String toStringUCM() {
			return dibujo;
		}
}