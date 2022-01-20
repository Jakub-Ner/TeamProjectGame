package API;
import Characters.Friends.Dwarf;
import Characters.NPCFactory;
import Characters.Npc;
import Characters.Villains.Dragon;
import MovePattern.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class NpcAPITest {
    private Vector<Npc> expectedValue = new Vector<>();

    public void createVector(){
       //expectedValue.add(new Dragon(new SquarePattern()));
       expectedValue.add(new Dwarf(new LPattern()));
       //expectedValue.add(new Dragon(new PlusPattern()));
    }

    @BeforeEach
    public void setData(){
        createVector();
        NPCFactory.setCharacters(expectedValue);
    }
    @Test
    public void SaveNPCTest() throws IOException, ClassNotFoundException{
        //setData();
        NpcAPI.SaveNPC();


        assertEquals(
                expectedValue.toString(),
                (new ObjectInputStream(new FileInputStream("PlikNPC.ser")).readObject().toString()));
    }
    @Test
    public void LoadNPCTest() throws IOException, ClassNotFoundException{

        NpcAPI.SaveNPC();
        NpcAPI.LoadNPC();

        assertEquals(
                expectedValue.toString(),
                NPCFactory.getCharacters().toString()
        );
    }
}
