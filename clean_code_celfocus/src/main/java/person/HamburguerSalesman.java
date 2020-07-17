package person;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import vehicles.Vehicle;

import java.util.List;

/**
 * This is an implementation of the Salesman abstraction
 */
public class HamburguerSalesman  extends Salesman{


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
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean canBuyACar() {
        throw new NotImplementedException();
    }
}
