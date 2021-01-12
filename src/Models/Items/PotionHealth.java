package Models.Items;

import Models.Character.Character;

public class PotionHealth extends Item{
    private int increasePv;

    public PotionHealth(String name, String description,int increasePv) {
        super(name, description);
        this.increasePv = increasePv;
    }

    @Override
    public void used(Character character){
        if(character.getHealth() < 100){
            if(character.getHealth() + increasePv > 100){ // it's ok you can use potion of health
                character.setHealth(100);
            }
            else{
                character.setHealth(character.getHealth()+increasePv);
            }
        }
        else{
            System.out.println("Your life is at maximum");
        }
    }
}
