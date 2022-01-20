package Board;
import Characters.Character;
import Characters.Friends.Human;
import Characters.Player;
import Main.Game;
import MovePattern.SquarePattern;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
public class BoardTest {


    @Test
    public void ShouldBeCorrectHeight(){
        Player dummy = mock(Player.class);
        Board board = new Board(dummy);

        assertEquals(board.HEIGHT,board.board.length);
    }


    @Test
    public void ShouldBeCorrectWidth(){
        Player dummy = mock(Player.class);
        Board board = new Board(dummy);

        assertEquals(board.WIDTH,board.board[0].length);
    }

    @Test
    public void ShouldBeOnlyValidCharacters(){
        Player dummy = mock(Player.class);
        Board board = new Board(dummy);

        for(int Y=0;Y<board.HEIGHT;Y++){
            for(int X = 0;X<board.WIDTH;X++){
                Assert.assertTrue("X#B dheOPD".contains(String.valueOf(board.board[Y][X])));
            }

        }


    }

    @Test
    public void shouldBeStartingSpace(){
        Player dummy = mock(Player.class);
        Board board = new Board(dummy);
        char[] CorrectArr = new char[] {'B',' ',' ',' '};
        char[] result = new char[] {board.board[0][0],board.board[1][0],board.board[0][1],board.board[1][1]};
        assertArrayEquals(result,CorrectArr);
    }


}
