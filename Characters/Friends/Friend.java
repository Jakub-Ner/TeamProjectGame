package game.TeamProjectGame.Characters.Friends;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Cries.Cry;


public abstract class Friend extends Character {

    protected Cry cry;
    private String name;

    public Friend(){
        super();
    }

    public Friend(int hp, int dmg, int speed,String name){
        super(hp,dmg,speed);
    }

    public void getBattleCry(){
        this.cry.battleShout();
    }

    public void getFriendlyCry(){
        this.cry.friendlyShout();
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
