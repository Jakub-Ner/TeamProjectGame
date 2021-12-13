package game.TeamProjectGame.Characters.Villains;

import game.TeamProjectGame.Characters.Npc;
import game.TeamProjectGame.MovePattern.MovePattern;

public abstract class Villain extends Npc {

    public Villain(int hp, int dmg, int speed, MovePattern movePattern, char symbol) {
        super(hp, dmg, speed, movePattern, symbol);
    }
    
}
