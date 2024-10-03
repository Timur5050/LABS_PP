package droids;

public class SplashDroid extends Droid {
    int damage;
    public SplashDroid() {
        this.name = "Splash Droid";
        this.healthPoints = 270;
        this.maxHealthPoints = 270;
        this.damage = 80;
        this.type = "attacker";
    }

    @Override
    public int getTotalDamage()
    {
        return damage;
    }

    @Override
    public int getSplashDamage()
    {
        return (int)(damage * 0.235);
    }

    @Override
    public String toString() {
        return "name: " + name + "\nsplash damage: " + (damage * 0.3) + "\nhealth points: " + healthPoints;
    }
}
