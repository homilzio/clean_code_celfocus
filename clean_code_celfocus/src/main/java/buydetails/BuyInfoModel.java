package buydetails;

import person.Person;
import vehicles.Car;

import java.util.Date;
import java.util.List;

/***
 * Documentation comment -> this class should be userd to Pass the parameters
 */
public class BuyInfoModel implements BuyInfo {

    boolean operationSuccess;
    private List<BuyInfo> buyInfoResults;

    public BuyInfoModel(boolean operationSuccess){
        this.operationSuccess = operationSuccess;
    }

    public BuyInfoModel(){
        this.operationSuccess = false;
    }

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
        this.operationSuccess = true;
    }

    @Override
    public boolean getOperationStatus() {
        return operationSuccess;
    }
}
