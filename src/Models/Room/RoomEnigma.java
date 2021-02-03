package Models.Room;

import Models.Player;
import Services.Game;

import java.util.Scanner;

public class RoomEnigma extends Room{

    private int answer;
    private int gold = 100;
    public RoomEnigma(int order, boolean isLocked) {
        super(order, isLocked);
        setName("Room Enigma");
        setDescription("/Data/Room/RoomEnigmaData.txt");
        answer = Integer.parseInt(description.split(";")[1]);
        description = description.split(";")[0];
    }

    @Override
    public void enterInRoom(){
        Game game = Game.getInstance();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == answer){
            System.out.println("You right !\n");
            game.getPlayer().addGold(gold);
        }else{
            System.out.println("You failed...\n");
        }
    }

}
