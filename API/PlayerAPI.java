package game.TeamProjectGame.API;

import game.TeamProjectGame.Characters.Player;

import java.io.IOException;
import java.io.*;

public class PlayerAPI {
    public void savePlayer(Player player) {
        try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("Player.ser")))
        {
            so.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadPlayer(Player player){
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Player.ser"))) {
            Object obj1 = is.readObject();
            player = null;
            player = (Player) obj1;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
