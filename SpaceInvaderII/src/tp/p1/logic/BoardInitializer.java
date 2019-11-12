package tp.p1.logic;

import tp.p1.logic.lists.GameObjectBoard;
import tp.p1.logic.objects.DestroyerShip;
import tp.p1.logic.objects.GameObject;
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
		GameObject objeto=new Ovni(game);
		this.board.add(objeto);
	}
	private void initializeRegularAliens () {
		int row=1, col=8;
		GameObject objeto;
		for(int i=0;i<level.getNumRegularAliens();i++) {
			objeto=new RegularShip(game, row, col);
			this.board.add(objeto);
			col--;
			if(i==3) {//para los niveles hard e insane
				row=2;
				col=8;
			}
			
		}
		
	}
	private void initializeDestroyerAliens () {
		int row=2, col=6;
		GameObject objeto;
		if(level==Level.HARD ||level==Level.INSANE) {row++;}
		for(int i=0;i<level.getNumDestroyerAliens();i++) {
			objeto=new DestroyerShip(game, row, col);
			this.board.add(objeto);
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
