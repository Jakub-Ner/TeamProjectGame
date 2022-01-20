package game.TeamProjectGame.src.Characters;

import Board.Board;
import MeetingAndFight.MeetingAndFight;

import javax.swing.*;
import java.io.Serializable;

public abstract class Character implements Serializable {

	//fields
	private int x = 0;
	private int y = 0; //coordinates

	private int hp;
	private int dmg;
	protected int speed;

	protected char symbol;

	private int[] lastMove = {0, 0};

	//constructor

	public Character(int hp, int dmg, int speed, char symbol) {
		this.hp = hp;
		this.dmg = dmg;
		this.speed = speed;
		this.symbol = symbol;
	}

	//methods

	//finds the NPC standing at given coordinates and initiates meeting
	private void meet(int y, int x, Board board, JLabel messages) {

		for (int i = 0; i < NPCFactory.getCharacters().size(); i++) {
			if ((NPCFactory.getCharacters().elementAt(i).getX() == x) && (NPCFactory.getCharacters().elementAt(i).getY() == y)) {
				MeetingAndFight.Meeting(this, NPCFactory.getCharacters().elementAt(i), board, messages);
				break;
			}
		}
	}

	//checks nearby squares for NPCs
	private void surroundings(Board board, JLabel messages) {
		String npc = "hdeDOP";

		if ((y + 1 < board.HEIGHT) && (npc.indexOf(board.board[y + 1][x]) != -1)) {
			meet((y + 1), x, board, messages);
		}

		if ((y - 1 >= 0) && (npc.indexOf(board.board[y - 1][x]) != -1)) {
			meet((y - 1), x, board, messages);
		}

		if ((x - 1 >= 0) && (npc.indexOf(board.board[y][x - 1]) != -1)) {
			meet(y, (x - 1), board, messages);
		}

		if ((x + 1 < board.WIDTH) && (npc.indexOf(board.board[y][x + 1]) != -1)) {
			meet(y, (x + 1), board, messages);
		}
	}

	//moves position on map and changes coordinates if we're able to
	public void moveCharacter(int further, Board board, JLabel messages) {

		Board.board[y][x] = ' ';

		lastMove = new int[]{y, x};


		switch (further) {
			case 2: {
				if (y + 1 < board.HEIGHT) {
					if (Board.board[y + 1][x] == ' ') {
						y++;
					}
				}
				break;
			}
			case 8: {
				if (y > 0) {
					if (Board.board[y - 1][x] == ' ') {
						y--;
					}
				}
				break;
			}
			case 6: {
				if (x + 1 < board.WIDTH) {
					if (Board.board[y][x + 1] == ' ') {
						x++;
					}
				}
				break;
			}
			case 4: {
				if (x > 0) {
					if (Board.board[y][x - 1] == ' ') {
						x--;
					}
				}
				break;
			}
			default: {
				System.out.println("Please use NumPad to move");
				break;
			}
		}

		Board.board[y][x] = symbol;
		surroundings(board, messages);
	}

	public int[] oldCoordinates() {
		return lastMove;
	}

	public void firstCoordinates(int x, int y) {
		this.x = x;
		this.y = y;

		lastMove = new int[]{y, x};
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

	public char getSymbol() {
		return symbol;
	}
}
