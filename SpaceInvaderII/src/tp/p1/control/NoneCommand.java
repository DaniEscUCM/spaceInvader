package tp.p1.control;

import tp.p1.logic.Game;

public class NoneCommand extends Command {
	
	private static String name = "[none]";
	private static String shortcut = "N";
	private static String detail = " ";
	private static String help = ": Skips one cycle.";

	public NoneCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		game.computerAction();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {//creo que todos los commands(excepto esta y move) se deber�an hacer en command pq son iguales
		Command cm=null;	
		if(commandWords[0].equalsIgnoreCase(this.name)||commandWords[0].equalsIgnoreCase("") || commandWords[0].equalsIgnoreCase(this.shortcut)) {
			cm =this;//funciona?
			}
		return cm;
	}

}
