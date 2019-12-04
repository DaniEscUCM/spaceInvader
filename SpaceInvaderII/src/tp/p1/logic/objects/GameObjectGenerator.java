package tp.p1.logic.objects;

import tp.p1.logic.Game;

public class GameObjectGenerator {

	private static GameObject[] availableGameObjects = {
			new UCMShip(null, 0, 0),
			new Ovni(null),
			new RegularShip(null, 0, 0),
			new DestroyerShip(null, 0, 0),
			new ExplosivShip(null, 0, 0, 0, 0, 0, null),
			//new ShockWave(),
			new Bomb(null, 0, 0, null),
			new UCMShipLaser(null, 0, 0),
			new SuperMisil(null, 0, 0)
		};
	/*	
	public static GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier)
				throws FileContentsException {
			GameObject gameObject = null;
		for (GameObject go: availableGameObjects) {
			gameObject = go.parse(stringFromFile, game, verifier);
			if (gameObject != null) break;
		}
		return gameObject;
	}*/

}