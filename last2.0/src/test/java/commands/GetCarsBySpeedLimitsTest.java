package commands;

import Fleets.CarFleet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class GetCarsBySpeedLimitsTest {
    private CarFleet fleet;
    private GetCarsBySpeedLimits command;

    @BeforeEach
    public void setUp() {
        // Створення мок-об'єкта CarFleet
        fleet = mock(CarFleet.class);
        // Ініціалізація команди з мок-об'єктом і значеннями швидкості
        command = new GetCarsBySpeedLimits(fleet);
    }

    @Test
    public void testExecute() {
        // Виконання команди
        double[] array = {50.0, 100.0};
        command.execute(array);

        // Перевірка, що метод getCarsBySpeedLimits був викликаний з правильними параметрами
        verify(fleet).getCarsBySpeedLimits(50.0, 100.0);
    }
}
