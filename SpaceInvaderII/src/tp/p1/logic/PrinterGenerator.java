package tp.p1.logic;


public class PrinterGenerator {
	
	private static GamePrinter[] availableGamePrinters = {
			new BoardPrinter(null, 0, 0),
			new Stringifier(null)
	};
	
	public static GamePrinter parseGamePrinter(String[] gameWords) {
		GamePrinter gp=null;

		for(GamePrinter gameprinter:availableGamePrinters) {
			gp = gameprinter.parse(gameWords);
			if(gp!=null)
				return gp;
		}
		return gp;
	}
	
	/*
	public static String gamePrinterHelp() {
		String s = "";
		for(int i = 0; i < PrinterGenerator.availableGamePrinters.length; i++) {
			GamePrinter gp = PrinterGenerator.availableGamePrinters[i];
			s+= gp.helpText() /*+ System.lineSeparator()*/;
		//}
		//return s;
	//}

}
