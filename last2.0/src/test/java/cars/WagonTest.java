package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WagonTest {

    private Wagon wagon;

    @BeforeEach
    public void setUp() {
        wagon = new Wagon("Subaru Outback", 160.0, 300.0, 8.5, true, 15.5);
    }

    @Test
    public void testGetAdditionalAmountOfPlace() {
        assertEquals(15.5, wagon.getAdditionalAmountOfPlace(), "Expected additional amount of place to match");
    }

    @Test
    public void testToString() {
        String expectedString = "type: Standard, model: Subaru Outback, speed: 160.0, price: 300.0, fuel consumption: 8.5, free or not : true, additional amount of place: 15.5";
        assertEquals(expectedString, wagon.toString(), "Expected string representation to match");
    }

    // Додатковий тест на перевірку іншого значення
    @Test
    public void testWagonWithDifferentAmountOfPlace() {
        Wagon anotherWagon = new Wagon("Volvo V60", 170.0, 320.0, 9.0, false, 20.0);
        assertEquals(20.0, anotherWagon.getAdditionalAmountOfPlace(), "Expected additional amount of place to match");
    }
}
