package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Cries.ElvenCries;
import game.TeamProjectGame.MovePattern.MovePattern;

public class Elf extends Friend {

    public Elf(MovePattern movePattern){
        super(60,6,8, movePattern, new ElvenCries(), 'e');
    }

}
