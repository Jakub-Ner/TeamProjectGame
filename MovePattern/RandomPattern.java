package game.TeamProjectGame.MovePattern;

public class RandomPattern implements MovePattern {
    @Override
    public int[] pattern() {
        int[] random = new int[]{6,2,8,4,6,8,6,4,8,2,6,4,6,4,4,6,2,8,6,4,2,8,6,8,6,4,2,6,4,6,4,2,2,4,4,6,8,2};
        return random;
    }
}
