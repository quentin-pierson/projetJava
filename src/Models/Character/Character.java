package Models.Character;

import Models.*;

import java.beans.EventHandler;
import java.util.Random;

public class Character extends Abilities {
        private String name;
        private ClassType classType;
        private Weapon weapon;
        private boolean isDefend;

    public Character(int health, int armor, int level, int rateAttack, int damage, int lucky, int mana, int dodge,String name, ClassType classType) {
            super(health, armor, level, rateAttack, damage, lucky, mana, dodge);
            this.name = name;
            this.classType = classType;
        }
        public String getName(){
            return name;
        }

        public void setWeapon(Weapon weapon) {
            this.weapon= weapon;
        }

        public Weapon getWeapon() {
            return weapon;
        }

        public ClassType getClassType() {
            return classType;
        }


        public String toString() {
            return "Monsters{" +
                    ", classType=" + getClassType() +
                    '}';
        }

        public void fight(Character character){
            Random rnd = new Random();
            int diceAttack = rnd.nextInt(100);

            if(diceAttack <= this.getRateattack()) {
                if(diceAttack <= 5){
                    System.out.println("Critical success!");
                    character.takeDamage(damage + 10,character.getName());
                }
                else{
                    System.out.println("Success!");
                    character.takeDamage(damage,character.getName());
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

        public void defence () {
        isDefend = true;
    }

        public void takeDamage(int damage, String name){
            health = health - damage;
            System.out.println(name + " take " + damage);
            if(health <= 0){
                dead();
            }
        }
}
