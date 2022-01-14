package game.TeamProjectGame.Main;

import game.TeamProjectGame.API.*;
import game.TeamProjectGame.Board.*;
import game.TeamProjectGame.Characters.Friends.*;
import game.TeamProjectGame.Characters.Player;
import game.TeamProjectGame.Cries.DwarvenCries;
import game.TeamProjectGame.Cries.ElvenCries;
import game.TeamProjectGame.Cries.HumanCries;
import game.TeamProjectGame.MovePattern.SquarePattern;
import game.TeamProjectGame.Main.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;

import static game.TeamProjectGame.API.BoardAPI.LoadBoard;

public class Menu implements Serializable {
	private static boolean startNewGame = true;

	public static void start(Friend player) {
		File file = new File("Player.ser");
		//checks if there's an already existing game (if yes, it loads data from it)
		if (PlayerAPI.checkFile(file)) {
			if (!startNewGame) {
				Game.player = PlayerAPI.loadPlayer();
				Game.board = new Board(Game.player);
				LoadBoard(Game.board);
				NpcAPI.LoadNPC();
			} else {
				startGame(player);
			}
		} else {
			startGame(player);
		}
	}

	public static void startGame(Friend player) { //from the beginning
		Game.player = new Player(player);
		Game.player.setCry(player.getCry());
		Game.board = new Board(Game.player);
		NPC_generator_NEW.generateNPC(Game.board);
	}

	public static void setStartNewGame(boolean startNewGame) {
		Menu.startNewGame = startNewGame;
	}
}
