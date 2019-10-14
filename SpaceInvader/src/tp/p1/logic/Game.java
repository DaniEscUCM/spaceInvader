package tp.p1.logic;

import java.util.Random;

import tp.p1.control.Command;
import tp.p1.logic.lists.BombList;
import tp.p1.logic.lists.DestroyerShipList;
import tp.p1.logic.lists.RegularShipList;
import tp.p1.logic.objects.Ovni;
import tp.p1.logic.objects.UCMShip;
//import tp.p1.logic.objects.UCMShipLaser;

//el update inicializa con el tiempo en que se cambia y en 0 se mueve.
	//split(" ")...palabra a palabra?
	// showUsage() -> error


public class Game {
	
	private BombList bombList;
	private DestroyerShipList destroyerShipList;
	private RegularShipList regularShipList;
	private UCMShip ucmShip;
	private Ovni ovni;
	
	private Level level;
	private Random rand;
	private GamePrinter gamePrinter;
	
	private int cycles=0;
	private int points=0;
	private int remainingAliens;
	private boolean shockWave=false;
	private int row = 8;
	private int col = 9;
	private boolean finish=false;
	private int wins;//0 nadie gana,1 gana player y 2 gana aliens
	
	
	public Game(Level level, Random rand) {
		this.level = level;
		this.rand = rand;
		this.initGame();
		
	}

	public void initGame() {
		int n;
		this.ovni=null;
		this.ucmShip=new UCMShip();
		n=level.getNumDestroyers();
		this.destroyerShipList = new DestroyerShipList(n,level); // seria pasarle tmbn row*col
		n=level.getNumRegular();
		this.regularShipList = new RegularShipList(n);
		this.bombList = new BombList(level.getNumDestroyers());
		this.remainingAliens = destroyerShipList.getCount() + regularShipList.getCount();
		this.gamePrinter = new GamePrinter(this, row, col);// no estoy segura de esto
	}
	
	public void update() {
		int auxn;
		boolean auxb;		
		enemyMoves();//mueve naves	
		if (!this.ucmShip.getCanShoot()) {
			auxb=this.Laserhits(this.ucmShip.laser.getRow(),this.ucmShip.laser.getColumn());
			if(!auxb) {
				this.ucmShip.laser.move();
				this.Laserhits(this.ucmShip.laser.getRow(),this.ucmShip.laser.getColumn());			
			}
		}		
		if (this.bombList.getCount()!=0) {//para cada movimiento se verifica antes y despues si hay dano
			auxn=this.bombList.find(this.ucmShip.getRow(), this.ucmShip.getColumn());
			if(auxn!=-1) {
				this.ucmShip.hurt();
				this.bombList.delete(auxn);
			}
			this.bombList.move();
			auxn=this.bombList.find(this.ucmShip.getRow(), this.ucmShip.getColumn());
			if(auxn!=-1) {
				this.ucmShip.hurt();
				this.bombList.delete(auxn);
			}
		}
		if (this.ovni!=null) {//si esta el alien lo mueve, si llega al final lo elimina
			this.ovni.move();
			if(this.ovni.getColumn()<0) {
				ovni=null;
			}
		}		
		
		this.remainingAliens = destroyerShipList.getCount() + regularShipList.getCount();//final del juego
		if(this.remainingAliens==0) {finish=true;wins=1;}//jugador gana
		else if (this.ucmShip.getHealth()==0 || this.aliensWins()){//jugador pierde
			finish =true;
			wins=2;
			this.ucmShip.setDraw("!xx!");
			}
		else {//continua
			this.cycles++;
			computerAction();//ve si dispara y si sale ovni}
		}
		
	}
	
	private boolean Laserhits(int lrow, int lcol) {
		boolean resul=false;
		if(this.ucmShip.laser.getRow()<0) {
			this.ucmShip.laser=null;
			resul=true;
		}
		else if(this.destroyerShipList.destroyerhit(lrow,lcol)) {
			this.points+=this.destroyerShipList.getPoints();
			this.ucmShip.laser=null;
			resul=true;
		}
		else if (this.regularShipList.regularHit(lrow,lcol)) {
			this.points+=this.regularShipList.getPoints();
			this.ucmShip.laser=null;
			resul=true;
		}
		else if(this.ovni!=null&this.ovni.hurt(lrow,lcol)) {
			this.points+=this.ovni.getPoint();
			this.ucmShip.laser=null;
			resul=true;
		}

		return resul;
	}
	
	private boolean aliensWins() {
		boolean resul=false;
		int i=0,aux1=-1, aux2=-1;
		if (this.destroyerShipList.getCount()!=0) {
			while(resul & i<this.col) {
				if(this.destroyerShipList.getNumDestroyer()!=0) {
					aux1=this.destroyerShipList.search(7,i);
				}
				if(this.regularShipList.getCount()!=0) {
					aux2=this.regularShipList.find(7, i);
				}
				resul=(aux1!=-1)||(aux2!=-1);
			}
		}	
		return resul;
	}

	
	public String toStringObjectAt(int i, int j) {
		int pos=-1;
		String draw=" ";
		
		if(this.destroyerShipList.search(i, j)!=-1) {draw=this.destroyerShipList.toString(this.destroyerShipList.search(i, j));}
		else if(this.bombList.find(i, j)!=-1){draw=this.bombList.toString(this.bombList.find(i, j));}
		else if(this.regularShipList.find(i, j)!=-1) {draw=this.regularShipList.toString(this.regularShipList.find(i, j));}
		else if(this.ucmShip.getRow()==i && this.ucmShip.getColumn()==j) {draw=this.ucmShip.toString();}
		else if(!this.ucmShip.getCanShoot() && (this.ucmShip.laser.getRow()==i && this.ucmShip.laser.getColumn()==j)) {draw=this.ucmShip.laser.toStringLaser();}
		else if(this.ovni!=null && this.ovni.getRow()==i & this.ovni.getColumn()==j) {draw=this.ovni.toString();}
				
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

	public void commands(Command cm, Move move, int i) {
		// Metodo que llama a funciones de game segun el comando; 
		if(cm == Command.MOVE) {
			this.ucmShip.move_UCMship(i, move);// aqui suo
		}
		else if(cm == Command.EXIT) {
			this.finish = true; this.wins = 0;
		}
		else if(cm == Command.HELP) {
			//this.showHelp();
		}
		else if(cm == Command.LIST) {
			//this.showList();
		}
		else if(cm == Command.NONE) {
			// ciclos++?? creo que no hace falta, se pasa directo al update
		}
		else if(cm == Command.RESET) {
			this.initGame();
		}
		else if(cm == Command.SHOCKWAVE) {}
		
	}
	
	private void enemyMoves() {
		if(this.cycles!=0 && this.level.getSpeed()%this.cycles==0) {
			if(this.destroyerShipList.isBorder()|this.regularShipList.isBorder()) {
				this.destroyerShipList.move(Move.DOWN);
				this.regularShipList.move(Move.DOWN);
			}
			else if (this.cycles%2==0) {
				this.destroyerShipList.move(Move.RIGHT);
				this.regularShipList.move(Move.RIGHT);
			}
			else {
				this.destroyerShipList.move(Move.LEFT);
				this.regularShipList.move(Move.LEFT);
			}
		}
	}
	
	public void computerAction() {
		
		double ayuda=this.rand.nextDouble();
		if(this.ovni==null & this.level.getOvniProb()<ayuda) {
			this.ovni= new Ovni();
		}
		aliensShoots();
	}
	
	private void aliensShoots() {
		double num;
		for(int i=0;i<this.destroyerShipList.getCount();i++) {
			num=this.rand.nextDouble();
			if (num<this.level.getFrecShoot() & this.destroyerShipList.search(this.destroyerShipList.getRow(i)+1, this.destroyerShipList.getColumn(i))==-1) {
				this.bombList.insert(this.destroyerShipList.getRow(i),this.destroyerShipList.getColumn(i));
			}//se inicializa la bomba en la posicion de su nave, en update se mueve fuera de la nave
		}
	}
	
	public String toString() {
		String draw="Life: "+this.ucmShip.getHealth()+"\n";
		draw+="Number of cycles: "+this.cycles+"\n";
		draw+="Points: "+this.points+"\n";
		draw+="Remaining aliens: "+this.remainingAliens+"\n";
		draw+="ShockWave: ";
		if (shockWave) {draw+="SI\n";}
		else draw+="NO\n";
		/*	Life:
		 	Number of cycles: 
			Points: 
			Remaining aliens: 
			shockWave:
		  */
		this.gamePrinter=new GamePrinter(this, this.row, this.col);
		draw+=this.gamePrinter.toString();
		return draw;
	}
	
	public int getPoints() {
		return points;
	}
}