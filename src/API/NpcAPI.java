package API;

import Characters.NPCFactory;
import Characters.Npc;

import java.io.*;
import java.util.Vector;

public class NpcAPI implements Serializable {

	public static void SaveNPC() {
		try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("PlikNPC"));) {
			so.writeObject(NPCFactory.getCharacters());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void LoadNPC() {

		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("PlikNPC"));) {
			Object czyBrakObiektu = null;

			Object addedNPCS = is.readObject();

			NPCFactory.setCharacters((Vector<Npc>) addedNPCS);

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}