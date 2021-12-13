package game.TeamProjectGame;

import game.TeamProjectGame.API.BoardAPI;
import game.TeamProjectGame.API.NpcAPI;
import game.TeamProjectGame.API.PlayerAPI;
import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.Board.NPC_generator;
import game.TeamProjectGame.Characters.Friends.Dwarf;
import game.TeamProjectGame.Characters.Friends.Elf;
import game.TeamProjectGame.Characters.Friends.Friend;
import game.TeamProjectGame.Characters.Friends.Human;
import game.TeamProjectGame.Characters.NPCFactory;
import game.TeamProjectGame.Characters.Player;
import game.TeamProjectGame.MovePattern.SquarePattern;
import game.TeamProjectGame.API.PlayerAPI;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import static game.TeamProjectGame.API.BoardAPI.LoadBoard;

public class Menu implements Serializable {


        public static void start(){
                System.out.println("Welcome to our game!");

				load();
				////TMP - TO BE DELETED
				//PlayerAPI.savePlayer(Game.player);
				//BoardAPI.SaveBoard(Game.board);
				//NpcAPI.SaveNPC();
				////ENDOF TMP
        }
        public static int choosingNumber(int options){ //sprawdza czy uzytkownik podaje dobrą liczbe

                Scanner scanner = new Scanner(System.in);

                int input;

                try{input = scanner.nextInt();} catch (InputMismatchException e){
                        scanner.nextLine();
                        input = -1;
                }

                while(1 > input || options <= input){
                        System.out.print("Answer out of reach! Try again.\n>");

                        try{input = scanner.nextInt();} catch (InputMismatchException e){
                                scanner.nextLine();
                                input = -1;
                        }
                }

                return input;
        }

        public static Friend chooseCharacterMenu(){ //obowiązkowo do wywołania na początku
                System.out.println("Choose number of a character:\n" +
                        "1 - HUMAN\n" +
                        "2 - DWARF\n" +
                        "3 - ELF\n");

                int n = choosingNumber(4);
                switch (n){
					default: return new Human(new SquarePattern());
					case 2: return new Dwarf(new SquarePattern());
					case 3: return new Elf(new SquarePattern());
                }
        }
        public static void printStats(Player player){
                        System.out.println(player.getClass().getSimpleName()
                        + "\tHP: " + player.getHp()
                        + "\tDmg: "+ player.getDmg()
                        + "\tSpeed: " + player.getSpeed());
        }

	public static void load(){

		Scanner scanner = new Scanner(System.in);

		System.out.println("Choose:\n" +
				"1 - if you want to use data from previous game\n" +
				"2 - if you want to start from the beginning\n");
		int n = choosingNumber(3);


		if(n == 1){
			PlayerAPI.loadPlayer(Game.player);
			Game.board = new Board(Game.player);
			LoadBoard(Game.board);
			NpcAPI.LoadNPC();
		}
		else{
			Game.player = new Player(chooseCharacterMenu());
			Game.board = new Board(Game.player);

			NPC_generator.generateNPC(Game.board);
		}
		System.out.println("hui");
	}
}
