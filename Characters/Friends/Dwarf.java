package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Cries.src.*;

public class Dwarf extends Friend {
    public Dwarf(){
        super(100,12,3,"Murdoch");
    }

    public void getBattleDwarvenCry(){
        setCry(new BattleDwarvenCry());
        this.cry.shout();
    }

    public void getFriendlyDwarvenCry(){
        setCry(new FriendlyDwarvenCry());
        this.cry.shout();
    }
}
