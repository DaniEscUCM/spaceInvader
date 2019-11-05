package tp.p1.control;

import tp.p1.logic.Game;

public class ExitCommand extends Command {
	
	private final static String name = "exit";
	private final static String shortcut = "E";
	private final static String detail = " [E]xit";
	private final static String help = ": Terminates the program.";//para algo es la herencia

	public ExitCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		game.exit();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;	
		if(matchCommandName(commandWords[0])) {
			cm =new ExitCommand();
			}
		return cm;
	}

}
