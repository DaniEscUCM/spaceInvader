package tp.p1.control;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import exceptions.MissileInFlightException;
import exceptions.NoSuperMissileAvaible;
import exceptions.OffWorldException;
import tp.p1.logic.Game;
//import tp.p1.logic.Move;

public class MoveCommand extends Command {
	
	//private Move dir;
	private int steps=0;
	private final static String name = "move";
	private final static String shortcut = "M";
	private final static String detail = " [M]ove <left|right><1|2>";
	private final static String help = ": Moves UCM-Ship to the indicated direction.";
	
	public MoveCommand( int steps) {//Move dir,
		super(name, shortcut, detail, help);
		//this.dir = dir;
		this.steps = steps;
		
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		/*game.moveUCMShip(dir, steps);		
		game.computerAction();*/
		try {
		game.update();
		return game.move(steps);
		}
		catch(OffWorldException mife) {
		      throw new CommandExecuteException(mife.getMessage());
		  }
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command cm=null;
		//Move diraux=Move.DOWN;
		if(matchCommandName(commandWords[0]) && commandWords.length == 3) { 	
				if(Character.isDigit(commandWords[2].charAt(0))) {			
				int i=Integer.parseInt(commandWords[2]);
				if(i >= 1 && i <= 2) {
					if(commandWords[1].equalsIgnoreCase("RIGHT")|| commandWords[1].equalsIgnoreCase("R")) {
						cm=new MoveCommand(i);
						//diraux = Move.RIGHT;
						}
					else if(commandWords[1].equalsIgnoreCase("LEFT")|| commandWords[1].equalsIgnoreCase("L")) {
						cm=new MoveCommand(-i);
						//diraux= Move.LEFT;
						}
					else {
						CommandParseException ex= new CommandParseException("UNKNOWN DIRECTION");
						throw ex;
						}
				}
				else {
					System.out.println("TOO MANY STEPS");
					}
			
			}
		}
		return cm;
	}

	@Override
	protected boolean printGame() {
		// TODO Auto-generated method stub
		return true;
	}

}
