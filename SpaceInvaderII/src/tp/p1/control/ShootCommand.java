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

	public ShootCommand() {
		super(name, shortcut, detail, help);
		superm=false;
	}

	@Override
	public boolean execute(Game game) {
		/*if(!game.thereisLaser()) {
			game.shoot();
			game.update();
			game.computerAction();
			}*/
		game.update();
		return game.shootMissile();//por entrada se diria si es super misil
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		if(matchCommandName(commandWords[0])) {
			cm=new ShootCommand();
			superm=this.shortcutSuper.equalsIgnoreCase(name) ||	this.nameSuper.equalsIgnoreCase(name);
			}
		return cm;
	}

}
