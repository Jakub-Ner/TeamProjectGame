package game.TeamProjectGame.Characters;

public enum NPCTypes {
	HUMAN, DWARF, ELF, ORC, PHANTOM, DRAGON;

	@Override
	public String toString() {
		return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
	}
}
