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
	private boolean finish=false;
	private int wins;//0 nadie gana,1 gana player y 2 gana aliens
	
	
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
		int aux1,aux2,aux3;
		if (!this.ucmShip.getCanShoot()) {
			this.ucmShip.laser.move();
			aux1=this.ucmShip.laser.getRow();
			aux2=this.ucmShip.laser.getColumn();			
			if(this.ucmShip.laser.getRow()<0|(this.destroyerShipList.destroyerhit(aux1,aux2))|(this.regularShipList.regularHit(aux1,aux2))) {
				this.ucmShip.laser=null;
			}	
		}		
		if (this.bombList.getCount()!=0) {
			this.bombList.move();
			aux3=this.bombList.find(this.ucmShip.getRow(), this.ucmShip.getColumn());
			if(aux3!=-1) {
				this.ucmShip.hurt();
				this.bombList.delete(aux3);
			}
		}
		
		//commandComputer()->mueve las naves alienigenas si hace falta
		
		this.remainingAliens = destroyerShipList.getCount() + regularShipList.getCount();//final del juego
		if(this.remainingAliens==0) {finish=true;wins=1;}//jugador gana
		else if (this.ucmShip.getHealth()==0 | this.aliensWins()){
			finish =true;
			wins=2;
			this.ucmShip.setDraw("!xx!");
			}//jugador pierde, hacer metodo para ver si esta en borde
		else {this.cycles++;}//continua
		
	}
	
	public boolean aliensWins() {
		boolean resul=true;
		int i=0,aux;
		if (this.destroyerShipList.getCount()!=0) {
			while(resul & i<(this.destroyerShipList.getCount())) {
				aux=this.destroyerShipList.search(7,i);
				resul=aux!=-1;
			}
		}
			
		if(this.regularShipList.getCount()!=0 & resul) {
			while(resul & i<this.destroyerShipList.getCount()){
				aux=this.regularShipList.find(7, i);
				resul=aux!=-1;
			}
		}		
		return resul;
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
	
	public boolean getFinish() {
		return this.finish;
	}
	
	public int getWins() {
		return this.wins;
	}
	
	public void setFinish(boolean in) {
		this.finish=in;
	}
}