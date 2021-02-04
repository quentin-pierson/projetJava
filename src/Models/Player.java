package Models;

import Models.Character.Character;
import Models.Character.DeadEvent;
import Models.Items.Item;
import Services.Game;

import java.util.ArrayList;

public class Player implements DeadEvent {

    private String name;
    private float experience;
    private int gold;
    private int life; // point Open
    private ArrayList<Item> inventory;
    private Character character;

    private int inventoryCapacity;
    protected String[] menuText = {"1: ---", "2: ---","3: ---","4: ---"};


    public Player(String name, float experience, int gold, int life,Character character) {
        this.name = name;
        this.experience = experience;
        this.gold = gold;
        this.life = life;
        this.character = character;
        inventory = new ArrayList<Item>();

        inventoryCapacity= 4;
    }

    public String[] getMenuText(){
        return menuText;
    }

    public String getName(){
        return name;
    }

    public int getGold(){ return gold;}

    public void addGold(int gold){ this.gold += gold;}

    public Character getCharacter() {
        return character;
    }

    public void addItem(Item item){
        if(inventoryCapacity > inventory.size()){
            inventory.add(item);
        }
    }

    public int getInventoryCapacity(){
        return inventoryCapacity;
    }

    public int getInventorySize(){
        return inventory.size();
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public int getLife() {
        return life;
    }

    public void AddLife(int life) {
        this.life += life;
    }

    private void gameOver(){
        System.out.println(
                " ▄████  ▄▄▄       ███▄ ▄███▓▓█████     ▒█████   ██▒   █▓▓█████  ██▀███  \n" +
                " ██▒ ▀█▒▒████▄    ▓██▒▀█▀ ██▒▓█   ▀    ▒██▒  ██▒▓██░   █▒▓█   ▀ ▓██ ▒ ██▒\n" +
                "▒██░▄▄▄░▒██  ▀█▄  ▓██    ▓██░▒███      ▒██░  ██▒ ▓██  █▒░▒███   ▓██ ░▄█ ▒\n" +
                "░▓█  ██▓░██▄▄▄▄██ ▒██    ▒██ ▒▓█  ▄    ▒██   ██░  ▒██ █░░▒▓█  ▄ ▒██▀▀█▄  \n" +
                "░▒▓███▀▒ ▓█   ▓██▒▒██▒   ░██▒░▒████▒   ░ ████▓▒░   ▒▀█░  ░▒████▒░██▓ ▒██▒\n" +
                " ░▒   ▒  ▒▒   ▓▒█░░ ▒░   ░  ░░░ ▒░ ░   ░ ▒░▒░▒░    ░ ▐░  ░░ ▒░ ░░ ▒▓ ░▒▓░\n" +
                "  ░   ░   ▒   ▒▒ ░░  ░      ░ ░ ░  ░     ░ ▒ ▒░    ░ ░░   ░ ░  ░  ░▒ ░ ▒░\n" +
                "░ ░   ░   ░   ▒   ░      ░      ░      ░ ░ ░ ▒       ░░     ░     ░░   ░ \n" +
                "      ░       ░  ░       ░      ░  ░       ░ ░        ░     ░  ░   ░     \n" +
                "                                                     ░                   ");
        System.exit(0);
    }

    public void dead() {
        System.out.println(
                "▓██   ██▓ ▒█████   █    ██    ▓█████▄  ██▓▓█████ ▓█████▄                \n" +
                " ▒██  ██▒▒██▒  ██▒ ██  ▓██▒   ▒██▀ ██▌▓██▒▓█   ▀ ▒██▀ ██▌               \n" +
                "  ▒██ ██░▒██░  ██▒▓██  ▒██░   ░██   █▌▒██▒▒███   ░██   █▌               \n" +
                "  ░ ▐██▓░▒██   ██░▓▓█  ░██░   ░▓█▄   ▌░██░▒▓█  ▄ ░▓█▄   ▌               \n" +
                "  ░ ██▒▓░░ ████▓▒░▒▒█████▓    ░▒████▓ ░██░░▒████▒░▒████▓  ██▓  ██▓  ██▓ \n" +
                "   ██▒▒▒ ░ ▒░▒░▒░ ░▒▓▒ ▒ ▒     ▒▒▓  ▒ ░▓  ░░ ▒░ ░ ▒▒▓  ▒  ▒▓▒  ▒▓▒  ▒▓▒ \n" +
                " ▓██ ░▒░   ░ ▒ ▒░ ░░▒░ ░ ░     ░ ▒  ▒  ▒ ░ ░ ░  ░ ░ ▒  ▒  ░▒   ░▒   ░▒  \n" +
                " ▒ ▒ ░░  ░ ░ ░ ▒   ░░░ ░ ░     ░ ░  ░  ▒ ░   ░    ░ ░  ░  ░    ░    ░   \n" +
                " ░ ░         ░ ░     ░           ░     ░     ░  ░   ░      ░    ░    ░  \n" +
                " ░ ░                           ░                  ░        ░    ░    ░ ");
        life -= 1;
        Game.getInstance().getGameInfo();
        if (life == -1) {
            gameOver();
        }
        character.setHealth(50);
    }
}
