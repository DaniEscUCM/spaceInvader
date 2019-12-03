package tp.p1.control;

import exceptions.CommandExecuteException;
import exceptions.MissileInFlightException;
import exceptions.NoShockwaveException;
import exceptions.NoSuperMissileAvaible;
import exceptions.OffWorldException;

public interface IPlayerController {
	
	// Player actions
	public boolean move (int numCells) throws OffWorldException;
	public boolean shootMissile() throws MissileInFlightException;
	public boolean shockWave() throws NoShockwaveException;
	public boolean shootSuperMis() throws MissileInFlightException,NoSuperMissileAvaible;
	
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}
