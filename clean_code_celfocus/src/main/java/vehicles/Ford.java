package vehicles;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import person.CarSalesman;
import util.Color;

import java.util.Arrays;
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
                    for (int k = 0; k < INTERMEDIATE_CAR_SIZE; ++k){
                        if(k == MIN_CAR_SIZE){
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

  /*  private boolean isValidVehicleList(List<Car> cars) {
        return CollectionUtils.isEmpty(cars) && cars.size() == MAX_CAR_SIZE;
    }
*/

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


    // generic
    // TODO change this to a proper class
    public <T> T isAllVehiclesAvailableIdealAndCanBeFoundInTheSalesmanMarketPlaceToBuy(T t){
        return  t instanceof List && isValidVehicleList((List)t) ? t : null;
    }

    @Override
    public boolean isValidVehicleList(List<Car> cars) {
        return false;
    }

    protected <T> T jsonRPC(T paramValue) {
        Ford black = new Ford("Black", 4);

        T allVehiclesAvailableIdealAndCanBeFoundInTheSalesmanMarketPlaceToBuy = isAllVehiclesAvailableIdealAndCanBeFoundInTheSalesmanMarketPlaceToBuy(paramValue);//isAllVehiclesAvailableIdealAndCanBeFoundInTheSalesmanMarketPlaceToBuy(Arrays.asList(black));

        return allVehiclesAvailableIdealAndCanBeFoundInTheSalesmanMarketPlaceToBuy;
    }

    public boolean isValidCarTypeDirty(Car car){

        if(car.isClean() && Color.WHITE.value().equals(car.getColor())){
            if(car.hasInsurance() && car.getStatus())
                return true;
            else if(!isClean()){
                return true;
            }
        }
        return false;
    }

    //TODO change all to enum
    public static boolean isValidCarTypeClean(Car car){
        if(car == null || !car.getStatus() || !car.hasInsurance()){
            return false;
        }
        return car.isClean() && car.getColor().equals(Color.WHITE.value());
    }

}
