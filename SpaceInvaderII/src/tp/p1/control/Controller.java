package tp.p1.control;

import java.util.Scanner;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import tp.p1.logic.Game;
import view.BoardPrinter;
import view.GamePrinter;

public class Controller {
	private Game game;
	private Scanner in;
	private final String promt = "Command > ";
	private final String unknownCommandMsg="UNKNOWN COMMAND";
	private GamePrinter printer;
	
	@SuppressWarnings("static-access")
	public Controller(Game game, Scanner in) {
		super();
		this.game = game;
		this.in = in;
		this.printer = new BoardPrinter(game, game.DIM_X ,game.DIM_Y);
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		printGame();
		while(!game.isFinished()) {
			System.out.print(this.promt);
			String[] words =  in.nextLine().toLowerCase().trim().split("\\s+");
			try {
				
				Command command = CommandGenerator.parseCommand(words);
				if (command != null) {
					if (command.execute(game) && command.printGame()) {
						this.printer = new BoardPrinter(game, game.DIM_X ,game.DIM_Y);
						printGame();
					}
				}else {
					System.out.println(unknownCommandMsg);
				}		
			}catch(CommandParseException | CommandExecuteException ex) {//se trata la excepcion
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
	
	
	public void printGame() {
		System.out.println(printer);
	}
	
	
}
