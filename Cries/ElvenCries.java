package game.TeamProjectGame.Cries;

import java.io.Serializable;

public class ElvenCries implements Cry, Serializable {
	@Override
	public void battleShout() { System.out.println("*Battle cry in Elvish*"); }

	@Override
	public void friendlyShout() { System.out.println("*Friendly greeting in Elvish*"); }
}