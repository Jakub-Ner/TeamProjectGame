package game.TeamProjectGame.MovePattern;

public class PlusPattern implements MovePattern {
    @Override
    public int[] pattern() {
        int[] plus = new int[]{4,4,6,6,6,6,4,4,2,2,8,8,8,8,2,2,4,4,6,6,6,6,4,4,2,2,8,8,8,8,2,2};
        return plus;
    }
}
