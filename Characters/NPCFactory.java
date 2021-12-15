package game.TeamProjectGame.Characters;

import game.TeamProjectGame.Characters.Friends.*;
import game.TeamProjectGame.Characters.Villains.*;
import game.TeamProjectGame.MovePattern.*;

import java.util.Random;
import java.util.Vector;

public class NPCFactory {
	private static MovePattern[] movePatterns = {
			new LPattern(),
			new PlusPattern(),
			new UPattern(),
			new RandomPattern(),
			new SPattern(),
			new SquarePattern()
	};
	private static Random random = new Random();

	public static Vector<Npc> characters = new Vector<>();	//but dont touch

	//returns pointer to a newly created character
	private static Npc createNew(NPCTypes type){
		switch (type) {
			case HUMAN: return new Human(chooseMovePattern());
			case DWARF: return new Dwarf(chooseMovePattern());
			case ELF: return new Elf(chooseMovePattern());
			case ORC: return new Orc(chooseMovePattern());
			case PHANTOM: return new Phantom(chooseMovePattern());
			case DRAGON: return new Dragon(chooseMovePattern());
		}
		return null;
	}

	private static MovePattern chooseMovePattern(){
		return movePatterns[random.nextInt(movePatterns.length)];
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
	public static NPCTypes toCharacterType(int type){
		return NPCTypes.values()[type];
	}

	/**
	 * Inteface to work with character list
	 *
	 * @return	pointer to vector aggregating all the characters
	 */
	public static Vector<Npc> getCharacters(){
		return characters;
	}

	/**
	 * Adds new character to the list
	 *
	 * @param type	enum type of character to be created
	 * @return returns newly created character
	 */
	public static Npc addCharacter(NPCTypes type){
		characters.add(createNew(type));
		return characters.lastElement();
	}

	/**
	 * Adds new npc to the list
	 *
	 * @param type	is promoted to an enum type required for internal work
	 * @return returns newly created character
	 */
	public static Npc addCharacter(int type){
		characters.add(createNew(toCharacterType(type)));
		return characters.lastElement();
	}


}