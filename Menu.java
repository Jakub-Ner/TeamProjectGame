package game.TeamProjectGame;

import game.TeamProjectGame.API.*;
import game.TeamProjectGame.Board.*;
import game.TeamProjectGame.Characters.Friends.*;
import game.TeamProjectGame.Characters.Player;
import game.TeamProjectGame.MovePattern.SquarePattern;
import game.TeamProjectGame.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import static game.TeamProjectGame.API.BoardAPI.LoadBoard;

public class Menu implements Serializable {
    //creates GUI (menu where one can choose a player character and decide if to play a new game or the already existing one)
    private JDialog frame = new JDialog();
    private JLabel welcome = new JLabel("Welcome to The Game! ");
    Font specialFont = new Font("Impact", Font.ITALIC,33);
    Font casualFont = new Font("Palatino", Font.PLAIN,33);


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

    private static boolean startNewGame = true;

    private static int chosenCharacter;

    private boolean menuON = true;

    public boolean isMenuON() {
        return menuON;
    }

    public void drawMenu() {

        frame.getContentPane().add(BorderLayout.NORTH, panel1);
        frame.getContentPane().add(BorderLayout.WEST, panel2);
        frame.getContentPane().add(BorderLayout.CENTER, panel3);
        frame.getContentPane().add(BorderLayout.EAST, panel4);

        panel1.add(welcome);
        welcome.setFont(specialFont);

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

        Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int)dimensions.getWidth(), (int)dimensions.getHeight());

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    public class loadButtonReaction implements ActionListener {
        //starts new game or loads the previous one depending on players choice
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == loadButton1) {

                startNewGame = true;
            }
            if(e.getSource() == loadButton2) {

                startNewGame = false;
            }
        }
    }

    public class charButtonReaction implements ActionListener {
        //creates our player depending on the choice of character in the menu
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == charButton1) {

                chosenCharacter = 1;
            }else if(e.getSource() == charButton2) {

                chosenCharacter = 2;
            }else if(e.getSource() == charButton3) {

                chosenCharacter = 3;
            }
        }
    }

    public class startButtonReaction implements ActionListener {
        //clears the menu window
        @Override
        public void actionPerformed(ActionEvent e) {

            frame.dispose();
        }
    }

    public static Friend GUI_chooseCharacter () {

        switch (chosenCharacter) {
            default:
                return new Human(new SquarePattern());
            case 2:
                return new Dwarf(new SquarePattern());
            case 3:
                return new Elf(new SquarePattern());
        }
    }


    public static void start() {

        load();
    }

    //public static void printStats(Player player) {
    //    System.out.println(player.getClass().getSimpleName()
    //            + "\tHP: " + player.getHp()
    //            + "\tDmg: " + player.getDmg()
    //            + "\tSpeed: " + player.getSpeed());
    //}

    public static void load() {

        Scanner scanner = new Scanner(System.in);
        File file = new File("Player.ser");
        //checks if there's an already existing game (if yes, it loads data from it)
        if (PlayerAPI.checkFile(file)) {
            if (!startNewGame) {
                Game.player = PlayerAPI.loadPlayer();
                Game.board = new Board(Game.player);
                LoadBoard(Game.board);
                NpcAPI.LoadNPC();
            } else {
                startGame();
            }
        } else {
            startGame();
        }
    }

    public static void startGame() { //from the beginning
        Game.player = new Player(GUI_chooseCharacter());
        Game.board = new Board(Game.player);
        NPC_generator_NEW.generateNPC(Game.board);
    }
}
