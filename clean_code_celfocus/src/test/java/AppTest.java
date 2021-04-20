import junit.framework.TestCase;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AppTest extends TestCase {

    public static final String OK = "Ok";
    public static final int PORTUGAL_SIZE = 8;
    public static final int MIN_SIZE = 0;
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


    // with instanceOf
    public void testListFor1(){

        List<String> listToSearch = Arrays.asList("AbA", "Joana", "Joaquim", "francis", null, "Portugal");

        for (String str: listToSearch) {
            if( str instanceof  String && str.equals("Portugal")){
                return;
            }
        }
    }

    public void testListFor2(){

        List<String> listToSearch = Arrays.asList("AbA", "Joana", "Joaquim", "francis", null, "Portugal");

        for (String str: listToSearch) {
            if( str != null && str.equals("Portugal")){
                return;
            }
        }
    }


    public void testListStream(){

        List<String> listToSearch = Arrays.asList("AbA", "Joana", "portugal", "Joaquim", "francis", null, "Portugal");
        List<String> listToSearch1 = Arrays.asList("AbA", "Joana", "portugal", "Joaquim", "francis", "Portugal");
        List<String> listToSearch2 = Arrays.asList("Portugal");
        List<String> listToSearch3 = Arrays.asList("Portugal");

        List<String> collect = listToSearch.stream()
                .filter(element -> element != null) // delete all nulls
                .filter(element1 -> element1.startsWith("P")) // delete all elements that does not start With P
                .filter(element -> toLowerCase(element).startsWith("p"))
                //.map(element -> element.toString())
                //.filter( element -> element.toLowerCase().startsWith("P") ) // delete all elements that does not start With P
                .filter(element -> element.equals("Portugal"))
                .collect(Collectors.toList());

        assertTrue(collect.size() == 1);
    }

    // should return the size of the match string

    public void testListStreamMapToInt(){

        int size = MIN_SIZE;

        List<String> listToSearch = Arrays.asList("AbA", "Joana", "portugal", "Joaquim", "francis", null, "Portugal");

        Optional<Integer> collect = listToSearch.stream()
                .filter(element -> element != null) // delete all nulls
                .filter(element -> element.equals("Portugal"))
                .map(element -> element.length())
                .findFirst();

        if(collect.isPresent()){
            size = collect.get().intValue();
        }
        assertTrue(size == PORTUGAL_SIZE);
    }


    public void testListStreamMapToIntParalel(){

        int size = MIN_SIZE;

        List<String> listToSearch = Arrays.asList("AbA", "Joana", "portugal", "Joaquim", "francis", null, "Portugal");

        Optional<Integer> collect = listToSearch.parallelStream()
                .filter(element -> element != null) // delete all nulls
                .filter(element -> element.equals("Portugal"))
                .map(element -> element.length())
                .findFirst();

        if(collect.isPresent()){
            size = collect.get().intValue();
        }
        assertTrue(size == PORTUGAL_SIZE);
    }


    public String toLowerCase(String str){
        return  str.toLowerCase(); // possible NPE
    }
    // TODO fix the test error
    public void testListNotEmpty() {
        Optional<List<String>> listToStream;
        listToStream = Optional.of(Arrays.asList());

        boolean isValid = isValidListAndNotEmpty(listToStream);

        assertFalse(isValid);
    }

    private boolean isValidList(Optional<List<String>> listToStream) {
        return listToStream.isPresent() && listToStream.get() != null ;
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
