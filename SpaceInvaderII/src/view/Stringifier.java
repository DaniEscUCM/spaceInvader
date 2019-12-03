package view;

import tp.p1.logic.Game;

public class Stringifier extends GamePrinter{

	public Stringifier(Game game) {
		this.setGame(game);
	}

	@Override
	public String toString() {
		String s =this.game.stringify();
		return s;
	}

}
