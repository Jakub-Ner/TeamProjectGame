
package game.TeamProjectGame.API;

import game.TeamProjectGame.Characters.Player;

import java.io.IOException;
import java.io.*;

public class PlayerAPI {
    public static void savePlayer(Player player) {
        try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("Player.ser")))
        {
            so.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean loadPlayer(Player player){
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Player.ser"))) {
            Object obj1 = is.readObject();
            player = null;
            player = (Player) obj1;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File ("Player.ser");
        return checkFileEmpty(file);
    }

    public static boolean checkFileEmpty(File file){
        if(file.length()==0)
            return true;
        else
            return false;
    }
}
