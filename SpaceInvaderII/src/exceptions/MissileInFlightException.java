package exceptions;

public class MissileInFlightException extends Exception {
	
	private static String message="Cause of Exception:\r\n" + 
			"exceptions.MissileInFlightException: Cannot fire missile: missile already exists on board";
	//private static Throwable cause=Shoot;

	
	public MissileInFlightException() {
		super(message);
	}

}
