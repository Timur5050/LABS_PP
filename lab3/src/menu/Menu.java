package menu;

import java.io.File;

import droids.*;
import fights.Fight;
import fights.ManyToManyFight;
import fights.OneVSOneFight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    File file = new File("droids.txt");
    protected static final String COLOR_RESET = "\u001B[0m";
    protected static final String COLOR_GREEN = "\u001B[32m";
    protected static final String COLOR_BLUE = "\u001B[34m";
    protected static final String COLOR_YELLOW = "\u001B[33m";
    protected static final String COLOR_PURPLE = "\u001B[35m";
    private List<Droid> listOfAllDroids = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    private void choose() {
        System.out.println("0 - create droid");
        System.out.println("1 - list of created droids");
        System.out.println("2 - start 1v1 fight");
        System.out.println("3 - start many to many fight");
        System.out.println("4 - write fight into file");
        System.out.println("5 - read fight from file");
        System.out.println("6 - exit");
        System.out.print("your choice : ");
    }

    private void miniChooseForManyToManyFight() {
        System.out.println("0 - list of both teams");
        System.out.println("1 - add droid to first team");
        System.out.println("2 - add droid to second team");
        System.out.println("3 - end choosing droids to many to many fight");
        System.out.print("your choice : ");
    }

    private Droid createDroid() {
        System.out.println("choose droid to create(by default - Balanced droid): ");
        System.out.println("0 - balanced droid");
        System.out.println("1 - damage droid");
        System.out.println("2 - splash droid");
        System.out.println("3 - heal droid");
        System.out.println("4 - reviver droid");
        System.out.print("your choice : ");
        int number = scanner.nextInt();
        if (number == 0) return new BalancedDroid();
        if (number == 1) return new DamageDroid();
        if (number == 2) return new SplashDroid();
        if (number == 3) return new HealDroid();
        if (number == 4) return new ReviverDroid();

        return new BalancedDroid();
    }

    private void showListOfCreatedDroids() {
        for (int i = 0; i < 40; i++) System.out.print(COLOR_GREEN + "-" + COLOR_RESET);
        for (Droid droid : listOfAllDroids) {
            System.out.println("\n" + droid);
            for (int i = 0; i < 40; i++) System.out.print(COLOR_GREEN + "-" + COLOR_RESET);
        }
        System.out.println();
    }

    private Droid choosingOneDroidFromListOfDroids() {
        System.out.println("small list of all droids : ");
        for (Droid droid : listOfAllDroids) {
            System.out.println(droid.getName());
        }
        System.out.println("choose one of them by index : ");
        int index = scanner.nextInt();
        Droid tempDroid = listOfAllDroids.get(index);
        listOfAllDroids.remove(index);
        return tempDroid;
    }


    public void mainStart() {
        if (file.exists()) {
            try (FileWriter writer = new FileWriter(file, false)) {
                System.out.println("Файл успішно очищено.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            choose();
            int number = scanner.nextInt();
            if (number == 6) {
                break;
            }
            switch (number) {
                case 0:
                    listOfAllDroids.add(createDroid());
                    break;
                case 1:
                    showListOfCreatedDroids();
                    break;
                case 2:

                    if (file.exists()) {
                        try (FileWriter writer = new FileWriter(file, false)) {
                            System.out.println("Файл успішно очищено.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (listOfAllDroids.size() < 2) {
                        System.out.println("you need to have more than two droids to perform 1v1 fight");
                    } else {
                        System.out.print("for first team : \n");
                        Droid droid1 = choosingOneDroidFromListOfDroids();
                        System.out.print("for second team : \n");
                        Droid droid2 = choosingOneDroidFromListOfDroids();
                        Fight fight = new OneVSOneFight(droid1, droid2);
                        fight.fight();
                    }
                    break;
                case 3:
                    if (file.exists()) {
                        try (FileWriter writer = new FileWriter(file, false)) {
                            System.out.println("Файл успішно очищено.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (listOfAllDroids.size() < 2) {
                        System.out.println("you need to have more than two droids to perform 1v1 fight");
                    } else {
                        System.out.println("you need to choose at least one droid for each team: ");
                        List<Droid> team1 = new ArrayList<>();
                        List<Droid> team2 = new ArrayList<>();


                        while (true) {
                            miniChooseForManyToManyFight();
                            int ask = scanner.nextInt();
                            if (ask == 3) break;
                            if (ask == 1) {
                                Droid tempDroid = choosingOneDroidFromListOfDroids();
                                team1.add(tempDroid);
                            } else if (ask == 2) {
                                Droid tempDroid = choosingOneDroidFromListOfDroids();
                                team2.add(tempDroid);
                            } else if (ask == 0) {
                                System.out.println("team1: ");
                                for (Droid droid : team1) System.out.print(droid.getName() + "\t");
                                System.out.println("\nteam2: ");
                                for (Droid droid : team2) System.out.print(droid.getName() + "\t");
                                System.out.println();
                            }
                        }
                        if (team1.size() != team2.size()) {
                            System.out.println("you need to have the same amount of droids in both teams");
                            break;
                        }
                        if (team1.isEmpty()) {
                            System.out.println("you need to at least one droid for each team");
                            break;
                        }
                        Fight manyToManyFight = new ManyToManyFight(team1, team2);
                        manyToManyFight.fight();
                    }
                    break;
                case 4:
                    if (file.exists() && file.length() == 0) {
                        System.out.println("nothing to write to file");
                    } else {
                        System.out.println("done!");
                    }
                    break;
                case 5:
                    file = new File("droids.txt");
                    if (file.exists() && file.length() == 0) {
                        System.out.println("nothing to read from file");
                    } else {
                        try (BufferedReader br = new BufferedReader(new FileReader("droids.txt"))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }
    }

}
