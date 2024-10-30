package commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class InvokerTest {
    private Command getPriceOfWholeCarFleetCommand;
    private Command sortCarsByFuelConsumptionCommand;
    private Command getCarsBySpeedLimitsCommand;
    private Invoker invoker;

    @BeforeEach
    public void setUp() {
        // Створення мок-об'єктів команд
        getPriceOfWholeCarFleetCommand = mock(Command.class);
        sortCarsByFuelConsumptionCommand = mock(Command.class);
        getCarsBySpeedLimitsCommand = mock(Command.class);

        // Ініціалізація Invoker з мок-об'єктами
        invoker = new Invoker(getPriceOfWholeCarFleetCommand, sortCarsByFuelConsumptionCommand, getCarsBySpeedLimitsCommand);
    }

    @Test
    public void testExecuteGetPriceOfWholeCarFleet() {
        double[] array = {};
        // Виконання команди
        invoker.executeGetPriceOfWholeCarFleet(array);

        // Перевірка, що метод execute() був викликаний на відповідній команді
        verify(getPriceOfWholeCarFleetCommand).execute(array);
    }

    @Test
    public void testExecuteSortCarsByFuelConsumption() {
        double[] array = {};
        // Виконання команди
        invoker.executeSortCarsByFuelConsumption(array);

        // Перевірка, що метод execute() був викликаний на відповідній команді

        verify(sortCarsByFuelConsumptionCommand).execute(array);
    }

    @Test
    public void testExecuteGetCarsBySpeedLimits() {
        // Виконання команди
        double[] array = {};
        invoker.executeGetCarsBySpeedLimits(array);

        // Перевірка, що метод execute() був викликаний на відповідній команді
        verify(getCarsBySpeedLimitsCommand).execute(array);
    }
}
