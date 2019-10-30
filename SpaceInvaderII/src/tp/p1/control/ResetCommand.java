package tp.p1.control;

import tp.p1.logic.Game;

public class ResetCommand extends Command {
	
	private static String name = "reset";
	private static String shortcut = "R";
	private static String detail = " ";
	private static String help = ": Starts a new game.";

	public ResetCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) { // en estos casos, no se si hacer que la funcion del game sea tmbn boolean
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
