package tp.p1.control;

import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class MoveCommand extends Command {
	
	//private Move dir;
	private int steps=0;
	private final static String name = "move";
	private final static String shortcut = "M";
	private final static String detail = " [M]ove <left|right><1|2>";
	private final static String help = ": Moves UCM-Ship to the indicated direction.";
	
	public MoveCommand(Move dir, int steps) {//???
		super(name, shortcut, detail, help);
		//this.dir = dir;
		this.steps = steps;
		
	}

	@Override
	public boolean execute(Game game) {
		/*game.moveUCMShip(dir, steps);		
		game.computerAction();*/
		game.update();
		return game.move(steps);
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		Move diraux=Move.DOWN;
		if(commandWords.length == 3) { 				
			if(matchCommandName(commandWords[0])) {
				if(commandWords[1].equalsIgnoreCase("RIGHT")|| commandWords[1].equalsIgnoreCase("R")) {
					diraux = Move.RIGHT;
				}
				else if(commandWords[1].equalsIgnoreCase("LEFT")|| commandWords[1].equalsIgnoreCase("L")) {
					diraux= Move.LEFT;
				}
				if(Character.isDigit(commandWords[2].charAt(0))) {
					int i=Integer.parseInt(commandWords[2]);
					if(i >= 1 && i <= 2) {
						cm=new MoveCommand(diraux,i);
					}
				}
			}
		}
		return cm;
	}

}
