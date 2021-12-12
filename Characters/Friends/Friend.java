package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.Npc;
import game.TeamProjectGame.Cries.BattleElvenCry;
import game.TeamProjectGame.Cries.Cry;
import game.TeamProjectGame.Cries.FriendlyElvenCry;


public abstract class Friend extends Npc {

    protected Cry cry;
    private String name;

    public Friend(){
        super();
    }

    public Friend(int hp, int dmg, int speed,String name, MovePattern pattern){
        super(hp,dmg,speed, pattern);
        this.name = name;
    }

    public void getBattleCry(){
        this.cry.shout();
    }

    public void getFriendlyCry(){
        this.cry.shout();
    }

    public void setCry(Cry cry) {
        this.cry = cry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Your stats:\n" + "Health points:" + this.getHp() + "\n\t" +
        "Damage: " + this.getDmg() + "\n\t" + "Speed: " + this.getSpeed() + "\n";
    }
}
