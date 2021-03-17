package vehicles;

import account.Account;
import buydetails.BuyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.Client;
import person.Person;
import util.Color;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class  Car implements  Vehicle{

    public static final String BLACK = "Black";
    public static final int ISMAJOR = 18;
    public static final String WHITE_COLOR = "WHITE";
    public static final Logger LOGGER = LoggerFactory.getLogger(Car.class);

    private Person owner;
    private final String WHITE;
    private String id;
    private Tire tire;
    private Date nextMaintenanceDay;
    private Date lastMaintenanceDay;
    private boolean isClean;

    private BigDecimal montlyPayment;
    private BigDecimal finalOneOffPriceNew;
    private BigDecimal actualPrice;
    private BigDecimal finalPrice;
    private VehicleFinance vehicleFinance;

    private String color;

    public Car(String color){
        // TODO validate what can be done better
        this.id = "Car-" + Math.random();
        this.tire = new Tire();
        this.WHITE = WHITE_COLOR;
        this.color = color;
        this.vehicleFinance = new VehicleFinance();
        this.owner = null;
    }

    public Car(String color, int tire ){
        // TODO validate what can be done better
        this.id = "Car-" + Math.random();
        this.tire = new Tire();
        this.color = color;
        this.WHITE = WHITE_COLOR;
    }

    public Car(String color, int tire, Person owner ){
        // TODO validate what can be done better
        this.id = "Car-" + Math.random();
        this.tire = new Tire();
        this.color = color;
        this.WHITE = WHITE_COLOR;
        this.owner = owner;
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

    public String getWHITE() {
        return WHITE;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public BigDecimal getMontlyPayment() {
        return montlyPayment;
    }

    public void setMontlyPayment(BigDecimal montlyPayment) {
        this.montlyPayment = montlyPayment;
    }

    public BigDecimal getFinalOneOffPriceNew() {
        return finalOneOffPriceNew;
    }

    public void setFinalOneOffPriceNew(BigDecimal finalOneOffPriceNew) {
        this.finalOneOffPriceNew = finalOneOffPriceNew;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getColor() {
        return Color.valueOf(color).value();
    }

    public Color getColorEnum() {
        return Color.valueOf(color);
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean canBuy(Client client) {
        boolean isNull = client == null;
        boolean isMajor = !isNull && (client.getAge() >= ISMAJOR);
        boolean equalsColor = !isNull && this.color.equals(client.getColor());

       /* if(isNull){
            LOGGER.warn("canBuy::Client is null");
            return false; // TODO
        }

        if(!isMajor){
            LOGGER.warn("canBuy::Client whith name {} is not major", client.getName());
        }

        if(!equalsColor){
            LOGGER.warn("canBuy::Client with name {}, is expecting color: {} and this car color is: {}", client.getName(), client.getColor(), this.color);
        }*/

        return !isNull && isMajor && equalsColor;
    }

    //@Override
    public boolean canBuy(int age, String color, String name) {
        boolean isNull = color == null;
        boolean isMajor = !isNull && (age >= ISMAJOR);
        boolean equalsColor = !isNull && this.color.equals(color);

        if(isNull){
            LOGGER.warn("canBuy::Client is null");
            return false; // TODO
        }

        if(!isMajor){
            LOGGER.warn("canBuy::Client whith name {} is not major", name);
        }

        if(!equalsColor){
            LOGGER.warn("canBuy::Client with name {}, is expecting color: {} and this car color is: {}",name, color, this.color);
        }

        return !isNull && isMajor && equalsColor;
    }


    // TODO pass the correct parameter low cohesion
    public boolean canBuy(int age, boolean isGreater, String color, BigDecimal cashAmount) {

        return false;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
