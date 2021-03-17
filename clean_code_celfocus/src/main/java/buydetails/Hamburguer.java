
package buydetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import person.Client;

public class Hamburguer {


    private static final Logger LOGGER = LoggerFactory.getLogger(Hamburguer.class);


    private String id;
    private int price;
    private boolean sold;

    public Hamburguer(String id, int price ){

        this.id = id;
        this.price = price;
        this.sold = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean buy(Client client) {
        LOGGER.info("Buying hamburger!!");
        this.sold = true;
        return true;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
