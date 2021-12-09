package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Cries.BattleDwarvenCry;
import game.TeamProjectGame.Cries.FriendlyDwarvenCry;

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
