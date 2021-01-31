package Models.Room;

import Models.Character.Character;

public class RoomBoss extends Room{

    private Character character;

    public RoomBoss(String name, String description, int order, boolean isLocked, Character character, RoomExisting roomExisting) {
        super(name, description, order, isLocked, roomExisting);
        this.character = character;
    }

    public Character getCharacter(){
        return character;
    }
}
