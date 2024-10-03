package droids;

import java.util.Random;

public class DamageDroid extends Droid {
    private final int damage;
    private final int accuracy;
    private final int criticalChance;

    public DamageDroid()
    {
        this.name = "Damage droid";
        this.damage = 100;
        this.healthPoints = 300;
        this.maxHealthPoints = 300;
        this.accuracy = 85;
        this.criticalChance = 40;
        this.type = "attacker";
    }

    @Override
    public int getTotalDamage()
    {
        Random random = new Random();
        int finalDamage = damage;
        if(random.nextInt(1, 101) > accuracy) // check for accuracy chance
        {
            System.out.println("\u001B[36m" + "miss" + "\u001B[0m");
            return 0;
        }
        if(random.nextInt(1, 101) < criticalChance)
        {
            System.out.println("\u001B[1;31m" + "(critical damage)" + "\u001B[0m");
            return (int)(finalDamage * 1.5);
        }
        return finalDamage;
    }

    @Override
    public String toString()
    {
        return "name: " + name + "\ndamage: " + damage + "\nhealth points: " + healthPoints + "\naccuracy: " + accuracy + "%\ncritical damage: " + criticalChance + "%";
    }

}
