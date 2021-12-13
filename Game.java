package game.TeamProjectGame;

import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.NPCFactory;

import java.util.Scanner;

public class Game {

    public void run(){

        Scanner scanner = new Scanner(System.in);

        Menu.start();
        Character player = Menu.chooseCharacterMenu();

        boolean run = true;
        player = NPCFactory.getCharacters().lastElement();

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
