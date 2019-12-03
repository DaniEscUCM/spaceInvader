package exceptions;

public class NoSuperMissileAvaible extends Exception {

	private static String message="Cause of Exception:\r\n" +  
			"exceptions.NoSuperMissileAvaible: Cannot fire missile: no super missile has been bought";
	
	public NoSuperMissileAvaible() {
		super(message);
	}

}
