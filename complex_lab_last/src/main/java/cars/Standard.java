package cars;

public class Standard extends Car {
    private final boolean canBeOrderedInAdvance;

    public Standard(String _modeName, double _speed, double _price, double _fuelConsumption, boolean _freeOrNot, boolean _canBeOrderedInAdvance) {
        super("Standard", _modeName, _speed, _price, _fuelConsumption, _freeOrNot);
        canBeOrderedInAdvance = _canBeOrderedInAdvance;
    }

    boolean getCanBeOrderedInAdvance() {
        return canBeOrderedInAdvance;
    }

    @Override
    public String toString() {
        return super.toString() + ", can it be ordered in advance: " + canBeOrderedInAdvance;
    }
}
