package fights;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import droids.Droid;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ManyToManyFight extends Fight {
    String filePath = "droids.txt";
    File file = new File(filePath);
    Scanner scanner = new Scanner(System.in);

    public ManyToManyFight(List<Droid> _team1, List<Droid> _team2) {
        team1 = _team1;
        team2 = _team2;
    }

    private Droid chooseDroidFromFirstTeam() {
        Droid droid;
        do {
            System.out.print("enter number: ");
            int number = scanner.nextInt();
            droid = team1.get(number);
        } while (!droid.isAlive());
        return droid;
    }

    private Droid chooseDroidFromSecondTeam() {
        Droid droid;
        do {
            System.out.print("enter number: ");
            int number = scanner.nextInt();
            droid = team2.get(number);
        } while (!droid.isAlive());
        return droid;
    }

    @Override
    public void fight() {
        Random random = new Random();

        System.out.println("Who starts first? Let's throw monet (0 - first player, 1 - second player)");
        boolean res = random.nextBoolean();

        System.out.println("General stats: ");
        System.out.println("team 1: ");
        for (Droid droid : team2) {
            System.out.print(droid.getName() + "\t");
        }
        System.out.println("\nteam 2: ");
        for (Droid droid : team1) {
            System.out.print(droid.getName() + "\t");
        }

        if (res) {
            System.out.println("\nfirst player starts");
        } else {
            System.out.println("\nsecond player starts");
        }

        while (true) {
            System.out.print(COLOR_GREEN + "\nsmall stats : \n" + COLOR_RESET);
            System.out.println("team 1: ");
            for (Droid droid : team1) {
                System.out.print(droid.getName() + "(" + droid.getHealthPoints() + ")" + "\t");
            }
            System.out.println("\nteam 2: ");
            for (Droid droid : team2) {
                System.out.print(droid.getName() + "(" + droid.getHealthPoints() + ")" + "\t");
            }
            System.out.println();
            if (res) {
                Droid droid1, droid2;
                System.out.println("player first, choose droid to use: ");
                droid1 = chooseDroidFromFirstTeam();
                System.out.println("player first, choose droid from team2 to use your droid: ");
                droid2 = chooseDroidFromSecondTeam();
                if (performStep(droid1, droid2, "first")) break;

                System.out.println("player second, choose droid to use: ");
                droid2 = chooseDroidFromSecondTeam();
                System.out.println("player second, choose droid from team1 to use your droid: ");
                droid1 = chooseDroidFromFirstTeam();
                if (performStep(droid2, droid1, "second")) break;

            } else {
                Droid droid1, droid2;
                System.out.println("player second, choose droid to use: ");
                droid2 = chooseDroidFromSecondTeam();
                System.out.println("player second, choose droid from team1 to use your droid: ");
                droid1 = chooseDroidFromFirstTeam();
                if (performStep(droid2, droid1, "second")) break;

                System.out.println("player first, choose droid to use: ");
                droid1 = chooseDroidFromFirstTeam();
                System.out.println("player first, choose droid from team2 to use your droid: ");
                droid2 = chooseDroidFromSecondTeam();
                if (performStep(droid1, droid2, "first")) break;
            }

        }
    }

    private boolean performStep(Droid attacker, Droid defender, String player) {
        System.out.println(COLOR_BLUE + "\n" + player + " step: " + COLOR_RESET);
        step(attacker, defender, player);
        return localCheck() == 1;
    }

    private int localCheck() {
        if (this.GeneralCheck() == 1) {
            System.out.println(COLOR_PURPLE + "player second won, congrats!!!!" + COLOR_RESET);
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write( COLOR_PURPLE + "player second won, congrats!!!!" + "\n" + COLOR_RESET );
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        }
        if (this.GeneralCheck() == 2) {
            System.out.println(COLOR_PURPLE + "player first won, congrats!!!!" + COLOR_RESET);
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write( COLOR_PURPLE + "player second won, congrats!!!!" + "\n" + COLOR_RESET);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        }
        return 0;
    }

    private void step(Droid droid1, Droid droid2, String player) {

        if (Objects.equals(droid1.getType(), "attacker")) {
            int damage = droid1.getTotalDamage();
            droid2.receiveDamage(damage);
            System.out.println(COLOR_YELLOW + "(" + player + ") droid" + droid1.getName() + " hit " + droid2.getName() + " with " + damage + ", now is has : " + droid2.getHealthPoints() + "hp\n" + COLOR_RESET);
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(COLOR_YELLOW + "(" + player + ") droid" + droid1.getName() + " hit " + droid2.getName() + " with " + damage + ", now is has : " + droid2.getHealthPoints() + "hp\n" + COLOR_RESET);
            }
            catch (IOException e) {
                e.printStackTrace();
            }

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

        } else if (Objects.equals(droid1.getType(), "healer")) {
            System.out.println(COLOR_YELLOW + "droid " + droid1.getName() + " healed the team with " + droid1.getHeal() + "hps" + COLOR_RESET);
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write( COLOR_YELLOW + "(" + player + ") droid " + droid1.getName() + " healed the team with " + droid1.getHeal() + "hps" + "\n" + COLOR_RESET);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            if (Objects.equals(player, "first")) {
                for (Droid droid : team1) {
                    droid.receiveHeal(droid1.getHeal());
                }
            } else {
                for (Droid droid : team2) {
                    droid.receiveHeal(droid1.getHeal());
                }
            }
        } else if (Objects.equals(droid1.getType(), "reviver")) {
            if (droid1.getRevive() == 1) {
                int number;
                Droid revivedDroid;
                List<Droid> team = player.equals("first") ? team1 : team2; // Вибір команди залежно від гравця
                System.out.println("enter number of droid to revive");

                boolean allAlive = true;
                for(Droid droid : team) {
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

                    System.out.println(COLOR_YELLOW + droid1.getName() + " revived " + revivedDroid.getName() + COLOR_RESET);
                    try (FileWriter writer = new FileWriter(file, true)) {
                        writer.write(COLOR_YELLOW + "(" + player + ") " + droid1.getName() + " revived " + revivedDroid.getName() + COLOR_RESET);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println(COLOR_YELLOW + "(" + player + ") " + "that droid can not revive any more" + COLOR_RESET);
                try (FileWriter writer = new FileWriter(file, true)) {
                    writer.write(COLOR_YELLOW + "(" + player + ") " + "that droid can not revive any more" + COLOR_RESET);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
