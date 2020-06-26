import account.Account;
import account.AccountImpl;
import error.RentCarAppError;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.CarSalesman;
import person.Client;
import person.Person;
import person.Salesman;
import vehicles.Car;
import vehicles.Ford;
import vehicles.Vehicle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


/**
 * TODO This is the main app, we can remove the static methods moving then the the correct classes
 */
public class RentCarApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(RentCarApp.class);
    public static void main(String [] args){
        //
        LOGGER.info("App started!!");
        printWelcomeMessage();
        //TODO add relevant type



        Salesman instanceSalesMan = new CarSalesman();

        Salesman newSalesman = instanceSalesMan.createNewSalesman();

        int newSalesmanAge = Objects.nonNull(newSalesman)? newSalesman.getAge() : 0;
        System.out.println(newSalesmanAge);

        Person minorPersonWithName = new Client("Black", "Joana", 17);
        Person majorPersonWithName = new Client("Black", "Maria", 18);

        Vehicle ford = new Ford("Blue");
        Vehicle fordBlack = new Ford("Black");
        Vehicle renault = new Ford("Pink", 4);

        List<Vehicle> carList = new LinkedList<Vehicle>(Arrays.asList(ford, renault));

        boolean cannotBuyACar = minorPersonWithName.canBuyACar(ford);
        boolean canBuyACar = majorPersonWithName.canBuyACar(fordBlack);

        LOGGER.info("Can {} client buy a car? - {}", minorPersonWithName.getName(), cannotBuyACar);
        LOGGER.info("Can {} client buy a car? - {}", majorPersonWithName.getName(), canBuyACar);


        // TODO give proper names and validate
           /* Person p = new Client();
            Client c = new Client();
            */

        // TODO install Lombok plugin

        try {
           // Client alberto = createNewClientErrorTest("Alberto", 18, true, Arrays.asList(new AccountImpl(), new AccountImpl()));
        } catch (Exception e) {
            //TODO Logg exception properly
            e.printStackTrace();
			//TODO write the exception to the new created log file ccc.log
        }

    }

    private static <T> Client createNewClientErrorTest(String alberto, int age, boolean canBuyACar, List<T> accountList) throws Exception {
        // TODO implement method body -> validate if name is acceptable and check the minimum age to buy a car
        throw RentCarAppError.METHOD_NOT_IMPLEMENTED;
    }

    private static Client createNewClientErrorTest(String alberto, int age, boolean canBuyACar) {
        return null;
    }

    public static void printWelcomeMessage(){
         System.out.println("hello  user, whats your name? \nWrite it here: ");
    }

    // TODO validate if client it's the best return type
    public static Client createNewUser(){
        // TODO create a new user and return the correct type
        System.out.println("Hello, user created");
        return null;
    }

    public static Salesman createNewSalesman(){
        // TODO create a new user and return the correct type
        System.out.println("Hello, Salesman created");
        return null;
    }
}
