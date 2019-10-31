package tp.p1.control;

import tp.p1.logic.Game;

public class NoneCommand extends Command {
	
	private final static String name = "none";
	private final static String shortcut = "N";
	private final static String detail = "[none]";
	private final static String help = ": Skips one cycle.";

	public NoneCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		game.update();
		game.computerAction();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {//creo que todos los commands(excepto esta y move) se deber�an hacer en command pq son iguales
		Command cm=null;	
		if(matchCommandName(commandWords[0])) {
			cm =new NoneCommand();
			}
		return cm;
	}

}
