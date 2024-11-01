package Menus;

import Fleets.CarFleet;
import cars.*;
import commands.*;
import logger.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private CarFleet fleet;
    private Logger logger;

    public Menu() {
        fleet = new CarFleet();
        logger = new Logger();
    }

    public void setFleet(CarFleet fleet) {
        this.fleet = fleet;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public CarFleet getFleet() {
        return fleet;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void showCommands() {
        System.out.println("0 - Add cars from file");
        System.out.println("1 - Add car manually");
        System.out.println("2 - Get list of cars");
        System.out.println("3 - Get price of whole car fleet");
        System.out.println("4 - Sort cars by fuel consumption");
        System.out.println("5 - Get cars by speed limits");
        System.out.println("6 - Exit");
        System.out.print(": ");
    }


    public void menu() {
        Command getPriceOfWholeCarFleetCommand = new GetPriceOfWholeCarFleetCommand(fleet);
        Command sortCarsByFuelConsumptionCommand = new SortCarsByFuelConsumptionCommand(fleet);
        Command getCarsBySpeedLimitsCommand = new GetCarsBySpeedLimits(fleet);

        Invoker invoker = new Invoker(getPriceOfWholeCarFleetCommand, sortCarsByFuelConsumptionCommand, getCarsBySpeedLimitsCommand);

        while (true) {
            showCommands();
            int ask = scanner.nextInt();
            scanner.nextLine();

            if (ask == 6) {
                logger.logInformation("\nPOST leave the program");
                logger.logInformation("\n---------------------------------END---------------------------------\n");
                break;
            }
            menuHelper(ask, invoker);

        }
    }

    public void menuHelper(int ask, Invoker invoker) {
        double[] array = {};
        switch (ask) {
            case 0:
                logger.logInformation("\nPOST add cars to the fleet from the file");
                addCarsFromFile();
                break;
            case 1:
                logger.logInformation("\nPOST add car manually");
                addCarManually();
                break;
            case 2:
                logger.logInformation("\nGET display all cars");
                displayCars();
                break;
            case 3:
                logger.logInformation("\nGET price of the fleet");
                invoker.executeGetPriceOfWholeCarFleet(array);
                break;
            case 4:
                logger.logInformation("\nGET sorted by fuel consumption fleet");
                invoker.executeSortCarsByFuelConsumption(array);
                break;
            case 5:
                System.out.print("Enter min limit of speed: ");
                double start = scanner.nextDouble();
                System.out.print("Enter max limit of speed: ");
                double finish = scanner.nextDouble();
                double[] tempArray = {start, finish};
                logger.logInformation("\nGET cars by speed limits [" + start + "]");
                invoker.executeGetCarsBySpeedLimits(tempArray);
                break;
            default:
                logger.logInformation("\n404 invalid command");
                System.out.println("Invalid command, please try again.");
        }
    }

    public void addCarsFromFile() {
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
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getModelName() {
        System.out.print("Enter model name: ");
        return scanner.nextLine();
    }

    public double getCarSpeed() {
        System.out.print("Enter car speed: ");
        return scanner.nextDouble();
    }

    public double getCarPrice() {
        System.out.print("Enter car price: ");
        return scanner.nextDouble();
    }

    public double getCarFuelConsumption() {
        System.out.print("Enter car fuel consumption: ");
        return scanner.nextDouble();
    }

    public boolean isCarFree() {
        System.out.print("Is the car free now? (true/false): ");
        return scanner.nextBoolean();
    }


    public void createExactCat(String modelName, double speed, double price, double fuelConsumption, boolean freeOrNot)
    {
        System.out.print("Enter type of the car: ");
        String type = scanner.nextLine();
        switch (type.toLowerCase()) {
            case "business":
                logger.logInformation(" " + type + "(" + modelName + ") added");
                addBusinessCar(modelName, speed, price, fuelConsumption, freeOrNot);
                break;
            case "comfort":
                logger.logInformation(" " + type + "(" + modelName + ") added");
                addComfortCar(modelName, speed, price, fuelConsumption, freeOrNot);
                break;
            case "kids":
                logger.logInformation(" " + type + "(" + modelName + ") added");
                addKidsCar(modelName, speed, price, fuelConsumption, freeOrNot);
                break;
            case "lite":
                logger.logInformation(" " + type + "(" + modelName + ") added");
                Lite liteCar = new Lite(modelName, speed, price, fuelConsumption, freeOrNot);
                fleet.addCarToTheFleet(liteCar);
                break;
            case "minibus":
                logger.logInformation(" " + type + "(" + modelName + ") added");
                addMinibusCar(modelName, speed, price, fuelConsumption, freeOrNot);
                break;
            case "standard":
                logger.logInformation(" " + type + "(" + modelName + ") added");
                addStandardCar(modelName, speed, price, fuelConsumption, freeOrNot);
                break;
            case "wagon":
                logger.logInformation(" " + type + "(" + modelName + ") added");
                addWagonCar(modelName, speed, price, fuelConsumption, freeOrNot);
                break;
            default:
                logger.logInformation(" " + "car was not added, invalid car type");
                System.out.println("Invalid car type.");
                break;
        }
    }

    public void addCarManually() {
        String modelName = getModelName();
        double speed = getCarSpeed();
        double price = getCarPrice();
        double fuelConsumption = getCarFuelConsumption();
        boolean freeOrNot = isCarFree();
        scanner.nextLine();

        createExactCat(modelName, speed, price, fuelConsumption, freeOrNot);
    }

    public Business addBusinessCar(String modelName, double speed, double price, double fuelConsumption, boolean freeOrNot) {
        System.out.print("Does the car have premium service? (true/false): ");
        boolean hasService = scanner.nextBoolean();
        System.out.print("Can the car be ordered in advance? (true/false): ");
        boolean canBeOrderedInAdvance = scanner.nextBoolean();
        Business businessCar = new Business(modelName, speed, price, fuelConsumption, freeOrNot, hasService, canBeOrderedInAdvance);
        fleet.addCarToTheFleet(businessCar);
        return businessCar;
    }

    public Comfort addComfortCar(String modelName, double speed, double price, double fuelConsumption, boolean freeOrNot) {
        System.out.print("Enter additional features: ");
        scanner.nextLine(); // Consume the newline character
        String additionalFeatures = scanner.nextLine();
        Comfort comfortCar = new Comfort(modelName, speed, price, fuelConsumption, freeOrNot, additionalFeatures);
        fleet.addCarToTheFleet(comfortCar);
        return comfortCar;
    }

    public Kids addKidsCar(String modelName, double speed, double price, double fuelConsumption, boolean freeOrNot) {
        System.out.print("Enter additional places for kids: ");
        int additionalPlacesForKids = scanner.nextInt();
        Kids kidsCar = new Kids(modelName, speed, price, fuelConsumption, freeOrNot, additionalPlacesForKids);
        fleet.addCarToTheFleet(kidsCar);
        return kidsCar;
    }

    public Minibus addMinibusCar(String modelName, double speed, double price, double fuelConsumption, boolean freeOrNot) {
        System.out.print("Enter additional places: ");
        int additionalPlaces = scanner.nextInt();
        Minibus minibusCar = new Minibus(modelName, speed, price, fuelConsumption, freeOrNot, additionalPlaces);
        fleet.addCarToTheFleet(minibusCar);
        return minibusCar;
    }

    public Standard addStandardCar(String modelName, double speed, double price, double fuelConsumption, boolean freeOrNot) {
        System.out.print("Can the car be ordered in advance? (true/false): ");
        boolean carCanBeOrderedInAdvance = scanner.nextBoolean();
        Standard standardCar = new Standard(modelName, speed, price, fuelConsumption, freeOrNot, carCanBeOrderedInAdvance);
        fleet.addCarToTheFleet(standardCar);
        return standardCar;
    }

    public Wagon addWagonCar(String modelName, double speed, double price, double fuelConsumption, boolean freeOrNot) {
        System.out.print("Enter additional place: ");
        double carAdditionalAmountOfPlace = scanner.nextDouble();
        Wagon wagonCar = new Wagon(modelName, speed, price, fuelConsumption, freeOrNot, carAdditionalAmountOfPlace);
        fleet.addCarToTheFleet(wagonCar);
        return wagonCar;
    }

    public void displayCars() {
        for (Car car : fleet.getCarFleet()) {
            System.out.println(car);
        }
    }


}
