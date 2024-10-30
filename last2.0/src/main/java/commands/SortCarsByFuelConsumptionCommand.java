package commands;

import Fleets.CarFleet;

public class SortCarsByFuelConsumptionCommand implements Command {
    private final CarFleet fleet;

    public SortCarsByFuelConsumptionCommand(CarFleet _fleet) {
        fleet = _fleet;
    }

    @Override
    public void execute(double[] args) {
        fleet.sortCarsByFuelConsumption();
    }
}
