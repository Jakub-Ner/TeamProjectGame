package MovePattern;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class MovePatternTest {
    private void patternTest(int[] pattern){
        for(int step: pattern){
            assertEquals("Result", 0, step % 2);
        }
    }
    @Test
    public void lPatternTest(){
        patternTest(new LPattern().pattern());
    }
}
