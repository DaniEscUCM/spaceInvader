package tp.p1.logic;


public abstract class GamePrinter {
	
	protected final String name;//ej: Help
	protected final String shortcut;//ej: h
	private final String details ;//izquierda de help
	private final String help;

	public GamePrinter(String name, String shortcut, String details, String help){
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
		}
	
	public abstract GamePrinter parse(String[] gameWords);

	public String helpText(){
		return name + details + help + "\n";
		}

}
