package vehicles;

import buydetails.BuyInfo;
import buydetails.BuyInfoModel;
import person.Client;
import person.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

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
    public boolean canBuy(Client client) {
        return false;
    }

    @Override
    public void cleanVehicle() {

    }

    public BuyInfo buyACar(Person client, Vehicle car) {

        // TODO implement with proper validations
        return new BuyInfoModel();
    }
}
