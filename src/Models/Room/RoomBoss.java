package Models.Room;

import Models.Character.Character;
import Models.Player;
import Services.DataServices;
import Services.Game;

public class RoomBoss extends Room{

    private Character character;

    public RoomBoss(int order, boolean isLocked, Character character) {
        super(order, isLocked);
        this.character = character;
        setName("Room Boss");
        setDescription(DataServices.getInstance().getRoomBoss());
    }

    @Override
    public void enterInRoom(){
        Game game = Game.getInstance();
        game.displayFight(false, character);
        game.win();
    }

}
