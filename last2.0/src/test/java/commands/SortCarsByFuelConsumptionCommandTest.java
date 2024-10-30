package commands;

import Fleets.CarFleet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SortCarsByFuelConsumptionCommandTest {
    private CarFleet fleet;
    private SortCarsByFuelConsumptionCommand command;

    @BeforeEach
    public void setUp() {
        // Створення мок-об'єкта CarFleet
        fleet = mock(CarFleet.class);
        // Ініціалізація команди з мок-об'єктом
        command = new SortCarsByFuelConsumptionCommand(fleet);
    }

    @Test
    public void testExecute() {
        double[] array = {};
        // Виконання команди
        command.execute(array);

        // Перевірка, що метод sortCarsByFuelConsumption був викликаний
        verify(fleet).sortCarsByFuelConsumption();
    }
}
