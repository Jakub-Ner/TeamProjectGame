package game.TeamProjectGame;

import game.TeamProjectGame.API.*;
import game.TeamProjectGame.Board.*;
import game.TeamProjectGame.Characters.Friends.*;
import game.TeamProjectGame.Characters.Player;
import game.TeamProjectGame.MovePattern.SquarePattern;

import java.io.File;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import static game.TeamProjectGame.API.BoardAPI.LoadBoard;

public class Menu implements Serializable {


	public static void start() {
		System.out.println("Welcome to our game!");

		load();
	}

	public static int choosingNumber(int options) { //sprawdza czy uzytkownik podaje dobrą liczbe

		Scanner scanner = new Scanner(System.in);

		int input;

		try {
			input = scanner.nextInt();
		} catch (InputMismatchException e) {
			scanner.nextLine();
			input = -1;
		}

		while (1 > input || options <= input) {
			System.out.print("Answer out of reach! Try again.\n>");

			try {
				input = scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				input = -1;
			}
		}

		return input;
	}

	public static Friend chooseCharacterMenu() { //obowiązkowo do wywołania na początku
		System.out.println("Choose number of a character:\n" +
				"1 - HUMAN\n" +
				"2 - DWARF\n" +
				"3 - ELF\n");

		int n = choosingNumber(4);
		switch (n) {
			default:
				return new Human(new SquarePattern());
			case 2:
				return new Dwarf(new SquarePattern());
			case 3:
				return new Elf(new SquarePattern());
		}
	}

	public static void printStats(Player player) {
		System.out.println(player.getClass().getSimpleName()
				+ "\tHP: " + player.getHp()
				+ "\tDmg: " + player.getDmg()
				+ "\tSpeed: " + player.getSpeed());
	}

	public static void load() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Choose:\n" +
				"1 - if you want to use data from previous game\n" +
				"2 - if you want to start from the beginning\n");
		int n = choosingNumber(3);


		if (n == 1) {
			File file = new File("Player.ser");
			if (PlayerAPI.checkFile(file)) {
				Game.player = PlayerAPI.loadPlayer();
				Game.board = new Board(Game.player);
				LoadBoard(Game.board);
				NpcAPI.LoadNPC();
			}
			else{
				System.out.println("You have to start game from the beggining");
				startGame();
			}
		}
		else {
			startGame();
		}
	}

	public static void startGame(){
		Game.player = new Player(chooseCharacterMenu());
		Game.board = new Board(Game.player);
		NPC_generator_NEW.generateNPC(Game.board);
	}
}
