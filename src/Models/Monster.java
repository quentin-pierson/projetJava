package Models;

import java.util.Random;

public class Monster extends Abilities {
    private String name;
    private MonsterType monsterType;
    private ClassType classType;

    public Monster(int health, int armor, int level, int attack, int damage, int lucky, int mana, int dodge,String name, MonsterType monsterType, ClassType classType) {
        super(health, armor, level, attack, damage, lucky, mana, dodge);
        this.name = name;
        this.monsterType = monsterType;
        this.classType = classType;
    }
    public String getName(){
        return name;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public ClassType getClassType() {
        return classType;
    }


    public String toString() {
        return "Monsters{" +
                "monsterType=" + getMonsterType() +
                ", classType=" + getClassType() +
                '}';
    }
    public void fight(Player player){
        Random rnd = new Random();
        int diceAttack = rnd.nextInt(100);

        if(diceAttack <= this.getAttack()) {
            if(diceAttack <= 5){
                System.out.println("Critical success!");
                player.takeDamage(damage + 10,player.getName());
            }
            else{
                System.out.println("Success!");
                player.takeDamage(damage,player.getName());
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

    private void dead() {
        System.out.println(name + " is dead");
    }

    public void takeDamage(int damage, String name){
        health = health - damage;
        System.out.println(name + " take " + damage);
        if(health <= 0){
            dead();
        }
    }
}
