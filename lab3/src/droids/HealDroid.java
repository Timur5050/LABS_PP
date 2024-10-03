package droids;

public class HealDroid extends Droid{
    public HealDroid()
    {
        this.name = "Heal Droid";
        this.healthPoints = 175;
        this.maxHealthPoints = 175;
        this.type = "healer";
        this.heal = 70;
    }

    @Override
    public String toString() {
        return "name: " + name + "\nheal: " + heal + "\nhealth points: " + healthPoints;
    }
}
