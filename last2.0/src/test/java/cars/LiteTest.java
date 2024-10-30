package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LiteTest {

    private Lite liteCar;

    @BeforeEach
    public void setUp() {
        liteCar = new Lite("Toyota Yaris", 120.0, 200.0, 5.5, true);
    }

    @Test
    public void testToString() {
        String expectedString = "type: Standard, model: Toyota Yaris, speed: 120.0, price: 200.0, fuel consumption: 5.5, free or not : true";
        assertEquals(expectedString, liteCar.toString(), "Expected string representation to match");
    }

    // Додатковий тест на перевірку різних значень
    @Test
    public void testLiteCarWithDifferentValues() {
        Lite anotherCar = new Lite("Honda Fit", 130.0, 220.0, 6.0, false);
        String expectedString = "type: Standard, model: Honda Fit, speed: 130.0, price: 220.0, fuel consumption: 6.0, free or not : false";
        assertEquals(expectedString, anotherCar.toString(), "Expected string representation to match");
    }
}
