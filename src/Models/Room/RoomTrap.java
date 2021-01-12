package Models.Room;
import Models.Character.Character;
import Models.Trader;


import java.util.ArrayList;

public class RoomTrap extends Room{

    private Character character;

    public RoomTrap(String name, String description, int order, boolean isLocked, Character character, RoomType roomType) {
        super(name, description, order, isLocked, roomType);
        this.character = character;
    }

    public Character getCharacter(){
        return character;
    }
}
