package game.TeamProjectGame.Board;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.NPCFactory;

import java.util.Random;

public class NPC_generator {
    final static int n = 30;
    public static void generateNPC (char[][] board){
        Random rand = new Random();
        for (int i=0; i<n; i++){
            int type=rand.nextInt(6);
            NPCFactory.addCharacter(type);
            Character npc= NPCFactory.getCharacters().lastElement();
            do {
                npc.setX(rand.nextInt(board.length));
                npc.setY(rand.nextInt(board[0].length));
            } while (board[npc.getX()][npc.getY()]!=' ');
            switch(type){
                case 0:
                    board[npc.getX()][npc.getY()]='h';
                    break;
                case 1:
                    board[npc.getX()][npc.getY()]='d';
                    break;
                case 2:
                    board[npc.getX()][npc.getY()]='e';
                    break;
                case 3:
                    board[npc.getX()][npc.getY()]='O';
                    break;
                case 4:
                    board[npc.getX()][npc.getY()]='P';
                    break;
                case 5:
                    board[npc.getX()][npc.getY()]='D';
                    break;
            }
        }
    }
}
