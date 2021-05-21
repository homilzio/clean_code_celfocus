import junit.framework.TestCase;
import person.Client;
import person.Person;

public class TestClient extends TestCase {

    public void testEquals() {
        Person john = new Client("Blue", "John", 50);
        Person michael = new Client("Blue", "Michael", 50);

        assertFalse(john.equals(michael));
    }

    public void testEqualsWithNullValues() {
        Person john = new Client("Blue", "John", 50);
        Person michael = new Client("Blue", "Michael", 50);

        assertFalse(john.equals(null));
    }
}
