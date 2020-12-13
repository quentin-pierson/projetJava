package Models;

public class Players extends Attributes{

    private String name;
    private float experience;
    private ClassType classType;

    public Players(int health, int armor, int level, int attack, int lucky, int mana, int dodge, String name, float experience, ClassType classType) {
        super(health, armor, level, attack, lucky, mana, dodge);
        this.name = name;
        this.experience = experience;
        this.classType = classType;
    }
}
