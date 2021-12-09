package game.TeamProjectGame;

import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.CharacterFactory;
import game.TeamProjectGame.Characters.Friends.Dwarf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    public int choosingCharacterMenu(int options){

        int input;

        try{input = scanner.nextInt();} catch (InputMismatchException e){
            scanner.nextLine();
            input = -1;
        }

        while(0 > input || options <= input){
            System.out.print("Answer out of reach! Try again.\n>");

            try{input = scanner.nextInt();} catch (InputMismatchException e){
                scanner.nextLine();
                input = -1;
            }
        }

        return input;
    }

    public void menu() {

        System.out.println("Choose your character:");
        System.out.println("1. Human");
        System.out.println("2. Dwarf");
        System.out.println("3. Elf");
        System.out.println("0. Exit");

        switch( choosingCharacterMenu(3) )
        {
            case 1:
                CharacterFactory.addCharacter( CharacterFactory.HUMAN );
                break;
            case 2:
                CharacterFactory.addCharacter( CharacterFactory.DWARF );
                break;
            case 3:
                CharacterFactory.addCharacter( CharacterFactory.ELF );
                break;
            case 0:
                return;

        }
    }

    public void run(){

        Character player = Menu.chooseCharacterMenu();

        boolean run = true;

        menu();
        player = CharacterFactory.getCharacters().lastElement();

        Board board = new Board(player);
//        startMenu()
//        chooseCharacter();

        board.initBoard();

        while (run) {

            board.updateBoard( scanner.nextInt() );


        }


    }

}
