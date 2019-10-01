package tp.p1;

import java.util.Scanner;

import tp.p1.control.Controller;
import tp.p1.logic.Game;
import tp.p1.logic.Level;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Level level = null;
		if(args[0].equalsIgnoreCase("EASY")) {
			level = Level.EASY;
		}else if (args[0].equalsIgnoreCase("HARD")) {
			level = Level.HARD;
		}else if(args[0].equalsIgnoreCase("INSANE") ) {
			level = Level.INSANE;
		}else {
			//imprimir error
		}
		
		
		
		

		
		
		
		Game game = new Game();
		Controller control = new Controller(game, in);
		control.run();

	}

}
