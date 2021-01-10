package Models.Items;

import Models.Player;

public class PotionMana extends Item{
    private int increaseMana;

    public PotionMana(String name, String description,int increaseMana) {
        super(name, description);
        this.increaseMana = increaseMana;
    }

    @Override
    public void used(Player player){
        if(player.getMana() < 100){
            if(player.getMana() + increaseMana > 100){ // it's ok you can use potion of health
                player.setMana(100);
            }
            else{
                player.setHealth(player.getMana()+increaseMana);
            }
        }
        else{
            System.out.println("Your mana is at maximum");
        }
    }
}
