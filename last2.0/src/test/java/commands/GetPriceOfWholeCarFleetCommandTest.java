package commands;

import Fleets.CarFleet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GetPriceOfWholeCarFleetCommandTest {
    private CarFleet fleet;
    private GetPriceOfWholeCarFleetCommand command;

    @BeforeEach
    public void setUp() {
        // Створення мок-об'єкта CarFleet
        fleet = mock(CarFleet.class);
        // Ініціалізація команди з мок-об'єктом
        command = new GetPriceOfWholeCarFleetCommand(fleet);
    }

    @Test
    public void testExecute() {
        // Налаштування поведінки мок-об'єкта
        when(fleet.getPriceOFWholeCarFleet()).thenReturn(10000.0);

        // Виконання команди
        double[] array = {};
        command.execute(array);

        // Перевірка, що метод getPriceOFWholeCarFleet був викликаний
        verify(fleet).getPriceOFWholeCarFleet();
    }
}
