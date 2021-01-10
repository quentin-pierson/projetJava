package Models;

import Models.Items.Item;

import java.util.ArrayList;

public class Trader {
    public ArrayList<Item> inventory = new ArrayList<Item>();

    public void addItem(Item item){
        inventory.add(item);
    }

    public void buyItem(Player player, int i) {
        if (player.getGold() >= inventory.get(i).getPrice()){
            player.addGold(-inventory.get(i).getPrice());
            player.addItem(inventory.get(i));
        }
    }

    public void displayInventory(){
        System.out.println("+-----------------------------+\n" +
                "| Charles David: Hello traveler! |\n" +
                "+-----------------------------+");
    }
}
