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
	private int cycles;
	private int points;
	private int remainingAliens;
	private int row = 8;
	private int col = 9;
	
	
	public void initGame() {
		this.cycles = 1;
		this.points = 0;
		this.destroyerShipList = new DestroyerShipList(); // seria pasarle tmbn row*col
		this.regularShipList = new RegularShipList(row*col);
		this.bombList = new BombList(row*col);
		this.remainingAliens = destroyerShipList.getCount() + regularShipList.getCount();
	}
	
	public void update() {
		
	}
	
	
	
	

		public String toStringObjectAt(int i, int j) {return "vacio";}//busca en la posicion y devuelve el string
}
