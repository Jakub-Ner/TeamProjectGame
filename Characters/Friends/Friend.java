package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Characters.Npc;
import game.TeamProjectGame.Cries.Cry;
import game.TeamProjectGame.MovePattern.MovePattern;


public abstract class Friend extends Npc {

	protected Cry cry;

	public Friend(int hp, int dmg, int speed, MovePattern pattern, Cry cry, char symbol) {
		super(hp, dmg, speed, pattern, symbol);
		this.cry = cry;
	}

	public Cry getCry() {
		return this.cry;
	}

	public void setCry(Cry cry) {
		this.cry = cry;
	}

	@Override
	public String toString() {
		return "Your stats:\n" + "Health points:" + this.getHp() + "\n\t" +
				"Damage: " + this.getDmg() + "\n\t" + "Speed: " + this.getSpeed() + "\n";
	}
}
