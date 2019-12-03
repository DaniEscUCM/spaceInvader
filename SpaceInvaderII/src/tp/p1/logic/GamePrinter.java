package tp.p1.logic;


public abstract class GamePrinter {
	
	protected Game game;
	protected int x;
	protected int y;

	public GamePrinter(Game game, int x, int y){
		this.game = game;
		this.x =x;
		this.y = y;
		}
	
	public abstract GamePrinter parse(String[] gameWords);

}
