package vehicles;

import buydetails.BuyInfo;
import buydetails.BuyInfoModel;
import person.Client;

/**
 * TODO implement the body of the class
 * Select financing
 * Calculate monthly payment
 */
public class VehicleFinance implements Vehicle{

    // TODO Implement methods

    @Override
    public boolean getStatus() {
        return false;
    }

    @Override
    public boolean hasInsurance() {
        return false;
    }

    @Override
    public void cleanVehicle() {

    }

    public BuyInfo buyACar(Client client, Car car) {

        // TODO implement with proper validations
        return new BuyInfoModel();
    }
}
