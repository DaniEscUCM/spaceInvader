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
		// 1. avanza proyectil
		if(this.laser.move() == true) {
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
		// 2. avanza proyectil:
		this.bombList.update();
		int i = bombList.find(this.ucmShip.getRow(), this.ucmShip.getColumn());
		if(i!= -1) {
			this.ucmShip.hurt();
		}
		
		//3. comprobar si tiene vida ucmship y ovni
		if(this.ovni.getLife() == 0) {
			this.ovni = null;
			this.shockWave = true;
		}
		if(this.ucmShip.getLife() == 0) {
			this.ucmShip.setDraw("!XX?");
			this.setFinish(true); 
			this.setWins(2); // ganan los aliens
		}
		else if (this.destroyerShipList.getCount() == 0 && 
				this.regularShipList.getCount() == 0 &&
				this.bombList.getCount() == 0 && this.ovni.getLife() == 0) {
			this.setFinish(true);
			this.setWins(1); //gana el jugador
		}
		
	}
	
	private void setWins(int i) {
		this.wins = i;
		
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
			this.update();
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
			this.update();
		}
		else if(cm == Command.RESET) {
			this.initGame();
		}
		else if(cm == Command.SHOCKWAVE) {
			//quita vida a todas las naves alienigenas
			this.shockWave();//quitaria vida a todas las naves alienigenas
			this.update();
		}
		else if(cm == Command.SHOOT) {
			//realiza disparo si puede
			if(this.laser == null) this.laser = new UCMShipLaser(this.ucmShip.getRow());
			this.update();
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
				this.bombList.insert(this.destroyerShipList.getRow(i),this.destroyerShipList.getColumn(i));
			}//se inicializa la bomba en la posicion de su nave, en update se mueve fuera de la nave
		}
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