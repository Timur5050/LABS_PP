package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("Sedan", "Toyota Camry", 180.0, 25000.0, 7.5, true);
    }

    @Test
    public void testGetType() {
        assertEquals("Sedan", car.getType(), "Expected type to match");
    }

    @Test
    public void testGetModeName() {
        assertEquals("Toyota Camry", car.getModeName(), "Expected mode name to match");
    }

    @Test
    public void testGetSpeed() {
        assertEquals(180.0, car.getSpeed(), "Expected speed to match");
    }

    @Test
    public void testGetPrice() {
        assertEquals(25000.0, car.getPrice(), "Expected price to match");
    }

    @Test
    public void testGetFuelConsumption() {
        assertEquals(7.5, car.getFuelConsumption(), "Expected fuel consumption to match");
    }

    @Test
    public void testIsFreeOrNot() {
        assertEquals(true, car.isFreeOrNot(), "Expected freeOrNot to be true");
    }

    @Test
    public void testToString() {
        String expectedString = "type: Sedan, model: Toyota Camry, speed: 180.0, price: 25000.0, fuel consumption: 7.5, free or not : true";
        assertEquals(expectedString, car.toString(), "Expected string representation to match");
    }
}
