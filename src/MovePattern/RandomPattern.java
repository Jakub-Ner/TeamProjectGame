package MovePattern;

import java.io.Serializable;

public class RandomPattern implements MovePattern, Serializable {
    int[] random = new int[]{6,2,8,4,6,8,6,4,8,2,6,4,6,4,4,6,2,8,6,4,2,8,6,8,6,4,2,6,4,6,4,2,2,4,4,6,8,2};

    @Override
    public int[] pattern() {
        return random;
    }
}
