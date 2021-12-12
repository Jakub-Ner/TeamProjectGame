package game.TeamProjectGame.Characters.Villains;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.Npc;

public abstract class Villain extends Npc {

    public Villain(int hp, int dmg, int speed, MovePattern pattern) {
        super(hp, dmg, speed, pattern);
    }
    
}
