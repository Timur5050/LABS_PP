package menus;


import Fleets.CarFleet;
import Menus.Menu;
import cars.*;
import commands.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import java.io.*;
import java.util.Scanner;


class MenuTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Menu menu;

    @Mock
    private CarFleet fleet;

    @Mock
    private Scanner scanner;

    @Mock
    private Menu menu2;

    @InjectMocks
    private Menu menu1;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        MockitoAnnotations.openMocks(this);
        menu = new Menu();
    }

    @Test
    void testAttributes() {
        Scanner scanner = new Scanner(System.in);
        CarFleet fleet = new CarFleet();

        menu.setScanner(scanner);
        menu.setFleet(fleet);

        assertEquals(scanner, menu.getScanner());
        assertEquals(fleet, menu.getFleet());

    }

    @Test
    void testShowCommands() {
        menu.showCommands();
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("0 - Add cars from file"));
        assertTrue(output.contains("1 - Add car manually"));
        assertTrue(output.contains("2 - Get list of cars"));
        assertTrue(output.contains("3 - Get price of whole car fleet"));
        assertTrue(output.contains("4 - Sort cars by fuel consumption"));
        assertTrue(output.contains("5 - Get cars by speed limits"));
        assertTrue(output.contains("6 - Exit"));
        System.out.print(": ");
    }

    @Test
    void testDisplayCars() {
        Business businessCar = new Business("BMW", 150.0, 300.0, 10.0, true, true, false);
        CarFleet fleet = new CarFleet();
        fleet.addCarToTheFleet(businessCar);
        menu.setFleet(fleet);

        menu.displayCars();
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("type: Standard, model: BMW"));
    }


    @Test
    public void testAddWagonCar() {
        String modelName = "TestModel";
        double speed = 120.0;
        double price = 20000.0;
        double fuelConsumption = 15.0;
        boolean freeOrNot = true;
        double additionalPlace = 5.0;

        when(scanner.nextDouble()).thenReturn(additionalPlace);

        Wagon result = menu1.addWagonCar(modelName, speed, price, fuelConsumption, freeOrNot);

        assertNotNull(result);
        assertEquals(modelName, result.getModeName());
        assertEquals(speed, result.getSpeed(), 0);
        assertEquals(price, result.getPrice(), 0);
        assertEquals(fuelConsumption, result.getFuelConsumption(), 0);
        assertEquals(freeOrNot, result.isFreeOrNot());
        verify(fleet).addCarToTheFleet(result);
    }

    @Test
    public void testStandardCar() {
        String modelName = "TestModel";
        double speed = 120.0;
        double price = 20000.0;
        double fuelConsumption = 15.0;
        boolean freeOrNot = true;
        boolean carCanBeOrderedInAdvance = true;

        when(scanner.nextBoolean()).thenReturn(carCanBeOrderedInAdvance);

        Standard result = menu1.addStandardCar(modelName, speed, price, fuelConsumption, freeOrNot);

        assertNotNull(result);
        assertEquals(modelName, result.getModeName());
        assertEquals(speed, result.getSpeed(), 0);
        assertEquals(price, result.getPrice(), 0);
        assertEquals(fuelConsumption, result.getFuelConsumption(), 0);
        assertEquals(freeOrNot, result.isFreeOrNot());
        verify(fleet).addCarToTheFleet(result);
    }

    @Test
    public void testMinibusCar() {
        String modelName = "TestModel";
        double speed = 120.0;
        double price = 20000.0;
        double fuelConsumption = 15.0;
        boolean freeOrNot = true;
        int carCanBeOrderedInAdvance = 2;

        when(scanner.nextInt()).thenReturn(carCanBeOrderedInAdvance);

        Minibus result = menu1.addMinibusCar(modelName, speed, price, fuelConsumption, freeOrNot);

        assertNotNull(result);
        assertEquals(modelName, result.getModeName());
        assertEquals(speed, result.getSpeed(), 0);
        assertEquals(price, result.getPrice(), 0);
        assertEquals(fuelConsumption, result.getFuelConsumption(), 0);
        assertEquals(freeOrNot, result.isFreeOrNot());
        verify(fleet).addCarToTheFleet(result);
    }

    @Test
    public void testAddBusinessCar() {
        String modelName = "TestBusinessModel";
        double speed = 120.0;
        double price = 20000.0;
        double fuelConsumption = 15.0;
        boolean freeOrNot = true;
        boolean hasService = true;
        boolean canBeOrderedInAdvance = false;

        when(scanner.nextBoolean()).thenReturn(hasService, canBeOrderedInAdvance);

        Business result = menu1.addBusinessCar(modelName, speed, price, fuelConsumption, freeOrNot);

        assertNotNull(result);
        assertEquals(modelName, result.getModeName());
        assertEquals(speed, result.getSpeed(), 0);
        assertEquals(price, result.getPrice(), 0);
        assertEquals(fuelConsumption, result.getFuelConsumption(), 0);
        assertEquals(freeOrNot, result.isFreeOrNot());
        verify(fleet).addCarToTheFleet(result);
    }

    @Test
    public void testAddComfortCar() {
        String modelName = "TestComfortModel";
        double speed = 120.0;
        double price = 20000.0;
        double fuelConsumption = 15.0;
        boolean freeOrNot = true;
        String additionalFeatures = "Leather seats";

        when(scanner.nextLine()).thenReturn(additionalFeatures);

        Comfort result = menu1.addComfortCar(modelName, speed, price, fuelConsumption, freeOrNot);

        assertNotNull(result);
        assertEquals(modelName, result.getModeName());
        assertEquals(speed, result.getSpeed(), 0);
        assertEquals(price, result.getPrice(), 0);
        assertEquals(fuelConsumption, result.getFuelConsumption(), 0);
        assertEquals(freeOrNot, result.isFreeOrNot());
        verify(fleet).addCarToTheFleet(result);
    }

    @Test
    public void testAddKidsCar() {
        String modelName = "TestKidsModel";
        double speed = 120.0;
        double price = 20000.0;
        double fuelConsumption = 15.0;
        boolean freeOrNot = true;
        int additionalPlacesForKids = 2;

        when(scanner.nextInt()).thenReturn(additionalPlacesForKids);

        Kids result = menu1.addKidsCar(modelName, speed, price, fuelConsumption, freeOrNot);

        assertNotNull(result);
        assertEquals(modelName, result.getModeName());
        assertEquals(speed, result.getSpeed(), 0);
        assertEquals(price, result.getPrice(), 0);
        assertEquals(fuelConsumption, result.getFuelConsumption(), 0);
        assertEquals(freeOrNot, result.isFreeOrNot());
        ;
        verify(fleet).addCarToTheFleet(result);
    }

    @Test
    public void testAddingCarsFromFile() {
        CarFleet fleet = new CarFleet();
        menu.setFleet(fleet);
        menu.addCarsFromFile();

        assertEquals(6, menu.getFleet().getCarFleet().size());
    }

    @Test
    public void testMenuHelperZero() {
        CarFleet fleet = new CarFleet();
        menu.setFleet(fleet);
        Command getPriceOfWholeCarFleetCommand = new GetPriceOfWholeCarFleetCommand(fleet);
        Command sortCarsByFuelConsumptionCommand = new SortCarsByFuelConsumptionCommand(fleet);
        Command getCarsBySpeedLimitsCommand = new GetCarsBySpeedLimits(fleet);

        Invoker invoker = new Invoker(getPriceOfWholeCarFleetCommand, sortCarsByFuelConsumptionCommand, getCarsBySpeedLimitsCommand);

        menu.menuHelper(0, invoker);

        assertEquals(6, fleet.getCarFleet().size());
    }


    @Test
    public void testMenuHelperTwo() {
        CarFleet fleet = new CarFleet();
        menu.setFleet(fleet);
        Command getPriceOfWholeCarFleetCommand = new GetPriceOfWholeCarFleetCommand(fleet);
        Command sortCarsByFuelConsumptionCommand = new SortCarsByFuelConsumptionCommand(fleet);
        Command getCarsBySpeedLimitsCommand = new GetCarsBySpeedLimits(fleet);

        Invoker invoker = new Invoker(getPriceOfWholeCarFleetCommand, sortCarsByFuelConsumptionCommand, getCarsBySpeedLimitsCommand);


        Business businessCar = new Business("BMW", 150.0, 300.0, 10.0, true, true, false);
        fleet.addCarToTheFleet(businessCar);
        menu.setFleet(fleet);

        menu.menuHelper(2, invoker);

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("type: Standard, model: BMW"));
    }

    @Test
    public void testMenuHelperOne() {
        CarFleet fleet = new CarFleet();
        Menu menu = Mockito.spy(new Menu());
        menu.setFleet(fleet);

        Command getPriceOfWholeCarFleetCommand = new GetPriceOfWholeCarFleetCommand(fleet);
        Command sortCarsByFuelConsumptionCommand = new SortCarsByFuelConsumptionCommand(fleet);
        Command getCarsBySpeedLimitsCommand = new GetCarsBySpeedLimits(fleet);

        Invoker invoker = new Invoker(getPriceOfWholeCarFleetCommand, sortCarsByFuelConsumptionCommand, getCarsBySpeedLimitsCommand);

        doNothing().when(menu).addCarManually();

        menu.menuHelper(1, invoker);

        assertEquals(0, fleet.getCarFleet().size());
    }

    @Test
    public void testMenuHelperThree() {
        CarFleet fleet = new CarFleet();
        fleet.addCarToTheFleet(new Lite("Toyota Yaris", 120.0, 200.0, 5.5, true));
        fleet.addCarToTheFleet(new Comfort("Audi A6", 160.0, 350.0, 9.5, true, "Leather seats, Sunroof"));
        menu.setFleet(fleet);

        Command getPriceOfWholeCarFleetCommand = new GetPriceOfWholeCarFleetCommand(fleet);
        Command sortCarsByFuelConsumptionCommand = new SortCarsByFuelConsumptionCommand(fleet);
        Command getCarsBySpeedLimitsCommand = new GetCarsBySpeedLimits(fleet);

        Invoker invoker = new Invoker(getPriceOfWholeCarFleetCommand, sortCarsByFuelConsumptionCommand, getCarsBySpeedLimitsCommand);

        menu.menuHelper(3, invoker);

        double expectedPrice = 200.0 + 350.0; // Update based on test data
        double[] arr = {};
        assertEquals(expectedPrice, fleet.getCarFleet().get(0).getPrice() + fleet.getCarFleet().get(1).getPrice(), 0.01);
    }

    @Test
    public void testMenuHelperFour() {
        CarFleet fleet = new CarFleet();
        fleet.addCarToTheFleet(new Lite("Toyota Yaris", 120.0, 200.0, 7.5, true));
        fleet.addCarToTheFleet(new Comfort("Audi A6", 160.0, 350.0, 9.5, true, "Leather seats, Sunroof"));
        menu.setFleet(fleet);

        Command getPriceOfWholeCarFleetCommand = new GetPriceOfWholeCarFleetCommand(fleet);
        Command sortCarsByFuelConsumptionCommand = new SortCarsByFuelConsumptionCommand(fleet);
        Command getCarsBySpeedLimitsCommand = new GetCarsBySpeedLimits(fleet);

        Invoker invoker = new Invoker(getPriceOfWholeCarFleetCommand, sortCarsByFuelConsumptionCommand, getCarsBySpeedLimitsCommand);

        menu.menuHelper(4, invoker);

        assertTrue(fleet.getCarFleet().get(0).getFuelConsumption() <= fleet.getCarFleet().get(1).getFuelConsumption());
    }


    @Test
    public void testMenuHelperFive() {

        when(scanner.nextDouble()).thenReturn(150.0);
        when(scanner.nextDouble()).thenReturn(200.0);

        CarFleet fleet = new CarFleet();
        fleet.addCarToTheFleet(new Lite("Toyota Yaris", 120.0, 200.0, 7.5, true));
        fleet.addCarToTheFleet(new Comfort("Audi A6", 160.0, 350.0, 9.5, true, "Leather seats, Sunroof"));
        menu1.setFleet(fleet);

        Command getPriceOfWholeCarFleetCommand = new GetPriceOfWholeCarFleetCommand(fleet);
        Command sortCarsByFuelConsumptionCommand = new SortCarsByFuelConsumptionCommand(fleet);
        Command getCarsBySpeedLimitsCommand = new GetCarsBySpeedLimits(fleet);

        Invoker invoker = new Invoker(getPriceOfWholeCarFleetCommand, sortCarsByFuelConsumptionCommand, getCarsBySpeedLimitsCommand);

        menu1.menuHelper(5, invoker);


        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("type: comfort"));
    }


    @Test
    public void testMenuDefault() {

        Command getPriceOfWholeCarFleetCommand = new GetPriceOfWholeCarFleetCommand(fleet);
        Command sortCarsByFuelConsumptionCommand = new SortCarsByFuelConsumptionCommand(fleet);
        Command getCarsBySpeedLimitsCommand = new GetCarsBySpeedLimits(fleet);

        Invoker invoker = new Invoker(getPriceOfWholeCarFleetCommand, sortCarsByFuelConsumptionCommand, getCarsBySpeedLimitsCommand);

        menu.menuHelper(10, invoker);

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Invalid command, please try again."));
    }


    @Test
    public void testGetCarSpeed() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextDouble()).thenReturn(100.0);

        double res = menu1.getCarSpeed();
        assertEquals(100.0, res, 0.0);
    }

    @Test
    public void testGetModelName() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("M5 F90");

        String res = menu1.getModelName();
        assertEquals("M5 F90", res);
    }

    @Test
    public void testGetCarPrice() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextDouble()).thenReturn(50000.0);

        double res = menu1.getCarPrice();
        assertEquals(50000.0, res, 0.0);
    }

    @Test
    public void testGetCarFuelConsumption() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextDouble()).thenReturn(8.5);

        double res = menu1.getCarFuelConsumption();
        assertEquals(8.5, res, 0.0);
    }

    @Test
    public void testIsCarFree() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextBoolean()).thenReturn(true);

        boolean res = menu1.isCarFree();
        assertEquals(true, res);
    }

    @Test
    public void testCreateExactCatDefault() {
        when(scanner.nextLine()).thenReturn("test");

        menu1.createExactCat("ModelX", 150, 30000, 10, true);

        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Invalid car type."));
    }

    @Test
    public void testCreateExactCatBusiness() {
        when(scanner.nextLine()).thenReturn("business");

        menu1.createExactCat("ModelX", 150, 30000, 10, true);
    }

    @Test
    public void testCreateExactCatComfort() {
        when(scanner.nextLine()).thenReturn("comfort");

        menu1.createExactCat("ModelX", 150, 30000, 10, true);
    }

    @Test
    public void testCreateExactCatKids() {
        when(scanner.nextLine()).thenReturn("kids");

        menu1.createExactCat("ModelX", 150, 30000, 10, true);
    }

    @Test
    public void testCreateExactCatLite() {
        when(scanner.nextLine()).thenReturn("lite");

        menu1.createExactCat("ModelX", 150, 30000, 10, true);
    }

    @Test
    public void testCreateExactCatMinibus() {
        when(scanner.nextLine()).thenReturn("minibus");

        menu1.createExactCat("ModelX", 150, 30000, 10, true);
    }

    @Test
    public void testCreateExactCatStandard() {
        when(scanner.nextLine()).thenReturn("standard");

        menu1.createExactCat("ModelX", 150, 30000, 10, true);
    }

    @Test
    public void testCreateExactCatWagon() {
        when(scanner.nextLine()).thenReturn("wagon");

        menu1.createExactCat("ModelX", 150, 30000, 10, true);
    }

    @Test
    public void testMenu() {
        when(scanner.nextInt()).thenReturn(6);

        CarFleet fleet = new CarFleet();

        menu1.setFleet(fleet);
        menu1.menu();

        assertEquals(0, fleet.getCarFleet().size());
    }

    @Test
    public void testMenuNotExit() {
        when(scanner.nextInt()).thenReturn(0);
        when(scanner.nextInt()).thenReturn(6);

        CarFleet fleet = new CarFleet();

        menu1.setFleet(fleet);
        menu1.menu();

        assertEquals(0, fleet.getCarFleet().size());
    }

    @Test
    public void testMenuHelperCalled() {
        Menu spyMenu = spy(menu1);

        when(scanner.nextInt()).thenReturn(0).thenReturn(6); // Simulate user input

        spyMenu.menu();


        verify(spyMenu).menuHelper(eq(0), any(Invoker.class));
    }

    @Test
    public void testAddCarManually() {
        when(scanner.nextLine()).thenReturn("M5");
        when(scanner.nextDouble()).thenReturn(100.0);
        when(scanner.nextDouble()).thenReturn(120.0);
        when(scanner.nextDouble()).thenReturn(11.0);
        when(scanner.nextBoolean()).thenReturn(true);

        menu1.addCarManually();

    }

}
