package game.TeamProjectGame.Characters;

import game.TeamProjectGame.Board.Board;

import javax.swing.*;
import java.util.Base64;


public abstract class Character {

    //fields
    private int x = 0;
    private int y = 0; //coordinates

    private int hp;
    private int dmg;
    private int speed;

    //constructors

    public Character() {

    }

    public Character(int hp, int dmg, int speed) {

        this.hp = hp;
        this.dmg = dmg;
        this.speed = speed;

    }

    //methods

    public void moveCharacter(String further, Board board) {

        switch(further) {
            case "w":
            {
                if ( y < board.HEIGHT ) {

                    if ( Board.board[y+1][x] == ' ' ) {
                        y++;
                    }
                }

            }
            case "s":
            {
                if ( y > 0 ) {

                    if ( Board.board[y-1][x] == ' ' ) {
                        y--;
                    }
                }
            }
            case "d":
            {
                if ( x < board.WIDTH ) {

                    if ( Board.board[y][x+1] == ' ' ) {
                        x++;
                    }
                }
            }
            case "a":
            {
                if ( x > 0 ) {

                    if ( Board.board[y][x-1] == ' ' ) {
                        x--;
                    }
                }
            }
            default: {
                //System.out.println("Please use WSAD to move");
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
}
