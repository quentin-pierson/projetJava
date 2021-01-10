package Models.Items;

import Models.Player;

public class PotionHealth extends Item{
    private int increasePv;

    public PotionHealth(String name, String description,int increasePv) {
        super(name, description);
        this.increasePv = increasePv;
    }

    @Override
    public void used(Player player){
        if(player.getHealth() < 100){
            if(player.getHealth() + increasePv > 100){ // it's ok you can use potion of health
                player.setHealth(100);
            }
            else{
                player.setHealth(player.getHealth()+increasePv);
            }
        }
        else{
            System.out.println("Your life is at maximum");
        }
    }
}
