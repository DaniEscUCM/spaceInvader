package tp.p1.logic.lists;

import tp.p1.logic.objects.GameObject;

public class GameObjectBoard {//ya no va a haber las otras listas, esta es la superlista

	private GameObject[] objects;//es una lista!!
	private int currentObjects;
	
	
	public GameObjectBoard (int width, int height) {//lista con objetos de tamaño de width*height; cont=0
	// TODO implement
	}
	private int getCurrentObjects () {
		return currentObjects;
	// TODO implement
	}
	
	public void add (GameObject object) {
	// TODO implement
	}
	private GameObject getObjectInPosition (int x, int y) {//usa getIndex, devuelve el objeto en esa posicion
		return null;
	// TODO implement
	}
	private int getIndex(int x, int y) {
		return y;
	// TODO implement
	}
	
	private void remove (GameObject object) {//getIndex y desplazamos a la izquierda
	// TODO implement
	}
	
	public void update() {//(1)recorre y hace move de todos,(2)check attack,(3) remove dead
	// TODO implement
	}
	
	private void checkAttacks(GameObject object) {//perfomeattack?? other recibe daño
	// TODO implement
	}
	
	public void computerAction() {//llamar computerAction de todos
	// TODO implement
	}
	
	private void removeDead() {//quita los muertos?? primero delete y llama a remove
	// TODO implement
	}
	
	public String toString(int x, int y) {//el string
		return null;
	// TODO implement
	}

}
