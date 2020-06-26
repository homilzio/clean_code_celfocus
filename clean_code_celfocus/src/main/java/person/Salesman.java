package person;

import vehicles.Vehicle;
import java.util.List;

public abstract class Salesman implements  Person {
    public abstract List<Vehicle> vehicleListInStock();
    public abstract boolean rentAVehicle(Vehicle v, Client client);
    public abstract boolean sellAVehicle(Vehicle v, Client client);
    public abstract boolean addAVehicle(Vehicle v, Client client);
    // TODO create Salesman class with relevant fields
     /*
        TODO implement the method sell car, that try to sell a car from a pre-built list and to a list of clients.
     */

    /*
        TODO implement the method repair a car, that will only repair a car that it's still under warranty.
     */

}
