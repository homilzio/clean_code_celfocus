package rentcar;

import person.Person;
import vehicles.Car;

import java.util.List;
public interface Leasing {
    boolean rentACar(Person p, Car c);
    List<Car> getAvailableCars();

}
