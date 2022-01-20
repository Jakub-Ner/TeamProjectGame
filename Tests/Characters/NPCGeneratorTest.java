package Characters;

import Board.*;
import game.TeamProjectGame.src.Board.Board;
import game.TeamProjectGame.src.Board.NPC_generator_NEW;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class NPCGeneratorTest {

    private Board b;
    private NPC_generator_NEW gen;

    @BeforeEach
    public void beforeEach() {
        b = mock(Board.class);
        Board.board = new char[b.HEIGHT][b.WIDTH];

        for (int y = 0; y < b.HEIGHT; y++) {
            for (int x = 0; x < b.WIDTH; x++) {
                Board.board[y][x] = ' ';
            }
        }

        NPCFactory.getCharacters().clear();
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
        assertEquals(gen.getN(), NPCFactory.getCharacters().size());
    }


    @Test
    public void shouldAllInPlace() {
        boolean inPlace = true;

        for (Npc npc: NPCFactory.getCharacters()) {
            if (Board.board[npc.getY()][npc.getX()] != npc.getSymbol()) {
                inPlace = false;
                break;
            }
        }

        assertTrue(inPlace);
    }
}
