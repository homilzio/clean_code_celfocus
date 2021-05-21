package person;

import buydetails.Hamburguer;
import error.RentCarAppError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import vehicles.Vehicle;

import java.util.List;

/**
 * This is an implementation of the Salesman abstraction
 */
public class HamburguerSalesman  extends Salesman{

    private static final Logger LOGGER = LoggerFactory.getLogger(HamburguerSalesman.class);

    String name;

    public HamburguerSalesman(String name){
        this.name = name;
    }
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

    // TODO
    public Salesman createNewSalesman(String name) {
       if(name == null || !name.contains("Rui") ){
           try {
               throw RentCarAppError.INVALID_PERSON_NAME;
           } catch (Exception e) {
               e.printStackTrace(); // should not be done - abafator!!!
           }
       }
       return  null;
    }


    public Salesman createNewSalesmanCorrect(String name) throws Exception {
        if(name == null || name.isEmpty() || name.contains("Rui") ) {
            LOGGER.error("Invalid name: ", name);
            throw RentCarAppError.INVALID_PERSON_NAME;
        }
        return new HamburguerSalesman(name) ;
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
    public boolean canBuyACar(Vehicle car) throws InterruptedException {
        throw new NotImplementedException();
    }

    public void sellHamburguer(Client client, String hamburguerId){
        // TODO implement method
        throw new NotImplementedException();
    }

    public void sellHamburguer(Client client, Hamburguer hamburguer){

        if(client == null){ //fail fast
            LOGGER.info("sellHamburguer::client is null");
            return;
        }

        if(hamburguer == null){
            LOGGER.info("sellHamburguer::hamburguer is null");
            return;
        }
        if(client.getCash() >= hamburguer.getPrice()){
            hamburguer.buy(client);
        }
    }
}
