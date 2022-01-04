package game.TeamProjectGame;

import game.TeamProjectGame.API.BoardAPI;
import game.TeamProjectGame.API.PlayerAPI;
import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.NPCFactory;
import game.TeamProjectGame.Characters.Player;

import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;

public class Game implements ActionListener{

	public static Player player;
	public static Board board;

	private JButton W;
	private JButton S;
	private JButton A;
	private JButton D;
	private JTextArea BoardArea;
	private JTextArea playerstats;
	private int input=-1;
	//private boolean run = true;
	public static Menu menu = new Menu();

    public void run(){

		menu.drawMenu();
        menu.start();

		Game GUIWindow = new Game();
		GUIWindow.DrawGUI();


    }

	//updating board in gui after a move
	public void UpdateBoardGUI2 ()
	{
		char newboard[][] = board.rewriteBoard2();
		//clear textarea
		BoardArea.setText("");

		//add new board to cleared textarea
		for (int i = 0; i < newboard.length; i++) {
			BoardArea.append(String.copyValueOf(newboard[i]));
			BoardArea.append(" \n");
		}
	}


	public void UpdateBoardGUI ()
	{
		String Sboard[] = board.rewriteBoard();

		//clear textarea
		BoardArea.setText("");

		//add new board to cleared textarea
		for (int i = 0; i < Sboard.length; i++) {
			BoardArea.append(Sboard[i]);
			BoardArea.append("\n");
		}
	}

	public void DrawGUI() {

		JFrame mainframe = new JFrame("TeamProjectGame.exe");
		W = new JButton("W");
		S = new JButton("S");
		A = new JButton("A");
		D = new JButton("D");
		BoardArea = new JTextArea();
		playerstats = new JTextArea();
		JTextField Title = new JTextField("Welcome to the game!");
		JTextField WSADtitle = new JTextField("Use WSAD buttons to move your character");

		//user can't change the text in textfields and textareas
		playerstats.setEditable(false);
		BoardArea.setEditable(false);
		Title.setEditable(false);
		WSADtitle.setEditable(false);

		W.addActionListener(this);
		S.addActionListener(this);
		A.addActionListener(this);
		D.addActionListener(this);


		//panels declaration
		JPanel BoardPanel = new JPanel();
		JPanel MovePanel = new JPanel();
		JPanel StatsPanel = new JPanel();

		//filling mainframe with panels
		mainframe.getContentPane().add(BorderLayout.NORTH, Title);
		mainframe.getContentPane().add(BorderLayout.CENTER, BoardPanel);
		mainframe.getContentPane().add(BorderLayout.EAST, MovePanel);
		mainframe.getContentPane().add(BorderLayout.WEST, StatsPanel);

		//setting panels
		MovePanel.setLayout(new GridBagLayout());
		BoardPanel.setLayout(new GridBagLayout());
		StatsPanel.setLayout(new BoxLayout(StatsPanel, BoxLayout.Y_AXIS));
		StatsPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
		MovePanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

		//setting text fonts
		Title.setFont(new Font("Calibri", Font.ITALIC, 16));
		WSADtitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		playerstats.setFont(new Font("Calibri", Font.BOLD, 14));
		BoardArea.setFont(new Font("Courier New", Font.PLAIN, 13));



		GridBagConstraints coordinates = new GridBagConstraints();

		StatsPanel.add(playerstats);
		coordinates.fill = GridBagConstraints.BOTH;
		BoardPanel.add(BoardArea);

		UpdateBoardGUI2(); //we have to do it for the first time to display the board
		printStatsGUI(); //we have to do it for the first time to display player stats

		//setting MovePanel
		coordinates.fill = GridBagConstraints.HORIZONTAL;
		coordinates.gridx = 0;
		coordinates.gridy = 0;
		coordinates.gridwidth = 4;
		MovePanel.add(WSADtitle, coordinates);

		coordinates.ipadx = 8;
		coordinates.ipady = 16;
		coordinates.gridwidth = 1;
		coordinates.gridx = 1;
		coordinates.gridy = 1;
		MovePanel.add(W, coordinates);

		coordinates.anchor = GridBagConstraints.PAGE_END;
		coordinates.gridx = 1;
		coordinates.gridy = 2;
		MovePanel.add(S, coordinates);

		coordinates.gridx = 0;
		coordinates.gridy = 2;
		MovePanel.add(A, coordinates);

		coordinates.gridx = 2;
		coordinates.gridy = 2;
		MovePanel.add(D, coordinates);


		//mainframe settings
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.pack();
		mainframe.setSize(1000, 500);
		mainframe.setVisible(true);
	}

	//method used to finish the game in GUI
	public void GameOverMan ()
	{
		BoardArea.setText(null);
		BoardArea.append("" +
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
		W.setEnabled(false);
		S.setEnabled(false);
		A.setEnabled(false);
		D.setEnabled(false);
		player.setHp(0);
		printStatsGUI();


	}

	//updating player stats
	public void printStatsGUI ()
	{
		playerstats.setText(null);

		int PlayerHp = player.getHp();
		int PlayerDmg = player.getDmg();
		int PlayerSpeed = player.getSpeed();

		playerstats.append("PLAYER STATS" + "\n");
		playerstats.append(" HP: " + PlayerHp + "\n");
		playerstats.append(" Damage: " + PlayerDmg + "\n");
		playerstats.append(" Speed: " + PlayerSpeed + "\n");
	}


	public void actionPerformed (ActionEvent e) {

		if (player.getHp()<=0)
			GameOverMan();
		else {
			//zamienia wybrana litere na liczbe, ktora jest wykorzystywana w moveCharacter do poruszenia postaci w zadanym kierunku
			if (e.getSource() == W) {
				input = 8;
			} else if (e.getSource() == S) {
				input = 2;
			} else if (e.getSource() == A) {
				input = 4;
			} else if (e.getSource() == D) {
				input = 6;
			}

			board.updateBoard(input);
			UpdateBoardGUI2();
			printStatsGUI();
		}
	}

}
