package commands;

public class Invoker {
    private final Command getPriceOfWholeCarFleetCommand;
    private final Command sortCarsByFuelConsumptionCommand;
    private final Command getCarsBySpeedLimits;

    public Invoker(Command _GetPriceOfWholeCarFleetCommand,
                   Command _SortCarsByFuelConsumptionCommand,
                   Command _GetCarsBySpeedLimits
    ) {
        getPriceOfWholeCarFleetCommand = _GetPriceOfWholeCarFleetCommand;
        sortCarsByFuelConsumptionCommand = _SortCarsByFuelConsumptionCommand;
        getCarsBySpeedLimits = _GetCarsBySpeedLimits;
    }

    public void executeGetPriceOfWholeCarFleet() {
        getPriceOfWholeCarFleetCommand.execute();
    }

    public void executeSortCarsByFuelConsumption() {
        sortCarsByFuelConsumptionCommand.execute();
    }

    public void executeGetCarsBySpeedLimits() {
        getCarsBySpeedLimits.execute();
    }
}
