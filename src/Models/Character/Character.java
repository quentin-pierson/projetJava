package Models.Character;

import Models.*;
import java.util.Random;

public class Character extends Abilities {
    private String name;
    private Weapon weapon;
    private boolean isDefend;
    private DeadEvent deadEventListener;

    public Character(){
        super(0,0,0,0,0,0,0,0);
    }

    public Character(int health, int armor, int level, int rateAttack, int damage, int lucky, int mana, int dodge,String name) {
        super(health, armor, level, rateAttack, damage, lucky, mana, dodge);
        this.name = name;
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

        public void setDeadListener(DeadEvent deadEventListener){
            this.deadEventListener = deadEventListener;
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
            if(deadEventListener != null) deadEventListener.dead();
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

        public String getTypeOfClass(){
            return "";
        }
        public void firstSpell(){

        }

        public void secondSpell(){

        }
        public void thirdSpell(){

        }
}
