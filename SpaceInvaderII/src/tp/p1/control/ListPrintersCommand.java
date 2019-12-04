package tp.p1.control;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import tp.p1.logic.Game;
import view.PrinterTypes;

public class ListPrintersCommand extends Command{
	private final static String name = "listPrinters";
	private final static String shortcut = "P";
	private final static String detail = " list[P]rinters";
	private static String help = "";//para algo es la herencia
	
	public ListPrintersCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		System.out.println(PrinterTypes.printerHelp(game));
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command cm=null;	
		if(matchCommandName(commandWords[0])) {
			cm =new ListPrintersCommand();
			}
		return cm;
	}

	@Override
	protected boolean printGame() {
		// TODO Auto-generated method stub
		return false;
	}

}
