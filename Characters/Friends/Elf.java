package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Cries.src.*;

public class Elf extends Friend {

    public Elf(){
        super(60,6,8,"Laurion");
    }

    public void getBattleElvenCry(){
        setCry(new BattleElvenCry());
        this.cry.shout();
    }

    public void getFriendlyElvenCry(){
        setCry(new FriendlyElvenCry());
        this.cry.shout();
    }
}
