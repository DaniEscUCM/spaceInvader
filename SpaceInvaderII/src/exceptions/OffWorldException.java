package exceptions;

@SuppressWarnings("serial")
public class OffWorldException extends Exception {
	
//tal vez se le pueda aplicar a las dem�s naves, aunque no deber�an salirse del board
	private static String message="Failed to move\r\n"+"Cause of Exception:\r\n" + 
			"exceptions.OffWorldException: Cannot perform move: ship too near border";//preguntar si seria asi el mensaje

	public OffWorldException() {
		super(message);
	}

}
