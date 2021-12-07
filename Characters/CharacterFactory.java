package game.TeamProjectGame.Characters;

import game.TeamProjectGame.Characters.Friends.*;
import game.TeamProjectGame.Characters.Villains.*;

import java.util.Vector;

public enum CharacterFactory {
	HUMAN, ELF, DWARF, ORC, PHANTOM, DRAGON;

	static Vector<Character> characters = new Vector<>();

	//returns pointer to a newly created character
	private static Character createNew(CharacterFactory type){
		switch (type) {
			case HUMAN: return new Human();
			case DWARF: return new Dwarf();
			case ELF: return new Elf();
			case ORC: return new Orc();
			case PHANTOM: return new Phantom();
			case DRAGON: return new Dragon();
		}
		return null;
	}

	//returns pointer to a newly created character
	private static Character createNew(int type){
		return CharacterFactory.createNew(toCharacterType(type));
	}

	/**
	 * <p>returns CharacterFactory interpretation of int</p>
	 * <p></p>
	 * <p>how it works:</p>
	 * <p>toCharacterType(0) returns HUMAN.</p>
	 * <p>toCharacterType(1) returns DWARF.</p>
	 * <p>toCharacterType(2) returns ELF.</p>
	 * <p>toCharacterType(3) returns ORC.</p>
	 * <p>toCharacterType(4) returns PHANTOM.</p>
	 * <p>toCharacterType(5) returns DRAGON.</p>
	 * @param	type	number to be interpreted
	 * @return	returns int as a type of character
	 */
	public static CharacterFactory toCharacterType(int type){
		return CharacterFactory.values()[type];
	}

	/**
	 * Inteface to work with character list
	 *
	 * @return	pointer to vector agregating all the characters
	 */
	public static Vector<Character> getCharacters(){
		return characters;
	}

	/**
	 * Adds new character to the list
	 *
	 * @param type	enum type of a character to be created
	 */
	public static void addCharacter(CharacterFactory type){
		characters.add(createNew(type));
	}

	/**
	 * Adds new character to the list
	 *
	 * @param type	is promoted to an enum type required for internal work
	 */
	public static void addCharacter(int type){
		characters.add(createNew(type));
	}

	@Override
	public String toString(){
		return super.toString().charAt(0) + super.toString().substring(1).toLowerCase();
	}
}
