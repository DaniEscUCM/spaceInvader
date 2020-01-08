package exceptions;

@SuppressWarnings("serial")
public class MissileInFlightException extends Exception {
	
	private static String message="Failed to shoot\r\n" +"Cause of Exception:\r\n" + 
			"exceptions.MissileInFlightException: Cannot fire missile: missile already exists on board";


	
	public MissileInFlightException() {
		super(message);
	}

}
