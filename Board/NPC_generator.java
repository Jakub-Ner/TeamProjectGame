package game.TeamProjectGame.Board;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.CharacterFactory;

import java.util.Random;

public class NPC_generator {
    final static int n = 10;
    public static void generateNPC (char[][] board){
        Random rand = new Random();
        for (int i=0; i<n; i++){
            int type=rand.nextInt(6);
            CharacterFactory.addCharacter(type);
            Character npc=CharacterFactory.getCharacters().lastElement();
            do {
                npc.setX(rand.nextInt(board.length) + 1);
                npc.setY(rand.nextInt(board[0].length) + 1);
            } while (board[npc.getX()][npc.getY()]!=' ');
            switch(type){
                case 0: board[npc.getX()][npc.getY()]='h';
                case 1: board[npc.getX()][npc.getY()]='d';
                case 2: board[npc.getX()][npc.getY()]='e';
                case 3: board[npc.getX()][npc.getY()]='O';
                case 4: board[npc.getX()][npc.getY()]='P';
                case 5: board[npc.getX()][npc.getY()]='D';
            }
        }
    }
}
