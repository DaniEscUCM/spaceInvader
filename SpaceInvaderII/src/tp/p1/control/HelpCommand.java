package tp.p1.control;

import tp.p1.logic.Game;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("HELP", "H", "NO SE", "help");
	}

	@Override
	public boolean execute(Game game) {
		game.showHelp();
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
