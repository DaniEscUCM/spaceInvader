package tp.p1.logic;

import java.util.Random;

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
	private Ovni ovni;
	
	private Level level;
	private Random rand;
	
	private int cycles=0;
	private int points=0;
	private int remainingAliens;
	private int row = 8;
	private int col = 9;
	
	
	public Game(Level level, Random rand) {
		// TODO Auto-generated constructor stub
		this.level = level;
		this.rand = rand;
	}

	public void initGame(Level level) {
		int n;
		this.ucmShip=new UCMShip();
		n=level.getNumDestroyers();
		this.destroyerShipList = new DestroyerShipList(n,level); // seria pasarle tmbn row*col
		n=level.getNumRegular();
		this.regularShipList = new RegularShipList(n);
		double f=level.getFrecShoot();
		this.bombList = new BombList(f,level.getNumDestroyers());//el nivel da la frecuencia de disparo
		this.remainingAliens = destroyerShipList.getCount() + regularShipList.getCount();
	}
	
	public void update() {
		if (!this.ucmShip.getCanShoot()) {this.ucmShip.laser.move();}
		if (this.bombList.getCount()!=0) {this.bombList.move();}
		
		this.remainingAliens = destroyerShipList.getCount() + regularShipList.getCount();//final del juego
		if(this.remainingAliens==0) {}//jugador gana
		else if (this.ucmShip.getHealth()==0){}//jugador pierde
		else {this.cycles++;}
		
	}
	public void commands() {//lo hago en el laboratorio
		String comman;
		
		
	}
	
	public String toStringObjectAt(int i, int j) {
		int pos=-1;
		String draw=" ";
		
		if(this.destroyerShipList.search(i, j)!=pos) {draw=this.destroyerShipList.toString();}
		else if(this.bombList.find(i, j)!=pos){draw=this.bombList.toString();}
		else if(this.regularShipList.find(i, j)!=pos) {draw=this.regularShipList.toString();}
		else if(this.ucmShip.getRow()==i & this.ucmShip.getColumn()==j) {draw=this.ucmShip.toString();}//tal vez crear metodo para que compare directamente con las posiciones
		else if(!this.ucmShip.getCanShoot() & (this.ucmShip.laser.getRow()==i & this.ucmShip.laser.getColumn()==j)) {draw=this.ucmShip.laser.toStringLaser();}
		else if(this.ovni!=null & this.ovni.getRow()==i & this.ovni.getColumn()==j) {draw=this.ovni.toString();}
					
		return draw;
		}//busca en la posicion y devuelve el string
}