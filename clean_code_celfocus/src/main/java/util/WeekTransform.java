package util;

import vehicles.Car;

public class WeekTransform {


    public String weekday(int day) {

        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Monday";
            case 4:
                return "Tuesday";
            case 5:
                return "Wednesday";

            default:
                return "No day defined";
        }
    }



    public String weekdayIf(int day) {
        if(Status.F.equals(Car.BLACK)){

        }

        if(day == 1 ){
            day = 3;
            return "Monday";
        }

        else if(day == 2){
            return "Tuesday";
        }

        else if(day ==3){
            return "Wednesday";
        }
        else {
            return "No date defined";
        }
    }



}
