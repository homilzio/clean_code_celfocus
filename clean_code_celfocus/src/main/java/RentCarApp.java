import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.Client;
import person.Salesman;

public class RentCarApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(RentCarApp.class);
    public static void main(String [] args){
        //
        LOGGER.info("App started!!");
        printWelcomeMessage();
        //TODO add relevant type
        createNewUser();
        Salesman newSalesman = createNewSalesman();
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
