package game.TeamProjectGame.Cries;

import java.io.Serializable;

public class HumanCries implements Cry, Serializable {
	@Override
	public String battleShout() { return "*Battle cry in Human Language*"; }
	@Override
	public String friendlyShout() { return "*Friendly greeting in Human Language*"; }
}