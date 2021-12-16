package game.TeamProjectGame.MovePattern;

import java.io.Serializable;

public class PlusPattern implements MovePattern, Serializable {
    int[] plus = new int[]{4,4,6,6,6,6,4,4,2,2,8,8,8,8,2,2,4,4,6,6,6,6,4,4,2,2,8,8,8,8,2,2};

    @Override
    public int[] pattern() {
        return plus;
    }
}
