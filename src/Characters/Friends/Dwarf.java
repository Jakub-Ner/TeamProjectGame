package game.TeamProjectGame.src.Characters.Friends;

import Cries.DwarvenCries;
import MovePattern.MovePattern;

public class Dwarf extends Friend {
    public Dwarf(MovePattern pattern){
        super(100,12,3, pattern, new DwarvenCries(), 'd');
    }

}
