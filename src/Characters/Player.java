package game.TeamProjectGame.src.Characters;


import Characters.Friends.Friend;
import Cries.Cry;

import java.io.Serial;
import java.io.Serializable;

public class Player extends Character implements Serializable {
	private Cry cry;

	@Serial
	private static final long serialVersionUID = 1553400894846351235L;

	/**
	 * Initializes players with stats of said Friend.
	 * It MUST NOT use NPCFactory to initialize itself
	 *
	 * @param type takes Friend which represents player's race
	 */
	public Player(Friend type) {
		super(type.getHp(), type.getDmg(), type.getSpeed(), 'B');
		firstCoordinates(0, 0);
	}

	public Cry getCry() {
		return this.cry;
	}

	public void setCry(Cry cry) {
		this.cry = cry;
	}
}
