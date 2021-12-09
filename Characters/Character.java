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

    public void moveCharacter(int further, Board board) {

        switch(further) {
            case 2:
            {
                if ( y < board.HEIGHT ) {

                    if ( Board.board[y+1][x] == ' ' ) {
                        y++;
                    }
                }

                break;

            }
            case 8:
            {
                if ( y > 0 ) {

                    if ( Board.board[y-1][x] == ' ' ) {
                        y--;
                    }
                }

                break;
            }
            case 6:
            {
                if ( x < board.WIDTH ) {

                    if ( Board.board[y][x+1] == ' ' ) {
                        x++;
                    }
                }

                break;
            }
            case 4:
            {
                if ( x > 0 ) {

                    if ( Board.board[y][x-1] == ' ' ) {
                        x--;
                    }
                }

                break;
            }
            default: {
                System.out.println("Please use numpad to move");
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
