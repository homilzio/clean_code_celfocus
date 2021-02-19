package vehicles;

import org.springframework.util.CollectionUtils;
import person.Client;

import java.util.List;

public interface Vehicle {
    boolean getStatus();
    boolean hasInsurance();
    String getColor();
    /**
     *
     * @param client client to validate the buy method
     * @return if it's possible or not to buy
     */
    boolean canBuy(Client client);
    void cleanVehicle();

    default <T> T isAllVehiclesAvailableIdealAndCanBeFoundInTheSalesmanMarketPlaceToBuy(T t){
        return  t instanceof List && isValidVehicleList((List)t) ? t : null;
    }

    boolean isValidVehicleList(List<Car> cars);

}
