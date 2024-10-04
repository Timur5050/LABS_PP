package fights;

import droids.Droid;
import logging.ConsoleLogger;
import logging.FileLogger;

import java.util.Objects;
import java.util.Random;

public class OneVSOneFight extends Fight {
    ConsoleLogger consoleLogger = new ConsoleLogger();
    FileLogger fileLogger = new FileLogger();

    public OneVSOneFight(Droid droid1, Droid droid2) {
        team1.add(droid1);
        team2.add(droid2);
    }

    @Override
    public void fight() {
        Random random = new Random();

        consoleLogger.logInformation("Who starts first? Let's throw monet (0 - first player, 1 - second player)", "");
        fileLogger.logInformation("Who starts first? Let's throw monet (0 - first player, 1 - second player)", "");
        Droid droid1 = team1.get(0), droid2 = team2.get(0);
        boolean res = random.nextBoolean();

        if (res) {
            consoleLogger.logInformation("first player starts", "");
            fileLogger.logInformation("first player starts", "");
        } else {
            consoleLogger.logInformation("second player starts", "");
            fileLogger.logInformation("second player starts", "");
        }

        while (true) {
            String stats = "\nsmall stats : " + droid1.getName() + " hp :  " + droid1.getHealthPoints() + "     |     " + droid2.getName() + " hp : " + droid2.getHealthPoints();
            consoleLogger.logInformation(stats, "green");
            fileLogger.logInformation(stats, "green");

            if (res) {
                if (performStep(droid1, droid2, "first")) break;
                if (performStep(droid2, droid1, "second")) break;
            } else {
                if (performStep(droid2, droid1, "second")) break;
                if (performStep(droid1, droid2, "first")) break;
            }
        }
    }

    private boolean performStep(Droid attacker, Droid defender, String player) {
        String stepMessage = "\n" + player + " step: ";
        consoleLogger.logInformation(stepMessage, "blue");
        fileLogger.logInformation(stepMessage, "blue");

        step(attacker, defender, player);
        return localCheck() == 1;
    }

    private int localCheck() {
        if (this.GeneralCheck() == 1) {
            consoleLogger.logInformation("\nplayer second won, congrats!!!!", "purple");
            fileLogger.logInformation("\nplayer second won, congrats!!!!\n", "purple");
            return 1;
        }
        if (this.GeneralCheck() == 2) {
            consoleLogger.logInformation("\nplayer first won, congrats!!!!", "purple");
            fileLogger.logInformation("\nplayer first won, congrats!!!!\n", "purple");
            return 1;
        }
        return 0;
    }

    private void step(Droid droid1, Droid droid2, String player) {
        String droidType = droid1.getType();

        if (Objects.equals(droidType, "attacker")) {
            int damage = droid1.getTotalDamage();
            droid2.receiveDamage(damage);

            String attackMessage = "droid" + droid1.getName() + " hit " + droid2.getName() + " with damage : " + damage + ", now it has : " + droid2.getHealthPoints();
            consoleLogger.logInformation(attackMessage, "yellow");
            fileLogger.logInformation(attackMessage, "yellow");

        } else if (Objects.equals(droidType, "healer")) {
            String healMessage = "You can not heal bro in one to one fight :(";
            consoleLogger.logInformation(healMessage, "yellow");
            fileLogger.logInformation(healMessage, "yellow");
        } else if (Objects.equals(droidType, "reviver")) {
            String reviveMessage = "You can not revive bro in one to one fight :(";
            consoleLogger.logInformation(reviveMessage, "yellow");
            fileLogger.logInformation(reviveMessage, "yellow");
        }
    }
}
