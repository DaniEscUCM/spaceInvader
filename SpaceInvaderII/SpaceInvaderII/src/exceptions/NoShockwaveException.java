package exceptions;

@SuppressWarnings("serial")
public class NoShockwaveException extends Exception {

	private static String message="Failed to shoot shockwave\r\n"+"Cause of Exception:\r\n" + 
			"exceptions.NoShockwaveException: Cannot release shockwave: no shockwave available";//preguntar si seria asi el mensaje
	
	public NoShockwaveException() {
		super(message);
	}

}
