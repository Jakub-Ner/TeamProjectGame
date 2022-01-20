package API;

import Characters.Friends.Friend;
import Characters.Friends.Human;
import Characters.Player;
import Main.Game;
import MovePattern.LPattern;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PlayerAPITest {

    Player player = new Player(new Human(new LPattern()));

    @Test
    public void testSaving() throws IOException, ClassNotFoundException {
        PlayerAPI.savePlayer(player);

        Assertions.assertEquals(player, new ObjectInputStream(new FileInputStream("Player.ser")).readObject());
    }


}
