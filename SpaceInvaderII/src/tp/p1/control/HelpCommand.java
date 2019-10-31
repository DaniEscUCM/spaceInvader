package tp.p1.control;

import tp.p1.logic.Game;

public class HelpCommand extends Command {
	
	private final static String name = "help";
	private final static String shortcut = "H";
	private final static String detail = "[H]elp";
	private final static String help = ": Prints this help message.";

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
		if(matchCommandName(commandWords[0])) {
			cm = new HelpCommand();
			}		
		return cm;
	}

}
