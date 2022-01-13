package game.TeamProjectGame;


import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.Characters.NPCFactory;
import game.TeamProjectGame.Characters.Npc;
import game.TeamProjectGame.Characters.Player;
import game.TeamProjectGame.GUI.GUIGame;
import game.TeamProjectGame.GUI.StatusBox;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;

public class Game implements ActionListener {

	public static Player player;
	public static Board board;
	private int input = -1;
	public static GUIGame GUIWindow;
	public static Menu menu = new Menu();

	private StatusBox statusBox;

	public void run() {
		statusBox = new StatusBox(new Font("Courier New", Font.PLAIN, 13));

		menu.drawMenu();
		menu.start();

		GUIWindow = new GUIGame(statusBox);
		AddAL();
		UpdateBoardGUI2(GUIWindow.getBoardArea()); //we have to do it for the first time to display the board
		printStatsGUI(); //we have to do it for the first time to display player stats

	}

	//adds action listeners
	public void AddAL() {
		GUIWindow.getW().addActionListener(this);
		GUIWindow.getS().addActionListener(this);
		GUIWindow.getA().addActionListener(this);
		GUIWindow.getD().addActionListener(this);
	}

	//updating board in gui after a move
	public void UpdateBoardGUI2(JTextArea BoardArea) {
		char newboard[][] = board.rewriteBoard2();
		//clear textarea
		BoardArea.setText("");

		//add new board to cleared textarea
		for (int i = 0; i < newboard.length; i++) {
			BoardArea.append(String.copyValueOf(newboard[i]));
			BoardArea.append("\n");
		}
	}

	//method used to finish the game in GUI
	public void GameOverMan() {

		GUIWindow.getBoardArea().setText(null);
		GUIWindow.getBoardArea().append("" +
				"  ▄████  ▄▄▄       ███▄ ▄███▓▓█████     ▒█████   ██▒   █▓▓█████  ██▀███  \n" +
				" ██▒ ▀█▒▒████▄    ▓██▒▀█▀ ██▒▓█   ▀    ▒██▒  ██▒▓██░   █▒▓█   ▀ ▓██ ▒ ██▒\n" +
				"▒██░▄▄▄░▒██  ▀█▄  ▓██    ▓██░▒███      ▒██░  ██▒ ▓██  █▒░▒███   ▓██ ░▄█ ▒\n" +
				"░▓█  ██▓░██▄▄▄▄██ ▒██    ▒██ ▒▓█  ▄    ▒██   ██░  ▒██ █░░▒▓█  ▄ ▒██▀▀█▄  \n" +
				"░▒▓███▀▒ ▓█   ▓██▒▒██▒   ░██▒░▒████▒   ░ ████▓▒░   ▒▀█░  ░▒████▒░██▓ ▒██▒\n" +
				" ░▒   ▒  ▒▒   ▓▒█░░ ▒░   ░  ░░░ ▒░ ░   ░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░░ ▒▓ ░▒▓░\n" +
				"  ░   ░   ▒   ▒▒ ░░  ░      ░ ░ ░  ░     ░ ▒ ▒░    ░ ░░   ░ ░  ░  ░▒ ░ ▒░\n" +
				"░ ░   ░   ░   ▒   ░      ░      ░      ░ ░ ░ ▒       ░░     ░     ░░   ░ \n" +
				"      ░       ░  ░       ░      ░  ░       ░ ░        ░     ░  ░   ░     \n" +
				"                                                     ░                   \n" +
				"																		  \n" +
				"             Please use the X Windows button to close the game             ");
		GUIWindow.getW().setEnabled(false);
		GUIWindow.getS().setEnabled(false);
		GUIWindow.getA().setEnabled(false);
		GUIWindow.getD().setEnabled(false);
		player.setHp(0);
		printStatsGUI();
	}

	//updating player stats
	public void printStatsGUI() {
		GUIWindow.getPlayerstats().setText(null);

		int PlayerHp = player.getHp();
		int PlayerDmg = player.getDmg();
		int PlayerSpeed = player.getSpeed();

		GUIWindow.getPlayerstats().append("PLAYER STATS" + "\n");
		GUIWindow.getPlayerstats().append(" HP: " + PlayerHp + "\n");
		GUIWindow.getPlayerstats().append(" Damage: " + PlayerDmg + "\n");
		GUIWindow.getPlayerstats().append(" Speed: " + PlayerSpeed + "\n");
	}

	public void UpdateBoardGUI() {
		for (Npc c : NPCFactory.getCharacters()) {
			if(c.oldCoordinates()[0] == c.getY() && c.oldCoordinates()[1] == c.getX()) continue;

			GUIWindow.getBoardArea().replaceRange(
					Character.toString(Board.board[c.oldCoordinates()[0]][c.oldCoordinates()[1]]),
					((board.WIDTH + 1) * c.oldCoordinates()[0]) + c.oldCoordinates()[1],
					((board.WIDTH + 1) * c.oldCoordinates()[0]) + c.oldCoordinates()[1] + 1);
			GUIWindow.getBoardArea().replaceRange(
					Character.toString(Board.board[c.getY()][c.getX()]),
					((board.WIDTH + 1) * c.getY()) + c.getX(),
					((board.WIDTH + 1) * c.getY()) + c.getX() + 1);
		}

		GUIWindow.getBoardArea().replaceRange(
				Character.toString(Board.board[player.oldCoordinates()[0]][player.oldCoordinates()[1]]),
				((board.WIDTH + 1) * player.oldCoordinates()[0]) + player.oldCoordinates()[1],
				((board.WIDTH + 1) * player.oldCoordinates()[0]) + player.oldCoordinates()[1] + 1);
		GUIWindow.getBoardArea().replaceRange(
				Character.toString(Board.board[player.getY()][player.getX()]),
				((board.WIDTH + 1) * player.getY()) + player.getX(),
				((board.WIDTH + 1) * player.getY()) + player.getX() + 1);

		statusBox.tick();
	}

	public void actionPerformed(ActionEvent e) {

		if (player.getHp() <= 0)
			GameOverMan();
		else {
			//zamienia wybrana litere na liczbe, ktora jest wykorzystywana w moveCharacter do poruszenia postaci w zadanym kierunku
			if (e.getSource() == GUIWindow.getW()) {
				input = 8;
			} else if (e.getSource() == GUIWindow.getS()) {
				input = 2;
			} else if (e.getSource() == GUIWindow.getA()) {
				input = 4;
			} else if (e.getSource() == GUIWindow.getD()) {
				input = 6;
			}

			board.updateBoard(input);
			//UpdateBoardGUI2(GUIWindow.getBoardArea());
			UpdateBoardGUI();
			printStatsGUI();
		}
	}

}