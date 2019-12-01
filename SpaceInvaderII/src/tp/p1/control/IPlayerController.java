package tp.p1.control;

import exceptions.CommandExecuteException;
import exceptions.MissileInFlightException;
import exceptions.OffWorldException;

public interface IPlayerController {
	
	// Player actions
	public boolean move (int numCells) throws OffWorldException;
	public boolean shootMissile() throws MissileInFlightException;
	public boolean shockWave() throws MissileInFlightException;
	public boolean shootSuperMis() throws MissileInFlightException;
	
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}
