package tp.p1.control;

import tp.p1.logic.Game;

public class ShootCommand extends Command{
	private static String name = "shoot";
	private static String shortcut = "S";
	private static String detail = " [S]hoot";
	private static String help = ": UCM-Ship launches a missile.";

	public ShootCommand() {
		super(name, shortcut, detail, help);
	}

	@Override
	public boolean execute(Game game) {
		if(!game.thereisLaser()) {
			game.shoot();
			game.update();
			game.computerAction();
			}
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command cm=null;
		if(matchCommandName(commandWords[0])) {cm=new ShootCommand();}
		return cm;
	}

}
