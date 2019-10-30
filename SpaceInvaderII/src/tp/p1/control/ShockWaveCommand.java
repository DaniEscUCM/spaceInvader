package tp.p1.control;

import tp.p1.logic.Game;

public class ShockWaveCommand extends Command {
	
	private static String name = "shockWave";
	private static String shortcut = "W";
	private static String detail = " ";
	private static String help = ": UCM-Ship releases a shock wave.";
	public ShockWaveCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		return game.shockWave();
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