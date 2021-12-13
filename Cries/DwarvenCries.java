package game.TeamProjectGame.Cries;

public class DwarvenCries implements Cry{
    @Override
    public void battleShout() { System.out.println("*Battle cry in Dwarven*"); }
    @Override
    public void friendlyShout() { System.out.println("*Friendly greeting in Dwarven*"); }
}
