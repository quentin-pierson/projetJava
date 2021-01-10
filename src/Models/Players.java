package Models;

public class Players extends Abilities {

    private String name;
    private float experience;
    private ClassType classType;
    private int gold;
    private int pointOpen; // number of life remaining
    private Weapons weapons;

    public Players(int health, int armor, int level, int attack, int lucky, int mana, int dodge, String name, float experience, ClassType classType,int gold,int pointOpen) {
        super(health, armor, level, attack, lucky, mana, dodge);
        this.name = name;
        this.experience = experience;
        this.classType = classType;
        this.gold = gold;
        this.pointOpen = pointOpen;
    }

    public String getName(){
        return name;
    }

    public ClassType getClassType(){
        return classType;
    }

    public int getPointOpen() {
        return pointOpen;
    }

    public void setPointOpen(int pointOpen) {
        this.pointOpen += pointOpen;
    }
}
