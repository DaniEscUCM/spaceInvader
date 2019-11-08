package tp.p1.logic;

import tp.p1.logic.lists.GameObjectBoard;
import tp.p1.logic.objects.DestroyerShip;
import tp.p1.logic.objects.Ovni;
import tp.p1.logic.objects.RegularShip;

public class BoardInitializer {
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this. game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		initializeOvni ();
		initializeRegularAliens ();
		initializeDestroyerAliens ();
		return board;
	}
	private void initializeOvni () {
		game.board.add(new Ovni(game));
	}
	private void initializeRegularAliens () {
		int row=1, col=8;
		for(int i=0;i<level.getNumRegularAliens();i++) {
			game.board.add(new RegularShip(game, row, col));
			col--;
			if(i==3) {//para los niveles hard e insane
				row=2;
				col=8;
			}
			
		}
		
	}
	private void initializeDestroyerAliens () {
		int row=2, col=6;
		if(level==Level.HARD ||level==Level.INSANE) {row++;}
		for(int i=0;i<level.getNumDestroyerAliens();i++) {
			game.board.add(new DestroyerShip(game, row, col));
			if(col==7) {//para insane				
				row++;
				col=6;
			}
			else {
				col++;
			}
		}
	}


}
