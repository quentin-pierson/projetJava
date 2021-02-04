package Models.Room;
import Models.Character.Character;
import Models.Player;
import Services.DataServices;
import Services.Game;
import View.GameUI;

public class RoomTrap extends Room{

    private Character character;

    public RoomTrap(int order, boolean isLocked, Character character) {
        super(order, isLocked);
        this.character = character;
        setName("Room Trap");
        setDescription(DataServices.getInstance().getRoomTrap());
    }

    @Override
    public void enterInRoom(){
        Game game = Game.getInstance();
        game.displayFight(true, character,getDescriptionAndName());
    }

}
