package cars;

public class Business extends Car {
    private final boolean premiumServices;
    private final boolean canBeOrderedInAdvance;

    public Business(String _modeName, double _speed, double _price, double _fuelConsumption, boolean _freeOrNot, boolean _premiumServices, boolean _canBeOrderedInAdvance) {
        super("Standard", _modeName, _speed, _price, _fuelConsumption, _freeOrNot);
        premiumServices = _premiumServices;
        canBeOrderedInAdvance = _canBeOrderedInAdvance;
    }

    boolean getPremiumServices() {
        return premiumServices;
    }

    boolean getCanBeOrderedInAdvance() {
        return canBeOrderedInAdvance;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "does it have premium service: " + premiumServices + ", can it be ordered in advance: " + canBeOrderedInAdvance;
    }
}