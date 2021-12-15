package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Characters.Npc;
import game.TeamProjectGame.Cries.Cry;
import game.TeamProjectGame.MovePattern.MovePattern;


public abstract class Friend extends Npc {

    protected Cry cry;
    private String name;

    public Friend(int hp, int dmg, int speed, String name, MovePattern pattern, Cry cry, char symbol){
        super(hp,dmg,speed, pattern, symbol);
        this.cry = cry;
    }

    public void getBattleCry(){
        this.cry.battleShout();
    }

    public void getFriendlyCry(){
        this.cry.friendlyShout();
    }

    public Cry getCry(){ return this.cry;}

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
