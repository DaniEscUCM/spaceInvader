package tp.p1.control;

import tp.p1.logic.Game;

//no entiendo bien lo de command generator
public abstract class Command {//subclase por cada objeto de la shoot...etc, command generator si null no es reconocido
	protected final String name;//ej: Help
	protected final String shortcut;//ej: h
	private final String details ;//??
	private final String help;
	protected static final String incorrectNumArgsMsg = "Incorrect number of arguments";
	protected static final String incorrectArgsMsg = "Incorrect	argument format";
	
	public Command(String name, String shortcut, String details, String		help){
		this.name = name;
		this.shortcut = shortcut;
		this.details = details;
		this.help = help;
		}
	
	public abstract boolean execute(Game game);
	public abstract Command parse(String[] commandWords);
	
	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) ||	this.name.equalsIgnoreCase(name);
		}
	
	public String helpText(){
		return details + " : " + help + "\n";
		}

}
