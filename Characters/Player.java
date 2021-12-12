package game.TeamProjectGame.Characters;

import game.TeamProjectGame.Characters.Friends.Friend;

public class Player extends Friend {
	/**
	 * Initializes players with stats of said Friend
	 *
	 * @param type takes Friend which represents player's race
	 */
	public Player(Friend type){
		super(type.getHp(), type.getDmg(), type.getSpeed(), type.getName());
	}

}
