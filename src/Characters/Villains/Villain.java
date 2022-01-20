package game.TeamProjectGame.src.Characters.Villains;


import Characters.Npc;
import MovePattern.MovePattern;

public abstract class Villain extends Npc {

    public Villain(int hp, int dmg, int speed, MovePattern movePattern, char symbol) {
        super(hp, dmg, speed, movePattern, symbol);
    }
    
}
