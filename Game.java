package game.TeamProjectGame;

import game.TeamProjectGame.API.BoardAPI;
import game.TeamProjectGame.API.PlayerAPI;
import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.NPCFactory;
import game.TeamProjectGame.Characters.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;
import game.TeamProjectGame.GUI;
import javax.swing.*;

public class Game implements ActionListener{

	public static Player player;
	public static Board board;

	//public static Game obj = new Game();
	private JButton W;
	private JButton S;
	private JButton A;
	private JButton D;
	private int input=2;

    public void run(){

        Scanner scanner = new Scanner(System.in);

        Menu.start();

        boolean run = true;
		Game GUIWindow = new Game();
		GUIWindow.DrawGUI();

        while (run) {
			//board.drawScreen();
			//input = -1;

			/*while(input == -1) {
				try {
					input = scanner.nextInt();
				} catch (InputMismatchException e) {
					scanner.nextLine();
					input = -1;
					System.out.println("Wrong input! write numbers, not strings");
				}
			}*/
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


        }


    }



		public static void UpdateBoardGUI (Board board)
		{
			//rysowanie board od nowa po ruchu w gui
		}

		public void DrawGUI() {

			W = new JButton("W");
			S = new JButton("S");
			A = new JButton("A");
			D = new JButton("D");

			W.addActionListener(this);
			S.addActionListener(this);
			A.addActionListener(this);
			D.addActionListener(this);

			JFrame mainframe = new JFrame("TeamProjectGame.exe");
			mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel BoardPanel = new JPanel();
			JPanel MovePanel = new JPanel();
			JTextField title = new JTextField("Welcome to the game!");

			mainframe.getContentPane().add(BorderLayout.NORTH, title);
			mainframe.getContentPane().add(BorderLayout.CENTER, BoardPanel);
			mainframe.getContentPane().add(BorderLayout.EAST, MovePanel);

			MovePanel.setLayout(new GridBagLayout());
			GridBagConstraints coordinates = new GridBagConstraints();


			JTextArea textarea = new JTextArea();
			BoardPanel.add(textarea);

			JTextField WSADtitle = new JTextField("Use WSAD buttons to move your character");

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
			}

			mainframe.pack();
			mainframe.setSize(900, 500);
			mainframe.setVisible(true);
		}


	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == W) {
			input = 8;
			board.updateBoard(8);
		} else if (e.getSource() == S) {
			input = 2;
			board.updateBoard(2);
		} else if (e.getSource() == A) {
			input = 4;
			board.updateBoard(4);
		} else if (e.getSource() == D) {
			input = 6;
			board.updateBoard(6);
		}
		System.out.println(input);
		board.drawScreen();
		//board.updateBoard( a );

	}

}
