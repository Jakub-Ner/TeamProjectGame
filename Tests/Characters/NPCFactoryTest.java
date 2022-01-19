package Characters;

import Characters.Friends.Dwarf;
import Characters.Friends.Elf;
import Characters.Friends.Human;
import Characters.Villains.Dragon;
import Characters.Villains.Orc;
import Characters.Villains.Phantom;
import MovePattern.MovePattern;
import org.junit.jupiter.api.Test;

import static Characters.NPCFactory.*;
import static org.junit.jupiter.api.Assertions.*;

class NPCFactoryTest {

    @Test
    public void shouldReturnTypeHuman(){
        assertEquals(NPCTypes.HUMAN, toCharacterType(0));
    }
    @Test
    public void shouldReturnTypeDwarf(){
        assertEquals(NPCTypes.DWARF, toCharacterType(1));
    }
    @Test
    public void shouldReturnTypeElf(){
        assertEquals(NPCTypes.ELF, toCharacterType(2));
    }
    @Test
    public void shouldReturnTypeOrc(){
        assertEquals(NPCTypes.ORC, toCharacterType(3));
    }
    @Test
    public void shouldReturnTypePhantom(){
        assertEquals(NPCTypes.PHANTOM, toCharacterType(4));
    }
    @Test
    public void shouldReturnTypeDragon(){
        assertEquals(NPCTypes.DRAGON, toCharacterType(5));
    }

    @Test
    public void shouldReturnHuman(){
        boolean isItHuman;
        if(addCharacter(0) instanceof Human){
            isItHuman = true;
        } else {
            isItHuman = false;
        }
        assertTrue(isItHuman);
    }

    @Test
    public void shouldReturnDwarf(){
        boolean isItDwarf;
        if(addCharacter(1) instanceof Dwarf){
            isItDwarf = true;
        } else {
            isItDwarf = false;
        }
        assertTrue(isItDwarf);
    }
    @Test
    public void shouldReturnElf(){
        boolean isItElf;
        if(addCharacter(2) instanceof Elf){
            isItElf = true;
        } else {
            isItElf = false;
        }
        assertTrue(isItElf);
    }
    @Test
    public void shouldReturnOrc(){
        boolean isItOrc;
        if(addCharacter(3) instanceof Orc){
            isItOrc = true;
        } else {
            isItOrc = false;
        }
        assertTrue(isItOrc);
    }
    @Test
    public void shouldReturnPhantom(){
        boolean isItPhantom;
        if(addCharacter(4) instanceof Phantom){
            isItPhantom = true;
        } else {
            isItPhantom = false;
        }
        assertTrue(isItPhantom);
    }
    @Test
    public void shouldReturnDragon(){
        boolean isItDragon;
        if(addCharacter(5) instanceof Dragon){
            isItDragon = true;
        } else {
            isItDragon = false;
        }
        assertTrue(isItDragon);
    }

}