package tp.p1.control;

import tp.p1.logic.Game;

public class ListCommand extends Command {
	private final static String name = "list";
	private final static String shortcut = "L";
	private final static String detail = "[L]ist";
	private final static String help = ": Prints the list of available ships.";
	
	public ListCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		game.showList();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {//no se si va as�
		Command cm=null;
		if(matchCommandName(commandWords[0])) {
			cm =new ListCommand();
			}		
		return cm;
	}

}

