package tp.p1.control;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import exceptions.OffWorldException;
import tp.p1.logic.Game;
//import tp.p1.logic.Move;

public class MoveCommand extends Command {
	
	private int steps=0;
	private final static String name = "move";
	private final static String shortcut = "M";
	private final static String detail = " [M]ove <left|right><1|2>";
	private final static String help = ": Moves UCM-Ship to the indicated direction.";
	
	public MoveCommand( int steps) {
		super(name, shortcut, detail, help);
		this.steps = steps;
		
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		boolean exec = false;
		try {
			exec = game.move(steps);
			if(exec) game.update();
		}
		catch(OffWorldException mife) {
		      throw new CommandExecuteException(mife.getMessage());
		 }
		return exec;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command cm=null;
		if(matchCommandName(commandWords[0]) && commandWords.length == 3) {//numero de parametros 	
			if(Character.isDigit(commandWords[2].charAt(0))) {	//move		
				int i=Integer.parseInt(commandWords[2]);
				if(i >= 1 && i <= 2) {//numero de pasos
					if(commandWords[1].equalsIgnoreCase("RIGHT")|| commandWords[1].equalsIgnoreCase("R")) {//dir
						cm=new MoveCommand(i);
					}
					else if(commandWords[1].equalsIgnoreCase("LEFT")|| commandWords[1].equalsIgnoreCase("L")) {
						cm=new MoveCommand(-i);
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
		return true;
	}

}
