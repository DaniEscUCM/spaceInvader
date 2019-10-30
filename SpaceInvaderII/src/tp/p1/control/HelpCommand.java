package tp.p1.control;

import tp.p1.logic.Game;

public class HelpCommand extends Command {
	
	private static String name = "help";
	private static String shortcut = "H";
	private static String detail = "";
	private static String help = ": Prints this help message.";

	public HelpCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		if(commandWords[0].equalsIgnoreCase(this.name) || commandWords[0].equalsIgnoreCase(this.shortcut)) {
			cm = this;
			}		
		return cm;
	}

}
