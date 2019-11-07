package tp.p1.logic;
import java.util.Random;

import tp.p1.control.IPlayerController;
import tp.p1.logic.Level;
import tp.p1.logic.lists.GameObjectBoard;
import tp.p1.logic.objects.AlienShip;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.UCMShip;
//import pr2.game.GameObjects.AlienShip;
//import pr2.game.GameObjects.BoardInitializer;
//import pr2.game.GameObjects.GameObject;
//import pr2.game.GameObjects.IPlayerController;

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
		
		public Game (Level level, Random random){
			this. rand = random;
			this.level = level;
			initializer = new BoardInitializer();
			initGame();
		}
		
		public void initGame () {
			currentCycle = 0;
			board = initializer.initialize(this, level );
			player = new UCMShip(this, DIM_X / 2, DIM_Y - 1);
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
			return true;
		}
		@Override
		public boolean shootMissile() {
			return true;
		}
		@Override
		public boolean shockWave() {
			return true;
		}
		
		@Override
		public void receivePoints(int points) {
			
		}
		@Override
		public void enableShockWave() {
			
		}
		@Override
		public void enableMissile() {
			
		}
		public String toStringObjectAt(int i, int j) {
			return "hay que hacer nuevo con gameobjectboard";
		}
		
		public void showList() {
			
		}
}
