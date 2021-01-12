package Models.Items;

import Models.Character.Character;

public class PotionMana extends Item {
    private int increaseMana;

    public PotionMana(String name, String description,int increaseMana) {
        super(name, description);
        this.increaseMana = increaseMana;
    }

    @Override
    public void used(Character character){
        if(character.getMana() < 100){
            if(character.getMana() + increaseMana > 100){ // it's ok you can use potion of health
                character.setMana(100);
            }
            else{
                character.setHealth(character.getMana()+increaseMana);
            }
        }
        else{
            System.out.println("Your mana is at maximum");
        }
    }
}
