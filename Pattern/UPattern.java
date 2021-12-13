package game.TeamProjectGame.Pattern;

public class UPattern implements MovePattern{
    @Override
    public int[] pattern() {
        int[] u = new int[]{8,8,8,8,6,6,2,2,2,2,8,8,8,8,4,4,2,2,2,2,8,8,8,8,6,6,2,2,2,2,8,8,8,8,4,4,2,2,2,2};
        return u;
    }
}
