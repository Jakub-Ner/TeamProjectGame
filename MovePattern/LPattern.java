package game.TeamProjectGame.MovePattern;

import java.io.Serializable;

public class LPattern implements MovePattern, Serializable {

    @Override
    public int[] pattern() {
        int[] l = new int[]{8,8,8,8,6,6,4,4,2,2,2,2,8,8,8,8,6,6,4,4,2,2,2,2,8,8,8,8,6,6,4,4,2,2,2,2,8,8,8,8,6,6,4,4,2,2,2,2};
        return l;
    }

}
