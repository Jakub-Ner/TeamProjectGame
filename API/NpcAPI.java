package game.TeamProjectGame.API;

import game.TeamProjectGame.Characters.NPCFactory;
import game.TeamProjectGame.Characters.Npc;

import java.io.*;
import java.util.Vector;

public class NpcAPI implements Serializable {

	public static void SaveNPC() {

		try {
			ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("PlikNPC"));

			so.writeObject(NPCFactory.getCharacters());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void LoadNPC() {

		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("PlikNPC"));
			Object czyBrakObiektu = null;

			Object addedNPCS = is.readObject();

			NPCFactory.characters = (Vector<Npc>) addedNPCS;

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}