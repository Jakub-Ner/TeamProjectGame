package GUI;

import Characters.Friends.*;
import Main.Menu;
import MovePattern.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI {

	private int framesize_X = 450;
	private int framesize_Y = 200;

	private JDialog frame = new JDialog();

	private JLabel welcome = new JLabel("Welcome to our game!");

	private JRadioButton loadButton1 = new JRadioButton("New game");
	private JRadioButton loadButton2 = new JRadioButton("Load game from file");
	private ButtonGroup loadGroup = new ButtonGroup();

	private JLabel charLabel = new JLabel("Choose your character:");
	private JRadioButton charButton1 = new JRadioButton("Human");
	private JRadioButton charButton2 = new JRadioButton("Elf");
	private JRadioButton charButton3 = new JRadioButton("Dwarf");
	private ButtonGroup charGroup = new ButtonGroup();

	private JButton startButton = new JButton("Play!");

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel5 = new JPanel();

	private Friend chosenCharacter;

	public Friend getChosenCharacter() {
		return chosenCharacter;
	}

	//konstruktor z default wyborami.
	public MenuGUI() {
		Menu.setStartNewGame(true);
		this.chosenCharacter = new Human(new SquarePattern());
	}

	public void drawMenu() {

		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.WEST, panel2);
		frame.getContentPane().add(BorderLayout.CENTER, panel3);
		frame.getContentPane().add(BorderLayout.EAST, panel4);

		panel1.add(welcome);

		loadGroup.add(loadButton1);
		loadGroup.add(loadButton2);

		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.add(loadButton1);
		panel2.add(loadButton2);

		loadButton1.addActionListener(new loadButtonReaction());
		loadButton2.addActionListener(new loadButtonReaction());

		charGroup.add(charButton1);
		charGroup.add(charButton2);
		charGroup.add(charButton3);

		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		panel3.add(charLabel);
		panel3.add(charButton1);
		panel3.add(charButton2);
		panel3.add(charButton3);

		charButton1.addActionListener(new charButtonReaction());
		charButton2.addActionListener(new charButtonReaction());
		charButton3.addActionListener(new charButtonReaction());

		panel4.add(startButton);

		startButton.addActionListener(new startButtonReaction());

		loadButton1.setSelected(true);
		charButton1.setSelected(true);

		frame.setModal(true);

		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		frame.setSize(framesize_X,framesize_Y);

		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}

	public class loadButtonReaction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == loadButton1) {
				Menu.setStartNewGame(true);
			}
			if(e.getSource() == loadButton2) {

				Menu.setStartNewGame(false);
			}
		}
	}

	public class charButtonReaction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == charButton1) {

				chosenCharacter = new Human(new SquarePattern());
			}else if(e.getSource() == charButton2) {

				chosenCharacter = new Elf(new SquarePattern());
			}else if(e.getSource() == charButton3) {

				chosenCharacter = new Dwarf(new SquarePattern());
			}
		}
	}

	public class startButtonReaction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			frame.dispose();
		}
	}

}