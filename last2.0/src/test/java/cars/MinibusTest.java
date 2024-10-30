package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinibusTest {

    private Minibus minibus;

    @BeforeEach
    public void setUp() {
        minibus = new Minibus("Mercedes Sprinter", 120.0, 400.0, 10.0, true, 10);
    }

    @Test
    public void testGetAdditionalPlaces() {
        assertEquals(10, minibus.getAdditionalPlaces(), "Expected additional places to match");
    }

    @Test
    public void testToString() {
        String expectedString = "type: Standard, model: Mercedes Sprinter, speed: 120.0, price: 400.0, fuel consumption: 10.0, free or not : true, additional places: 10";
        assertEquals(expectedString, minibus.toString(), "Expected string representation to match");
    }

    // Додатковий тест на перевірку інших значень
    @Test
    public void testMinibusWithDifferentPlaces() {
        Minibus anotherMinibus = new Minibus("Volkswagen Crafter", 130.0, 420.0, 9.0, false, 12);
        assertEquals(12, anotherMinibus.getAdditionalPlaces(), "Expected additional places to match");
    }
}
