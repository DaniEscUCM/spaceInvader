package tp.p1.control;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import tp.p1.logic.Game;
import tp.p1.logic.PrinterTypes;

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
		help += PrinterTypes.BOARDPRINTER.printerHelp(game) + 
				game.DIM_X + "x" + game.DIM_Y +
				PrinterTypes.BOARDPRINTER.printerHelp(game);
		System.out.println(help);
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

}
