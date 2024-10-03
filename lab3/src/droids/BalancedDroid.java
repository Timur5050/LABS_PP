package droids;

public class BalancedDroid extends Droid {
    int damage;

    public BalancedDroid() {
        this.name = "Balanced droid";
        this.maxHealthPoints = 400;
        this.healthPoints = 400;
        this.damage = 65;
        this.type = "attacker";
    }

    @Override
    public int getTotalDamage()
    {
        return damage;
    }

    @Override
    public String toString() {
        return "name: " + name + "\ndamage: " + damage + "\nhealth points: " + healthPoints;
    }
}
