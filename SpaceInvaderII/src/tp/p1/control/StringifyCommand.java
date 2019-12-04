package tp.p1.control;

import tp.p1.logic.Game;

public class StringifyCommand extends Command{

	private final static String name = "stringify";
	private final static String shortcut = "ST";
	private final static String detail = " [St]ringify";
	private final static String help = ": Starts a new game.";

	public StringifyCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(game.stringify());
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		if(matchCommandName(commandWords[0])) {
			cm = new StringifyCommand();
		}
		return cm;
	}

	@Override
	protected boolean printGame() {
		// TODO Auto-generated method stub
		return false;
	}

}
