package game.TeamProjectGame.Characters;

import game.TeamProjectGame.Characters.Friends.Friend;
import game.TeamProjectGame.Cries.Cry;

public class Player extends Character {
	private Cry cry;

	/**
	 * Initializes players with stats of said Friend.
	 * It MUST NOT use NPCFactory to initialize itself
	 *
	 * @param type takes Friend which represents player's race
	 */
	public Player(Friend type){
		super(type.getHp(), type.getDmg(), type.getSpeed(), 'B');
		this.cry = type.getCry();
	}

	public Cry getCry(){
		return this.cry;
	}

}
