package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusinessTest {

    private Business businessCar;

    @BeforeEach
    public void setUp() {
        businessCar = new Business("BMW", 150.0, 300.0, 10.0, true, true, false);
    }

    @Test
    public void testGetPremiumServices() {
        assertEquals(true, businessCar.getPremiumServices(), "Expected premium services to be true");
    }

    @Test
    public void testGetCanBeOrderedInAdvance() {
        assertEquals(false, businessCar.getCanBeOrderedInAdvance(), "Expected can be ordered in advance to be false");
    }

    @Test
    public void testToString() {
        String expectedString = "type: Standard, model: BMW, speed: 150.0, price: 300.0, fuel consumption: 10.0, free or not : true, does it have premium service: true, can it be ordered in advance: false";
        assertEquals(expectedString, businessCar.toString(), "Expected string representation to match");
    }

    // Додатковий тест на перевірку інших значень
    @Test
    public void testBusinessCarWithDifferentValues() {
        Business anotherCar = new Business("Mercedes", 200.0, 500.0, 12.0, false, false, true);
        assertEquals(false, anotherCar.getPremiumServices(), "Expected premium services to be false");
        assertEquals(true, anotherCar.getCanBeOrderedInAdvance(), "Expected can be ordered in advance to be true");
    }
}
