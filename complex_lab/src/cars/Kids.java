package cars;

public class Kids extends Car {
    private final int additionalPlacesForKids;

    public Kids(String _modeName, double _speed, double _price, double _fuelConsumption, boolean _freeOrNot, int _additionalPlacesForKids) {
        super("Standard", _modeName, _speed, _price, _fuelConsumption, _freeOrNot);
        additionalPlacesForKids = _additionalPlacesForKids;
    }

    float getAdditionalPlacesForKids() {
        return additionalPlacesForKids;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "additional places for kids: " + additionalPlacesForKids;
    }
}