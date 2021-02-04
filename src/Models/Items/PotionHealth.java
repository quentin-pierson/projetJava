package Models.Items;

import Models.Character.Character;
import Models.Player;
import View.GameUI;

import java.util.Scanner;

public class PotionHealth extends Item{
    private int increasePv;

    public PotionHealth(String name, String description,int increasePv) {
        super(name, description);
        this.increasePv = increasePv;
    }

    public PotionHealth(String name, String description,int increasePv,int price) {
        super(name, description,price);
        this.increasePv = increasePv;

    }

    @Override
    public void used(Player player, String description){
        String desc = description;
        Scanner scanner = new Scanner(System.in);
        if(player.getCharacter().getHealth() < 100){
            if(player.getCharacter().getHealth() + increasePv > 100){ // it's ok you can use potion of health
                desc += "&&&nYour life increase !";
                player.getCharacter().setHealth(100);
                player.getInventory().remove(this);
            }
            else{
                desc += "&&&nYour life increase !";
                player.getCharacter().setHealth(player.getCharacter().getHealth()+increasePv);
                player.getInventory().remove(this);
            }
        }
        else{
            desc += "&&&nYour life is at maximum";
        }
        GameUI.getInstance().displayGame(desc,player.getMenuText());
        scanner.next();
    }
}
