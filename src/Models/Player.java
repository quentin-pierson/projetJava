package Models;

public class Player extends Abilities {

    private String name;
    private float experience;
    private ClassType classType;
    private int gold;
    private int life; // point Open
    private Weapon weapons;

    public Player(int health, int armor, int level, int attack, int lucky, int mana, int dodge, String name, float experience, ClassType classType, int gold, int life) {
        super(health, armor, level, attack, lucky, mana, dodge);
        this.name = name;
        this.experience = experience;
        this.classType = classType;
        this.gold = gold;
        this.life = life;
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

    public void gameOver(int pointOpen){
        if(pointOpen==0){
            System.out.println("GAME OVER");
        }
    }

    public void dead(Player player) {
        if (player.getHealth() == 0) {
            System.out.println("Vous êtes mort");
            player.AddLife(-1);
        }
        if (player.getLife() == -1) {
            gameOver(0);
        }
    }
}
