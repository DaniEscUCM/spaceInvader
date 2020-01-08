package exceptions;

@SuppressWarnings("serial")
public class NoEnoughPoints extends Exception {

	private static String message="Failed to buy\r\n" + "Cause of Exception:\r\n" + 
			"exceptions.NoEnoughPoints: Cannot buy super missile: No enough points to buy SuperMissile";
	
	public NoEnoughPoints() {
		super(message);
	}

}
