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
	private JPanel SidePanel;
	private JPanel MovePanel;


	//to show messages to user
	private JLabel messages = new JLabel(); //AGATA


	//konstruktor
	public GUIGame() {
		mainframe = new JFrame("TeamProjectGame.exe");
		W = new JButton("W");
		S = new JButton("S");
		A = new JButton("A");
		D = new JButton("D");
		BoardArea = new JTextArea();
		playerstats = new JTextArea(5, 5);
		;
		Title = new JTextField("Welcome to the game!");
		WSADtitle = new JTextField("Use WSAD buttons to move your character");
		messages = new JLabel();


		//user can't change the text in textfields and textareas
		playerstats.setEditable(false);
		BoardArea.setEditable(false);
		Title.setEditable(false);
		WSADtitle.setEditable(false);

		//panels declaration
		BoardPanel = new JPanel();
		SidePanel = new JPanel();
		MovePanel = new JPanel();
		JPanel BottomPanel = new JPanel(); //AGATA


		//filling mainframe with panels
		mainframe.getContentPane().add(BorderLayout.NORTH, Title);
		mainframe.getContentPane().add(BorderLayout.CENTER, BoardPanel);
		mainframe.getContentPane().add(BorderLayout.EAST, SidePanel);
		mainframe.getContentPane().add(BorderLayout.SOUTH, BottomPanel); ///AGATA


		//setting panels
		MovePanel.setLayout(new GridBagLayout());
		BoardPanel.setLayout(new GridBagLayout());
		SidePanel.setLayout(new BoxLayout(SidePanel, BoxLayout.Y_AXIS));
		SidePanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
		MovePanel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

		//setting text fonts
		Title.setFont(new Font("Calibri", Font.ITALIC, 25));
		WSADtitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		playerstats.setFont(new Font("Calibri", Font.BOLD, 20));
		BoardArea.setFont(new Font("Courier New", Font.PLAIN, 20));


		GridBagConstraints coordinates = new GridBagConstraints();

		SidePanel.add(playerstats);
		coordinates.fill = GridBagConstraints.BOTH;
		BoardPanel.add(BoardArea);
		messages.setText("");
		BottomPanel.add(messages); //AGATA
		messages.setFont(new Font("Calibri", Font.ITALIC, 40));

		JLabel jLabel = new JLabel("");
		BottomPanel.add(jLabel);

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

		SidePanel.add(MovePanel);

		//mainframe settings
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.pack();
		Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
		mainframe.setSize((int) dimensions.getWidth(), (int) dimensions.getHeight());
		mainframe.setVisible(true);
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

	public JLabel getMessages() {
		return messages;
	}
}
