package exceptions;

public class MissileInFlightException extends CommandExecuteException {

	public MissileInFlightException() {
	}

	public MissileInFlightException(String message) {
		super(message);
	}

}
