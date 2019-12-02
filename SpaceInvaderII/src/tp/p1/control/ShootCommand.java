package tp.p1.control;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import tp.p1.logic.Game;

public class ShootCommand extends Command{
	private static String name = "shoot";
	private static String shortcut = "S";
	private static String detail = " [S]hoot";
	private static String help = ": UCM-Ship launches a missile, if [SM]supermissile will shoot avaible super missile.";
	private String nameSuper = "supermissile";
	private String shortcutSuper = "SM";
	private boolean superm;

	public ShootCommand(boolean sup) {
		super(name, shortcut, detail, help);
		this.superm=sup;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		/*if(!game.thereisLaser()) {
			game.shoot();
			game.update();
			game.computerAction();
			}*/
		game.update();
		if(superm) {return game.shootSuperMis();}
		else {	return game.shootMissile();		}
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command cm=null;
		superm=false;
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length>1) {
				if(this.shortcutSuper.equalsIgnoreCase(commandWords[1])||this.nameSuper.equalsIgnoreCase(commandWords[1])) {
					superm= true;
				}
				else {
					CommandParseException miExc = new CommandParseException("UNKNOWN COMMAND NEXT TO SHOOT COMMAND"); 
					 throw miExc;

				}
			}
			cm=new ShootCommand(superm);
			}
		return cm;
	}

}
