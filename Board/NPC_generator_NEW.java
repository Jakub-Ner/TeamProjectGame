package game.TeamProjectGame.Board;

import game.TeamProjectGame.Characters.NPCFactory;
import game.TeamProjectGame.Characters.NPCTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//22 linie, optymalniejsze
public class NPC_generator_NEW {
	final static int n = 30;

	public static void generateNPC(Board board) {
		Random rand = new Random();
		Map<Integer, Integer> data = new HashMap<>();
		int counter = 0;

		/* zapełniam data pustymi pozycjami z board, pozycję zapisuję jako x + y * board.WIDTH, co dalej nazwę ID
		 * by z ID uzyskać koordynaty, wystarczy zrobić poniższe
		 * x = ID % board.WIDTH
		 * y = ID / board.WIDTH
		 * działa, testowane niejednokrotnie
		 */
		for (int y = 0; y < board.HEIGHT; y++)
			for (int x = 0; x < board.WIDTH; x++)
				if (Board.board[y][x] == ' ') data.put(data.size(), x + y * board.WIDTH);

		//tu dopiero tworzę NPC
		for (int i = 0; i < n; i++) {
			//dodaję nowego npc
			NPCFactory.addCharacter(rand.nextInt(NPCTypes.values().length));

			//counter = ID, czyli zakodowanej pozycji
			counter = data.put(rand.nextInt(data.size() - 1), data.get(data.size() - 1));
			data.remove(data.size() - 1);

			//ustawiam pozycję NPC na tą wylosowaną
			NPCFactory.getCharacters().lastElement().firstCoordinates(counter % board.WIDTH, counter / board.WIDTH);

			//wypełniam mapę
			Board.board[counter / board.WIDTH][counter % board.WIDTH] = NPCFactory.getCharacters().lastElement().getSymbol();
		}
	}
}
