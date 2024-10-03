package droids;

public class ReviverDroid extends Droid {
    public ReviverDroid()
    {
        this.name = "Reviver Droid";
        this.healthPoints = 150;
        this.maxHealthPoints = 150;
        this.type = "reviver";
        this.heal = 50;
        this.revive = 1;
    }

    @Override
    public String toString() {
        return "name: " + name + "\nheal: " + heal + "\nrevive opportunity: " + revive + "\nhealth points: " + healthPoints;
    }
}
