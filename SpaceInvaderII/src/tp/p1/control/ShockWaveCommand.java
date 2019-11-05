package tp.p1.control;

import tp.p1.logic.Game;

public class ShockWaveCommand extends Command {
	
	private final static String name = "shockWave";
	private final static String shortcut = "W";
	private final static String detail = " shock[W]ave";
	private final static String help = ": UCM-Ship releases a shock wave.";
	
	public ShockWaveCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		/*game.shockWave();//se que devuelve booleano pero da problemas con que dira que el comando es incorrecto
		game.update();
		game.computerAction();*/
		game.update();
		return game.shockWave();
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		if(matchCommandName(commandWords[0])) {
			cm = new ShockWaveCommand();
		}
		return cm;
	}

}