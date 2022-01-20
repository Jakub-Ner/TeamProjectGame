package game.TeamProjectGame.src.Characters.Friends;


import Cries.HumanCries;
import MovePattern.MovePattern;

public class Human extends Friend {

	public Human(MovePattern movePattern) {
		super(80, 9, 5, movePattern, new HumanCries(), 'h');
	}

}
