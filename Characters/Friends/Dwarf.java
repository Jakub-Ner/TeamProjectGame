package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Cries.BattleDwarvenCry;
import game.TeamProjectGame.Cries.FriendlyDwarvenCry;
import game.TeamProjectGame.MovePattern.MovePattern;

public class Dwarf extends Friend {
    public Dwarf(MovePattern pattern){
        super(100,12,3,"Murdoch", pattern);
    }

    public void getBattleCry(){
        setCry(new BattleDwarvenCry());
        super.getBattleCry();
    }

    public void getFriendlyCry(){
        setCry(new FriendlyDwarvenCry());
        super.getFriendlyCry();
    }
}
