package game.TeamProjectGame.Main;

import game.TeamProjectGame.API.*;
import game.TeamProjectGame.Board.*;
import game.TeamProjectGame.Characters.Player;

import java.io.File;
import java.io.Serializable;

import static game.TeamProjectGame.API.BoardAPI.LoadBoard;

public class Menu implements Serializable {

    MenuGUI menuGUI = new MenuGUI();

    public static void printStats(Player player) {
        System.out.println(player.getClass().getSimpleName()
                + "\tHP: " + player.getHp()
                + "\tDmg: " + player.getDmg()
                + "\tSpeed: " + player.getSpeed());
    }

    public void load() {
        File file = new File("Player.ser");

        if (PlayerAPI.checkFile(file)) {

            if (!menuGUI.isStartNewGame()) {
                Game.player = PlayerAPI.loadPlayer();
                Game.board = new Board(Game.player);
                LoadBoard(Game.board);
                NpcAPI.LoadNPC();
            } else {
                startGame();
            }
        } else {
            startGame();
        }
    }

    public void startGame() { //from the beginning
        Game.player = new Player(menuGUI.getChosenCharacter());
        Game.board = new Board(Game.player);
        NPC_generator_NEW.generateNPC(Game.board);
    }

    public void startMenu() {
        menuGUI.drawMenu();
        load();
    }



}
