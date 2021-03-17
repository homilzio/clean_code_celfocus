package person;

import account.Account;
import buydetails.BuyInfo;
import buydetails.BuyInfoModel;
import lombok.Data;
import lombok.Getter;
import org.springframework.util.CollectionUtils;
import vehicles.Car;
import vehicles.Vehicle;
import vehicles.VehicleFinance;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    private int cash;
    private final VehicleFinance vehicleFinance;


    public Client(final String carColor, final String name, int age){
        this.carColor = carColor;
        this.name = name;
        this.age = age;
        this.vehicleFinance = new VehicleFinance();
        this.cash = 50;
    }

    protected  boolean hasRentedCars(){
        // TODO implement this method
        return false;
    }

    // TODO change this to proper class -> BuyOptions

    /**
     *  TODO please implement this method and change the necessary methods to leave the class as clean as possible
     * @param car - the car that this customer wants to buy.
     * @return if its possible to rent the car, note that the customer must have all legal  info corrected
     */
    protected  boolean canRentACar(Car car){
        // TODO implement this method
        return false;
    }

    // this will rent a car - unnecessary comment - overly Verbose method
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

    /**
     *
     * @param car - the car to sell
     * @return
     * @throws Exception
     */
    public boolean canSellACar(Car car,  Person p) throws Exception{

        /// todo implement throwif like
        if(car == null || !this.equals(car.getOwner())) {
            return false; // TODO throw exception
        }
        // TODO validate if the buyer has enough money to buy the car  25/09

        return false;
    }


    public BuyInfo buyACar(CarSalesman salesmanList){
        if(salesmanList == null || salesmanList.vehicleListInStock().isEmpty()){
            return null;
        }
        BuyInfo buyInfo = new BuyInfoModel();

        Optional<Vehicle> first = salesmanList.vehicleListInStock()
                .stream()
                .filter(vehicle -> "Blue".equals(vehicle.getColor())) // keep only blue vehicles
                .findFirst();

        if(first.isPresent()){
            buyInfo.setBuyInfoResults(null);
        }
        return buyInfo;
    }


    // TODO
    /**
     *
     * @param car - the car to sell
     * @return
     * @throws Exception
     */
    public boolean sellAVehicle(Car car,  Person p)throws Exception{



        return false;
    }

    // TODO --> add a new test and check the possible problems - 25/09
    @Override
    public boolean equals(Object person){
        if( person == null || !(person instanceof Person)){
            return false;
        }

        String name = ((Person) person).getName();
        return name.equals(this.name);
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
