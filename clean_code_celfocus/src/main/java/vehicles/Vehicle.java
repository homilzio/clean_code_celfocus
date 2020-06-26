package vehicles;

import person.Client;

public interface Vehicle {
    boolean getStatus();
    boolean hasInsurance();
    boolean canBuy(Client client);
    void cleanVehicle();

}
