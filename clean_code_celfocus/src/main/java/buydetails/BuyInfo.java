package buydetails;

import person.Person;
import vehicles.Car;

import java.util.Date;
import java.util.List;

/***
 * Resume
 */
public interface BuyInfo {

    /***
     *  Documentation - this method shoud be used to buy a car
     * @param car - The car to buy
     * @param operationDate - date of the operation
     * @param buyer - Person to buy the car
     * @return if the person byer is able to buy car
     */
    boolean canBuy(Car car, Date operationDate, Person buyer);
    void setBuyInfoResults(List<BuyInfo> buyInfoResults);
    List<BuyInfo> getBuyInfoResults();

    // TODO add relevant info

    // This change should be included on the new branch

}
