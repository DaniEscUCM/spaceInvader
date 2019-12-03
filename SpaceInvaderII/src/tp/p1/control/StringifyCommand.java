package tp.p1.control;

import tp.p1.logic.Game;
import view.GamePrinter;
import view.Stringifier;

public class StringifyCommand extends Command{

	private final static String name = "stringify";
	private final static String shortcut = "S";
	private final static String detail = " [S]tringify";
	private final static String help = ": Starts a new game.";
	private GamePrinter printer;

	public StringifyCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		//game.reset();
		printer = new Stringifier (game);
		System.out.println(printer);
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		if(matchCommandName(commandWords[0])) {
			cm = new ResetCommand();
		}
		return cm;
	}

}
