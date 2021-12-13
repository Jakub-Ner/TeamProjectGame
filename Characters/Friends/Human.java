package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Cries.HumanCries;
import game.TeamProjectGame.Pattern.MovePattern;


public class Human extends Friend {

    public Human(MovePattern pattern){
        super(80,9,5,"Talwyn", pattern, new HumanCries());
    }

}
