package tp.p1.control;

import tp.p1.logic.Game;

public class ListCommand extends Command {
	private static String name = "list";
	private static String shortcut = "L";
	private static String detail = "";
	private static String help = ": Prints the list of available ships.";
	
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
		if(commandWords[0].equalsIgnoreCase(this.name) || commandWords[0].equalsIgnoreCase(this.shortcut)) {
			cm = this;//funciona??
			}		
		return cm;
	}

}

