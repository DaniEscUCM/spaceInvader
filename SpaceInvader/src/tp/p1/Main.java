package tp.p1;

import java.util.Scanner;

import tp.p1.control.Controller;
import tp.p1.logic.Game;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		Controller control = new Controller(game, in);
		control.run();

	}

}
