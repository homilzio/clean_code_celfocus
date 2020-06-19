package person;

import account.Account;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import vehicles.Car;
import vehicles.Vehicle;

import java.util.List;
@Data
@Getter
@Builder
public class Client implements Person{

    protected List<Vehicle> allVehicles;
    protected List<Account> allAccounts;
    protected List<String> keys;

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
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean canBuyACar() {
        // TODO
        return false;
    }
}
