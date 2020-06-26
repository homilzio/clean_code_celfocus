package buydetails;

import person.Person;
import vehicles.Car;

import java.util.Date;

public class BuyInfoModel implements BuyInfo {

    // TODO implement method with proper validations
    @Override
    public boolean canBuy(Car car, Date operationDate, Person buyer) {
        return true;
    }
}
