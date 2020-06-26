package vehicles;

import account.Account;
import buydetails.BuyInfo;
import person.Client;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract class  Car implements  Vehicle{

    public static final String BLACK = "Black";
    public static final int ISMAJOR = 18;

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
        this.color = BLACK;
        this.WHITE = color;
        this.vehicleFinance = new VehicleFinance();
    }

    public Car(String color, int tire ){
        // TODO validate what can be done better
        this.id = "Car-" + Math.random();
        this.tire = new Tire();
        this.color = BLACK;
        this.WHITE = color;
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
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean canBuy(Client client) {
        return client != null &&
                client.getAge() > ISMAJOR &&
                this.color.equals(client.getColor());
    }

}
