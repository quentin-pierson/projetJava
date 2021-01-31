package Models.Room;
import Models.Character.Character;

public class RoomFight extends Room {

    private Character character;

    public RoomFight(String name, String description, int order, boolean isLocked, Character character, RoomExisting roomExisting) {
        super(name, description, order, isLocked, roomExisting);
        this.character = character;
    }

    public Character getCharacter(){
        return character;
    }
}
