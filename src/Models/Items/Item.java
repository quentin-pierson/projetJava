package Models.Items;

import Models.Character.Character;

public class Item {
    private String name;
    private String description;
    private int price;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description,int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void used(Character character){
        System.out.println("Well done you used the item "+getName()+"\n");
    }

    public int getPrice(){ return price;}

    public String getDescription() {
        return description;
    }


    public String toString(int position) {
        return position+ ": " + name + "\n" +description + "\n" + price + " gold" + "\n";
    }
}
