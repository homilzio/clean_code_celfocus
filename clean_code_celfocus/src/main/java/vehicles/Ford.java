package vehicles;

public class Ford extends Car {

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
}
