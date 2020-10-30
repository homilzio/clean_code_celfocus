package vehicles;

import java.math.BigDecimal;

/**
 * This is a class with Tire information, but it's dirty. Can you kindly clean it?
 */
public class Tire {
    // TODO implement getters and setters
    int size;
    private BigDecimal price;
    long kmDone = 0;

    public Tire (){
        this.kmDone = 0;
        this.price = new BigDecimal("200"); // TODO Magic Number
        this.size = 17;  // TODO Magic Number
    }

    public Tire (BigDecimal price, int size, long kmDone){
        this.price = price;
        this.size = size;
        this.kmDone = kmDone;
        this.kmDone = 0;
    }

    public Tire (BigDecimal price, int size, long kmDone, boolean isNew){
      // TODO implement method
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
