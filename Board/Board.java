package game.TeamProjectGame.Board;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.NPCFactory;
import game.TeamProjectGame.Characters.Npc;

import java.util.Arrays;
import java.util.Random;


public class Board {
    public final int HEIGHT = 25;
    public final int WIDTH = 61;

    public static char[][] board;
    Character character;

    //constructor
    public Board(Character character) {
        board = new char[HEIGHT][WIDTH];
        this.character = character;
        initBoard();
    }

    //filling the board with obstacles # and X
    private void obstacles() {
        Random random = new Random();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH ; j++) {
                if (random.nextInt(100) > 80) {
                    board[i][j] = 'X';
                } else board[i][j] = '#';
            }
        }
    }

    //generating walkable paths for characters
    private void partOfBoard(int limit, int[][] start) {
        Random random = new Random();
        do {

            limit--;

            //making a part of the path
            if (board[start[0][0]][start[0][1]] != ' ') {
                for (int i = 0; i < start.length; i++) {
                    board[start[i][0]][start[i][1]] = ' ';
                }
            }

            int direction = 2 * (int) Math.pow(-1, random.nextInt(2));
            int coordinate = random.nextInt(2);
            int licznik = 0;

            for (int i = 0; i < start.length; i++) {
                if (start[i][coordinate] + direction <= 0
                        || (coordinate == 0 && start[i][coordinate] + direction >= board.length)
                        || (coordinate == 1 && start[i][coordinate] + direction >= board[0].length)) {
                    continue;
                }
                licznik++;
            }

            if (licznik == start.length) {
                for (int i = 0; i < start.length; i++) {
                    start[i][coordinate] += direction;
                }
            }

        } while (limit > 0);
    }

    //filling the board with paths and obstacles
    private void drawBoard() {
        obstacles();

        int[][] fields = new int[][]{
                {0, 0}, {0, 1},
                {1, 0}, {1, 1}};
        partOfBoard(520, fields);

        int[][] fields2 = new int[][]{
                {board.length - 2, board[0].length - 2}, {board.length - 2, board[0].length - 1},
                {board.length - 1, board[0].length - 2}, {board.length - 1, board[0].length - 1}};
        partOfBoard(352, fields2);

    }


    public void initBoard() {
        drawBoard();
        NPC_generator_NEW.generateNPC(this);
        board[character.getY()][character.getY()] = 'B';
    }

    public void drawScreen() {
        space();

        for (int i = 0; i < HEIGHT; i++) {
            System.out.print(Arrays.toString(board[i]));
            System.out.println(" ");
        }

    }

    //added method for GUI
    public String [] rewriteBoard ()
    {
        String [] temp = new String[board.length];

        for (int i=0; i< board.length; i++)
        {
            temp[i]=Arrays.toString(board[i]);
            temp[i]+=" ";
        }

        return temp;
    }

    //added method for GUI
    public char [][] rewriteBoard2 ()
    {
        char [][] temp = new char[board.length][board[0].length];
        for (int i=0; i< temp.length; i++)
        {
            for (int j=0; j<temp[i].length; j++)
            {
                temp[i][j]=board[i][j];
            }
        }
        return temp;
    }

    public void space() {
        for (int i = 0; i < 10; i++) System.out.println("");
    }

    public void updateBoard(int goFurther) {
         //erases previous location

        character.moveCharacter(goFurther, this);

		updateNPC();
    }

    private void updateNPC(){
		for (Npc c: NPCFactory.getCharacters()) {
			c.move(this);
		}
    }
}

