package exceptions;

@SuppressWarnings("serial")
public class OffWorldException extends Exception {

	private static String message="Failed to move\r\n"+"Cause of Exception:\r\n" + 
			"exceptions.OffWorldException: Cannot perform move: ship too near border";

	public OffWorldException() {
		super(message);
	}

}
