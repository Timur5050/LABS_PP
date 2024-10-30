package Fleets;

import cars.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFleet {
    private final List<Car> carFleet = new ArrayList<>();

    public List<Car> getCarFleet()
    {
        return carFleet;
    }

    public double getPriceOFWholeCarFleet() {
        double finalSum = 0.0;
        for (Car car : carFleet) {
            finalSum += car.getPrice();
        }
        return finalSum;
    }

    public void sortCarsByFuelConsumption() {
        for (int i = 0; i < carFleet.size(); i++) {
            for (int j = 0; j < carFleet.size() - i - 1; j++) {
                if (carFleet.get(j).getFuelConsumption() > carFleet.get(j + 1).getFuelConsumption()) {
                    Car tempCar = carFleet.get(j);
                    carFleet.set(j, carFleet.get(j + 1));
                    carFleet.set(j + 1, tempCar);
                }
            }
        }
    }

    public List<Car> getCarsBySpeedLimits(double start, double finish) {
        List<Car> listOfCars = new ArrayList<Car>();
        for (Car car : carFleet) {
            if (start <= car.getSpeed() && car.getSpeed() <= finish) {
                System.out.println(car);
                listOfCars.add(car);
            }
        }
        return listOfCars;
    }

    public void     addCarToTheFleet(Car car)
    {
        carFleet.add(car);
    }
}
