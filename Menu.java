package game.TeamProjectGame;

import game.TeamProjectGame.Characters.*;
import game.TeamProjectGame.Characters.Friends.*;
import game.TeamProjectGame.Pattern.*;

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
        public static Player chooseCharacterMenu(){ //obowiązkowo do wywołania na początku
                System.out.println("Choose number of a character:\n" +
                        "1 - HUMAN\n" +
                        "2 - DWARF\n" +
                        "3 - ELF\n");

                int n = choosingNumber(4);

                switch(n) {
                        case 1: return new Player(new Human(new RandomPattern()));
                        case 2: return new Player(new Dwarf(new RandomPattern()));
                        case 3: return new Player(new Elf(new RandomPattern()));
                        default: return null;
                }
        }

        /*public static void load(){
                Scanner scanner = new Scanner(System.in);
                Player player = new Player();



                if(loadPlayer(player)){
                        player = chooseCharacterMenu();
                }
                else{
                        System.out.println("Choose:\n" +
                                "1 - if you want to use data from previous game\n" +
                                "2 - if you want to start from the beginning\n");
                        int n = scanner.nextInt();
                        if(n == 2) {
                                player = chooseCharacterMenu();
                        }
                }
        }

         */

        public static void printStats(){

                        System.out.println(NPCFactory.getCharacters().get(0).getClass().getSimpleName()
                        + "\tHP: " + NPCFactory.getCharacters().get(0).getHp()
                        + "\tDmg: "+ NPCFactory.getCharacters().get(0).getDmg()
                        + "\tSpeed: " + NPCFactory.getCharacters().get(0).getSpeed());

        }

}
