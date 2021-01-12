package Models.Room;

import Models.Character.Character;

import java.util.ArrayList;

public class RoomBoss extends Room{

    private Character character;

    public RoomBoss(String name, String description, int order, boolean isLocked, Character character, RoomType roomType) {
        super(name, description, order, isLocked, roomType);
        this.character = character;
    }

    public Character getCharacter(){
        return character;
    }
}
