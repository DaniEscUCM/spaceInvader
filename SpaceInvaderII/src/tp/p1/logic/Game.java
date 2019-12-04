package tp.p1.logic;

import java.util.Random;
import exceptions.MissileInFlightException;
import exceptions.NoEnoughPoints;
import exceptions.NoShockwaveException;
import exceptions.NoSuperMissileAvaible;
import exceptions.OffWorldException;
import tp.p1.control.IPlayerController;
import tp.p1.logic.Level;
import tp.p1.logic.lists.GameObjectBoard;
import tp.p1.logic.objects.AlienShip;
import tp.p1.logic.objects.DestroyerShip;
import tp.p1.logic.objects.ExplosivShip;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.Ovni;
import tp.p1.logic.objects.RegularShip;
import tp.p1.logic.objects.Ship;
import tp.p1.logic.objects.SuperMisil;
import tp.p1.logic.objects.UCMShip;
import tp.p1.logic.objects.UCMShipLaser;

public class Game implements IPlayerController{
	
		public final static int DIM_X = 9;
		public final static int DIM_Y = 8;
		private int currentCycle;
		private Random rand;
		private Level level;
		GameObjectBoard board;
		private UCMShip player;
		private boolean doExit;
		private BoardInitializer initializer ;
		private boolean shockWave = false;
		private boolean serializing = false;
		
		private static Ship[] availableShips = {
				new ExplosivShip(null, 0, 0, 2, 0, 0, null),
				new RegularShip(null, 0, 0),
				new DestroyerShip(null, 0, 0),
				new Ovni(null),
				new UCMShip(null, 0, 0)
				
		};
		
		public Game (Level level, Random random){
			this. rand = random;
			this.level = level;
			initializer = new BoardInitializer();
			initGame();
		}
		
		public void initGame () {
			currentCycle = 0;
			board = initializer.initialize(this, level );
			player = new UCMShip(this,DIM_X / 2 ,DIM_Y - 1 );
			board.add(player);
		}
		
		public Random getRandom() {
		return rand;
		}
		
		public Level getLevel() {
			return level;
		}
		
		public void reset() {
			initGame();
		}
		
		public void addObject(GameObject object) {
			board.add(object);
		}
		
		public String positionToString(int x, int y) {
			return board.toString(x, y);
		}
		
		public boolean isFinished() {
			return playerWin() || aliensWin() || doExit;
		}
		
		public boolean aliensWin() {
			return  !player.isAlive () || AlienShip.haveLanded();
		}
		
		public boolean playerWin() {
			return AlienShip.allDead();
		}
		
		public void update() {
			board.computerAction();
			board.update();
			currentCycle ++;
		}
		public boolean isOnBoard(int x, int y) {
			return x >= 0 && y >= 0 && x < DIM_X && y < DIM_Y;
		}
			
		public void exit() {
			doExit = true;
		}
			
		public String infoToString() {
			return "Cycles: " + currentCycle + "\n" +
			player.stateToString() +
			"Remaining aliens: "+ (AlienShip.getRemainingAliens()) + "\n" +
			"ShockWave: " + (this.shockWave?"SI":"NO")+ "\n" +
			"SuperMissile: "+this.player.getNumofSuper()	;
		}
			
		public String getWinnerMessage () {
			if (playerWin()) return "Player win!";
			else if (aliensWin()) return "Aliens win!";
			else if (doExit) return "Player exits the game";
			else return "This should not happen";
		}
		
		@Override
		public boolean move (int numCells) throws OffWorldException {			
			return this.player.move(numCells);
		}
		@Override
		public boolean shootMissile() throws MissileInFlightException{
			if(this.player.isCanShootLaser()) {
				GameObject laser=new UCMShipLaser(this,this.player.getX(),this.player.getY());
				this.board.add(laser);
				this.player.setCanShootLaser();
				return true;
			}else {
				MissileInFlightException miExc = new MissileInFlightException(); 
				throw miExc;
			}
		}
		@Override
		public boolean shootSuperMis() throws MissileInFlightException, NoSuperMissileAvaible {
			if(this.player.isCanShootLaser() ) {
				if(this.player.getNumofSuper()>0) {
					GameObject laser=new SuperMisil(this,this.player.getX(),this.player.getY());
					this.board.add(laser);
					this.player.setCanShootLaser();
					return true;
					}
				else {
					NoSuperMissileAvaible miExc = new NoSuperMissileAvaible(); 
					throw miExc;
				}
			}else {
				MissileInFlightException miExc = new MissileInFlightException(); 
				throw miExc;
			}
		}
		@Override
		public boolean shockWave() throws NoShockwaveException {
			if(this.shockWave) {
				this.board.shockWave();
				this.shockWave = false;
				return true;
			}
			else {
				NoShockwaveException miExc = new NoShockwaveException(); 
				throw miExc;
			}
		}
		
		@Override
		public void receivePoints(int points) {
			this.player.receivePoints(points);		
		}
		@Override
		public void enableShockWave() {
			this.shockWave = true;
		}
		@Override
		public void enableMissile() {
			this.player.setCanShootLaser();
		}
		public void enableMissileSup() {
			this.player.setCanShootLaser();
			this.player.useSuper();
		}
		public String toStringObjectAt(int i, int j) {			
			return this.board.toString(i,j);
		}
		
		public void showList() {//ni ideade harm
			String s="";
			for(Ship e:availableShips) {
				s+=e.toString();
				s+=" Points: "+e.getPoints();
				s+=" - Shields: "+e.getLive();//ucm ship tiene una funcion que hace esto, seria ponerlo en ship
				s+="\n";
			}
			System.out.println(s);
		}
		
		public String toString() {
			String draw="";
			draw+=this.infoToString();
			//this.gamePrinter=new BoardPrinter(this,this.DIM_Y ,this.DIM_X );
			//draw+=this.gamePrinter.toString();
			return draw;
		}

		public void deleteOnlist(GameObject object) {
			board.removeObject(object);
	
		}

		public boolean buyMissile() throws NoEnoughPoints {
			if(player.getPoints() >= 20) {player.setNumofSuper();return true;}
			else{
				NoEnoughPoints miExc = new NoEnoughPoints(); 
				throw miExc;
			}
		}

		public String stringify() {
			serializing = false;
			String s = "		 — Space Invaders 2.0 —  \n"
					+ "G," + this.currentCycle + "\n"
					+ "L," + this.level.toString() + "\n"
					+ board.stringify();
			return s;
		}
		
		public void explosiveDeath(int x, int y) {
			board.explosiveDeath( x, y);
		}
		
		
		public void setSerializing() {
			serializing = true;
		}
		
		public boolean isSerializing() {
			return serializing;
		}
		
		public boolean getShockWave() {
			return this.shockWave;
		}

}
