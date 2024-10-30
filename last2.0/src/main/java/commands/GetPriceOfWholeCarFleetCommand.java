package commands;

import Fleets.CarFleet;

public class GetPriceOfWholeCarFleetCommand implements Command {
    private final CarFleet fleet;

    public GetPriceOfWholeCarFleetCommand(CarFleet _fleet) {
        fleet = _fleet;
    }

    @Override
    public void execute(double[] args) {
        System.out.println(fleet.getPriceOFWholeCarFleet());
    }
}
