package person;

import account.Account;
import buydetails.BuyInfo;
import lombok.Data;
import lombok.Getter;
import org.springframework.util.CollectionUtils;
import vehicles.Car;
import vehicles.Vehicle;
import vehicles.VehicleFinance;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Client Class, this has only client related info and fields
 */
@Data
@Getter
public class Client implements Person{

    public static final int MINIM_AGE_TO_DRIVE = 19;
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
        //validate if collection is empty before proceed
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

    // this will rent a car -ununcessary comment - overly Verbose method
    protected boolean rentACarForTheCustomerButOnlyIfHeCanRentAndHasEnoughtMoney(Car car, boolean isHisBestColor){
        // TODO implement this method
        if(!canRentACar(car)){
            return false;
        } else if(canRentACar(car) && isHisBestColor ) {
            car.rent(this);
        }
        return false;
    }


    /**
     * just a complex example
     * @param day
     * @return
     */
    public boolean isGreaterThan(int day) {
        return (day > this.getToday()) && this.getAge() > MINIM_AGE_TO_DRIVE && this.getName().equals(("maria"));
    }


    public boolean isGreaterThan(Integer day) {
        //int today = this.getToday();
        if(day != null && day > 0){
            return (day > this.getToday()) && this.getAge() > MINIM_AGE_TO_DRIVE && this.getName().equals(("maria"));
        }
        return false;
    }

    // TODO - implement the greater function
    public boolean isGreaterThan(Optional<Integer> day) {

        Optional<String> value = Optional.of("Value");

        if(value.isPresent()){
            String s = value.get();
        }

        return false;
    }

    // TODO
    private int getToday() {
        return 7;
    }


    // this whill return the customer age- ununcessary comment
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
