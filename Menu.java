package game.TeamProjectGame;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.CharacterFactory;

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
                        "3 - ELF\n" +
                        "4 - ORC\n" +
                        "5 - PHANTOM\n" +
                        "6 - DRAGON\n");

                int n = choosingNumber(6);
                return CharacterFactory.addCharacter(n-1);
        }

        public static void printCharacters(){
                for(int i = 0; i< CharacterFactory.getCharacters().size(); i++)
                {
                        System.out.println(CharacterFactory.getCharacters().get(i).getClass().getSimpleName()
                        + "HP: " + CharacterFactory.getCharacters().get(i).getHp()
                        + "Dmg: "+ CharacterFactory.getCharacters().get(i).getDmg()
                        + "Speed"     + CharacterFactory.getCharacters().get(i).getSpeed());
                }
        }
        public static int chooseAction(){
                System.out.println("What do you want to do? Choose number:\n" +
                        "1 - print a list of Characters\n" +
                        "2 - end the game\n");
                int n = choosingNumber(2);

                if(n==1) printCharacters();
                if(n==2) end();
                return 0;
        }

        public static void end(){
                System.out.println("Goodbye!");
        }


}
