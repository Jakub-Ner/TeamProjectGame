package game.TeamProjectGame.Cries;

import java.io.Serializable;

public class HumanCries implements Cry, Serializable {
	@Override
	public void battleShout() { System.out.println("*Battle cry in Human Language*"); }
	@Override
	public void friendlyShout() { System.out.println("*Friendly greeting in Human Language*"); }
}