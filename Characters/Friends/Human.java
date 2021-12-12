package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Cries.BattleElvenCry;
import game.TeamProjectGame.Cries.BattleHumanCry;
import game.TeamProjectGame.Cries.FriendlyElvenCry;
import game.TeamProjectGame.Cries.FriendlyHumanCry;


public class Human extends Friend {

    public Human(MovePattern pattern){
        super(80,9,5,"Talwyn", pattern);
    }

    public void getBattleCry(){
        setCry(new BattleHumanCry());
        super.getBattleCry();
    }

    public void getFriendlyCry(){
        setCry(new FriendlyHumanCry());
        super.getFriendlyCry();
    }
}
