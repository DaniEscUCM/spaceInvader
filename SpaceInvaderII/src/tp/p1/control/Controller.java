package tp.p1.control;

import java.util.Scanner;

import tp.p1.logic.Game;

public class Controller {
	private Game game;
	private Scanner in;
	private final String promt = "Command > ";
	private final String unknownCommandMsg="UNKNOWN COMMAND";
	
	public Controller(Game game, Scanner in) {
		super();
		this.game = game;
		this.in = in;
	}
	
	public void run() {
		System.out.println(game);
		while(!this.game.getFinish()) {
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
		if(game.getWins() == 1) {
			System.out.println(this.game.toString());
			System.out.println("Player wins");
		}
		else if(game.getWins() == 2){
			System.out.println(this.game.toString());
			System.out.println("Aliens win");
		}
		else {
			System.out.println("Game Over");
		}	
	}
}
