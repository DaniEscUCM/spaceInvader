package view;


public class PrinterGenerator {
	
	private static GamePrinter[] availableGamePrinters = {
			new BoardPrinter(null, 0, 0),
			new Stringifier(null)
	};
	
	public static GamePrinter parseGamePrinter(PrinterTypes typePrinter) {
		GamePrinter gm = null;
		for(GamePrinter gameprinter:availableGamePrinters) {
			gm = typePrinter.getObject();
			if(gm== gameprinter) {
				return gm;
			}
		}
		return gm;
	}
}
