package game.TeamProjectGame.Characters;

import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.MovePattern.MovePattern;

import java.io.Serializable;

public abstract class Npc extends Character implements Serializable {

	//fields

	final private int wait = 10;

	MovePattern pattern;
	private int turn = wait;
	private int nextMove = 0;

	//constructor

	public Npc(int hp, int dmg, int speed, MovePattern pattern, char symbol) {
		super(hp, dmg, speed, symbol);
		this.pattern = pattern;
	}

	//methods

	public void move(Board board) {
		if(getHp() <= 0) return;

		turn -= speed;

		if (turn <= 0) {

			moveCharacter(pattern.pattern()[nextMove % pattern.pattern().length], board);

			nextMove++;

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