package fights;

import droids.Droid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Fight {
    protected static final String COLOR_RESET = "\u001B[0m";
    protected static final String COLOR_GREEN = "\u001B[32m";
    protected static final String COLOR_BLUE = "\u001B[34m";
    protected static final String COLOR_YELLOW = "\u001B[33m";
    protected static final String COLOR_PURPLE = "\u001B[35m";
    protected List<Droid> team1 = new ArrayList<>();
    protected List<Droid> team2 = new ArrayList<>();

    protected int GeneralCheck() { // 0 - games continues 1 - first lose, 2 - second - lose
        boolean flag = true;
        for (Droid droid : team1) {
            if (droid.isAlive()) {
                flag = false;
            }
        }

        if(flag)
        {
            return 1;
        }
        flag = true;
        for (Droid droid : team2) {
            if (droid.isAlive()) {
                flag = false;
            }
        }
        if(flag)
        {
            return 2;
        }
        return 0;
    }

    public void fight()
    {
        System.out.println("fight has started");
    }


}
