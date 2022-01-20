package Characters;

import Board.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class NPCGeneratorTest {

    private Board b;
    private NPC_generator_NEW gen;
    private NPCFactory factory;

    @BeforeEach
    public void beforeEach() {
        b = mock(Board.class);
        Board.board = new char[b.HEIGHT][b.WIDTH];

        for (int y = 0; y < b.HEIGHT; y++) {
            for (int x = 0; x < b.WIDTH; x++) {
                Board.board[y][x] = ' ';
            }
        }

        factory = mock(NPCFactory.class);
        factory.getCharacters().clear();
        gen = new NPC_generator_NEW();
        NPC_generator_NEW.generateNPC(b);
    }

    @Test
    public void shouldAllOnBoard() {
        int l = 0;
        String symbols = "edhPDO";

        for (int y = 0; y < b.HEIGHT; y++) {
            for (int x = 0; x < b.WIDTH; x++) {
                if (symbols.indexOf(Board.board[y][x]) != -1) l++; //checks for NPC symbols
            }
        }
        assertEquals(l, gen.getN());
    }

    @Test
    public void shouldAllExist() {
        assertEquals(gen.getN(), factory.getCharacters().size());
    }


    @Test
    public void shouldAllInPlace() {
        boolean inPlace = true;

        for (Npc npc: factory.getCharacters()) {
            if (Board.board[npc.getY()][npc.getX()] != npc.getSymbol()) {
                inPlace = false;
                break;
            }
        }

        assertTrue(inPlace);
    }
}
