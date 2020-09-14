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
     /*
        TODO implement the method sell car, that try to sell a car from a pre-built list and to a list of clients.
     */

    /*
        TODO implement the method repair cars that receiving a list of cars, will only repair the cars that are still under warranty.
     */

}
