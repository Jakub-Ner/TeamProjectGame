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
import game.TeamProjectGame.GUI;
import javax.swing.*;

public class Game implements ActionListener{

	public static Player player;
	public static Board board;

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

	private JButton W;
	private JButton S;
	private JButton A;
	private JButton D;
	private JTextArea textarea;
	private JTextArea playerstats;
	private int input=-1;
	private boolean run = true;

    public void run(){

        //Scanner scanner = new Scanner(System.in);

        Menu.start();

		Game GUIWindow = new Game();
		GUIWindow.DrawGUI();
		//board.drawScreen();


        /*while (run) {
			//board.drawScreen();
			//input = -1;
			while(input == -1) {
				try {
					input = scanner.nextInt();
				} catch (InputMismatchException e) {
					scanner.nextLine();
					input = -1;
					System.out.println("Wrong input! write numbers, not strings");
				}
			}
            //board.updateBoard( input );

            if (player.getHp() <= 0) {
                System.out.println("" +
						"  ▄████  ▄▄▄       ███▄ ▄███▓▓█████     ▒█████   ██▒   █▓▓█████  ██▀███  \n" +
						" ██▒ ▀█▒▒████▄    ▓██▒▀█▀ ██▒▓█   ▀    ▒██▒  ██▒▓██░   █▒▓█   ▀ ▓██ ▒ ██▒\n" +
						"▒██░▄▄▄░▒██  ▀█▄  ▓██    ▓██░▒███      ▒██░  ██▒ ▓██  █▒░▒███   ▓██ ░▄█ ▒\n" +
						"░▓█  ██▓░██▄▄▄▄██ ▒██    ▒██ ▒▓█  ▄    ▒██   ██░  ▒██ █░░▒▓█  ▄ ▒██▀▀█▄  \n" +
						"░▒▓███▀▒ ▓█   ▓██▒▒██▒   ░██▒░▒████▒   ░ ████▓▒░   ▒▀█░  ░▒████▒░██▓ ▒██▒\n" +
						" ░▒   ▒  ▒▒   ▓▒█░░ ▒░   ░  ░░░ ▒░ ░   ░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░░ ▒▓ ░▒▓░\n" +
						"  ░   ░   ▒   ▒▒ ░░  ░      ░ ░ ░  ░     ░ ▒ ▒░    ░ ░░   ░ ░  ░  ░▒ ░ ▒░\n" +
						"░ ░   ░   ░   ▒   ░      ░      ░      ░ ░ ░ ▒       ░░     ░     ░░   ░ \n" +
						"      ░       ░  ░       ░      ░  ░       ░ ░        ░     ░  ░   ░     \n" +
						"                                                     ░                   ");
                run = false;

            }


        }*/


    }
	public void UpdateBoardGUI2 ()
	{
		char Sboard[][] = board.rewriteBoard2();

		//clear textarea
		textarea.setText("");

			/*for (int i = 0; i < board.HEIGHT; i++) {
				Sboard[i]=(Arrays.toString(board[i]));
				System.out.println(" ");
			}

			//fill Sboard with current board
			String[] temp = board.rewriteBoard();

			for (int i = 0; i < Sboard.length; i++) {
				Sboard[i] = "[";
				for (int j = 0; j < temp[i].length; j++)
				{
					Sboard[i] += temp[i][j];
					Sboard[i] += ", ";
				}
				Sboard[i]+="]";
			}*/

		//add new board to cleared textarea
		for (int i = 0; i < Sboard.length; i++) {
			textarea.append(Arrays.toString(Sboard[i]));
			textarea.append(" \n");
		}
	}


		public void UpdateBoardGUI ()
		{
			String Sboard[] = board.rewriteBoard();

			//clear textarea
			textarea.setText("");

			/*for (int i = 0; i < board.HEIGHT; i++) {
				Sboard[i]=(Arrays.toString(board[i]));
				System.out.println(" ");
			}

			//fill Sboard with current board
			String[] temp = board.rewriteBoard();

			for (int i = 0; i < Sboard.length; i++) {
				Sboard[i] = "[";
				for (int j = 0; j < temp[i].length; j++)
				{
					Sboard[i] += temp[i][j];
					Sboard[i] += ", ";
				}
				Sboard[i]+="]";
			}*/

			//add new board to cleared textarea
			for (int i = 0; i < Sboard.length; i++) {
				textarea.append(Sboard[i]);
				textarea.append("\n");
			}
		}

		public void DrawGUI() {

			W = new JButton("W");
			S = new JButton("S");
			A = new JButton("A");
			D = new JButton("D");
			textarea = new JTextArea();
			playerstats = new JTextArea();
			JTextField Title = new JTextField("Welcome to the game!");

			playerstats.setEditable(false);
			textarea.setEditable(false);
			Title.setEditable(false);

			W.addActionListener(this);
			S.addActionListener(this);
			A.addActionListener(this);
			D.addActionListener(this);

			JFrame mainframe = new JFrame("TeamProjectGame.exe");
			mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel BoardPanel = new JPanel();
			JPanel MovePanel = new JPanel();
			JPanel StatsPanel = new JPanel();

			mainframe.getContentPane().add(BorderLayout.NORTH, Title);
			mainframe.getContentPane().add(BorderLayout.CENTER, BoardPanel);
			mainframe.getContentPane().add(BorderLayout.EAST, MovePanel);
			mainframe.getContentPane().add(BorderLayout.WEST, StatsPanel);

			MovePanel.setLayout(new GridBagLayout());
			BoardPanel.setLayout(new GridBagLayout());
			StatsPanel.setLayout(new BoxLayout(StatsPanel, BoxLayout.Y_AXIS));
			//StatsPanel.setSize(100, 100);
			StatsPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
			MovePanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

			GridBagConstraints coordinates = new GridBagConstraints();

			StatsPanel.add(playerstats);
			coordinates.fill = GridBagConstraints.BOTH;
			//JTextArea textarea = new JTextArea();
			BoardPanel.add(textarea);
			UpdateBoardGUI2(); //we have to do it for the first time to display the board
			printStatsGUI(); //we have to do it for the first time to display player stats

			JTextField WSADtitle = new JTextField("Use WSAD buttons to move your character");
			WSADtitle.setEditable(false);

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

			/*textarea.setText(null);

			char tablica[][] = new char[25][61];

			char znak = 'a';

			for (int i = 0; i < tablica.length; i++) {
				for (int j = 0; j < tablica[i].length; j++) {
					tablica[i][j] = znak;
					znak++;
					if (znak > 120)
						znak = 'a';
				}
			}

			String newtab[] = new String[tablica.length];

			for (int i = 0; i < newtab.length; i++) {
				newtab[i] = "";
				for (int j = 0; j < tablica[i].length; j++) {
					newtab[i] += tablica[i][j];
					newtab[i] += " ";
				}
			}


			for (int i = 0; i < newtab.length; i++) {
				textarea.append(newtab[i]);
				textarea.append("\n");
			}*/

			mainframe.pack();
			mainframe.setSize(1400, 500);
			mainframe.setVisible(true);
		}

		public void GameOverMan ()
		{
			textarea.setText(null);
			textarea.append("" +
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


	public void actionPerformed (ActionEvent e) {

		if (player.getHp()<=0)
			GameOverMan();
		else {

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
