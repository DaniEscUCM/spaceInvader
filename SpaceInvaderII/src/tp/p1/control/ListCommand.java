package tp.p1.control;

import tp.p1.logic.Game;

public class ListCommand extends Command {
	
	public ListCommand() {
		super("LIST","L","no se que va aqui","tampoco se");
	}

	@Override
	public boolean execute(Game game) {
		game.showList();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {//no se si va así
		Command cm=null;
		if(commandWords[0].equalsIgnoreCase(this.name) || commandWords[0].equalsIgnoreCase(this.shortcut)) {
			cm = this;//funciona??
			}		
		return cm;
	}

}

