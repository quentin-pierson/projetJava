package Models.Room;

import Models.Player;
import Services.DataServices;
import Services.Game;
import View.GameUI;

import java.util.Scanner;

public class RoomEnigma extends Room{

    private int answer;
    private int gold = 100;
    public RoomEnigma(int order, boolean isLocked) {
        super(order, isLocked);
        setName("Room Enigma");
        setDescription(DataServices.getInstance().getRoomEnigma());
        answer = Integer.parseInt(description.split(";")[1]);
        description = description.split(";")[0];
    }

    @Override
    public void enterInRoom(){
        Game game = Game.getInstance();
        String desc = name + ": &&&n" + description;
        GameUI.getInstance().displayGame(desc,game.getPlayer().getMenuText());
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == answer){
            desc = name +  ": &&&n" + "You right!&&&n" + "+" + gold +"gold&&&n";
            game.getPlayer().addGold(gold);
            GameUI.getInstance().displayGame(desc,game.getPlayer().getMenuText());
        }else{
            desc = name + ": &&&n" + "You failed!&&&n";
            GameUI.getInstance().displayGame(desc,game.getPlayer().getMenuText());
        }
    }

}
