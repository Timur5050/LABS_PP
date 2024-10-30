package cars;

public class Minibus extends Car {
    private final int additionalPlaces;

    public Minibus(String _modeName, double _speed, double _price, double _fuelConsumption, boolean _freeOrNot, int _additionalPlaces) {
        super("Standard", _modeName, _speed, _price, _fuelConsumption, _freeOrNot);
        additionalPlaces = _additionalPlaces;
    }

    int getAdditionalPlaces() {
        return additionalPlaces;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "additional places: " + additionalPlaces;
    }

}