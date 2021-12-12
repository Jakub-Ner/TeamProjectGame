package game.TeamProjectGame.MovePattern;

public class SPattern implements MovePattern{
    @Override
    public int[] pattern() {
        int[] s = new int[]{4,4,8,8,6,6,8,8,4,4,6,6,2,2,4,4,2,2,6,6,4,4,8,8,6,6,8,8,4,4,6,6,2,2,4,4,2,2,6,6};
        return s;
    }
}
