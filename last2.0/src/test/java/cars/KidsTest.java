package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KidsTest {

    private Kids kidsCar;

    @BeforeEach
    public void setUp() {
        kidsCar = new Kids("Volkswagen Touran", 140.0, 250.0, 7.0, true, 2);
    }

    @Test
    public void testGetAdditionalPlacesForKids() {
        assertEquals(2, kidsCar.getAdditionalPlacesForKids(), "Expected additional places for kids to match");
    }

    @Test
    public void testToString() {
        String expectedString = "type: Standard, model: Volkswagen Touran, speed: 140.0, price: 250.0, fuel consumption: 7.0, free or not : true, additional places for kids: 2";
        assertEquals(expectedString, kidsCar.toString(), "Expected string representation to match");
    }

    // Додатковий тест на перевірку інших значень
    @Test
    public void testKidsCarWithDifferentPlaces() {
        Kids anotherCar = new Kids("Ford Galaxy", 150.0, 300.0, 8.0, false, 3);
        assertEquals(3, anotherCar.getAdditionalPlacesForKids(), "Expected additional places for kids to match");
    }
}
