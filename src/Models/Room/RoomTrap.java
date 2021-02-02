package Models.Room;
import Models.Character.Character;
import Models.Player;
import Services.Game;

public class RoomTrap extends Room{

    private Character character;

    public RoomTrap(String name, String description, int order, boolean isLocked, Character character) {
        super(name, description, order, isLocked);
        this.character = character;
    }

    @Override
    public void enterInRoom(Game game){
        game.displayFight(true, character);
    }
}
