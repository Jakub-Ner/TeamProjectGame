package game.TeamProjectGame.MeetingAndFight;

import game.TeamProjectGame.Characters.*;
import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.Characters.Friends.Friend;
import game.TeamProjectGame.Characters.Villains.Dragon;
import game.TeamProjectGame.Characters.Villains.Villain;

import javax.xml.stream.events.Characters;

class MeetingAndFight{

    public static void Meeting(Character char1, Character char2) {
        // Przyjaciel i przyjaciel, tu nie ma walki to dokończe później
        if(char1 instanceof Friend && char2 instanceof Friend){
            // Okrzyki
        }
        //  Przyjaciel i wróg, tu będzie wywoływana walka
        else if(char1 instanceof Friend && char2 instanceof Villain){

            // Fight(char1,char2)
            
        }else
        {
            // Na wszelki wypadek, jakby gracz był wpisany jako 2. argument
            Meeting(char2, char1);
        }
    }

    public static void Fight (Character friend, Character enemy)
    {

        if (enemy instanceof Dragon){
            friend.setHp(0);
            System.out.println("You lost the fight!");
        }
        else{
            if (friend.getSpeed()>enemy.getSpeed())
                enemy.setHp(enemy.getHp()-friend.getDmg());

            while (friend.getHp()>0 && enemy.getHp>0)
            {
                friend.setHp(friend.getHp()-enemy.getDmg());
                enemy.setHp(enemy.getHp()-friend.getDmg());
            }
            /*jezeli friend zginie w trakcie przejscia petli
            to nie ma znaczenia ze zada cios po smierci bo i tak game over*/

            if (friend.getHp()>0)
                System.out.println("You won the fight!");
            else
                System.out.println("You lost the fight!");
        }
    }
}