package Models.Items;

import Models.Character.Character;
import Models.Player;
import View.GameUI;

import java.util.Scanner;

public class PotionMana extends Item {
    private int increaseMana;

    public PotionMana(String name, String description,int increaseMana) {
        super(name, description);
        this.increaseMana = increaseMana;
    }

    public PotionMana(String name, String description,int increaseMana,int price) {
        super(name, description,price);
        this.increaseMana = increaseMana;
    }

    @Override
    public void used(Player player, String description){
        String desc = description;
        Scanner scanner = new Scanner(System.in);
        if(player.getCharacter().getMana() < 100){
            if(player.getCharacter().getMana() + increaseMana > 100){ // it's ok you can use potion of health
                desc += description + "&&&nYour mana increase !";
                player.getCharacter().setMana(100);
                player.getInventory().remove(this);
            }
            else{
                desc += description + "&&&nYour mana increase !";
                player.getCharacter().setHealth(player.getCharacter().getMana()+increaseMana);
                player.getInventory().remove(this);
            }
        }
        else{
            desc += "&&&nYour mana is at maximum";
        }
        GameUI.getInstance().displayGame(desc,player.getMenuText());
        scanner.next();
    }
}
