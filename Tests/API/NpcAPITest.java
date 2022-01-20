package API;



import Characters.Friends.Dwarf;
import Characters.Friends.Human;
import Characters.NPCFactory;
import Characters.Npc;
import Characters.Villains.Dragon;
import MovePattern.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NpcAPITest {
    private Vector<Npc> expectedValue;

    public void createVector(){
       expectedValue.add(new Dragon(new SquarePattern()));
       expectedValue.add(new Dwarf(new LPattern()));
       expectedValue.add(new Dragon(new PlusPattern()));
    }

    @BeforeEach
    public void setData(){
        NPCFactory.setCharacters(expectedValue);
    }
    @Test
    public void SaveNPCTest() throws IOException, ClassNotFoundException{
        new NpcAPITest().setData();
        NpcAPI.SaveNPC();
        assertEquals(
                expectedValue,
                new ObjectInputStream(new FileInputStream("PlikNPC.ser")).readObject()
        );
    }
    @Test
    public void LoadNPCTest() throws IOException, ClassNotFoundException{
        NpcAPI.SaveNPC();

        NpcAPI.LoadNPC();

        assertEquals(
                expectedValue,
                NPCFactory.getCharacters()
        );
    }
}
