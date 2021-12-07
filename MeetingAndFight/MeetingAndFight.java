package game.TeamProjectGame.MeetingAndFight;

import game.TeamProjectGame.Characters.*;

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


}