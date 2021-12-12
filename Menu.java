package game.TeamProjectGame;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.NPCFactory;

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
        public static Character chooseCharacterMenu(){ //obowiązkowo do wywołania na początku
                System.out.println("Choose number of a character:\n" +
                        "1 - HUMAN\n" +
                        "2 - DWARF\n" +
                        "3 - ELF\n");

                int n = choosingNumber(4);
                return NPCFactory.addCharacter(n-1);
        }

        public static void printStats(){

                        System.out.println(NPCFactory.getCharacters().get(0).getClass().getSimpleName()
                        + "\tHP: " + NPCFactory.getCharacters().get(0).getHp()
                        + "\tDmg: "+ NPCFactory.getCharacters().get(0).getDmg()
                        + "\tSpeed: " + NPCFactory.getCharacters().get(0).getSpeed());

        }

}
