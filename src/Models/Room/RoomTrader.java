package Models.Room;
import Models.Trader;
import java.util.ArrayList;

public class RoomTrader extends Room{

    private Trader trader;

    public RoomTrader(String name, String description, int order, boolean isLocked, Trader trader) {
        super(name, description, order, isLocked);
    }

    public Trader getTrader(){
        return trader;
    }
}
