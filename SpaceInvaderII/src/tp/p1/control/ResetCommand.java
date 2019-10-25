package tp.p1.control;

import tp.p1.logic.Game;

public class ResetCommand extends Command {

	public ResetCommand() {
		super("RESET", "R", "details", "help");
	}

	@Override
	public boolean execute(Game game) {
		game.initGame();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		if(commandWords[0].equalsIgnoreCase(this.name) || commandWords[0].equalsIgnoreCase(this.shortcut)) {
			cm = this;// funciona?
		}
		return cm;
	}

}
