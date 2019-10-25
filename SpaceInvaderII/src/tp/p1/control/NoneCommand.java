package tp.p1.control;

import tp.p1.logic.Game;

public class NoneCommand extends Command {

	public NoneCommand() {
		super("NONE", "N", "details", "help");
	}

	@Override
	public boolean execute(Game game) {
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {//creo que todos los commands(excepto esta y move) se deberían hacer en command pq son iguales
		Command cm=null;	
		if(commandWords[0].equalsIgnoreCase(this.name)||commandWords[0].equalsIgnoreCase("") || commandWords[0].equalsIgnoreCase(this.shortcut)) {
			cm =this;//funciona?
			}
		return cm;
	}

}
