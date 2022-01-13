package game.TeamProjectGame.Cries;

import java.io.Serializable;

public class ElvenCries implements Cry, Serializable {
	@Override
	public String battleShout() { return "*Battle cry in Elvish*"; }

	@Override
	public String friendlyShout() { return "*Friendly greeting in Elvish*"; }
}