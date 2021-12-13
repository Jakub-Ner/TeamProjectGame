package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Cries.ElvenCries;
import game.TeamProjectGame.Pattern.MovePattern;

public class Elf extends Friend {

    public Elf(MovePattern pattern){
        super(60,6,8,"Laurion", pattern, new ElvenCries());
    }

}
