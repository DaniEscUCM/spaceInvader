package tp.p1.control;

import exceptions.CommandParseException;

public class CommandGenerator {
	
	private static Command[] availableCommands = {//si hay comando nuevo, se debe agregar
			new MoveCommand(0),
			new ShootCommand(false),
			new ShockWaveCommand(),
			new ListCommand(),
			new ResetCommand(),
			new HelpCommand(),
			new ExitCommand(),
			new NoneCommand(),
			new BuySuper(),
			new StringifyCommand(), 
			new ListPrintersCommand(),
			new SaveCommand(null)
	};

	public static Command parseCommand(String[ ] commandWords) throws CommandParseException {
		Command cm=null;
		for(Command command:availableCommands) {
			cm = command.parse(commandWords);
			if(cm!=null) {
				return cm;
			}
		}
		return cm;
	}
	
	public static String commandHelp() {
		String s = "";
		for(int i = 0; i < CommandGenerator.availableCommands.length; i++) {
			Command cm = CommandGenerator.availableCommands[i];
			s+= cm.helpText() /*+ System.lineSeparator()*/;
		}
		return s;
	}
}
