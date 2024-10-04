package fights;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import droids.Droid;
import logging.ConsoleLogger;
import logging.FileLogger;

public class ManyToManyFight extends Fight {
    ConsoleLogger consoleLogger = new ConsoleLogger();
    FileLogger fileLogger = new FileLogger();
    Scanner scanner = new Scanner(System.in);

    public ManyToManyFight(List<Droid> _team1, List<Droid> _team2) {
        team1 = _team1;
        team2 = _team2;
    }

    private Droid chooseDroidFromFirstTeam() {
        Droid droid;
        do {
            consoleLogger.logInformation("enter number: ", "");
            int number = scanner.nextInt();
            droid = team1.get(number);
        } while (!droid.isAlive());
        return droid;
    }

    private Droid chooseDroidFromSecondTeam() {
        Droid droid;
        do {
            consoleLogger.logInformation("enter number: ", "");
            int number = scanner.nextInt();
            droid = team2.get(number);
        } while (!droid.isAlive());
        return droid;
    }

    @Override
    public void fight() {
        Random random = new Random();

        consoleLogger.logInformation("Who starts first? Let's throw monet (0 - first player, 1 - second player)", "");
        boolean res = random.nextBoolean();

        consoleLogger.logInformation("General stats: ", "");
        consoleLogger.logInformation("team 1: ", "");
        for (Droid droid : team2) {
            consoleLogger.logInformation(droid.getName() + "\t", "");
        }
        consoleLogger.logInformation("team 2: ", "");
        for (Droid droid : team1) {
            consoleLogger.logInformation(droid.getName() + "\t", "");
        }

        if (res) {
            consoleLogger.logInformation("\nfirst player starts", "");
        } else {
            consoleLogger.logInformation("\nsecond player starts", "");
        }

        while (true) {
            consoleLogger.logInformation("\nsmall stats : ", "green");
            consoleLogger.logInformation("team 1: ", "");
            for (Droid droid : team1) {
                consoleLogger.logInformation(droid.getName() + "(" + droid.getHealthPoints() + ")" + "\t", "");
            }
            consoleLogger.logInformation("team 2: ", "");
            for (Droid droid : team2) {
                consoleLogger.logInformation(droid.getName() + "(" + droid.getHealthPoints() + ")" + "\t", "");
            }
            System.out.println();
            if (res) {
                if(playerFirstStep()) break;
            } else {
                if(playerSecondStep()) break;
            }
        }
    }

    public boolean playerFirstStep() {
        Droid droid1, droid2;
        System.out.println("player first, choose droid to use: ");
        droid1 = chooseDroidFromFirstTeam();
        if (!Objects.equals(droid1.getType(), "attacker")) performHealerReviverStep(droid1, "first");
        else {
            System.out.println("player first, choose droid from team2 to use your droid: ");
            droid2 = chooseDroidFromSecondTeam();
            if (performAttackerStep(droid1, droid2, "first")) return true;
        }

        System.out.println("player second, choose droid to use: ");
        droid2 = chooseDroidFromSecondTeam();
        if (!Objects.equals(droid1.getType(), "attacker")) performHealerReviverStep(droid1, "second");
        else {
            System.out.println("player second, choose droid from team1 to use your droid: ");
            droid1 = chooseDroidFromFirstTeam();
            if (performAttackerStep(droid2, droid1, "second")) return true;
        }
        return false;
    }

    public boolean playerSecondStep() {
        Droid droid1, droid2;
        System.out.println("player second, choose droid to use: ");
        droid2 = chooseDroidFromSecondTeam();
        if (!Objects.equals(droid2.getType(), "attacker")) performHealerReviverStep(droid2, "second");
        else {
            System.out.println("player second, choose droid from team1 to use your droid: ");
            droid1 = chooseDroidFromFirstTeam();
            if (performAttackerStep(droid2, droid1, "second")) return true;
        }

        System.out.println("player first, choose droid to use: ");
        droid1 = chooseDroidFromFirstTeam();
        if (!Objects.equals(droid1.getType(), "attacker")) performHealerReviverStep(droid1, "first");
        else {
            System.out.println("player first, choose droid from team2 to use your droid: ");
            droid2 = chooseDroidFromSecondTeam();
            if (performAttackerStep(droid1, droid2, "first")) return true;
        }
        return false;
    }


    private boolean performAttackerStep(Droid attacker, Droid defender, String player) {
        consoleLogger.logInformation("\n" + player + " step: ", "blue");
        attackerStep(attacker, defender, player);
        return localCheck() == 1;
    }

    private void performHealerReviverStep(Droid droid, String player) {
        if (Objects.equals(droid.getType(), "healer")) {
            healerStep(droid, player);
        } else {
            reviverStep(droid, player);
        }
    }


    private int localCheck() {
        if (this.GeneralCheck() == 1) {
            consoleLogger.logInformation("player second won, congrats!!!!", "purple");
            fileLogger.logInformation("player second won, congrats!!!!", "purple");
            return 1;
        }
        if (this.GeneralCheck() == 2) {
            consoleLogger.logInformation("player first won, congrats!!!!", "purple");
            fileLogger.logInformation("player first won, congrats!!!!\n", "purple");
            return 1;
        }
        return 0;
    }


    private void attackerStep(Droid droid1, Droid droid2, String player) {
        int damage = droid1.getTotalDamage();
        droid2.receiveDamage(damage);
        String textToLog = "(" + player + ") droid " + droid1.getName() + " hit " + droid2.getName() + " with " + damage + ", now it has : " + droid2.getHealthPoints() + "hp\n";
        consoleLogger.logInformation(textToLog, "yellow");
        fileLogger.logInformation(textToLog, "yellow");

        // splash check
        if (droid1.getSplashDamage() > 0) {
            if (Objects.equals(player, "first")) {
                for (Droid droid : team2) {
                    if (droid.isAlive()) {
                        droid.receiveDamage(droid1.getSplashDamage());
                    }
                }
            } else {
                for (Droid droid : team1) {
                    if (droid.isAlive()) {
                        droid.receiveDamage(droid1.getSplashDamage());
                    }
                }
            }
        }
    }

    private void healerStep(Droid droid1, String player) {
        String textToLog = "droid " + droid1.getName() + " healed the team with " + droid1.getHeal() + "hps";
        consoleLogger.logInformation(textToLog, "yellow");
        fileLogger.logInformation(textToLog, "yellow");

        if (Objects.equals(player, "first")) {
            for (Droid droid : team1) {
                droid.receiveHeal(droid1.getHeal());
            }
        } else {
            for (Droid droid : team2) {
                droid.receiveHeal(droid1.getHeal());
            }
        }
    }

    private void reviverStep(Droid droid1, String player) {
        if (droid1.getRevive() == 1) {
            int number;
            Droid revivedDroid;
            List<Droid> team = player.equals("first") ? team1 : team2;
            System.out.println("enter number of droid to revive");

            boolean allAlive = true;
            for (Droid droid : team) {
                if (!droid.isAlive()) {
                    allAlive = false;
                    break;
                }
            }

            if (allAlive) {
                System.out.println("no one to revive");
            } else {
                do {
                    System.out.print("enter number: ");
                    number = scanner.nextInt();
                } while (team.get(number).isAlive());

                revivedDroid = team.get(number);
                revivedDroid.receiveHeal(revivedDroid.getMaxHealthPoints());
                droid1.setZeroRevivalOpportunity();

                consoleLogger.logInformation(droid1.getName() + " revived " + revivedDroid.getName(), "yellow");
                fileLogger.logInformation(droid1.getName() + " revived " + revivedDroid.getName(), "yellow");
            }
        } else {
            consoleLogger.logInformation(player + " that droid can not revive any more", "yellow");
            fileLogger.logInformation(player + " that droid can not revive any more", "yellow");
        }
    }
}

