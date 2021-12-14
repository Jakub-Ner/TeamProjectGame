package game.TeamProjectGame.API;

import game.TeamProjectGame.Characters.NPCFactory;
import game.TeamProjectGame.Characters.Npc;

import java.io.*;

public class NpcAPI implements Serializable {

    public void SaveNPC() {

        try {
            ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("PlikNPC"));

            for(int i = 0; i < NPCFactory.getCharacters().size(); i++) {

                so.writeObject(NPCFactory.getCharacters().get(i));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LoadNPC() {

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("PlikNPC"));
            Object czyBrakObiektu = null;

            while ( (czyBrakObiektu = is.readObject()) != null ) {

                Object addedNPC = is.readObject();

                NPCFactory.addCharacter( (Npc) addedNPC );
            }

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}



