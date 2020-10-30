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

    // each client can buy any car

    public BuyInfo sellCarsToCustomers(List<Vehicle> vehicleList, List<Person> clients){

        BuyInfo buyInfo = new BuyInfoModel();
        final List<BuyInfo> buyInfoList = new ArrayList<>();

        // linkedList melhor para add e remoções
        // arraylist melhor para leitura -

        if(!isEmpty(vehicleList) && !isEmpty(clients)){
            vehicleList.forEach( vehicle -> clients
                            .forEach( client -> buyInfoList.add(buyACar(client, vehicle) )));
        }

        buyInfo.setBuyInfoResults(buyInfoList);

        return buyInfo;
    }

    public BuyInfo buyACar(Person client, Vehicle car) {

        // TODO implement with proper validations
        return new BuyInfoModel(true);
    }
}
