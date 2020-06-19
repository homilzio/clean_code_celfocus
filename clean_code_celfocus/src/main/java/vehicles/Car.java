package vehicles;

import account.Account;
import person.Client;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class  Car implements  Vehicle{

    private String id;
    private Tire tire;
    private Date nextMaintenanceDay;
    private Date lastMaintenanceDay;
    protected boolean isClean;
    public BigDecimal montlyPayment;
    public BigDecimal finalOneOffPriceNew;
    public BigDecimal actualPrice;
    public BigDecimal finalPrice;

    public Car(){
        // TODO validate what can be done better
        this.id = "Car-" + Math.random();
        this.tire = new Tire();
    }

    public boolean rent(Client client) {
        //TODO implement this method
        return false;
    }


    public boolean rent(String clientName, int clientAge, List<Account> allAccounts) {
        //TODO implement this method
        return false;
    }

    public boolean swapCar(String clientName, int clientAge,  List<Vehicle> allVehicles) {
        //TODO implement this method
        return false;
    }


    @Override
    public void cleanVehicle() {
        // TODO should this be a void method?
        System.out.println("Cleaning the vehicle");
    }

}
