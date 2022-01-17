package MovePattern;

import java.io.Serializable;

public class LPattern implements MovePattern, Serializable {
    int[] l = new int[]{8,8,8,8,6,6,4,4,2,2,2,2,8,8,8,8,6,6,4,4,2,2,2,2,8,8,8,8,6,6,4,4,2,2,2,2,8,8,8,8,6,6,4,4,2,2,2,2};

    @Override
    public int[] pattern() {
        return l;
    }
}
