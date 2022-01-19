package MeetingAndFight;

import Board.Board;
import Characters.Character;
import org.junit.jupiter.api.Test;

import static MeetingAndFight.MeetingAndFight.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class MeetingAndFightTest {

    @Test
    void meeting() {
    }

    @Test
    void playerFight() {

    }

    @Test
    void inFightShouldEnemyDie() {
        Character friend = mock(Character.class);
        Character enemy = mock(Character.class);
        Board board = mock(Board.class);
        board.board = new char [board.HEIGHT][board.WIDTH];

        friend.setSpeed(50);
        friend.setHp(1000);
        friend.setDmg(20);
        friend.setX(1);
        friend.setY(1);

        enemy.setSpeed(20);
        enemy.setHp(200);
        enemy.setDmg(5);
        enemy.setX(2);
        enemy.setY(2);

        Fight(friend, enemy, board);

        assertEquals('+', board.board[enemy.getY()][enemy.getX()]);
    }

    @Test
    void inFightShouldFriendDie() {
        Character friend = mock(Character.class);
        Character enemy = mock(Character.class);
        Board board = mock(Board.class);
        board.board = new char [board.HEIGHT][board.WIDTH];

        friend.setSpeed(50);
        friend.setHp(1);
        friend.setDmg(20);
        friend.setX(1);
        friend.setY(1);

        enemy.setSpeed(20);
        enemy.setHp(200);
        enemy.setDmg(5);
        enemy.setX(2);
        enemy.setY(2);

        Fight(friend, enemy, board);

        assertEquals('+', board.board[friend.getY()][friend.getX()]);
    }
}