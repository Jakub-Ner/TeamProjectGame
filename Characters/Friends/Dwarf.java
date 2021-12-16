package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Cries.DwarvenCries;
import game.TeamProjectGame.MovePattern.MovePattern;

public class Dwarf extends Friend {
    public Dwarf(MovePattern pattern){
        super(100,12,3, pattern, new DwarvenCries(), 'd');
    }

}
