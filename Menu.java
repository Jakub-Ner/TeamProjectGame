package game.TeamProjectGame;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.CharacterFactory;

import java.util.Scanner;

public class Menu {
        public static void Start(){
                System.out.println("Welcome to our game!");
        }
        public static Character chooseCharacterMenu(){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Choose number of a character:\n" +
                        "1 - HUMAN\n" +
                        "2 - DWARF\n" +
                        "3 - ELF\n" +
                        "4 - ORC\n" +
                        "5 - PHANTOM\n" +
                        "6 - DRAGON\n");

                int n = scanner.nextInt() - 1;
                return CharacterFactory.addCharacter(n);
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
        //public static void


}
