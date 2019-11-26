package tp.p1.logic;
import java.util.Random;

import tp.p1.control.Command;
import tp.p1.control.ExitCommand;
import tp.p1.control.HelpCommand;
import tp.p1.control.IPlayerController;
import tp.p1.control.ListCommand;
import tp.p1.control.MoveCommand;
import tp.p1.control.NoneCommand;
import tp.p1.control.ResetCommand;
import tp.p1.control.ShockWaveCommand;
import tp.p1.control.ShootCommand;
import tp.p1.logic.Level;
import tp.p1.logic.lists.GameObjectBoard;
import tp.p1.logic.objects.AlienShip;
import tp.p1.logic.objects.DestroyerShip;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.Ovni;
import tp.p1.logic.objects.RegularShip;
import tp.p1.logic.objects.Ship;
import tp.p1.logic.objects.UCMShip;
import tp.p1.logic.objects.UCMShipLaser;
//import pr2.game.GameObjects.AlienShip;
//import pr2.game.GameObjects.BoardInitializer;
//import pr2.game.GameObjects.GameObject;
//import pr2.game.GameObjects.IPlayerController;

public class Game implements IPlayerController{
	
		public final static int DIM_X = 9;//9
		public final static int DIM_Y = 8;//8
		private int currentCycle;
		private Random rand;
		private Level level;
		GameObjectBoard board;
		private UCMShip player;
		private boolean doExit;
		private BoardInitializer initializer ;
		private GamePrinter gamePrinter;
		
		private static Ship[] availableShips = {
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
			"Remaining aliens: "+ (AlienShip.getRemainingAliens()) + "\n";
		}
			
		public String getWinnerMessage () {
			if (playerWin()) return "Player win!";
			else if (aliensWin()) return "Aliens win!";
			else if (doExit) return "Player exits the game";
			else return "This should not happen";
		}
		
		@Override
		public boolean move (int numCells) {			
			return this.player.move(numCells);
		}
		@Override
		public boolean shootMissile() {
			if(this.player.isCanShootLaser()) {
				GameObject laser=new UCMShipLaser(this,this.player.getX(),this.player.getY()-1);
				this.board.add(laser);
				this.player.setCanShootLaser();
				return true;
			}
			return false;
			
		}
		@Override
		public boolean shockWave() {
			// TODO
			return true;
		}
		
		@Override
		public void receivePoints(int points) {
			this.player.receivePoints(points);		
		}
		@Override
		public void enableShockWave() {
			// TODO
		}
		@Override
		public void enableMissile() {
			this.player.setCanShootLaser();
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
			this.gamePrinter=new GamePrinter(this,this.DIM_Y ,this.DIM_X );
			draw+=this.gamePrinter.toString();
			return draw;
		}
}
