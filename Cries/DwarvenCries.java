package game.TeamProjectGame.Cries;

import java.io.Serializable;

public class DwarvenCries implements Cry, Serializable {
	@Override
	public void battleShout() { System.out.println("*Battle cry in Dwarven*"); }
	@Override
	public void friendlyShout() { System.out.println("*Friendly greeting in Dwarven*"); }
}