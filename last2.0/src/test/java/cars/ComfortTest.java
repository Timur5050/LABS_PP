package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComfortTest {

    private Comfort comfortCar;

    @BeforeEach
    public void setUp() {
        comfortCar = new Comfort("Audi A6", 160.0, 350.0, 9.5, true, "Leather seats, Sunroof");
    }

    @Test
    public void testGetAdditionalFeatures() {
        assertEquals("Leather seats, Sunroof", comfortCar.getAdditionalFeatures(), "Expected additional features to match");
    }

    @Test
    public void testToString() {
        String expectedString = "type: Standard, model: Audi A6, speed: 160.0, price: 350.0, fuel consumption: 9.5, free or not : true, additional features: Leather seats, Sunroof";
        assertEquals(expectedString, comfortCar.toString(), "Expected string representation to match");
    }

    // Додатковий тест на перевірку інших значень
    @Test
    public void testComfortCarWithDifferentFeatures() {
        Comfort anotherCar = new Comfort("Toyota Camry", 140.0, 270.0, 8.0, false, "Navigation system, Heated seats");
        assertEquals("Navigation system, Heated seats", anotherCar.getAdditionalFeatures(), "Expected additional features to match");
    }
}
