package tp.p1.control;

import java.util.Scanner;

import tp.p1.logic.Game;

public class Controller {
// clase abstracta command updateCommand es NONE, es mejor usar none
	private Game game;
	private Scanner in;
	private final String promt = "Command > ";
	private final String unknownCommandMsg="UNKNOWN COMMAND";//bastante segura que no es así
	//private boolean print = true;
	
	public Controller(Game game, Scanner in) {
		super();
		this.game = game;
		this.in = in;
	}
	
	public void run() {
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
	}
}
