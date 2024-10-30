package commands;

import Fleets.CarFleet;

public class GetCarsBySpeedLimits implements Command {
    private final CarFleet fleet;

    public GetCarsBySpeedLimits(CarFleet _fleet) {
        fleet = _fleet;
    }

    @Override
    public void execute(double[] args) {
        fleet.getCarsBySpeedLimits(args[0], args[1]);
    }
}
