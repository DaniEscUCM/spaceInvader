package tp.p1.control;

import exceptions.CommandExecuteException;

public interface IPlayerController {
	
	// Player actions
	public boolean move (int numCells);
	public boolean shootMissile() throws CommandExecuteException;
	public boolean shockWave();
	public boolean shootSuperMis();
	
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}
