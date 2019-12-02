package tp.p1.control;

import java.util.Scanner;

import tp.p1.logic.BoardPrinter;
import tp.p1.logic.Game;
import tp.p1.logic.GamePrinter;

public class Controller {
	private Game game;
	private Scanner in;
	private final String promt = "Command > ";
	private final String unknownCommandMsg="UNKNOWN COMMAND";
	private GamePrinter printer;
	
	public Controller(Game game, Scanner in) {
		super();
		this.game = game;
		this.in = in;
		this.printer = new BoardPrinter(game, game.DIM_X, game.DIM_Y);
	}
	
	public void run() {
		System.out.println(game);
		while(!this.game.isFinished()) {
			System.out.println(printer);
			System.out.print(this.promt);
			String[] words =  in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandGenerator.parseCommand(words);
			if (command != null) {
				if (command.execute(game))
				System.out.println(game);
				}
				else {
				System.out.format(unknownCommandMsg);
				}
		}
		if(game.playerWin()) {
			System.out.println(this.game.toString());
			System.out.println("Player wins");
		}
		else if(game.aliensWin()){
			System.out.println(this.game.toString());
			System.out.println("Aliens win");
		}
		else {
			System.out.println("Game Over");
		}	
	}
}
