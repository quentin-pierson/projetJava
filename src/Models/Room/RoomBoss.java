package Models.Room;

import Models.Character.Character;
import Models.Player;
import Services.Game;

public class RoomBoss extends Room{

    private Character character;

    public RoomBoss(String name, String description, int order, boolean isLocked, Character character) {
        super(name, description, order, isLocked);
        this.character = character;
    }

    @Override
    public void enterInRoom(Game game){
        game.displayFight(false, character);
        game.win();
    }
}
