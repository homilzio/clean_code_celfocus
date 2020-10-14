import junit.framework.TestCase;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AppTest extends TestCase {

    public static final String OK = "Ok";
    private boolean isValid;

    public void testApp() {
        assertTrue(true);
    }

    public void testList() {
        Optional<List<String>> listToStream;
        listToStream = Optional.of(Arrays.asList("AbA", "Joana", "Joaquim", "francis"));

        boolean isValid = isValidList(listToStream);
        if (isValid) {

            if (listToStream.get().size() > 1) {

            }

        } else if (isValid) {

        }

        assertTrue(isValid);
    }

    // TODO fix the test error
    public void testListNotEmpty() {
        Optional<List<String>> listToStream;
        listToStream = Optional.of(Arrays.asList());

        boolean isValid = isValidListAndNotEmpty(listToStream);

        assertFalse(isValid);
    }

    private boolean isValidList(Optional<List<String>> listToStream) {
        return listToStream.isPresent() && listToStream.get() == null ;
    }

    private boolean isValidListAndNotEmpty(Optional<List<String>> listToStream) {
        return listToStream.isPresent() && listToStream.get() != null  && !CollectionUtils.isEmpty(listToStream.get());
    }


    private boolean isValidReturn(Optional<List<String>> listToStream) {

        if (isValidList(listToStream)) {
            return listToStream.isPresent() && listToStream.get() != null;
        }

        //int value = 2;
        //float newF = 0.1f; // to use later
        return isValidList(listToStream);
    }

    private boolean validateAndCheckIfTheStringIsNullOrEmpty(String str) {
        return str != null && str.length() >= 0;
    }

    private double calcNumbers(int sum, int sum2, int sum3, int divider){

        int sumResult = sum + sum2;
        double dividerResult = sumResult / divider;

        int result = sum > sum2 ? 1 : 2;
       // int secondResult = sum > sum2 ? 1: sum2 > sum3? 2: 3;

        return  dividerResult;
    }


    boolean isValidStringDirty(String toValidate){

        if(toValidate == null){
            return false;
        }

        if(toValidate.length() > 10){
            return false;
        }

        if(toValidate.contains("Ok")){
            return true;
        }
        return false;
    }

    boolean isValidStringClean(String toValidate){
        return toValidate != null && toValidate.length() < 10 && toValidate.contains(OK);
    }
}
