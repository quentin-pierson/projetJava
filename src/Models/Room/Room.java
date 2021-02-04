package Models.Room;

import Models.Player;
import Services.CSVServices;
import Services.FileServices;
import Services.Game;
import View.GameUI;

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

    public void enterInRoom(){

    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setDescription(String description){
       this.description = description;
    }
}
