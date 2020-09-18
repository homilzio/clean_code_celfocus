package buydetails;

import person.Person;
import vehicles.Car;

import java.util.Date;
import java.util.List;

/***
 * Documentation comment -> this class should be userd to Pass the parameters
 */
public class BuyInfoModel implements BuyInfo {
    private List<BuyInfo> buyInfoResults;

    // TODO implement method with proper validations
    /***
     *  Documentation - this method shoud be used to buy a car
     * @param car - The car to buy
     * @param operationDate - date of the operation
     * @param buyer - Person to buy the car
     * @return if the person byer is able to buy car
     */
    @Override
    public boolean canBuy(Car car, Date operationDate, Person buyer) {
        return true;
    }

    @Override
    public List<BuyInfo> getBuyInfoResults() {
        return buyInfoResults;
    }

    @Override
    public void setBuyInfoResults(List<BuyInfo> buyInfoResults) {
        this.buyInfoResults = buyInfoResults;
    }
}
