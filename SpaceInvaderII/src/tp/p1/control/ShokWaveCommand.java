package tp.p1.control;

import tp.p1.logic.Game;

public class ShokWaveCommand extends Command {
	
	public ShokWaveCommand() {
		super("SHOKWAVE","W","no se que va aqui","tampoco se");
	}

	@Override
	public boolean execute(Game game) {
		game.shockWave();
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