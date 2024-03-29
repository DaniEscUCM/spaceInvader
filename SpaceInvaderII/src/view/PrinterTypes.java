package view;

import tp.p1.logic.Game;

public enum PrinterTypes {
	
	BOARDPRINTER("boardprinter",
		"prints the game formatted as a board of dimension: ",
		new BoardPrinter(null, 0, 0)),
	STRINGIFIER("stringifier",
		"prints the game as plain text",
		new Stringifier(null) ); 
	
	private String printerName;
	private String helpText;
	private GamePrinter printerObject;
	
	private PrinterTypes(String name, String text, GamePrinter printer) {
		printerName = name;
		helpText = text;
		printerObject = printer;
	}
	
	public static String printerHelp(Game game) {
		String helpString = "";
		for (PrinterTypes printer : PrinterTypes.values())
			helpString += String.format(" %s : %s %s %n", printer.printerName, printer.helpText,
			(printer == BOARDPRINTER ? Game.DIM_X + " x " + Game.DIM_Y : "") );
		return helpString;
		}
	
	// Assumes a max of one object of each printer type is needed (otherwise return copy)
	public GamePrinter getObject() {
		return printerObject;
	}

}
