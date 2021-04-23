package vehicles;

import java.util.List;

public class Seat extends Car {

    public Seat(String color) {
        super(color);
    }

    @Override
    public boolean getStatus() {
        return false;
    }

    @Override
    public boolean hasInsurance() {
        return false;
    }

    @Override
    public boolean isValidVehicleList(List<Car> cars) {
        return false;
    }
}
