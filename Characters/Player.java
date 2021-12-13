package game.TeamProjectGame.Characters;

import game.TeamProjectGame.Characters.Friends.Friend;

public class Player extends Character implements Serializable{
	/**
	 * Initializes players with stats of said Friend.
	 * It MUST NOT use NPCFactory to initialize itself
	 *
	 * @param type takes Friend which represents player's race
	 */
	public Player(Friend type){
		super(type.getHp(), type.getDmg(), type.getSpeed());
	}

}
