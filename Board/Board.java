package game.TeamProjectGame.Board;

import java.util.Arrays;
import java.util.Random;

import game.TeamProjectGame.Characters.Character;

public class Board {
    public final int HEIGHT = 25;
    public final int WIDTH = 61;

    //    SideBar sideBar;
    public static char[][] board;
    Character character;

    public Board() {
    }


    private void obstacles() {
        Random random = new Random();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH * 3 / 4; j++) {
                if (random.nextInt(100) > 80) {
                    board[i][j] = 'X';
                } else board[i][j] = '#';
            }
        }
    }

    private void partOfBoard(int limit, int[][] start) {
        Random random = new Random();
        boolean newField = true;
        do {
//            if (newField) {
            limit--;
            for (int i = 0; i < start.length; i++) {
                board[start[i][0]][start[i][1]] = ' ';
            }
//            }
            int direction = 2 * (int) Math.pow(-1, random.nextInt(2));
            int coordinate = random.nextInt(2);
            int licznik = 0;

            for (int i = 0; i < start.length; i++) {
                if (start[i][coordinate] + direction <= 0
                        || (coordinate == 0 && start[i][coordinate] + direction >= board.length)
                        || (coordinate == 1 && start[i][coordinate] + direction >= board[0].length)) {
                    break;
                }
                licznik++;
            }
//            newField = false;
            if (licznik == start.length) {
//                if (board[start[0][0] + ((coordinate + 1) % 2) * direction][start[0][1] + ((coordinate + 0) % 2) * direction] != ' ') {
                for (int i = 0; i < start.length; i++) {
                    start[i][coordinate] += direction;
                }
//                    newField = true;
//                }
            }
        } while (limit > 0);
    }

    private void drawBoard() {
        obstacles();

        int[][] fields = new int[][]{
                {0, 0}, {0, 1},
                {1, 0}, {1, 1}};
        partOfBoard(520, fields);

        int[][] fields2 = new int[][]{
                {board.length - 2, board[0].length - 2}, {board.length - 2, board[0].length - 1},
                {board.length - 1, board[0].length - 2}, {board.length - 1, board[0].length - 1}};
        partOfBoard(12, fields2);

    }


    public void initBoard() {
//        board = new char[HEIGHT][WIDTH * 3 / 4];
//        sideBar = new SideBar(HEIGHT, WIDTH / 4);

        drawBoard();
//        drawNPC();
        updateBoard(0);
    }

    public void drawScreen() {
        for (int i = 0; i < HEIGHT; i++) {
            System.out.print(Arrays.toString(board[i]));
            System.out.println(" ");
        }

    }

    public void space() {
        for (int i = 0; i < 10; i++) System.out.println("");
    }

    public void updateBoard(int goFurther) {
        board[character.getX()][character.getY()] = ' '; //erases previous location

        character.moveCharacter(goFurther, board);

        board[character.getX()][character.getY()] = 'O'; // sets new location

        space();
        drawScreen();
    }
}

