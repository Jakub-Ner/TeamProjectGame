package Cries;

import java.io.Serializable;

public class DwarvenCries implements Cry, Serializable {
	@Override
	public String battleShout() { return "*Battle cry in Dwarven*"; }

	@Override
	public String friendlyShout() { return "*Friendly greeting in Dwarven*"; }
}