package commands;

public class Invoker {
    private Command getPriceOfWholeCarFleetCommand;
    private Command sortCarsByFuelConsumptionCommand;
    private Command getCarsBySpeedLimits;

    public Invoker(Command _GetPriceOfWholeCarFleetCommand,
                   Command _SortCarsByFuelConsumptionCommand,
                   Command _GetCarsBySpeedLimits
    ) {
        getPriceOfWholeCarFleetCommand = _GetPriceOfWholeCarFleetCommand;
        sortCarsByFuelConsumptionCommand = _SortCarsByFuelConsumptionCommand;
        getCarsBySpeedLimits = _GetCarsBySpeedLimits;
    }

    public void executeGetPriceOfWholeCarFleet(double[] args) {
        getPriceOfWholeCarFleetCommand.execute(args);
    }

    public void executeSortCarsByFuelConsumption(double[] args) {
        sortCarsByFuelConsumptionCommand.execute(args);
    }

    public void executeGetCarsBySpeedLimits(double[] args) {
        getCarsBySpeedLimits.execute(args);
    }

}
