package Fleets;

import cars.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CarFleetTest {
    private CarFleet carFleet;

    @BeforeEach
    public void setUp() {
        carFleet = new CarFleet();
    }

    @Test
    public void testAddCarToFleet() {
        Car mockCar = mock(Car.class);
        when(mockCar.getPrice()).thenReturn(10000.0);
        carFleet.addCarToTheFleet(mockCar);

        // Перевіряємо, що автомобіль додано до флоту
        assertEquals(1, carFleet.getCarFleet().size());
    }

    @Test
    public void testGetPriceOFWholeCarFleet() {
        Car mockCar1 = mock(Car.class);
        when(mockCar1.getPrice()).thenReturn(10000.0);

        Car mockCar2 = mock(Car.class);
        when(mockCar2.getPrice()).thenReturn(15000.0);

        carFleet.addCarToTheFleet(mockCar1);
        carFleet.addCarToTheFleet(mockCar2);

        // Перевіряємо, що загальна вартість флоту вірна
        assertEquals(25000.0, carFleet.getPriceOFWholeCarFleet(), 0.001);
    }

    @Test
    public void testSortCarsByFuelConsumption() {
        Car mockCar1 = mock(Car.class);
        when(mockCar1.getFuelConsumption()).thenReturn(10.0);

        Car mockCar2 = mock(Car.class);
        when(mockCar2.getFuelConsumption()).thenReturn(5.0);

        Car mockCar3 = mock(Car.class);
        when(mockCar3.getFuelConsumption()).thenReturn(8.0);

        carFleet.addCarToTheFleet(mockCar1);
        carFleet.addCarToTheFleet(mockCar2);
        carFleet.addCarToTheFleet(mockCar3);

        carFleet.sortCarsByFuelConsumption();

        // Перевіряємо порядок автомобілів за витратами пального
        List<Car> sortedFleet = carFleet.getCarFleet();
        assertEquals(mockCar2, sortedFleet.get(0)); // Найменша витрата
        assertEquals(mockCar3, sortedFleet.get(1));
        assertEquals(mockCar1, sortedFleet.get(2)); // Найбільша витрата
    }

    @Test
    void testGetCarsBySpeedLimits() {
        Car mockCar1 = mock(Car.class);
        when(mockCar1.getSpeed()).thenReturn(80.0);
        when(mockCar1.getPrice()).thenReturn(10000.0);
        when(mockCar1.getFuelConsumption()).thenReturn(20.0);
        when(mockCar1.isFreeOrNot()).thenReturn(true);

        Car mockCar2 = mock(Car.class);
        when(mockCar2.getSpeed()).thenReturn(50.0);
        when(mockCar2.getPrice()).thenReturn(15000.0);
        when(mockCar2.getFuelConsumption()).thenReturn(15.0);
        when(mockCar2.isFreeOrNot()).thenReturn(true);

        Car mockCar3 = mock(Car.class);
        when(mockCar3.getSpeed()).thenReturn(20.0);
        when(mockCar3.getPrice()).thenReturn(15000.0);
        when(mockCar3.getFuelConsumption()).thenReturn(15.0);
        when(mockCar3.isFreeOrNot()).thenReturn(true);

        Car mockCar4 = mock(Car.class);
        when(mockCar4.getSpeed()).thenReturn(200.0);
        when(mockCar4.getPrice()).thenReturn(15000.0);
        when(mockCar4.getFuelConsumption()).thenReturn(15.0);
        when(mockCar4.isFreeOrNot()).thenReturn(true);

        Car mockCar5 = mock(Car.class); // Автомобіль, що не потрапляє в діапазон
        when(mockCar5.getSpeed()).thenReturn(300.0);
        when(mockCar5.getPrice()).thenReturn(20000.0);
        when(mockCar5.getFuelConsumption()).thenReturn(18.0);
        when(mockCar5.isFreeOrNot()).thenReturn(true);

        CarFleet fleet = new CarFleet();
        fleet.addCarToTheFleet(mockCar1);
        fleet.addCarToTheFleet(mockCar2);
        fleet.addCarToTheFleet(mockCar3);
        fleet.addCarToTheFleet(mockCar4);
        fleet.addCarToTheFleet(mockCar5);

        List<Car> expectedCars = Arrays.asList(mockCar1, mockCar2, mockCar4);
        List<Car> actualCars = fleet.getCarsBySpeedLimits(50, 200);

        assertEquals(3, actualCars.size());
        assertEquals(expectedCars, actualCars); // Додана перевірка відповідності очікуваного і фактичного списку
    }


}
