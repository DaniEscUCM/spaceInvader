package exceptions;

public class NoEnoughPoints extends CommandExecuteException {

	public NoEnoughPoints() {
	}

	public NoEnoughPoints(String message) {
		super(message);
	}

}
