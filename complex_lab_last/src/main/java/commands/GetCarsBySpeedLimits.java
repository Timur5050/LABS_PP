package commands;

import Fleets.CarFleet;

public class GetCarsBySpeedLimits implements Command {
    private final CarFleet fleet;
    private final double start;
    private final double finish;

    public GetCarsBySpeedLimits(CarFleet _fleet, double _start, double _finish) {
        fleet = _fleet;
        start = _start;
        finish = _finish;
    }

    @Override
    public void execute() {
        fleet.getCarsBySpeedLimits(start, finish);
    }
}
