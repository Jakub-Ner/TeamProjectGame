package game.TeamProjectGame.MeetingAndFight;


import game.TeamProjectGame.Board.Board;
import game.TeamProjectGame.Characters.*;
import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.Friends.Friend;
import game.TeamProjectGame.Characters.Villains.Dragon;
import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.Friends.Friend;


import game.TeamProjectGame.Characters.Villains.Villain;
import game.TeamProjectGame.Menu;

import javax.xml.stream.events.Characters;

public class MeetingAndFight{

    public static void Meeting(Character char1, Character char2, Board board) {
        // Przyjaciel i przyjaciel, tu nie ma walki to dokończe później
        if(char1 instanceof Friend && char2 instanceof Friend){
            ((Friend) char1).getFriendlyCry();
        }
        //  Przyjaciel i wróg, tu będzie wywoływana walka
        else if(char1 instanceof Friend && char2 instanceof Villain){
            ((Friend) char1).getBattleCry();
            Fight(char1,char2, board);
            
        }else
        {
            // Na wszelki wypadek, jakby gracz był wpisany jako 2. argument
            Meeting(char2, char1, board);
        }
    }

    public static void Fight (Character friend, Character enemy, Board board)
    {

        if (enemy instanceof Dragon){
            friend.setHp(0);
            System.out.println("You lost the fight!");
        }
        else{
            if (friend.getSpeed()>enemy.getSpeed())
                enemy.setHp(enemy.getHp()-friend.getDmg());

            while (friend.getHp()>0 && enemy.getHp()>0)
            {
                friend.setHp(friend.getHp()-enemy.getDmg());
                enemy.setHp(enemy.getHp()-friend.getDmg());
            }
            /*jezeli friend zginie w trakcie przejscia petli
            to nie ma znaczenia ze zada cios po smierci bo i tak game over*/

            if (friend.getHp()>0) {
                System.out.println("You won the fight!");
                board.board[enemy.getX()][enemy.getY()] = '+';
                Menu.printStats();
            }
            else
                System.out.println("You lost the fight!");
        }
    }
}
