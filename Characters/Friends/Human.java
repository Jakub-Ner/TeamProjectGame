package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Cries.BattleHumanCry;
import game.TeamProjectGame.Cries.FriendlyHumanCry;


public class Human extends Friend {

    public Human(){
        super(80,9,5,"Talwyn");
    }

    public void getBattleHumanCry(){
        setCry(new BattleHumanCry());
        this.cry.shout();
    }

    public void getFriendlyHumanCry(){
        setCry(new FriendlyHumanCry());
        this.cry.shout();
    }
}
