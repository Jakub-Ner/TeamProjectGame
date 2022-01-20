package MeetingAndFight;

import Board.Board;
import Characters.Character;
import Characters.Friends.Friend;
import Characters.Player;
import Characters.Villains.Villain;
import Cries.Cry;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.verification.VerificationMode;
import org.powermock.*;

import javax.swing.*;

import static MeetingAndFight.MeetingAndFight.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class MeetingAndFightTest {

    //checks message sent to JLabel in case of 2 friends
    @Test
    void meeting() {
        Player player = mock(Player.class);
        Friend friend = mock(Friend.class);
        Board board = mock(Board.class);
        board.board = new char [board.HEIGHT][board.WIDTH];
        JLabel messages = new JLabel();

        Cry cry = mock(Cry.class);
        MeetingAndFight m = mock(MeetingAndFight.class);

        when(player.getCry()).thenReturn(cry);
        when(cry.friendlyShout()).thenReturn("*Battle cry in Human Language*");

        Meeting (player,friend,board,messages);

        assertEquals("*Battle cry in Human Language*", messages.getText());
    }

    //checks the message sent to JLabel in case our player won the fight
    @Test
    void inPlayerFightShouldWin() {
        Player friend = mock(Player.class);
        Character enemy = mock(Character.class);
        Board board = mock(Board.class);
        board.board = new char [board.HEIGHT][board.WIDTH];
        JLabel messages = new JLabel();

        when(friend.getHp()).thenReturn(1);

        PlayerFight(friend,enemy,board,messages);

        assertEquals("You won the fight!", messages.getText());
    }

    //checks the message to JLabel in case our player dies
    @Test
    void inPlayerFightShouldLose() {
        Player friend = mock(Player.class);
        Character enemy = mock(Character.class);
        Board board = mock(Board.class);
        board.board = new char [board.HEIGHT][board.WIDTH];
        JLabel messages = new JLabel();

        when(friend.getHp()).thenReturn(0);

        PlayerFight(friend,enemy,board,messages);

        assertEquals("You lost the fight!", messages.getText());
    }

    //checks the board in case enemy dies
    //also tests the first friend's move
    @Test
    void inFightShouldEnemyDie() {
        Character friend = mock(Character.class);
        Character enemy = mock(Character.class);
        Board board = mock(Board.class);
        board.board = new char [board.HEIGHT][board.WIDTH];

        when(friend.getHp()).thenReturn(10);
        when(friend.getSpeed()).thenReturn(10);
        when(enemy.getHp()).thenReturn(0);
        when(enemy.getSpeed()).thenReturn(0);

        Fight(friend, enemy, board);

        assertEquals('+', board.board[enemy.getY()][enemy.getX()]);
    }

    //checks the board in case friend dies
    @Test
    void inFightShouldFriendDie() {
        Character friend = mock(Character.class);
        Character enemy = mock(Character.class);
        Board board = mock(Board.class);
        board.board = new char [board.HEIGHT][board.WIDTH];

        when(friend.getHp()).thenReturn(0);

        Fight(friend, enemy, board);

        assertEquals('+', board.board[friend.getY()][friend.getX()]);
    }
}



















//
//    @Test
//    void meeting() {
//        Player player = mock(Player.class);
//        Villain enemy = mock(Villain.class);
//        Board board = mock(Board.class);
//        board.board = new char [board.HEIGHT][board.WIDTH];
//        JLabel messages = new JLabel();
//
//        Cry cry = mock(Cry.class);
//        MeetingAndFight m = mock(MeetingAndFight.class);
//
////        PowerMockito.doNothing().when(StaticResource.class, "getResource", anyString());
//        doNothing().doThrow(Exception.class).when(MeetingAndFight.class);
//
//        when(player.getCry()).thenReturn(cry);
//        when(cry.battleShout()).thenReturn("*Battle cry in Human Language*");
//
//        Meeting (player,enemy,board,messages);
//
//        assertEquals("*Battle cry in Human Language*", messages.getText());
//    }