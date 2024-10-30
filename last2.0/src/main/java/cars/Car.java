package cars;

public class Car {
    private String type;
    private String modeName;
    private double speed;
    private double price;
    private double fuelConsumption;
    private boolean freeOrNot;

    public Car(String _type, String _modeName, double _speed, double _price, double _fuelConsumption, boolean _freeOrNot) {
        this.type = _type;
        this.modeName = _modeName;
        this.speed = _speed;
        this.price = _price;
        this.fuelConsumption = _fuelConsumption;
        this.freeOrNot = _freeOrNot;
    }

    // Геттери
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

    public boolean isFreeOrNot() {
        return freeOrNot;
    }

    @Override
    public String toString() {
        return "type: " + type + ", model: " + modeName + ", speed: " + speed + ", price: " + price + ", fuel consumption: " + fuelConsumption + ", free or not : " + freeOrNot;
    }
}
