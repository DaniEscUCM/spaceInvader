package tp.p1.logic.lists;

import tp.p1.logic.objects.GameObject;

public class GameObjectBoard {//ya no va a haber las otras listas, esta es la superlista

	private GameObject[] objects;//es una lista!!
	private int currentObjects;
	
	
	public GameObjectBoard (int width, int height) {//lista con objetos de tama�o de width*height; cont=0
	
		this.objects= new GameObject[width*height];
		this.currentObjects = 0;
	}
	private int getCurrentObjects () {
		return currentObjects;
	}
	
	public void add (GameObject object) { // inserta si ese objeto no esta en la lista
		if(getIndex(object.getX(), object.getY()) == -1){
			this.objects[this.currentObjects] = object;
			this.currentObjects++;
		}
	// TODO implement
	}
	private GameObject getObjectInPosition (int x, int y) {//usa getIndex, devuelve el objeto en esa posicion
		int index = getIndex(x, y);
		if(index > -1) {
			return this.objects[index];
		}
		else return null;
	}
	private int getIndex(int x, int y) { // busca y devuelve el indice
		int ret = -1;
		int i = 0; 
		boolean found = false;
		while(!found && i < this.currentObjects) {
			if(this.objects[i].getX() == x && this.objects[i].getY() == y) {
				found = true;
				ret = i;
			}
			i++;
		}
		return ret;
	}
	
	private void remove (GameObject object) {//getIndex y desplazamos a la izquierda
	
		int index = getIndex(object.getX(), object.getY());
		if(index > -1) {
			for(int i = index; i < this.currentObjects; i++) {
				this.objects[i] = this.objects[i + 1];
			}
			this.currentObjects--;
		}
	}
		
	
	public void update() {//(1)recorre y hace move de todos los objetos,(2)check attack,(3) remove dead
		//objects[i].move();
		//checkAttack();
		for (int i = 0; i < this.currentObjects; i++) {
			this.objects[i].move();
			this.checkAttacks(this.objects[i]);
		}
		this.removeDead();
	}
	
	private void checkAttacks(GameObject object) {//perfomeattack?? other recibe da�o
		//llama a perfomeAttack en la interfa iAttack sobre other y recibe el ataque. lo recibe de getDamage
		for(int i = 0; i < this.currentObjects; i++) {
			if(this.objects[i].getX() == object.getX() &&
					this.objects[i].getY() == object.getY()){
				
			}
		}
	}
	
	public void computerAction() {//llamar computerAction de todos
		for(int i = 0; i < this.currentObjects; i++) {
			this.objects[i].computerAction();
		}
	}
	
	private void removeDead() {//quita los muertos?? primero delete y llama a remove
		for(int i = 0; i < this.currentObjects; i++) {
			if(this.objects[i].getLive() == 0) {
				this.objects[i].onDelete();
				this.remove(this.objects[i]);
			}
		}
		
	}
	
	public String toString(int x, int y) {//el string
		int i=this.getIndex(x, y);
		if(i!=-1) {return this.objects[i].toString();}
		return "";
	}
	

}
