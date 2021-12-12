package game.TeamProjectGame;

import game.TeamProjectGame.API.BoardAPI;
import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.CharacterFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    public void run(){

        Scanner scanner = new Scanner(System.in);

        Menu.start();
        Character player = Menu.chooseCharacterMenu();

        boolean run = true;
        player = CharacterFactory.getCharacters().lastElement();

        Board board = new Board(player);
//        BoardAPI.SaveBoard(board);
//        BoardAPI.LoadBoard(board);
        while (run) {
            board.updateBoard( scanner.nextInt() );

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

}
