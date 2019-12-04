package tp.p1.control;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import tp.p1.logic.Game;

public class SaveCommand extends Command {
	
	private static String name = "save";
	private static String shortcut = "sa";
	private static String detail = " [sa]ve";
	private static String help = ": player save current game";
	private  String nameoffile;

	public SaveCommand(String nameOffile) {
		super(name, shortcut, detail, help);
		 nameoffile=nameOffile;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		/*try(BufferWriter in= new BufferWritter (new FileWriter(nameoffile)){
		 * 		in.write(game.stringify);
		 * }
		 * catch(iosException mife) {
		      throw new CommandExecuteException( mife.getMessage());
		  }
		 * */
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command cm=null;
		if(matchCommandName(commandWords[0])) {
			if(commandWords.length==2) {
				cm=new SaveCommand(commandWords[1]);				
			}
			else {
				System.out.println("THE SAVE COMMAND ONLY WITH A NAME OF FILE");
			}
		}
		return cm;
	}

	@Override
	protected boolean printGame() {
		// TODO Auto-generated method stub
		return true;
	}

}
