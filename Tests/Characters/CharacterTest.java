package Characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Board.Board;
import Characters.Character;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharacterTest {

    private Character player;
    private Board board;

    private int []lastMove = {1,1};
    private int []coordinates = {0,0,-1,-1,0,-1,-1,0,14,2,3,10,15,1}; //7 pairs of coordinates, -1 values will be replaced in setUp
    private JLabel messages = new JLabel("a");

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception{

        player = mock (Character.class);
        player.firstCoordinates(1,1);

        board = mock (Board.class);
        board.board = new char [board.HEIGHT][board.WIDTH];
        int X = board.WIDTH;
        int Y = board.HEIGHT;
        coordinates [2]=Y-1;
        coordinates [3]=X-1;
        coordinates [5]=X-1;
        coordinates [6]=Y-1;
    }

    @org.junit.jupiter.api.Test
    void moveCharacter () {
        for (int i=0; i<coordinates.length; i+=2) {
            int y=coordinates[i];
            int x=coordinates[i+1];

            if (Board.board[y][x]!=' ') continue;

            player.setY(y);
            player.setX(x);
            player.moveCharacter(2, board, messages);
            if (y+1 < board.HEIGHT) {
                if (Board.board[y+1][x] == ' ') {
                    assertEquals(y + 1, player.getY());
                    assertEquals(x, player.getX());
                }
            } else {
                assertEquals(y,player.getY());
                assertEquals(x,player.getX());
            }

            player.setY(y);
            player.setX(x);
            player.moveCharacter(8, board, messages);
            if (y>0) {
                if (Board.board[y - 1][x] == ' ') {
                    assertEquals(y - 1, player.getY());
                    assertEquals(x, player.getX());
                }
            } else {
                assertEquals(y, player.getY());
                assertEquals(x, player.getX());
            }


            player.setY(y);
            player.setX(x);
            player.moveCharacter(6, board, messages);
            if (x+1< board.WIDTH) {
                if (Board.board[y][x + 1] == ' ') {
                    assertEquals(y, player.getY());
                    assertEquals(x + 1, player.getX());
                }
            } else {
                assertEquals(y, player.getY());
                assertEquals(x, player.getX());
            }


            player.setY(y);
            player.setX(x);
            player.moveCharacter(4, board, messages);
            if (x>0) {
                if (Board.board[y][x - 1] == ' ') {
                    assertEquals(y, player.getY());
                    assertEquals(x - 1, player.getX());
                }
            } else {
                assertEquals(y, player.getY());
                assertEquals(x, player.getX());
            }

            player.setY(y);
            player.setX(x);
            player.moveCharacter(32, board, messages);

            assertEquals(y, player.getY());
            assertEquals(x, player.getX());

        }
    }

    @org.junit.jupiter.api.Test
    void oldCoordinates() {
        lastMove[0]= player.getY();
        lastMove[1]= player.getX();

        //System.out.println("lm0: " + lastMove[0] + " lm1: " + lastMove[1]); why it doesn't work????????

        for (int i=0; i<10; i+=2) {
            player.setY(lastMove[0]);
            player.setX(lastMove[1]);
            player.moveCharacter(i, board, messages);
            assertArrayEquals(lastMove, player.oldCoordinates());
        }
    }
}