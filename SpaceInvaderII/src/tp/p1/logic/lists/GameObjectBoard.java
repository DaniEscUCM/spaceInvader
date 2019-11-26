package tp.p1.logic.lists;

import tp.p1.logic.objects.Bomb;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.IAttack;
import tp.p1.logic.objects.Ovni;
import tp.p1.logic.objects.UCMShip;
import tp.p1.logic.objects.UCMShipLaser;

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
		//if(getIndex(object.getX(), object.getY()) == -1){
			this.objects[this.currentObjects] = object;
			this.currentObjects++;
		//}
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
			else i++;
		}
		return ret;
	}
	
	public void remove (int i ) {//getIndex y desplazamos a la izquierda
	
		for(; i < this.currentObjects; i++) {
			this.objects[i] = this.objects[i + 1];
		}
		this.currentObjects--;
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
	
	public void checkAttacks(GameObject object) {//perfomeattack?? other recibe da�o
		//llama a perfomeAttack en la interfa iAttack sobre other y recibe el ataque. lo recibe de getDamage
		int i=0;
		while(!object.performAttack(this.objects[i])&& i<this.currentObjects-1) {
			i++;
		}
		
	}
	
	public void computerAction() {//llamar computerAction de todos
		for(int i = 0; i < this.currentObjects; i++) {
			this.objects[i].computerAction();
		}
	}
	
	public void removeDead() {//quita los muertos?? primero delete y llama a remove
		for(int i = 0; i < this.currentObjects; i++) {
			if(!this.objects[i].isAlive()) {
				this.objects[i].onDelete();
				this.remove(i);
			}
		}
		
	}
	
	public String toString(int x, int y) {//el string
		int i=this.getIndex(y, x);
		if(i!=-1) {return this.objects[i].toString();}
		return "";
	}
	/*
	public boolean shoot(GameObject laser) {
		=new UCMShipLaser(this,x,y);
	
		return false;
	}*/
	public void shockWave() {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.currentObjects; i++) {
			if(this.objects[i] instanceof UCMShip) {
				;
			}
			else {
				this.objects[i].receiveShockWaveAttack(1);
			}
		}
		this.removeDead();
	}
	
	
	
	

}
