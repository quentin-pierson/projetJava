package Models;

import Models.Items.Item;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Abilities {

    private String name;
    private float experience;
    private ClassType classType;
    private int gold;
    private int life; // point Open
    private Weapon weapons;
    private ArrayList<Item> inventory;
    private boolean isDefend;

    public Player(int health, int armor, int level, int attack, int damage, int lucky, int mana, int dodge, String name, float experience, ClassType classType, int gold, int life) {
        super(health, armor, level, attack, damage, lucky, mana, dodge);
        this.name = name;
        this.experience = experience;
        this.classType = classType;
        this.gold = gold;
        this.life = life;
        inventory = new ArrayList<Item>() ;
    }

    public String getName(){
        return name;
    }

    public ClassType getClassType(){
        return classType;
    }

    public int getLife() {
        return life;
    }

    public void AddLife(int life) {
        this.life += life;
    }

    private void gameOver(){
        System.out.println("GAME OVER");
    }

    private void dead() {
        System.out.println("You died...");
        life -= 1;
        if (life == -1) {
            gameOver();
        }
    }

    public void fight(Monster monster){
        Random rnd = new Random();

        int diceAttack = rnd.nextInt(100);

        if(diceAttack <= this.getAttack()) {
            if(diceAttack <= 5){
                System.out.println("Critical success!");
                monster.takeDamage(damage + 10,monster.getName());
            }
            else{
                System.out.println("Success!");
                monster.takeDamage(damage,monster.getName());
            }
        }else{
            if(diceAttack >= 95){
                System.out.println("Critical failure!");
            }
            else{
                System.out.println("Failure!");
            }
        }
    }

    public void defence () {
        isDefend = true;
    }

    public void takeDamage(int damage, String name){
        health = health - damage;
        if(health <= 0){
            dead();
        }
    }
}
