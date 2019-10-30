package tp.p1.control;

import tp.p1.logic.Game;

public class ExitCommand extends Command {
	
	private static String name = "exit";
	private static String shortcut = "E";
	private static String detail = "";
	private static String help = ": Terminates the program.";

	public ExitCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		return game.exit();
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;	
		if(commandWords[0].equalsIgnoreCase(this.name) || commandWords[0].equalsIgnoreCase(this.shortcut)) {
			cm =this;//funciona?
			}
		return cm;
	}

}
