package cars;

public class Car {
    private final String type;
    private final String modeName;
    private final double speed;
    private final double price;
    private final double fuelConsumption;
    private final boolean freeOrNot;

    public Car(String _type, String _modeName, double _speed, double _price, double _fuelConsumption, boolean _freeOrNot) {
        type = _type;
        modeName = _modeName;
        speed = _speed;
        price = _price;
        fuelConsumption = _fuelConsumption;
        freeOrNot = _freeOrNot;
    }

    public String getType() {
        return type;
    }

    public String getModeName() {
        return modeName;
    }

    public double getSpeed() {
        return speed;
    }

    public double getPrice() {
        return price;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public boolean getFreeOrNot() {
        return freeOrNot;
    }

    @Override
    public String toString()
    {
        return "type: " + type + ", model: " + modeName + ", speed: " + speed + ", price: " + price + ", fuel consumption: " + fuelConsumption + ", free or not : " + freeOrNot;
    }

}
