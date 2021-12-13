package game.TeamProjectGame.MovePattern;

import java.io.Serializable;

public class SquarePattern implements MovePattern, Serializable {
    @Override
    public int[] pattern() {
        int[] square = new int[]{2,2,6,6,8,8,4,4,2,2,6,6,8,8,4,4,2,2,6,6,8,8,4,4,2,2,6,6,8,8,4,4,2,2,6,6,8,8,4,4,2,2,6,6,8,8,4,4};
        return square;
    }
}
