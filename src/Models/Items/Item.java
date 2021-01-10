package Models.Items;

import Models.Player;

public class Item {
    private String name;
    private String description;
    private int price;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void used(Player player){
        System.out.println("Well done you used the item "+getName()+"\n");
    }

    public int getPrice(){ return price;}
}
