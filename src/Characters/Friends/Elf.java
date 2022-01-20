package game.TeamProjectGame.src.Characters.Friends;


import Cries.ElvenCries;
import MovePattern.MovePattern;

public class Elf extends Friend {

	public Elf(MovePattern movePattern) {
		super(60, 6, 8, movePattern, new ElvenCries(), 'e');
	}
}
