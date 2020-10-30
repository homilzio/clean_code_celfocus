package buydetails;

import person.Person;
import vehicles.Car;

import java.util.Date;
import java.util.List;

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
