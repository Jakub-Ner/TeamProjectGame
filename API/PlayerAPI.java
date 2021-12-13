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

    public boolean loadPlayer(Player player){
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Player.ser"))) {
            Object obj1 = is.readObject();
            player = null;
            player = (Player) obj1;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File ("Player.ser");
        return checkFileEpmty(file);
    }

    public static boolean checkFileEpmty (File file){
        if(file.length()==0)
            return true;
        else
            return false;
    }
}
