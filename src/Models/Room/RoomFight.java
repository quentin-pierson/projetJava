package Models.Room;
import Models.Character.Character;
import Models.Player;
import Services.DataServices;
import Services.Game;

public class RoomFight extends Room {

    private Character character;

    public RoomFight(int order, boolean isLocked, Character character) {
        super(order, isLocked);
        this.character = character;
        setName("Room Fight");
        setDescription(DataServices.getInstance().getRoomFight());
    }

    @Override
    public void enterInRoom(){
        Game game = Game.getInstance();
        game.displayFight(false,character);
    }

}
