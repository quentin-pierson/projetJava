package Models;

import Models.Character.Character;
import Models.Character.DeadEvent;
import Models.Items.Item;

import java.util.ArrayList;

public class Player implements DeadEvent {

    private String name;
    private float experience;
    private int gold;
    private int life; // point Open
    private ArrayList<Item> inventory;
    private Character character;

    public Player(String name, float experience, int gold, int life,Character character) {
        this.name = name;
        this.experience = experience;
        this.gold = gold;
        this.life = life;
        this.character = character;
        inventory = new ArrayList<Item>();
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
        inventory.add(item);
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
        if (life == -1) {
            gameOver();
        }
    }
}
