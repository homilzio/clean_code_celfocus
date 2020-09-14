package person;

import account.Account;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.util.CollectionUtils;
import vehicles.Car;
import vehicles.Vehicle;
import java.util.List;
import java.util.Optional;

/**
 * Client Class, this has only client related info and fields
 */
@Data
@Getter
@Builder
public class Client implements Person{

    /*
        TODO implement the method buy favourite car, that accessing a list salesmen find is car and try to buy it
     */
    protected List<Vehicle> allVehicles;
    protected List<Account> allAccounts;
    protected List<String> keys;

    protected  boolean hasRentedCars(){
        // TODO implement this method
        return false;
    }

    // TODO change this to proper class -> BuyOptions


    private BuyInfo buyFavoriteCarDirty(List<Vehicle> carList ) throws Exception {
        // dirty version
        BuyInfo buyInfo = null;
        for (Vehicle car : carList) { // possible NPE
            if(car.canBuy(this)){
                buyInfo = this.vehicleFinance.buyACar(this, car);
            }
        }
        return buyInfo;
    }

    private BuyInfo buyFavoriteCarClean(List<Car> carList ) throws Exception {
        // clean version
        BuyInfo buyInfo = null;

        if(!CollectionUtils.isEmpty(carList)){
            Optional<Car> anyCar = carList.stream()
                    .filter(Objects::nonNull) // car -> car !=null
                    .filter(car -> carColor.equals(car.getColor()))
                    .findAny();

            if(anyCar.isPresent()){
                buyInfo = this.vehicleFinance.buyACar(this, anyCar.get());
            }
        }
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
    public boolean canBuyACar(Vehicle car) throws InterruptedException {
        Thread.sleep(500);
        return car.canBuy(this);
    }

    public String getColor() {
        return this.carColor;
    }
}
