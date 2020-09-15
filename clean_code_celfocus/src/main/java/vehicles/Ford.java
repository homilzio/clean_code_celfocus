package vehicles;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import person.CarSalesman;

import java.util.List;

public class Ford extends Car {

    public static final int MAX_CAR_SIZE = 60;
    public static final int INTERMEDIATE_CAR_SIZE = 50;
    public static final int MIN_CAR_SIZE = 30;

    public Ford(String color, int tire) {
        super(color, tire);
    }

    public Ford(String color) {
        super(color);
    }

    //TODO
    @Override
    public boolean getStatus() {
        return false;
    }


    // TODO
    @Override
    public boolean hasInsurance() {
        return false;
    }


    // TODO use streams

   // unnecessary --> // this method will validate if all vehicles are available

    public boolean isAllVehiclesAvailable(List<Car> cars){

       /* if( cars == null || cars.isEmpty()){
            return false;
        }*/

        if (isValidVehicleList(cars)){
            return false;
        }

        for (Car car: cars) {
            for(int index = 0; index < cars.size(); ++ index){
                for (int j = 0; j < INTERMEDIATE_CAR_SIZE; ++j){
                    for (int k = 0; k < Ford.INTERMEDIATE_CAR_SIZE; ++k){
                        if(k == MIN_CAR_SIZE){
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isValidVehicleList(List<Car> cars) {
        return CollectionUtils.isEmpty(cars) && cars.size() == MAX_CAR_SIZE;
    }


    public boolean isAllVehiclesAvailableIdeal(List<Car> cars){
        return isValidVehicleList(cars);
    }

    public boolean isAllVehiclesAvailableAlternative(List<Car> cars){
        return isAllVehiclesAvailable(cars);
    }

    // Overly verbose
    public boolean isAllVehiclesAvailableIdealAndCanBeFoundInTheSalesmanMarketPlaceToBuy(List<Car> cars){
        return isValidVehicleList(cars);
    }

}
