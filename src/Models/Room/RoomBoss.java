package Models.Room;

import Models.Character.Character;
import Models.Player;
import Services.Game;

public class RoomBoss extends Room{

    private Character character;

    public RoomBoss(int order, boolean isLocked, Character character) {
        super(order, isLocked);
        this.character = character;
        setName("Room Boss");
        setDescription("/Data/Room/RoomBossData.txt");
    }

    @Override
    public void enterInRoom(Game game){
        game.displayFight(false, character);
        game.win();
    }

}
