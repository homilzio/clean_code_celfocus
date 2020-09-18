package person;

import vehicles.Vehicle;

import java.util.List;

public class CarSalesman extends Salesman {

    @Override
    public List<Vehicle> vehicleListInStock() {
        return null;
    }

    @Override
    public boolean rentAVehicle(Vehicle v, Client client) {
        return false;
    }

    @Override
    public boolean sellAVehicle(Vehicle v, Client client) {
        return false;
    }

    @Override
    public boolean addAVehicle(Vehicle v, Client client) {
        return false;
    }

    @Override
    public Salesman createNewSalesman() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean canBuyACar(Vehicle car) {
        return false;
    }
}


