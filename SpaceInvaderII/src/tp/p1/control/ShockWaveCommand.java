package tp.p1.control;

import exceptions.CommandExecuteException;
import exceptions.NoShockwaveException;
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
	public boolean execute(Game game) throws CommandExecuteException {
		boolean exec = false;
		try {
			exec = game.shockWave();
			if(exec) game.update();
		}
		catch(NoShockwaveException mife) {
		      throw new CommandExecuteException(mife.getMessage());
		}
		return exec;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length==1) {
				cm = new ShockWaveCommand();
			}
		}
		return cm;
	}

	@Override
	protected boolean printGame() {
		return true;
	}

}