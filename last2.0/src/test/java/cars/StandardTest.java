package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardTest {

    private Standard standardCar;

    @BeforeEach
    public void setUp() {
        standardCar = new Standard("Ford Focus", 150.0, 220.0, 6.5, true, true);
    }

    @Test
    public void testGetCanBeOrderedInAdvance() {
        assertEquals(true, standardCar.getCanBeOrderedInAdvance(), "Expected canBeOrderedInAdvance to be true");
    }

    @Test
    public void testToString() {
        String expectedString = "type: Standard, model: Ford Focus, speed: 150.0, price: 220.0, fuel consumption: 6.5, free or not : true, can it be ordered in advance: true";
        assertEquals(expectedString, standardCar.toString(), "Expected string representation to match");
    }

    // Додатковий тест на перевірку іншого значення
    @Test
    public void testStandardCarWithDifferentOrderOption() {
        Standard anotherCar = new Standard("Opel Astra", 160.0, 240.0, 7.0, false, false);
        assertEquals(false, anotherCar.getCanBeOrderedInAdvance(), "Expected canBeOrderedInAdvance to be false");
    }
}
