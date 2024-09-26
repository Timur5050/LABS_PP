package fights;

import droids.Droid;

import java.util.Objects;
import java.util.Random;

public class OneVSOneFight extends Fight {

    public OneVSOneFight(Droid droid1, Droid droid2) {
        team1.add(droid1);
        team2.add(droid2);
    }

    public void fight() {
        Random random = new Random();

        System.out.println("Who starts first? Let's throw monet (0 - first player, 1 - second player)");
        int res = random.nextInt(2);
        Droid droid1, droid2;
        if (res == 0) {
            droid1 = team1.get(0);
            droid2 = team2.get(0);
            System.out.println("we got 0, so 1 player starts: ");
        } else {
            droid1 = team2.get(0);
            droid2 = team1.get(0);
            System.out.println("we got 1, so 2 player starts: ");
        }


        while (true) {
            System.out.print("\u001B[32m" + "\nsmall stats : " + droid1.getName() + " hp :  " + droid1.getHealthPoints() + "     |     " + droid2.getName() + " hp : " + droid2.getHealthPoints() + "\u001B[0m");
            if (res == 0) {
                System.out.println("\u001B[34m" + "\nfirst player step: " + "\u001B[0m");
                step(droid1, droid2);
                if (this.localCheck() == 1) break;
                System.out.println("\u001B[31m" + "\nsecond player step: " + "\u001B[0m");
                step(droid2, droid1);
                if (this.localCheck() == 1) break;
            } else {
                System.out.println("\u001B[34m" + "\nsecond player step: " + "\u001B[0m");
                step(droid2, droid1);
                if (this.localCheck() == 1) break;
                System.out.println("\u001B[31m" + "\nfirst player step: " + "\u001B[0m");
                step(droid1, droid2);
                if (this.localCheck() == 1) break;
            }

        }
    }

    private int localCheck() {
        if (this.GeneralCheck() == 1) {
            System.out.println("\u001B[35m" + "first player won, congrats!!!!" + "\u001B[0m");
            return 1;
        }
        if (this.GeneralCheck() == 2) {
            System.out.println("\u001B[35m" + "second player won, congrats!!!!" + "\u001B[0m");
            return 1;
        }
        return 0;
    }

    private void step(Droid droid1, Droid droid2) {
        if (Objects.equals(droid1.getType(), "attacker")) {
            System.out.println("\u001B[33m" + "droid" + team1.get(0).getName() + " hit " + team2.get(0).getName() + "\u001B[0m");
            int damage = droid1.getTotalDamage();
            droid2.getDamage(damage);
        }
        //else if (Objects.equals(droid1.getType(), "healer"))
        //{
        //    droid1 +=
        //}
    }

}
