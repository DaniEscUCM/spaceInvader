package exceptions;

@SuppressWarnings("serial")
public class CommandExecuteException extends Exception {
	
	protected String action;

	public CommandExecuteException() {
	}

	public CommandExecuteException(String message) {
		super(message);
	}

}
