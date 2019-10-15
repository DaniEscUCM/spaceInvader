package tp.p1.control;

import java.util.Scanner;

import tp.p1.logic.Game;
import tp.p1.logic.Move;

public class Controller {
	private Game game;
	private Scanner in;
	private final String promt = "Command > ";
	private boolean print = true;
	
	public Controller(Game game, Scanner in) {
		super();
		this.game = game;
		this.in = in;
	}
	
	public void run() {
		Move move = null;
		Command cm = null;
		int i = -1;
		while(game.getFinish()!= true) {
			if(print) {
				System.out.println(this.game.toString());
			}
			System.out.print(this.promt);
			String[] words =  in.nextLine().toLowerCase().trim().split("\\s+");
			// desarrollo del juego
			if(words.length == 3) { // comando move				
				if(words[0].equalsIgnoreCase("MOVE") || words[0].equalsIgnoreCase("M")) {
					cm = Command.MOVE;
					if(words[1].equalsIgnoreCase("RIGHT")|| words[1].equalsIgnoreCase("R")) {
						move = Move.RIGHT;
					}
					else if(words[1].equalsIgnoreCase("LEFT")|| words[1].equalsIgnoreCase("L")) {
						move = Move.LEFT;
					}
					if(Character.isDigit(words[2].charAt(0))) {
						i=Integer.parseInt(words[2]);
						//i = Character.getNumericValue(words[2].charAt(3));
						if(i >= 1 && i <= 2) {
							// se mueve en esa direccion y esos pasos;
							game.commands(cm, move, i);
						}
					}
				}
			}
			else if(words.length == 1) { // cualquier comando 
				if(words[0].equalsIgnoreCase("SHOOT") || words[0].equalsIgnoreCase("S")) {
					// DISPARA
					cm = Command.SHOOT;
				}
				else if(words[0].equalsIgnoreCase("SHOCKWAVE") || words[0].equalsIgnoreCase("W")) {
					// SHOCKWAVE = TRUE
					//game.setShockwave(true);
					cm = Command.SHOCKWAVE;
				}
				else if(words[0].equalsIgnoreCase("RESET") || words[0].equalsIgnoreCase("R")) {
					//RESET
					//game.reset();
					cm = Command.RESET;
				}
				else if(words[0].equalsIgnoreCase("LIST") || words[0].equalsIgnoreCase("L")) {
					//game.printList()
					cm = Command.LIST;
					print=false;
				}
				else if(words[0].equalsIgnoreCase("EXIT") || words[0].equalsIgnoreCase("E")) {
					//game.setFinish(true);
					cm = Command.EXIT;
				}
				else if(words[0].equalsIgnoreCase("HELP") || words[0].equalsIgnoreCase("H")) {
					//game.showHelp();
					cm = Command.HELP;
					print=false;
				}
				else if(words[0].equalsIgnoreCase("") || words[0].equalsIgnoreCase("N")) {
					print = true; // por poner algo
					cm = Command.NONE;
				}
				if(cm == null) {
					System.out.println("Invalid command. View command 'Help' or 'H'");
					print = false;
				}	
				else {
					game.commands(cm, move, i);
					
					
				}
			}
			if(cm==Command.MOVE||cm==Command.SHOCKWAVE||cm==Command.SHOOT||cm==Command.NONE) {
				print=true;
				
				game.update();
			}
			
		}
		// si wins = true...gana jugador, si no, false.
		if(game.getWins() == 1) {
			System.out.println("Player wins");
		}
		else if(game.getWins() == 2){
			System.out.println("Aliens win");
		}
		else {
			System.out.println("Game Over");
		}	
	}

}
