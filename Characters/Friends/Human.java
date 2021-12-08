package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Cries.src.*;


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
