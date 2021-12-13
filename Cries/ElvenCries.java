package game.TeamProjectGame.Cries;

public class ElvenCries implements Cry{
    @Override
    public void battleShout() { System.out.println("*Battle cry in Elvish*"); }

    @Override
    public void friendlyShout() { System.out.println("*Friendly greeting in Elvish*"); }
}
