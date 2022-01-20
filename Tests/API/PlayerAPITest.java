package API;

import Characters.Friends.Friend;
import Characters.Friends.Human;
import Characters.Player;
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

    @BeforeEach
    public void setUp() {

        PlayerAPI.savePlayer(player);
    }

    @Test
    public void testLoading() throws IOException, ClassNotFoundException {

        Assertions.assertEquals(player, PlayerAPI.loadPlayer());
    }





}
