package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class Ovni extends EnemyShip implements IExecuteRandomActions{
	
	private final String draw = "O";
	private boolean enable;//ya no se crea y se quita
	private static int points=25;


	private static int x=9;
	private static int y=-1;
	private static int life=1;
	
	public Ovni(Game game) {
		super(game, x, y, life,points);
		enable=false;
	}
	
	public void move () {
		if(this.enable) {
			super.x--;
			if(isOut()) {
				this.enable=false;
				super.x=9;}
			
			}
		
	}
	
	public String toString() {
		return draw + "["+ super.life + "]"; 
	}
	
	@SuppressWarnings("static-access")
	public int getPoint() {
		return this.points;
	}
	
	public void computerAction() {
		if(!this.enable && IExecuteRandomActions.canGenerateRandomOvni(game)) {
			this.enable = true;super.y=0;}
	}
	
	public boolean isEnable() {
		return enable;
	}

	public void setEnable() {
		this.enable = false;
	}
	
	public void onDelete() {
		super.life=life;
		this.enable=false;
		super.x=x;
		super.y=y;
		game.receivePoints(this.getPoints());
	}
	
	public boolean receiveExplosivAttack(int damage) {
		this.enable=false;
		super.x=x;
		super.y=y;
		game.receivePoints(this.getPoints());
		game.enableShockWave();
		return true;
		}
	
	public boolean receiveMissileAttack(int damage) {
		this.enable=false;
		super.x=x;
		super.y=y;
		game.receivePoints(this.getPoints());
		game.enableShockWave();
		return true;
		}
	
	public boolean receiveShockWaveAttack(int damage) {
		this.enable=false;
		super.x=x;
		super.y=y;
		game.receivePoints(this.getPoints());
		return false;
	}
	
	@SuppressWarnings("static-access")
	public String stringify() {
		String s = this.draw + "," + super.x + "," + super.y + ";"+ super.life;
		return s;
	}
	
}
