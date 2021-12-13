package game.TeamProjectGame;

import game.TeamProjectGame.Characters.Friends.Dwarf;
import game.TeamProjectGame.Characters.Friends.Elf;
import game.TeamProjectGame.Characters.Friends.Friend;
import game.TeamProjectGame.Characters.Friends.Human;
import game.TeamProjectGame.Characters.Player;
import game.TeamProjectGame.MovePattern.SquarePattern;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


        public static void start(){
                System.out.println("Welcome to our game!");
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
                while(n == 0){
					n = choosingNumber(4);
				}
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

}
