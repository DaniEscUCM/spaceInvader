package tp.p1.logic;

import java.util.Random;

import tp.p1.control.Command;
import tp.p1.logic.lists.BombList;
import tp.p1.logic.lists.DestroyerShipList;
import tp.p1.logic.lists.RegularShipList;
import tp.p1.logic.objects.Ovni;
import tp.p1.logic.objects.UCMShip;
import tp.p1.logic.objects.UCMShipLaser;

//el update inicializa con el tiempo en que se cambia y en 0 se mueve.
	//split(" ")...palabra a palabra?
	// showUsage() -> error


public class Game {
	
	private BombList bombList;
	private DestroyerShipList destroyerShipList;
	private RegularShipList regularShipList;
	private UCMShip ucmShip;
	private Ovni ovni;
	private UCMShipLaser laser;
	
	private Level level;
	private Random rand;
	private GamePrinter gamePrinter;
	
	private int cycles;
	private int points;
	private int remainingAliens;
	private boolean shockWave=false;
	private int row = 8;
	private int col = 9;
	private boolean finish=false;
	private int wins;//0 nadie gana,1 gana player y 2 gana aliens
	private boolean right = false;
	
	
	public Game(Level level, Random rand) {
		this.level = level;
		this.rand = rand;
		this.initGame();
		
	}

	public void initGame() {
		int n;
		this.cycles = 0;
		this.points = 0;
		this.shockWave = false;
		this.right = false;
		this.ovni=null;
		this.ucmShip=new UCMShip();
		this.laser = null;
		n=level.getNumDestroyers();
		this.destroyerShipList = new DestroyerShipList(n,level); // seria pasarle tmbn row*col
		n=level.getNumRegular();
		this.regularShipList = new RegularShipList(n);
		this.bombList = new BombList(level.getNumDestroyers());
		this.remainingAliens = destroyerShipList.getCount() + regularShipList.getCount();
		this.gamePrinter = new GamePrinter(this, row, col);// no estoy segura de esto
	}
	
	public void update() {
		this.cycles++;
		enemyMoves();
		 // 1. ovni
		if(this.ovni!= null && !this.ovni.move())
			this.ovni = null;
		// 1. avanza proyectil
		/*
		if(this.laser!= null && this.laser.move() == true) {
			// 1.1 si alcanza un alien decrementa su vida. comprobar destroyershiplist, regularshiplist y ovni si alcanza bomba
			// elimina bomba y laser
			if(ovni.getColumn()== laser.getColumn() && ovni.getRow() == laser.getRow()) {
				ovni.hurt(); this.laser = null;
			}// destruye dentro de cada lista si le llega el laser
			else if(this.regularShipList.hurt(laser.getRow(), laser.getColumn()) ||
					this.destroyerShipList.hurt(laser.getRow(), laser.getColumn()) ||
					this.bombList.hurt(laser.getRow(), laser.getColumn()))
				this.laser = null;	
		}
		else this.laser = null;
		*/
		if (this.laser!=null) {
			if(this.Laserhits(this.laser.getRow(),this.laser.getColumn())&&this.laser.move()) {
				this.laser.move();
				this.Laserhits(this.laser.getRow(),this.laser.getColumn());			
			}
		}
		// 2. avanza proyectil:
		int i = bombList.find(this.ucmShip.getRow(), this.ucmShip.getColumn());
		if(i!= -1) {
			this.ucmShip.hurt();
			//abria que desvincular esa bomba a destroyership correspodiente
		}
		this.bombList.move();
		int k = bombList.find(this.ucmShip.getRow(), this.ucmShip.getColumn());
		if(k!= -1) {
			this.ucmShip.hurt();
			//abria que desvincular esa bomba a destroyership correspodiente
		}
		
		//3. comprobar si tiene vida ucmship 
		
		if(this.remainingAliens==0) {finish=true;wins=1;}//jugador gana
		else if (this.ucmShip.getLife()==0 || this.aliensWins()){//jugador pierde
			finish =true;
			wins=2;
			this.ucmShip.setDraw("!xx!");
			}
		else {//continua			
			computerAction();//ve si dispara y si sale ovni}
		}
		
	}
	
	private void enemyMoves() {
		if(this.cycles!=0 && this.cycles%this.level.getSpeed()==0) {
			if(this.destroyerShipList.isBorder(this.right)||this.regularShipList.isBorder(this.right)) {
				this.destroyerShipList.move(Move.DOWN);
				this.regularShipList.move(Move.DOWN);
				this.right=!this.right;
			}
			else if (this.right) {
				this.destroyerShipList.move(Move.RIGHT);
				this.regularShipList.move(Move.RIGHT);
			}
			else if(!this.right) {
				this.destroyerShipList.move(Move.LEFT);
				this.regularShipList.move(Move.LEFT);
			}
		}
	}
	
	private boolean Laserhits(int lrow, int lcol) {
		boolean resul=false;
		if(this.destroyerShipList.destroyerhit(lrow,lcol)) {
			this.points+=this.destroyerShipList.getPoints();
			this.laser=null;
			resul=true;
		}
		else if (this.regularShipList.regularHit(lrow,lcol)) {
			this.points+=this.regularShipList.getPoints();
			this.laser=null;
			resul=true;
		}
		else if(this.ovni!=null && this.ovni.hurt(lrow,lcol)) {
			this.points+=this.ovni.getPoint();
			this.laser=null;
			this.ovni=null;
			this.shockWave=true;
			resul=true;
		}

		return resul;
	}
	

	
	public String toStringObjectAt(int i, int j) {
		int pos=-1;
		String draw="";
		
		if(this.destroyerShipList.find(i, j)!=pos) {draw=this.destroyerShipList.toString();}
		else if(this.bombList.find(i, j)!=pos){draw=this.bombList.toString();}
		else if(this.regularShipList.find(i, j)!=pos) {draw=this.regularShipList.toString();}
		else if(this.ucmShip.getRow()==i && this.ucmShip.getColumn()==j) {draw=this.ucmShip.toString();}//tal vez crear metodo para que compare directamente con las posiciones
		else if(this.laser!= null && this.laser.getRow()==i && this.laser.getColumn()== j) {draw=this.laser.toStringLaser();}
		else if(this.ovni!=null && this.ovni.getRow()==i && this.ovni.getColumn()==j) {draw=this.ovni.toString();}
					
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
			this.computerAction();
		}
		else if(cm == Command.EXIT) {
			this.finish = true; this.wins = 0;
		}
		else if(cm == Command.HELP) {
			this.showHelp();
		}
		else if(cm == Command.LIST) {
			this.showList();
		}
		else if(cm == Command.NONE) {
			this.computerAction();
		}
		else if(cm == Command.RESET) {
			this.initGame();
		}
		else if(cm == Command.SHOCKWAVE) {
			//quita vida a todas las naves alienigenas
			this.shockWave();//quit
		}
		else if(cm == Command.SHOOT) {
			//realiza disparo si puede
			if(this.laser == null) this.laser = new UCMShipLaser(this.ucmShip.getRow());
		}
		
	}
	
	public void shockWave() {
		if(this.shockWave == true) {
			this.destroyerShipList.shokwave();
			this.regularShipList.shockWave();
			this.ovni.hurt();
		}
	}
	
	
	private void showList() {
		String s ="";
		s+= "[R]egular ship: Points: 5 - Harm: 0 - Shield: 2\n" +
		"[D]estroyer ship: Points: 10 - Harm: 1 - Shield: 1|n" +
		"[O]vni: Points: 25 - Harm: 0 - Shield: 1\n" +
		"^__^: Harm: 1 - Shield: 3\n";
		System.out.println(s);

	}

	private void showHelp() {
		String s ="";
		s+= "move <left|right><1|2>: Moves UCM-Ship to the indicated direction.\n" +
		"shoot: UCM-Ship launches a missile.\n" +
		"shockWave: UCM-Ship releases a shock wave.\n" +
		"list: Prints the list of available ships.\n" +
		"reset: Starts a new game.\n" +
		"help: Prints this help message. \n" +
		"exit: Terminates the program.\n" +
		"[none]: Skips one cycle.\n";
		System.out.println(s);
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
			if (num<this.level.getFrecShoot() & this.destroyerShipList.find(this.destroyerShipList.getRow(i)+1, this.destroyerShipList.getColumn(i))==-1) {
				this.bombList.insert(this.destroyerShipList.getShip());
			}//se inicializa la bomba en la posicion de su nave, en update se mueve fuera de la nave
		}
	}
	
	private boolean aliensWins() {//no hace que llega al borde
		boolean resul=false;
		int i=0,aux1=-1, aux2=-1;
		if (this.destroyerShipList.getCount()!=0) {
			while(resul & i<this.col) {
				if(this.destroyerShipList.getNumDestroyer()!=0) {
					aux1=this.destroyerShipList.find(7,i);
				}
				if(this.regularShipList.getCount()!=0) {
					aux2=this.regularShipList.find(7, i);
				}
				resul=(aux1!=-1)||(aux2!=-1);
			}
		}	
		return resul;
	}
	
	public String toString() {
		String draw="Life: "+this.ucmShip.getLife()+"\n";
		draw+="Number of cycles: "+this.cycles+"\n";
		draw+="Points: "+this.points+"\n";
		draw+="Remaining aliens: "+this.remainingAliens+"\n";
		draw+="ShockWave: ";
		if (shockWave) {draw+="SI\n";}
		else draw+="NO\n";
		draw+=this.gamePrinter.toString();
		/*	Life:
		 	Number of cycles: 
			Points: 
			Remaining aliens: 
			shockWave:
		  */
		return draw;
	}
	
	public int getPoints() {
		return points;
	}
}