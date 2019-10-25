package tp.p1.control;

import tp.p1.logic.Game;

public class ExitCommand extends Command {

	public ExitCommand() {
		super("", "", "details", "help");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		return null;
	}

}
