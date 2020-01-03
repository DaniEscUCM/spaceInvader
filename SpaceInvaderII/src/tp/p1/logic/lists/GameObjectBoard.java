package tp.p1.logic.lists;

import tp.p1.logic.objects.ExplosivShip;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.UCMShip;

public class GameObjectBoard {//es la superlista

	private GameObject[] objects;//una lista
	private int currentObjects;
	
	
	public GameObjectBoard (int width, int height) {//lista con objetos de tamano de width*height; cont=0
		this.objects= new GameObject[width*height];
		this.currentObjects = 0;
	}
	
	@SuppressWarnings("unused")
	private int getCurrentObjects () {
		return currentObjects;
	}
	
	public void add (GameObject object) { //se puede insertar en la misma posicion
		this.objects[this.currentObjects] = object;
		this.currentObjects++;
	}
	
	private GameObject getObjectInPosition (int x, int y) {//usa getIndex, devuelve el objeto en esa posicion
		int index = getIndex(x, y);
		if(index > -1) {
			return this.objects[index];
		}
		else return null;
	}
	
	private int getIndex(int x, int y) { // busca con posicion en tablero y devuelve el indice en la lista
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
	
	private void remove (int i ) {//getIndex y desplazamos a la izquierda
		for(; i < this.currentObjects; i++) {
			this.objects[i] = this.objects[i + 1];
		}
		this.currentObjects--;
	}
		
	
	public void update() {//(1)recorre y hace move de todos los objetos,(2)check attack,(3) remove dead
		for (int i = 0; i < this.currentObjects; i++) {
			this.objects[i].move();
			this.checkAttacks(this.objects[i]);
		}
		this.removeDead();
	}
	
	private void checkAttacks(GameObject object) {//perfomeattack other recibe dano
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
	
	private void removeDead() {//quita los muertos primero delete y llama a remove
		boolean hecho=false;
		int i=0;
		while(i < this.currentObjects) {
			if(!this.objects[i].isAlive() && ! (this.objects[i] instanceof UCMShip)) {
				this.objects[i].onDelete();
				this.remove(i);
				hecho=true;
			}
			else {i++;}
		}
		if(hecho) {removeDead();}//si se ha elimanado muertos se vuelve a revisar por si ha habido algun explosive
		
	}
	
	public String toString(int x, int y) {//el string
		int i=this.getIndex(y, x);
		if(i!=-1) {return this.objects[i].toString();}
		return "";
	}
	
	public void shockWave() {
		for(int i = 0; i < this.currentObjects; i++) {
			if(! (this.objects[i] instanceof UCMShip)) {
				this.objects[i].receiveShockWaveAttack(1);
			}
		}
		this.removeDead();
	}
	
	
	public void removeObject(GameObject object) {
		int i = this.getIndex(object.getX(), object.getY());
		this.remove(i);
	}
	public String stringify() {
		String s = "";
		for(int i = 0; i < this.currentObjects; i++)
			s+= this.objects[i].stringify() + "\n";
		return s;
	}
	
	public void explosiveDeath(int x, int y) {//hace daño a todos los que esten al rededor del explosive muerto
		ExplosivShip ex=(ExplosivShip) getObjectInPosition(x, y);
		for(int j=y-1;j<=y+1;j++) {
			for(int i=x-1;i<=x+1;i++) {
				GameObject ob=getObjectInPosition(i, j);
				if(ob!=null && !ob.isOnPosition(x, y)) {
					ex.performAttack(ob);
				}
			}
		}
	}
	
	

}
