package Menus;

import Fleets.CarFleet;
import cars.*;
import commands.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private void showCommands() {
        System.out.println("0 - add cars from file");
        System.out.println("1 - add car manually");
        System.out.println("2 - get list of cars");
        System.out.println("3 - get price of whole car fleet");
        System.out.println("4 - sort cars by fuel consumption");
        System.out.println("5 - get cars by speed limits");
        System.out.println("6 - exit");
        System.out.println(": ");
    }

    public void menu() {
        CarFleet fleet = new CarFleet();
        Scanner scanner = new Scanner(System.in);


        Command getPriceOfWholeCarFleetCommand = new GetPriceOfWholeCarFleetCommand(fleet);
        Command sortCarsByFuelConsumptionCommand = new SortCarsByFuelConsumptionCommand(fleet);
        Command getCarsBySpeedLimitsCommand = new GetCarsBySpeedLimits(fleet, 0, 0); // межі для швидкості задаємо пізніше


        Invoker invoker = new Invoker(getPriceOfWholeCarFleetCommand, sortCarsByFuelConsumptionCommand, getCarsBySpeedLimitsCommand);

        while (true) {
            showCommands();
            int ask = scanner.nextInt();
            scanner.nextLine();
            if (ask == 6) {
                break;
            }
            switch (ask) {
                case 0:
                    try (BufferedReader reader = new BufferedReader(new FileReader("src/main/cars.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] data = line.split(",");
                            String type = data[0];
                            switch (type) {
                                case "Business":
                                    Business business = new Business(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                                            Integer.parseInt(data[4]), Boolean.parseBoolean(data[5]), Boolean.parseBoolean(data[6]),
                                            Boolean.parseBoolean(data[7]));
                                    fleet.addCarToTheFleet(business);
                                    break;
                                case "Comfort":
                                    Comfort comfort = new Comfort(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                                            Integer.parseInt(data[4]), Boolean.parseBoolean(data[5]), data[6]);
                                    fleet.addCarToTheFleet(comfort);
                                    break;
                                case "Kids":
                                    Kids kids = new Kids(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                                            Integer.parseInt(data[4]), Boolean.parseBoolean(data[5]), Integer.parseInt(data[6]));
                                    fleet.addCarToTheFleet(kids);
                                    break;
                                case "Lite":
                                    Lite lite = new Lite(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                                            Integer.parseInt(data[4]), Boolean.parseBoolean(data[5]));
                                    fleet.addCarToTheFleet(lite);
                                    break;
                                case "Standard":
                                    Standard standard = new Standard(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                                            Integer.parseInt(data[4]), Boolean.parseBoolean(data[5]), Boolean.parseBoolean(data[6]));
                                    fleet.addCarToTheFleet(standard);
                                    break;
                                case "Wagon":
                                    Wagon wagon = new Wagon(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
                                            Integer.parseInt(data[4]), Boolean.parseBoolean(data[5]), Integer.parseInt(data[6]));
                                    fleet.addCarToTheFleet(wagon);
                                    break;
                                default:
                                    System.out.println("this type of cars does not exist");
                                    break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:

                    System.out.print("enter model name: ");
                    String modelName = scanner.nextLine();
                    System.out.print("enter car speed: ");
                    double speed = scanner.nextDouble();
                    System.out.print("enter car price: ");
                    double price = scanner.nextDouble();
                    System.out.print("enter car fuel consumption: ");
                    double fuelConsumption = scanner.nextDouble();
                    System.out.print("enter if the car is free now or no: ");
                    boolean freeOrNot = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.print("enter type of the car: ");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "business":
                            System.out.print("enter if the car has premium service : ");
                            boolean hasService = scanner.nextBoolean();
                            System.out.print("enter if the car can be ordered in advance : ");
                            boolean canBeOrderedInAdvance = scanner.nextBoolean();
                            Business businessCar = new Business(modelName, speed, price, fuelConsumption, freeOrNot, hasService, canBeOrderedInAdvance);
                            fleet.addCarToTheFleet(businessCar);
                            break;
                        case "comfort":
                            System.out.print("enter additional features : ");
                            String additionalFeatures = scanner.nextLine();
                            Comfort comfortCar = new Comfort(modelName, speed, price, fuelConsumption, freeOrNot, additionalFeatures);
                            fleet.addCarToTheFleet(comfortCar);
                            break;
                        case "kids":
                            System.out.print("enter additional places for kids : ");
                            int additionalPlacesForKids = scanner.nextInt();
                            Kids kidsCar = new Kids(modelName, speed, price, fuelConsumption, freeOrNot, additionalPlacesForKids);
                            fleet.addCarToTheFleet(kidsCar);
                            break;
                        case "lite":
                            Lite liteCar = new Lite(modelName, speed, price, fuelConsumption, freeOrNot);
                            fleet.addCarToTheFleet(liteCar);
                            break;
                        case "minibus":
                            System.out.print("enter additional places: ");
                            int additionalPlaces = scanner.nextInt();
                            Minibus minibusCar = new Minibus(modelName, speed, price, fuelConsumption, freeOrNot, additionalPlaces);
                            fleet.addCarToTheFleet(minibusCar);
                            break;
                        case "standard":
                            System.out.print("enter if the car can be ordered in advance: ");
                            boolean carCanBeOrderedInAdvance = scanner.nextBoolean();
                            Standard standardCar = new Standard(modelName, speed, price, fuelConsumption, freeOrNot, carCanBeOrderedInAdvance);
                            fleet.addCarToTheFleet(standardCar);
                            break;
                        case "wagon":
                            System.out.print("enter additional place: ");
                            double carAdditionalAmountOfPlace = scanner.nextDouble();
                            Wagon wagonCar = new Wagon(modelName, speed, price, fuelConsumption, freeOrNot, carAdditionalAmountOfPlace);
                            fleet.addCarToTheFleet(wagonCar);
                            break;
                    }
                    break;
                case 2:
                    for (Car car : fleet.getCarFleet()) {
                        System.out.println(car);
                    }
                    break;
                case 3:
                    invoker.executeGetPriceOfWholeCarFleet();
                    break;
                case 4:
                    invoker.executeSortCarsByFuelConsumption();
                    break;
                case 5:
                    System.out.print("enter min limit of speed : ");
                    double start = scanner.nextDouble();
                    System.out.print("enter max limit of speed : ");
                    double finish = scanner.nextDouble();
                    Command getCarsBySpeedLimits = new GetCarsBySpeedLimits(fleet, start, finish);
                    getCarsBySpeedLimits.execute();
                    break;
            }
        }
    }
}
