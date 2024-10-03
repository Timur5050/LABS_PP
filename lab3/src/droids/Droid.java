package droids;

abstract public class Droid {
    protected String name;
    protected int maxHealthPoints;
    protected int healthPoints;
    protected String type;
    protected int heal = 0;
    protected int revive = 0;

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public void receiveDamage(int damage) {
        if (healthPoints - damage > 0) {
            healthPoints -= damage;
        } else {
            healthPoints = 0;
            System.out.println(name + " was killed :( ");
        }
    }

    public void receiveHeal(int heal) {
        if (healthPoints > 0) {
            if (heal + healthPoints > maxHealthPoints) {
                healthPoints = maxHealthPoints;
            } else {
                healthPoints += heal;
            }
        }
    }

    public int getHeal() {
        return heal;
    }

    public int getRevive() {
        return revive;
    }

    public int getSplashDamage() {
        return 0;
    }

    public int getTotalDamage() {
        return 0;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }
}
