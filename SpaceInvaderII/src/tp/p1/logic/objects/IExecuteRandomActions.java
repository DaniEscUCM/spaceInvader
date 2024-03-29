package tp.p1.logic.objects;

import tp.p1.logic.Game;
public interface IExecuteRandomActions {

	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
		}
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();
	}
	static boolean canGenerateRandomExplosiv(Game game) {
		return game.getRandom().nextDouble() < game.getLevel().getTurnExplodeFreq();
	}

}
