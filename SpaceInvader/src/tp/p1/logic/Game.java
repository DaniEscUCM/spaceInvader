package tp.p1.logic;

import tp.p1.logic.lists.BombList;
import tp.p1.logic.lists.DestroyerShipList;
import tp.p1.logic.lists.RegularShipList;

//el update inicializa con el tiempo en que se cambia y en 0 se mueve.
	//split(" ")...palabra a palabra?
	// showUsage() -> error

//update destroyer: ahi esta border y sus bombas
//los aliens ganan si han llegado a la ultima fila
//posicion inicial -> initgame
//falta la clase move 
//blah
public class Game {
	
	private BombList bombList;
	private DestroyerShipList destroyerShipList;
	private RegularShipList regularShipList;
	
	
	public void update() {
		
	}
	
	public void draw() {
		
	}
	
	
	

		public String toStringObjectAt(int i, int j) {return "vacio";}//busca en la posicion y devuelve el string
}
