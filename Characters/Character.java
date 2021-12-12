package game.TeamProjectGame.Characters;

import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.MeetingAndFight.MeetingAndFight;

import javax.swing.*;
import java.util.Base64;


public abstract class Character {

    //fields
    private int x = 0;
    private int y = 0; //coordinates

    private int hp;
    private int dmg;
    protected int speed;

    //constructor

    public Character() {
        hp = 1;
        dmg = 1;
        speed = 1;

    }

    public Character(int hp, int dmg, int speed) {

        this.hp = hp;
        this.dmg = dmg;
        this.speed = speed;

    }

    //methods

    private void meet(int x, int y, Board board) {

        for (int i = 0; i < CharacterFactory.getCharacters().size(); i++) {
            if ( (CharacterFactory.getCharacters().elementAt(i).getX() == x) && (CharacterFactory.getCharacters().elementAt(i).getY() == y)) {
                MeetingAndFight.Meeting(this, CharacterFactory.getCharacters().elementAt(i), board);
                break;
            }
        }
    }

    private boolean surroundings(Board board) {
        String npc = "hdeDOP";

        if ( ( y+1 <= board.HEIGHT) && (npc.indexOf( board.board[y+1][x] ) != -1) ) {
            meet( (y+1), x, board);
        }

        if ( ( y-1 >= 0) && (npc.indexOf( board.board[y-1][x] ) != -1) ) {
            meet( (y-1), x, board );
        }

        if ( ( x-1 >= 0) && (npc.indexOf( board.board[y][x-1] ) != -1) ) {
            meet( y, (x-1), board );
        }

        if ( ( x+1 <= board.WIDTH) && (npc.indexOf( board.board[y][x+1] ) != -1) ) {
            meet( y, (x+1), board );
            meet( (y+1), x );
            return true;
        }

        if ( ( y-1 >= 0) && (npc.indexOf( board.board[y-1][x] ) != -1) ) {
            meet( (y-1), x );
            return true;
        }

        if ( ( x-1 >= 0) && (npc.indexOf( board.board[y][x-1] ) != -1) ) {
            meet( y, (x-1) );
            return true;
        }

        if ( ( x+1 <= board.WIDTH) && (npc.indexOf( board.board[y][x+1] ) != -1) ) {
            meet( y, (x+1) );
            return true;
        }
        return false;
    }

    public void moveCharacter(int further, Board board) {

        switch(further) {
            case 2:
            {
                if ( y < board.HEIGHT ) {

                    if ( Board.board[y+1][x] == ' ' ) {
                        y++;
                    }

                }

                surroundings(board);
                break;

            }
            case 8:
            {
                if ( y > 0 ) {

                    if ( Board.board[y-1][x] == ' ' ) {
                        y--;
                    }
                }

                surroundings(board);
                break;

            }
            case 6:
            {
                if ( x < board.WIDTH ) {

                    if ( Board.board[y][x+1] == ' ' ) {
                        x++;
                    }
                }

                surroundings(board);
                break;

            }
            case 4:
            {
                if ( x > 0 ) {

                    if ( Board.board[y][x-1] == ' ' ) {
                        x--;
                    }
                }

                surroundings(board);
                break;

            }
            default: {
                System.out.println("Please use NumPad to move");
                break;
            }

        }

    }

    //geters

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    //seters

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public int getDmg() {
        return dmg;
    }

    public int getSpeed() {
        return speed;
    }
}
