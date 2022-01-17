package MovePattern;

import java.io.Serializable;

public class SquarePattern implements MovePattern, Serializable {
    int[] square = new int[]{2,2,6,6,8,8,4,4,2,2,6,6,8,8,4,4,2,2,6,6,8,8,4,4,2,2,6,6,8,8,4,4,2,2,6,6,8,8,4,4,2,2,6,6,8,8,4,4};

    @Override
    public int[] pattern() {
        return square;
    }
}
