package buydetails;

import person.Person;
import vehicles.Car;

import java.util.Date;

public interface BuyInfo {

    boolean canBuy(Car car, Date operationDate, Person buyer);

    // TODO add relevant info

}
