package MovePattern;

import java.io.Serializable;

public class UPattern implements MovePattern, Serializable {
    int[] u = new int[]{8,8,8,8,6,6,2,2,2,2,8,8,8,8,4,4,2,2,2,2,8,8,8,8,6,6,2,2,2,2,8,8,8,8,4,4,2,2,2,2};

    @Override
    public int[] pattern() {
        return u;
    }
}
