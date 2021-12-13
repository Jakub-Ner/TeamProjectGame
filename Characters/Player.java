package game.TeamProjectGame.Characters;

import game.TeamProjectGame.Characters.Friends.Friend;


import java.io.Serial;
import java.io.Serializable;

public class Player extends Character implements Serializable {
	
	 @Serial
   	 private static final long serialVersionUID = 1553400894846351235L;
	
	/**
	 * Initializes players with stats of said Friend.
	 * It MUST NOT use NPCFactory to initialize itself
	 *
	 * @param type takes Friend which represents player's race
	 */
	public Player(){
	}
	public Player(Friend type){
		super(type.getHp(), type.getDmg(), type.getSpeed());
	}

}
