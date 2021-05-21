import buydetails.BuyInfo;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import person.Client;
import vehicles.Car;
import vehicles.Ford;
import vehicles.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.runner.RunWith;
public class TestBuyFavoriteCar extends TestCase {


    private final int NUMBER_OF_TIRES = 4;
    private final String BLUE = "Blue";
    private final String YELLOW = "Yellow";
    private final String RED = "Red";

    @Before
    public void setUp() {

    }


    @Test
    public void testCanBuyFavoriteCar() {
        Optional<List<String>> listToStream;
        Vehicle vehicle = new Ford(BLUE, NUMBER_OF_TIRES);
        Client john = new Client(BLUE, "John", 40);
        try {
            assertTrue(john.canBuyACar(vehicle));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCantBuyFavoriteCar() {
        Optional<List<String>> listToStream;
        Vehicle vehicle = new Ford(BLUE, NUMBER_OF_TIRES);
        Client michael = new Client(YELLOW, "Michael", 40);
        try {
            assertFalse(michael.canBuyACar(vehicle));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCantBuyFavoriteCarDirty() {
        Vehicle vehicle = new Ford(BLUE, NUMBER_OF_TIRES);
        List<Vehicle> listToStream = Arrays.asList(vehicle);

        Client michael = new Client(YELLOW, "Michael", 40);

        try {
            BuyInfo buyInfo = michael.buyFavoriteCarDirty(listToStream);
            assert(buyInfo == null);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void testBuyFavoriteCarDirty() {
        Vehicle vehicle = new Ford(BLUE, NUMBER_OF_TIRES);
        List<Vehicle> listToStream = Arrays.asList(vehicle);

        Client michael = new Client(BLUE, "Michael", 40);

        try {
            BuyInfo buyInfo = michael.buyFavoriteCarDirty(listToStream);
            assertTrue(buyInfo != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

 /*   @Test
    public void testBuyFavoriteCarClean() {
        Car vehicle = new Ford(BLUE, NUMBER_OF_TIRES);
        List<Car> listToStream = Arrays.asList(vehicle);

        Client michael = new Client(BLUE, "Michael", 40);

        try {
            BuyInfo buyInfo = michael.buyFavoriteCarClean(listToStream);
            assertTrue(buyInfo != null && buyInfo.getOperationStatus());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

  */



}

