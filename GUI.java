package game.TeamProjectGame;

import game.TeamProjectGame.Board.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import game.TeamProjectGame.Game;

public class GUI {

    /*public static void UpdateBoardGUI (Board board)
    {
        //rysowanie board od nowa po ruchu w gui
    }

    JButton W = new JButton("W");
    JButton S = new JButton("S");
    JButton A = new JButton("A");
    JButton D = new JButton("D");

    public void DrawGUI() {

        W.addActionListener(game.TeamProjectGame.Game.obj);
        S.addActionListener(game.TeamProjectGame.Game.obj);
        A.addActionListener(game.TeamProjectGame.Game.obj);
        D.addActionListener(game.TeamProjectGame.Game.obj);

        JFrame mainframe = new JFrame("TeamProjectGame.exe");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel BoardPanel = new JPanel();
        JPanel MovePanel = new JPanel();
        JTextField title = new JTextField("Welcome to the game!");

        mainframe.getContentPane().add(BorderLayout.NORTH, title);
        mainframe.getContentPane().add(BorderLayout.CENTER, BoardPanel);
        mainframe.getContentPane().add(BorderLayout.EAST, MovePanel);

        MovePanel.setLayout(new GridBagLayout());
        //panel1.setLayout(new GridLayout());
        //mainframe.setLayout(new GridBagLayout());
        GridBagConstraints coordinates = new GridBagConstraints();

        //panel2.setSize(300,300);
        /*coordinates.fill = GridBagConstraints.HORIZONTAL;
        coordinates.gridx = 0;
        coordinates.gridy = 0;
        coordinates.gridwidth = 2;
        coordinates.weighty=0.01; //tworzy odstep na osi y powyzej i ponizej dodawanego wlasnie elementu
        mainframe.getContentPane().add(title, coordinates);

        coordinates.fill = GridBagConstraints.NONE;
        coordinates.gridx = 1;
        coordinates.gridy = 0;
        coordinates.gridwidth = 0;
        mainframe.getContentPane().add(panel1, coordinates);

        coordinates.fill = GridBagConstraints.NONE;
        coordinates.gridx = 1;
        coordinates.gridy = 1;
        coordinates.gridwidth = 0;
        mainframe.getContentPane().add(panel2, coordinates);*/

        /*JTextArea textarea = new JTextArea();
        BoardPanel.add(textarea);

        JButton W = new JButton("W");
        JButton S = new JButton("S");
        JButton A = new JButton("A");
        JButton D = new JButton("D");
        JTextField WSADtitle = new JTextField("Use WSAD buttons to move your character");

        coordinates.fill = GridBagConstraints.HORIZONTAL;
        coordinates.gridx = 0;
        coordinates.gridy = 0;
        coordinates.gridwidth = 4;
        //coordinates.weighty=0.00001; //tworzy odstep na osi y powyzej i ponizej dodawanego wlasnie elementu
        MovePanel.add(WSADtitle, coordinates);


        //coordinates.fill = GridBagConstraints.NONE;
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
        mainframe.setVisible(true); */
    }

