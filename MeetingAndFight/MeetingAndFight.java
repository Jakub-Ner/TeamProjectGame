package game.TeamProjectGame.MeetingAndFight;


import game.TeamProjectGame.API.BoardAPI;
import game.TeamProjectGame.API.NpcAPI;
import game.TeamProjectGame.API.PlayerAPI;
import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.Characters.*;
import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.Friends.Friend;


import game.TeamProjectGame.Characters.Villains.Villain;
import game.TeamProjectGame.Main.Game;
import game.TeamProjectGame.Main.Menu;

import javax.swing.*;


public class MeetingAndFight {


	public static void Meeting(Character char1, Character char2, Board board, JLabel messages) {
		messages.setText("");
		if(char1 instanceof Player){
			// Przyjaciel i przyjaciel, tu nie ma walki to dokończe później
			if (char2 instanceof Friend) {
				messages.setText(((Player) char1).getCry().friendlyShout());
			}
			//  Przyjaciel i wróg, tu będzie wywoływana walka
			else if (char2 instanceof Villain) {
				messages.setText(((Player) char1).getCry().battleShout());
				PlayerFight((Player) char1, char2, board, messages);
			}
		} else{
			if(char1.getClass() != char2.getClass()){
				Fight(char1, char2, board);
			}
		}
	}

	public static void PlayerFight(Player friend, Character enemy, Board board, JLabel messages) {
		Fight(friend, enemy, board);
		messages.setText("");
		
		if (friend.getHp() > 0) {
			messages.setText("You won the fight!");
		} else
			messages.setText("You lost the fight!");

		PlayerAPI.savePlayer(Game.player);
		BoardAPI.SaveBoard(Game.board);
		NpcAPI.SaveNPC();
	}

	private static void Fight(Character friend, Character enemy, Board board){
		if (friend.getSpeed() > enemy.getSpeed())
			enemy.setHp(enemy.getHp() - friend.getDmg());

		while (friend.getHp() > 0 && enemy.getHp() > 0) {
			friend.setHp(friend.getHp() - enemy.getDmg());
			enemy.setHp(enemy.getHp() - friend.getDmg());
		}
        /*jezeli friend zginie w trakcie przejscia petli
        to nie ma znaczenia ze zada cios po smierci bo i tak game over*/

		if (friend.getHp() > 0) {
			board.board[enemy.getY()][enemy.getX()] = '+';
		} else {
			board.board[friend.getY()][friend.getX()] = '+';
		}
	}
}
