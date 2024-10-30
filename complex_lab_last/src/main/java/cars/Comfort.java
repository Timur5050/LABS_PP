package cars;

public class Comfort extends Car {
    private final String additionalFeatures;

    public Comfort(String _modeName, double _speed, double _price, double _fuelConsumption, boolean _freeOrNot, String _additionalFeatures) {
        super("Standard", _modeName, _speed, _price, _fuelConsumption, _freeOrNot);
        additionalFeatures = _additionalFeatures;
    }

    String getAdditionalFeatures() {
        return additionalFeatures;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "additional features: " + additionalFeatures;
    }
}
