package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Cries.BattleElvenCry;
import game.TeamProjectGame.Cries.FriendlyElvenCry;
import game.TeamProjectGame.MovePattern.MovePattern;

public class Elf extends Friend {

    public Elf(MovePattern pattern){
        super(60,6,8,"Laurion", pattern);
    }

    public void getBattleCry(){
        setCry(new BattleElvenCry());
        super.getBattleCry();
    }

    public void getFriendlyCry(){
        setCry(new FriendlyElvenCry());
        super.getFriendlyCry();
    }
}
