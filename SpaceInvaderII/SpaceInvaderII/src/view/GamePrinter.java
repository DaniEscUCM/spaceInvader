package view;

import tp.p1.logic.Game;

public abstract class GamePrinter {
	
	protected Game game;
	
	public GamePrinter(Game game) {
		this.game = game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
	

}
