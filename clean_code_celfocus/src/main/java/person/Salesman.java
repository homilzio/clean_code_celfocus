package person;

import vehicles.Vehicle;
import java.util.List;

public abstract class Salesman implements  Person {
    public abstract List<Vehicle> vehicleListInStock();
    public abstract boolean rentAVehicle(Vehicle v, Client client);
    public abstract boolean sellAVehicle(Vehicle v, Client client);
    public abstract boolean addAVehicle(Vehicle v, Client client);
    public abstract Salesman createNewSalesman();


    // TODO create Salesman class with relevant fields


}
