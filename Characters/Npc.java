package game.TeamProjectGame.Characters;

import game.TeamProjectGame.Board.Board;

public abstract class Npc extends Character {

    //fields

    final private int wait = 10;

    MovePattern pattern;
    private int turn = wait;
    private int nextMove = 0;

    //constructor

    public Npc(int hp, int dmg, int speed, MovePattern pattern) {
        super(hp, dmg, speed);
        this.pattern = pattern;
    }

    //methods

    @Override
    public void move(Board board) {

        turn -= speed;

        if (turn <= 0) {

            moveCharacter(pattern.pattern[nextMove], board);

            if (nextMove >= pattern.pattern.length ) {
                nextMove = 0;
            }
            else nextMove++;

            turn = wait;

        }

    }


    //getters

    public int getNextMove() {
        return nextMove;
    }

    public int getTurn() {
        return turn;
    }

    public int getWait() {
        return wait;
    }

    public MovePattern getPattern() {
        return pattern;
    }

    //setters

    public void setNextMove(int nextMove) {
        this.nextMove = nextMove;
    }

    public void setPattern(MovePattern pattern) {
        this.pattern = pattern;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
