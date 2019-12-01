package tp.p1.control;

import java.util.Scanner;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
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
		while(!this.game.isFinished()) {
			System.out.print(this.promt);
			String[] words =  in.nextLine().toLowerCase().trim().split("\\s+");
			try {
				if(words.length<=3) {
					Command command = CommandGenerator.parseCommand(words);
					if (command != null) {
						if (command.execute(game))
							System.out.println(game);
						}
					else {
						System.out.format(unknownCommandMsg);
					}
				}
				else {
					System.out.println("Usage: Main "+game.getLevel()+" "+game.getRandom());//la semilla muestra cosas raras
				}
			}catch(CommandParseException | CommandExecuteException ex) {
				System.out.format(ex.getMessage() + " %n %n");
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
