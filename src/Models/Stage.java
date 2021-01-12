package Models;

import Models.Character.Character;
import Models.Room.*;
import Models.Trader;

import java.util.ArrayList;
import java.util.Random;

public class Stage {
    private int difficulty;
    private int numberRoom;
    private ArrayList<Room> rooms;
    private Stage nextStage;
    private int typeOfRoomGeneration;

    public Stage(int minRoom, int maxRoom) {
        generateRoom(minRoom, maxRoom);
    }

    private void generateRoom(int minRoom, int maxRoom){
        Random randomRoom = new Random();

        numberRoom = randomRoom.nextInt(maxRoom - minRoom) + minRoom;
        System.out.println(numberRoom);
    }
    public void attributRoom(){
        RoomTransition startRoom = new RoomTransition("Start room", "Empty room, it has no interest..", 1, false);
        rooms.add(startRoom);

        RoomTransition endRoom = new RoomTransition("End room", "Empty room, it has a stairs..", numberRoom, false);
        rooms.add(endRoom);

        int previousValue = -1;
        for (int i = 2; i < numberRoom-1; i++) {
            Random randomRoomType = new Random();

            do {
                typeOfRoomGeneration = randomRoomType.nextInt(100);
            } while (typeOfRoomGeneration != previousValue);
            previousValue = typeOfRoomGeneration;


            if (typeOfRoomGeneration <= 5){
                // Room Treasure
                RoomTreasure roomTreasure = new RoomTreasure("Room Treasure", "A room with a chest in its center", i, false,100);
                rooms.add(roomTreasure);

            } else if ((typeOfRoomGeneration > 5)&&(typeOfRoomGeneration <= 15)){
                // Room Trader
                Trader trader = new Trader();
                RoomTrader roomTrader = new RoomTrader("Room Trader", "A room with a trader in its center", i, false, trader);
                rooms.add(roomTrader);

            } else if ((typeOfRoomGeneration > 15)&&(typeOfRoomGeneration <= 25)){
                // Room Trap
                Character monster = new Character(100,0,1,10,20,0,0,0,"zeubis", ClassType.Healer);
                RoomTrap roomTrap = new RoomTrap("Room Trap", "Ouch, you get trap..", i, false, monster);
                rooms.add(roomTrap);

            } else if ((typeOfRoomGeneration > 25)&&(typeOfRoomGeneration <= 35)){
                // Room Enigma
                RoomEnigma roomEnigma = new RoomEnigma("Room Enigma", "Hum, there are symbols on the walls of this room", i, false);
                rooms.add(roomEnigma);

            } else if ((typeOfRoomGeneration > 35)&&(typeOfRoomGeneration <= 65)){
                // Room Transition
                RoomTransition roomTransition = new RoomTransition("Room Transition", "Hum, there are symbols on the walls of this room", i, false);
                rooms.add(roomTransition);

            } else if ((typeOfRoomGeneration > 65)&&(typeOfRoomGeneration <= 100)){
                // Room Fight
                Character monster = new Character(100,0,1,10,20,0,0,0,"zeubis", ClassType.Healer);
                RoomFight roomFight = new RoomFight("Room Transition", "Oups, there are a lot of enemies in this room.", i, false, monster);
                rooms.add(roomFight);

            } else {
                System.out.println("Probabilty of room failed");
            }
        }
    }
}


