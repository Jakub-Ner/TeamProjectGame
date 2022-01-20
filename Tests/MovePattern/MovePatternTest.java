package MovePattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class MovePatternTest {

    private void patternTest(int[] pattern){
        for(int step: pattern){
            assertEquals("Result", 0, step % 2);
            assertTrue("Result", step > 0 && step <10);
        }
    }
    @Test
    public void PlusPatternTest(){
        patternTest(new PlusPattern().pattern());
    }

    @Test
    public void RandomPatternTest(){
        patternTest(new RandomPattern().pattern());
    }
    @Test
    public void SPatternTest(){
        patternTest(new SPattern().pattern());
    }
    @Test
    public void SquarePatternTest(){
        patternTest(new SquarePattern().pattern());
    }
    @Test
    public void UPatternTest(){
        patternTest(new UPattern().pattern());
    }

}
