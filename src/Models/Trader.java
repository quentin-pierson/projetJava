package Models;

import Models.Items.Item;
import Models.Items.PotionHealth;
import Models.Items.PotionMana;
import Services.Game;
import Services.ScannerSc;

import java.util.ArrayList;

public class Trader {
    public ArrayList<Item> inventory = new ArrayList<Item>();

    public Trader(){
        PotionHealth potienHealth = new PotionHealth("Morphine drugs","You get back 50hp",50,100);
        PotionMana potionMana = new PotionMana("Mana potion","The mana potion restores 25 mana when used",25,70);
        inventory.add(potienHealth);
        inventory.add(potionMana);
    }

    public void addItem(Item item){
        inventory.add(item);
    }

    public void buyItem(Player player, int i) {

        if(i>0 && i<=inventory.size()){
            i-=1;
            if (player.getGold() >= inventory.get(i).getPrice()){
                player.addGold(-inventory.get(i).getPrice());
                player.addItem(inventory.get(i));
                System.out.println("Successful you buy "+inventory.get(i).getName()+"\n"+
                        "You still have "+player.getGold() + " golds");

            }
            else {
                System.out.println("You don't have any money");
            }
        }

    }

    public void displayInventory(Game game){
        System.out.println("+-----------------------------+\n" +
                "| Charles David: Hello traveler! |\n" +
                "+-----------------------------+");
        for(int i=0;i<inventory.size();i++){
            System.out.println(inventory.get(i).toString(i+1));
        }
        System.out.println("Make your choice | 0 to skip \n"+
                "You have "+game.getPlayer().getGold() + " golds");

        ScannerSc scannerSc = new ScannerSc();
        int result = scannerSc.scanner();
        if(result != 0){
            buyItem(game.getPlayer(),result);
        }
        else{
            System.out.println("Charles David is disappointed that he didn't do business with you");
        }

    }





}
