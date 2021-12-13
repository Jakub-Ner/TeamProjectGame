package game.TeamProjectGame.Board;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.NPCFactory;

import java.util.Random;

public class NPC_generator {
    final static int n = 30;
    public static void generateNPC (Board board){

        Random rand = new Random();
        for (int i=0; i<n; i++){
            int type=rand.nextInt(6);
            NPCFactory.addCharacter(type);
            Character npc= NPCFactory.getCharacters().lastElement();
            do {
                npc.setX(rand.nextInt(board.WIDTH));
                npc.setY(rand.nextInt(board.HEIGHT));
            } while (Board.board[npc.getY()][npc.getX()]!=' ');

            switch(type){
                case 0:
                    Board.board[npc.getY()][npc.getX()]='h';
                    break;
                case 1:
                    Board.board[npc.getY()][npc.getX()]='d';
                    break;
                case 2:
                    Board.board[npc.getY()][npc.getX()]='e';
                    break;
                case 3:
                    Board.board[npc.getY()][npc.getX()]='O';
                    break;
                case 4:
                    Board.board[npc.getY()][npc.getX()]='P';
                    break;
                case 5:
                    Board.board[npc.getY()][npc.getX()]='D';
                    break;
            }
        }
    }
}
