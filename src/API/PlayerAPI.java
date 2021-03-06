package API;

import Characters.Player;

import java.io.IOException;
import java.io.*;

public class PlayerAPI {

	//Saves a player we were playing
	public static void savePlayer(Player player) {
		try (ObjectOutputStream so = new ObjectOutputStream(new FileOutputStream("Player.ser"))) {
			so.writeObject(player);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Loads a chosen player from "Player.ser" file and returns it
	//Returns null if Exception has been thrown
	public static Player loadPlayer() {
		Player player;
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("Player.ser"))) {
			Object obj1 = is.readObject();
			player = (Player) obj1;
		} catch (IOException | ClassNotFoundException e) {
			player = null;
			e.printStackTrace();
		}
		return player;
	}

	//Returns
	//true if "Player.ser" file exists and isn't empty
	//false if "PLayer.ser" file hasn't been created or is empty
	public static boolean checkFile(File file) {
		if (file.length() == 0)
			return false;
		else
			return true;
	}
}