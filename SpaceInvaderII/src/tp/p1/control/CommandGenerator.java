package tp.p1.control;

public class CommandGenerator {
	
	private static Command[] availableCommands = {// no entiendo esto
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new ListCommand(),
			new NoneCommand(),
			new MoveCommand(),
			new ShockWaveCommand()
	};

	public static Command parseCommand(String[ ] commandWords) {
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
			s+= cm.helpText() + System.lineSeparator();
		}
		return s;
	}
}
