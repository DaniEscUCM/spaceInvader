package tp.p1.logic;

import tp.p1.logic.lists.BombList;
import tp.p1.logic.lists.DestroyerShipList;
import tp.p1.logic.lists.RegularShipList;
import tp.p1.logic.objects.Ovni;
import tp.p1.logic.objects.UCMShip;
import tp.p1.logic.objects.UCMShipLaser;

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
	private UCMShip ucmShip;
	private UCMShipLaser ucmLaser;
	private Ovni ovni;
	
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
	public String toStringObjectAt(int i, int j) {
		int pos=-1;
		String draw=" ";
		
		if(this.destroyerShipList.search(i, j)!=pos) {draw=this.destroyerShipList.toString();}
		else if(this.bombList.find(i, j)!=pos){draw=this.bombList.toString();}
		else if(this.regularShipList.find(i, j)!=pos) {draw=this.regularShipList.toString();}
		else if(this.ucmShip.getRow()==i & this.ucmShip.getColumn()==j) {draw=this.ucmShip.toString();}//tal vez crear metodo para que compare directamente con las posiciones
		else if(this.ucmLaser!=null & this.ucmLaser.getRow()==i & this.ucmLaser.getColumn()==j) {draw=this.ucmLaser.toStringLaser();}
		else if(this.ovni!=null & this.ovni.getRow()==i & this.ovni.getColumn()==j) {draw=this.ovni.toString();}
					
		return draw;
		}//busca en la posicion y devuelve el string
}
