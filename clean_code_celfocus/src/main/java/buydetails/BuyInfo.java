package buydetails;

import person.Person;
import vehicles.Car;

import java.util.Date;
import java.util.List;

public interface BuyInfo {

    boolean canBuy(Car car, Date operationDate, Person buyer);
    void setBuyInfoResults(List<BuyInfo> buyInfoResults);
    List<BuyInfo> getBuyInfoResults();

    // TODO add relevant info

    // This change should be included on the new branch

}
