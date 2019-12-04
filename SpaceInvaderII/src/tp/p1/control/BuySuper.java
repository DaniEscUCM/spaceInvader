package tp.p1.control;

import exceptions.CommandExecuteException;
import exceptions.NoEnoughPoints;
import tp.p1.logic.Game;

public class BuySuper extends Command {
	
	private static String name = "buy";
	private static String shortcut = "B";
	private static String detail = " [B]uy";
	private static String help = ": player buy a super missile";

	public BuySuper() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		boolean exec = false;
		try{
		exec = game.buyMissile();
		if(exec) game.update();
		}
		catch(NoEnoughPoints mife) {
			 throw new CommandExecuteException(mife.getCause() + ": " + mife.getMessage());
		}
		return exec;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		if(matchCommandName(commandWords[0])) {
			cm=new BuySuper();			
		}
		return cm;
	}

	@Override
	protected boolean printGame() {
		return true;
	}

}
