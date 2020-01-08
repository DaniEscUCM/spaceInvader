package tp.p1;

import java.util.Random;
import java.util.Scanner;
import tp.p1.control.Controller;
import tp.p1.logic.Game;
import tp.p1.logic.Level;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Level level = null;
		boolean ok = true; // para controlar errores de argumentos
		Long seed = (long) new Random().nextInt(-(int) System.currentTimeMillis());// semilla por defecto
		
		if(args.length > 0 && args.length <= 2) {
			if(args[0].equalsIgnoreCase("EASY")) {
				level = Level.EASY;
			}else if (args[0].equalsIgnoreCase("HARD")) {
				level = Level.HARD;
			}else if(args[0].equalsIgnoreCase("INSANE") ) {
				level = Level.INSANE;
			}else {
				System.out.println("Usage: Main <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
				ok = false;
			}		
			
			if(args.length > 1) {
				
				if (!Character.isDigit(args[1].charAt(0))) {
					System.out.println("Incorrect parameters. Seed is a number");
					ok = false;
				}	
				else {
					seed = Long.parseLong(args[1]);
				}
			}
			
			if(ok) {
				Random rand = new Random(seed);
				Game game = new Game(level, rand);
				Controller control = new Controller(game, in);
				control.run();

			}
		}
		
		else
			System.out.println("Usage: Main <EASY|HARD|INSANE> [seed]");
		
	}
	

}