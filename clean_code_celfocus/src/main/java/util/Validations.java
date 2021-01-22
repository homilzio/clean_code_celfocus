package util;

import java.util.List;

public class Validations {

    private static final int MIN_AGE_TO_DRINK = 18;

    private final String MIN_AGE_TO_DRINK_STR = "18";

    public static boolean canDrink (int age){

        return  age >= MIN_AGE_TO_DRINK;

    }

    public static boolean isValidAgeToDrink(int age){

        return  age >= MIN_AGE_TO_DRINK;
    }

    public boolean isValidAgeToDrink(String age){  //"17" == false , "19" == false, null

        //return  age.equals( MIN_AGE_TO_DRINK_STR ); // NPE -> Null Pointer Exception
        return  MIN_AGE_TO_DRINK_STR.equals( age ); // false
    }

    public static boolean itsValidBanana(List<String> bananas){
        int index = 10;
        while(bananas.size() > 10){
            bananas.remove(--index);
        }

      /*  for(int idx = 1; idx <10; ++idx){
            bananas.get(idx); //
        }

        for(int idx = 1; idx <10; idx++){
            bananas.get(idx); //
        }

       */
        return false;
    }

    
    // weekday(4) --> null
    // weekday(1) --> "Monday"
    public String weekday(int day) {

        if(day == 1){
            day = 2;
            return "Monday";
        }
        else if(day == 2){
            day = 3;
            day = 4;
            return "Tuesday";
        }
        else if(day == 3){
            return "Wednesday";
        }
        return null;
    }
}
