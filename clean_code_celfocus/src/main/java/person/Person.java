package person;

import vehicles.Car;
import vehicles.Vehicle;

/**
 * This is a Person interface, it defines the general characteristics of a Human being in this context
 */
public interface Person {

    int getAge();
    String getName();
    boolean canBuyACar(Vehicle car);

    // the intent was to create a function to check if the customer has minimun age to checkout
    default boolean hasMinimunAgeToBuyACar(Person p) {
        return 18 < p.getAge();
    }
}
