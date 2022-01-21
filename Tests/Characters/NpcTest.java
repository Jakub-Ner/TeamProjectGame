package Characters;

import Board.Board;
import Characters.Villains.Phantom;
import MovePattern.LPattern;
import MovePattern.MovePattern;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class NpcTest{
    @Test
    void movePatternTest(){
        MovePattern pattern = new LPattern();
        Phantom npc = new Phantom(pattern);
        npc.firstCoordinates(30, 20);
        Board.board = new char[35][100];
        for(int i=0; i<35; i++){
            Board.board[i]= new char[100];
            for (int j=0; j<100; j++){
              Board.board[i][j]=' ';
            }
        }
        int[] oldcoordinates = npc.oldCoordinates();
        npc.setSpeed(100);
        npc.move(Mockito.mock(Board.class), new JLabel());
        int[] vector = {npc.getY()-oldcoordinates[0], npc.getX()-oldcoordinates[1]};
        int kierunek;
        if(vector[0]==-1) {
            kierunek = 8;
        }
        else if(vector[0]==1){
            kierunek=2;
        }
        else if(vector[1]==-1){
            kierunek=6;
        }
        else{
            kierunek=4;
        }
        assertEquals(kierunek, pattern.pattern()[0]);
    }
}
