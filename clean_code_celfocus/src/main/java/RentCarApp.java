import error.RentCarAppError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.*;
import vehicles.Ford;
import vehicles.Vehicle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * TODO This is the main app, we can remove the static methods moving then the the correct classes
 */
public class RentCarApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(RentCarApp.class);

    public static void main(String[] args) {
        //
        LOGGER.info("App started!!");
        printWelcomeMessage();
        //TODO add relevant type


        Salesman instanceSalesMan = new CarSalesman();

        Salesman newSalesman = instanceSalesMan.createNewSalesman();

        // ternary nok
        boolean canBuySomeThing = Objects.nonNull(newSalesman)? newSalesman.getAge() > 18  && newSalesman.getName().equals("Joao"): false;


        // ternary ok
        int newSalesmanAge = Objects.nonNull(newSalesman) ? newSalesman.getAge() : 0;

        // verbose example

        int newSalesmanAux;
        if(Objects.nonNull(newSalesman)){
            newSalesmanAux = newSalesman.getAge();
        }else{
            newSalesmanAux = 0;
        }


        System.out.println(newSalesmanAge);

        Person minorPersonWithName = new Client("Black", "Joana", 17);
        Person majorPersonWithName = new Client("Black", "Maria", 18);

        Vehicle ford = new Ford("Blue");
        Vehicle fordBlack = new Ford("Black");
        Vehicle renault = new Ford("Pink", 4);
        try {
            Salesman salesman = new HamburguerSalesman("Rui");
            try {
                ((HamburguerSalesman) salesman).createNewSalesmanCorrect("Rui");
            }catch (Exception e){
                LOGGER.error(e.getMessage());
            }

            List<Vehicle> carList = new LinkedList<Vehicle>(Arrays.asList(ford, renault));
            long initialTime = System.currentTimeMillis();

            AtomicBoolean cannotBuyACar = new AtomicBoolean(true); //minorPersonWithName.canBuyACar(ford);
            AtomicBoolean canBuyACar = new AtomicBoolean(false); //minorPersonWithName.canBuyACar(ford);

            Thread thread = new Thread(() -> {
                try {
                    cannotBuyACar.set(minorPersonWithName.canBuyACar(ford));
                } catch (InterruptedException e) {
                    LOGGER.error("An error occurred in main::", e.getMessage());
                }
            });

            Thread threadNegative = new Thread(() -> {
                try {
                    canBuyACar.set(majorPersonWithName.canBuyACar(fordBlack));
                } catch (InterruptedException e) {
                    LOGGER.error("An error occurred in main::", e.getMessage());
                }
            });
            thread.start();
            threadNegative.start();
            LOGGER.info("Can {} client buy a car? - {}", minorPersonWithName.getName(), cannotBuyACar);
            LOGGER.info("Can {} client buy a car? - {}", majorPersonWithName.getName(), canBuyACar);
            LOGGER.info("Execution Time with threads was {} of milliseconds", System.currentTimeMillis() - initialTime);

            long initialTimeWithoutThread = System.currentTimeMillis();

            boolean cannotBuyACarWithoutThread = minorPersonWithName.canBuyACar(ford);
            boolean canBuyACarWithoutThread = majorPersonWithName.canBuyACar(fordBlack);

            LOGGER.info("Can {} client buy a car? - {}", minorPersonWithName.getName(), cannotBuyACarWithoutThread);
            LOGGER.info("Can {} client buy a car? - {}", majorPersonWithName.getName(), canBuyACarWithoutThread);

            LOGGER.info("Execution Time without threads was {} of milliseconds", System.currentTimeMillis() - initialTimeWithoutThread);


            // Client alberto = createNewClientErrorTest("Alberto", 18, true, Arrays.asList(new AccountImpl(), new AccountImpl()));
        } catch (Exception e) {
            LOGGER.error("An error occurred in main::", e.getMessage());
        }

    }

    private static <T> Client createNewClientErrorTest(String alberto, int age, boolean canBuyACar, List<T> accountList) throws Exception {
        // TODO implement method body -> validate if name is acceptable and check the minimum age to buy a car
        throw RentCarAppError.METHOD_NOT_IMPLEMENTED;
    }

    private static Client createNewClientErrorTest(String alberto, int age, boolean canBuyACar) {
        return null;
    }

    public static void printWelcomeMessage() {
        System.out.println("hello  user, whats your name? \nWrite it here: ");
    }

    // TODO validate if client it's the best return type
    public static Client createNewUser() {
        // TODO create a new user and return the correct type
        System.out.println("Hello, user created");
        return null;
    }

    public static Salesman createNewSalesman() {
        // TODO create a new user and return the correct type
        System.out.println("Hello, Salesman created");
        return null;
    }
}
