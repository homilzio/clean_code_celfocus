package vehicles;

import person.Client;

public interface Vehicle {
    boolean getStatus();
    boolean hasInsurance();
    /**
     *
     * @param client client to validate the buy method
     * @return if it's possible or not to buy
     */
    boolean canBuy(Client client);
    void cleanVehicle();

}
