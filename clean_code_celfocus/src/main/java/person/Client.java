package person;

import account.Account;
import buydetails.BuyInfo;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import vehicles.Car;
import vehicles.Vehicle;
import vehicles.VehicleFinance;

import java.util.List;

/**
 * Client Class, this has only client related info and fields
 */
@Data
@Getter
public class Client implements Person{

    /*
        TODO implement the method buy favourite car, that accessing a list salesmen find is car and try to buy it
     */
    protected List<Vehicle> allVehicles;
    protected List<Account> allAccounts;
    protected List<String> keys;

    private final String carColor;
    private final String name;
    private int age;
    private final VehicleFinance vehicleFinance;


    public Client(final String carColor, final String name, int age){
        this.carColor = carColor;
        this.name = name;
        this.age = age;
        this.vehicleFinance = new VehicleFinance();
    }

    protected  boolean hasRentedCars(){
        // TODO implement this method
        return false;
    }

    // TODO change this to proper class -> BuyOptions


    private BuyInfo buyFavoriteCarDirty(List<Car> carList ) throws Exception {
        // dirty version
        BuyInfo buyInfo = null;
        for (Car car : carList) {
            if(car.canBuy(this)){
                buyInfo = this.vehicleFinance.buyACar(this, car);
            }
        }
        return buyInfo;
    }

    private BuyInfo buyFavoriteCarClean(List<Car> carList ) throws Exception {
        // clean version
        BuyInfo buyInfo = null;
        // TODO implement it in a clean solution
        return buyInfo;
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
        return this.age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean canBuyACar(Car car) {
        return car.canBuy(this);
    }

    public String getColor() {
        return this.carColor;
    }
}
