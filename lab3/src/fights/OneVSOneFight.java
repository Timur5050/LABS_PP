package fights;

import droids.Droid;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class OneVSOneFight extends Fight {
    String filePath = "droids.txt";
    File file = new File(filePath);

    public OneVSOneFight(Droid droid1, Droid droid2) {
        team1.add(droid1);
        team2.add(droid2);
    }

    @Override
    public void fight() {
        Random random = new Random();

        System.out.println("Who starts first? Let's throw monet (0 - first player, 1 - second player)");
        Droid droid1 = team1.get(0), droid2 = team2.get(0);
        boolean res = random.nextBoolean();

        if (res) {
            System.out.println("first player starts");
        } else {
            System.out.println("second player starts");
        }

        while (true) {
            System.out.print(COLOR_GREEN + "\nsmall stats : " + droid1.getName() + " hp :  " + droid1.getHealthPoints() + "     |     " + droid2.getName() + " hp : " + droid2.getHealthPoints() + COLOR_RESET);
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
        System.out.println(COLOR_BLUE + "\n" + player + " step: " + COLOR_RESET);
        step(attacker, defender, player);
        return localCheck() == 1;
    }

    private int localCheck() {
        if (this.GeneralCheck() == 1) {
            System.out.println(COLOR_PURPLE + "player second won, congrats!!!!" + COLOR_RESET);
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(COLOR_PURPLE + "player second won, congrats!!!!" + "\n" + COLOR_RESET);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        }
        if (this.GeneralCheck() == 2) {
            System.out.println(COLOR_PURPLE + "player first won, congrats!!!!" + COLOR_RESET);
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(COLOR_PURPLE + "player first won, congrats!!!!" + "\n" + COLOR_RESET);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        }
        return 0;
    }

    private void step(Droid droid1, Droid droid2, String player) {

        if (Objects.equals(droid1.getType(), "attacker")) {
            System.out.println(COLOR_YELLOW + "droid" + team1.get(0).getName() + " hit " + team2.get(0).getName() + COLOR_RESET);
            int damage = droid1.getTotalDamage();
            droid2.receiveDamage(damage);
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(COLOR_YELLOW + "(" + player + ") droid" + team1.get(0).getName() + " hit " + team2.get(0).getName() + "\n" + COLOR_RESET);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (Objects.equals(droid1.getType(), "healer")) {
            System.out.println(COLOR_YELLOW + "You can not heal bro in one to one fight :(" + COLOR_RESET);
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(COLOR_YELLOW + "(" + player + ") You can not heal bro in one to one fight :(\n" + COLOR_RESET );
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (Objects.equals(droid1.getType(), "reviver")) {
            System.out.println(COLOR_YELLOW + "You can not revive bro in one to one fight :(" + COLOR_RESET);
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(COLOR_YELLOW + "(" + player + ") You can not revive bro in one to one fight :(\n"+  COLOR_RESET);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
