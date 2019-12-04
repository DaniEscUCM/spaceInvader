package view;


public class PrinterGenerator {
	
	private static GamePrinter[] availableGamePrinters = {
			new BoardPrinter(null, 0, 0),
			new Stringifier(null)
	};
	
	public static GamePrinter parseGamePrinter(PrinterTypes typePrinter) {
		
		return typePrinter.getObject();
	}
}
