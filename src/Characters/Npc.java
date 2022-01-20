package game.TeamProjectGame.src.Characters;


import Board.Board;
import MovePattern.MovePattern;

import javax.swing.*;
import java.io.Serializable;

public abstract class Npc extends Character implements Serializable {
	//fields

	final private int wait = 10;

	MovePattern pattern;
	private int turn = wait;
	private int lastMove = -1;

	//constructor

	public Npc(int hp, int dmg, int speed, MovePattern pattern, char symbol) {
		super(hp, dmg, speed, symbol);
		this.pattern = pattern;
	}

	//methods

	public void move(Board board, JLabel messages) {
		if (getHp() <= 0) return;

		turn -= speed;

		if (turn <= 0) {

			lastMove++;

			moveCharacter(pattern.pattern()[lastMove % pattern.pattern().length], board, messages);

			turn = wait;
		}
	}

	//getters

	public int getLastMove() {
		return lastMove;
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

	public void setLastMove(int lastMove) {
		this.lastMove = lastMove;
	}

	public void setPattern(MovePattern pattern) {
		this.pattern = pattern;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
}