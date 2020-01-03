package tp.p1.logic.objects;


public class GameObjectGenerator {

	@SuppressWarnings("unused")
	private static GameObject[] availableGameObjects = {//todos los objetos misiles y naves
			new UCMShip(null, 0, 0),
			new Ovni(null),
			new RegularShip(null, 0, 0),
			new DestroyerShip(null, 0, 0),
			new ExplosivShip(null, 0, 0, 0, 0, 0, null),
			new Bomb(null, 0, 0, null),
			new UCMShipLaser(null, 0, 0),
			new SuperMisil(null, 0, 0)
	};

}
