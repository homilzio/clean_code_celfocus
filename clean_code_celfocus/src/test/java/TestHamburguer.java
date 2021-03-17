
import buydetails.Hamburguer;
import junit.framework.TestCase;
import person.Client;
import person.HamburguerSalesman;

public class TestHamburguer extends TestCase {

    public void testBuyHamburguer(){

        HamburguerSalesman hs = new HamburguerSalesman("Joqauim");
        Client client = new Client("Blue", "Manuel", 18);
        Hamburguer hamburguer = new Hamburguer("1", 2);

        hs.sellHamburguer(client, hamburguer);

        assertTrue(hamburguer.isSold());
    }

    public void testBuyHamburguerWithNullValues(){

        HamburguerSalesman hs = new HamburguerSalesman("Joqauim");
        Client client = new Client("Blue", "Manuel", 18);
        Hamburguer hamburguer = new Hamburguer("1", 2);

        hs.sellHamburguer(null, hamburguer);

        assertFalse(hamburguer.isSold());
       // assertTrue(!hamburguer.isSold());
    }

    public void testBuyHamburguerWithTwoNullValues(){

        HamburguerSalesman hs = new HamburguerSalesman("Joqauim");
        Client client = new Client("Blue", "Manuel", 18);
        Hamburguer hamburguer = new Hamburguer("1", 2);

        hs.sellHamburguer(null, hamburguer);

        assertFalse(hamburguer.isSold());
       // assertTrue(!hamburguer.isSold());
    }
}
