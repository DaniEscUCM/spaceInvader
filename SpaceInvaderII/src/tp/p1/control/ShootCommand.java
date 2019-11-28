package tp.p1.control;

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
	public boolean execute(Game game) {
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
	public Command parse(String[] commandWords) {
		Command cm=null;
		superm=false;
		if(matchCommandName(commandWords[0])) {
			superm=commandWords.length>1 
					&&(this.shortcutSuper.equalsIgnoreCase(commandWords[1])||this.nameSuper.equalsIgnoreCase(commandWords[1]));
			cm=new ShootCommand(superm);
			}
		return cm;
	}

}
