package game.TeamProjectGame.Characters.Villains;

import game.TeamProjectGame.Characters.Character;
import game.TeamProjectGame.MovePattern.MovePattern;

public class Dragon extends Villain {

    //żeby pokonać smoka zapraszamy do zakupu naszego DLC (19,99$)
    public Dragon(MovePattern pattern) {
        super(1000,999,20, pattern);
    }

}
