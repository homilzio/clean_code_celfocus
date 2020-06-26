package person;

import account.Account;
import vehicles.Car;
import vehicles.Vehicle;

import java.util.List;

public class Client implements Person{

    /*
        TODO implement the method buy favourite car, that accessing a list salesmen find is car and try to buy it
     */
    protected List<Vehicle> allVehicles;
    protected List<Account> allAccounts;

    protected  boolean hasRentedCars(){
        // TODO implement this method
        return false;
    }

    /**
     *  TODO please implement this method and change the necessary methods to leave the class as clean as possible
     * @param car - the car that this customer wants to buy.
     * @return if its possible to rent the car, note that the customer must have all legal  info corrected
     */
    protected  boolean canRentACar(Car car){
        // TODO implement this method
        return false;
    }

    protected boolean rentACar(Car car, boolean isHisBestColor){
        // TODO implement this method
        if(!canRentACar(car)){
            return false;
        } else if(canRentACar(car) && isHisBestColor ) {
            car.rent(this);
        }
        return false;
    }

    @Override
    public int getAge() {
        // TODO
        return 0;
    }

    @Override
    public String getName() {
        // TODO
        return null;
    }

    @Override
    public boolean canBuyACar() {
        // TODO
        return false;
    }
}
