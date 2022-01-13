package game.TeamProjectGame.GUI;

import game.TeamProjectGame.MeetingAndFight.MeetingAndFight;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIGame {

    //skladowe
    private JFrame mainframe;

    private JButton W;
    private JButton S;
    private JButton A;
    private JButton D;

    private JTextArea BoardArea;
    private JTextArea playerstats;
    private JTextField Title;
    private JTextField WSADtitle;

    private JPanel BoardPanel;
    private JPanel MovePanel;
    private JPanel StatsPanel;

    //to show messages to user
    private StatusBox statusBox;


    //konstruktor
    public GUIGame (StatusBox statusBox)
    {
        mainframe = new JFrame("TeamProjectGame.exe");
        W = new JButton("W");
        S = new JButton("S");
        A = new JButton("A");
        D = new JButton("D");
        BoardArea = new JTextArea();
        playerstats = new JTextArea();
        Title = new JTextField("Welcome to the game!");
        WSADtitle = new JTextField("Use WSAD buttons to move your character");

        //user can't change the text in textfields and textareas
        playerstats.setEditable(false);
        BoardArea.setEditable(false);
        Title.setEditable(false);
        WSADtitle.setEditable(false);
        statusBox.setEditable(false);

        //panels declaration
        BoardPanel = new JPanel();
        MovePanel = new JPanel();
        StatsPanel = new JPanel();

        //test
        JPanel rightPanel = new JPanel();



        //filling mainframe with panels
        mainframe.getContentPane().add(BorderLayout.NORTH, Title);
        mainframe.getContentPane().add(BorderLayout.CENTER, BoardPanel);
        mainframe.getContentPane().add(BorderLayout.EAST, rightPanel);
        mainframe.getContentPane().add(BorderLayout.WEST, StatsPanel);

        //setting panels
        MovePanel.setLayout(new GridBagLayout());
        BoardPanel.setLayout(new GridBagLayout());
        StatsPanel.setLayout(new BoxLayout(StatsPanel, BoxLayout.Y_AXIS));
        StatsPanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
        MovePanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        //setting text fonts
        Title.setFont(new Font("Calibri", Font.ITALIC, 16));
        WSADtitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        playerstats.setFont(new Font("Calibri", Font.BOLD, 14));
        BoardArea.setFont(new Font("Courier New", Font.PLAIN, 13));



        GridBagConstraints coordinates = new GridBagConstraints();

        StatsPanel.add(playerstats);
        coordinates.fill = GridBagConstraints.BOTH;
        BoardPanel.add(BoardArea);

        //UpdateBoardGUI2(); //we have to do it for the first time to display the board
        //printStatsGUI(); //we have to do it for the first time to display player stats

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

        //test
        rightPanel.add(statusBox);
        rightPanel.add(MovePanel);

        //mainframe settings
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.pack();
        mainframe.setSize(1000, 500);
        mainframe.setVisible(true);

        //sets message target for MeetngAndFight
        MeetingAndFight.setMessageTarget(statusBox);
    }

    public JButton getW() {
        return W;
    }

    public JButton getS() {
        return S;
    }

    public JButton getA() {
        return A;
    }

    public JButton getD() {
        return D;
    }

    public JTextArea getBoardArea() {
        return BoardArea;
    }

    public JTextArea getPlayerstats() {
        return playerstats;
    }

    public JFrame getMainframe() {
        return mainframe;
    }

    public JTextField getTitle() {
        return Title;
    }

    public JTextField getWSADtitle() {
        return WSADtitle;
    }

    public JPanel getBoardPanel() {
        return BoardPanel;
    }

    public JPanel getMovePanel() {
        return MovePanel;
    }

    public JPanel getStatsPanel() {
        return StatsPanel;
    }
}
