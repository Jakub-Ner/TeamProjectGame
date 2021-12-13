package game.TeamProjectGame;

import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.Friends.Friend;
import game.TeamProjectGame.Characters.NPCFactory;
import game.TeamProjectGame.Characters.Player;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import static game.TeamProjectGame.API.PlayerAPI.loadPlayer;
import static game.TeamProjectGame.API.BoardAPI.LoadBoard;
public class Menu {


        public static void start(Player player, Board board){
                System.out.println("Welcome to our game!");
                load(player,board);
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
        public static Player chooseCharacterMenu(){
                System.out.println("Choose number of a character:\n" +
                        "1 - HUMAN\n" +
                        "2 - DWARF\n" +
                        "3 - ELF");

                int n = choosingNumber(4);

                return new Player((Friend) NPCFactory.addCharacter(n-1));
        }

        public static void load(Player player, Board board){

                Scanner scanner = new Scanner(System.in);


                if(loadPlayer(player)){ //load player tworzy Playera z danych z pliku oraz zwraca true jesli plik jest pusty(wtedy player pozostaje domyslny)
                        player = chooseCharacterMenu();
                }
                else{
                        System.out.println("Choose:\n" +
                                "1 - if you want to use data from previous game\n" +
                                "2 - if you want to start from the beginning\n");
                        int n = scanner.nextInt();
                        if(n == 1){
                                LoadBoard(board);
                        }
                        else{
                                player = chooseCharacterMenu();
                        }
                }
        }

        public static void printStats(){

                        System.out.println(NPCFactory.getCharacters().get(0).getClass().getSimpleName()
                        + "\tHP: " + NPCFactory.getCharacters().get(0).getHp()
                        + "\tDmg: "+ NPCFactory.getCharacters().get(0).getDmg()
                        + "\tSpeed: " + NPCFactory.getCharacters().get(0).getSpeed());

        }

}
