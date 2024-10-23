package cars;

public class Wagon extends Car {
    private final double additionalAmountOfPlace;

    public Wagon(String _modeName, double _speed, double _price, double _fuelConsumption, boolean _freeOrNot, double _additionalAmountOfPlace) {
        super("Standard", _modeName, _speed, _price, _fuelConsumption, _freeOrNot);
        additionalAmountOfPlace = _additionalAmountOfPlace;
    }

    double getAdditionalAmountOfPlace() {
        return additionalAmountOfPlace;
    }

    @Override
    public String toString() {
        return super.toString() + ", additional amount of place: " + additionalAmountOfPlace;
    }
}