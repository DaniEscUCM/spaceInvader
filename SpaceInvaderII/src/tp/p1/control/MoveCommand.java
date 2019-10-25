package tp.p1.control;

import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class MoveCommand extends Command {
	
	private Move dir;
	private int steps=0;

	public MoveCommand(String name, String shortcut, String details, String help) {
		super("MOVE", "M", "details", "help");
	}

	@Override
	public boolean execute(Game game) {
		game.moveUCMShip(dir, steps);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		if(commandWords.length == 3) { 				
			if(commandWords[0].equalsIgnoreCase(this.name) || commandWords[0].equalsIgnoreCase(this.shortcut)) {
				if(commandWords[1].equalsIgnoreCase("RIGHT")|| commandWords[1].equalsIgnoreCase("R")) {
					this.dir = Move.RIGHT;
				}
				else if(commandWords[1].equalsIgnoreCase("LEFT")|| commandWords[1].equalsIgnoreCase("L")) {
					this.dir= Move.LEFT;
				}
				if(Character.isDigit(commandWords[2].charAt(0))) {
					int i=Integer.parseInt(commandWords[2]);
					if(i >= 1 && i <= 2) {
						cm=this;//funciona?
						steps=i;
					}
				}
			}
		}
		return cm;
	}

}
