package game.TeamProjectGame.Cries;

public class HumanCries implements Cry{
    @Override
    public void battleShout() { System.out.println("*Battle cry in Human Language*"); }
    @Override
    public void friendlyShout() { System.out.println("*Friendly greeting in Human Language*"); }
}
