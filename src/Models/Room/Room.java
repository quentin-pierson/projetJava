package Models.Room;

import Models.Player;
import Services.CSVServices;
import Services.FileServices;
import Services.Game;

import java.util.ArrayList;
import java.util.Random;

public class Room {
    protected String name;
    protected String description;
    protected int order;
    protected boolean isLocked;
    protected boolean playerPresent;

    public Room(int order, boolean isLocked) {
        this.order = order;
        this.isLocked = isLocked;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void enterInRoom(Game game){

    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setDescription(String descriptionFilePath){
        FileServices fileServices = new FileServices();

        ArrayList<String> descList = fileServices.fileReader(descriptionFilePath);

        Random random = new Random();

        int desc = random.nextInt(descList.size());
        description = descList.get(desc);
    }
}
