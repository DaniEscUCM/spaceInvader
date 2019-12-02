package tp.p1.control;

import tp.p1.logic.Game;

public class StringifyCommand extends Command{

	private final static String name = "stringify";
	private final static String shortcut = "S";
	private final static String detail = " [S]tringify";
	private final static String help = ": Starts a new game.";

	public StringifyCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		//game.reset();
		return true;
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
