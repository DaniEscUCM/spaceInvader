package tp.p1.control;

import tp.p1.logic.Game;

public class ResetCommand extends Command {
	
	private final static String name = "reset";
	private final static String shortcut = "R";
	private final static String detail = " [R]eset";
	private final static String help = ": Starts a new game.";

	public ResetCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
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
