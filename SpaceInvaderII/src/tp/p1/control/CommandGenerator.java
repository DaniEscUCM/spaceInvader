package tp.p1.control;

import exceptions.CommandParseException;

public class CommandGenerator {
	
	private static Command[] availableCommands = {
			new MoveCommand(0),
			new ShootCommand(false),
			new ShockWaveCommand(),
			new ListCommand(),
			new ResetCommand(),
			new HelpCommand(),
			new ExitCommand(),
			new NoneCommand(),
			new BuySuper()
	};

	public static Command parseCommand(String[ ] commandWords) throws CommandParseException {
		Command cm=null;

		for(Command command:availableCommands) {
			cm = command.parse(commandWords);
			if(cm!=null)
				return cm;
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
