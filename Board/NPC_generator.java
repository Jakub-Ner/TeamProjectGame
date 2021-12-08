package game.TeamProjectGame.Board;

import game.TeamProjectGame.Characters.CharacterFactory;

import java.util.Random;

public class NPC_generator {
    final static int n = 10;
    public static void generateNPC (CharacterFactory characters){
        Random rand = new Random();
        for (int i=0; i<n; i++){
            CharacterFactory.addCharacter(rand.nextInt(6));
        }
    }
}
