package buydetails;

import person.Person;
import vehicles.Car;

import java.util.Date;
import java.util.List;

public class BuyInfoModel implements BuyInfo {
    private List<BuyInfo> buyInfoResults;

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
    }
}
