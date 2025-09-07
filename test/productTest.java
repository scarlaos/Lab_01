import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class productTest {

    product p1, p2, p3, p4;

    @BeforeEach
    void setUp() {
        product.setIDSeed(0);

        p1 = new product("00000001", "Apple", "Tasty", 1.99, 5);
        p2 = new product("00000002", "Pear", "Juicy", 2.50, 3);
        p3 = new product("Banana", "Yellow", 0.99, 10); // auto ID
        p4 = new product("Grapes", "Seedless", 3.75, 2);
    }

    @Test
    void getIDNum() {
        assertEquals("00000001", p1.getIDNum());
    }

    @Test
    void getName() {
        assertEquals("Apple", p1.getName());
    }

    @Test
    void getDescription() {
        assertEquals("Tasty", p1.getDescription());
    }

    @Test
    void getCost() {
        assertEquals(1.99, p1.getCost());
    }

    @Test
    void getQuantity() {
        assertEquals(5, p1.getQuantity());
    }

    @Test
    void setIDNum() {
        p1.setIDNum("00000005");
        assertEquals("00000005", p1.getIDNum());
    }

    @Test
    void setName() {
        p1.setName("Green Apple");
        assertEquals("Green Apple", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Sour");
        assertEquals("Sour", p1.getDescription());
    }

    @Test
    void setCost() {
        p1.setCost(2.25);
        assertEquals(2.25, p1.getCost());
    }

    @Test
    void setQuantity() {
        p1.setQuantity(7);
        assertEquals(7, p1.getQuantity());
    }

    @Test
    void toCSVTest() {
        String expected = "00000001,Apple,Tasty,1.99,5";
        assertEquals(expected, p1.toCSV());
    }

    @Test
    void toJSONTest() {
        String expected = "{\"id\":\"00000001\",\"name\":\"Apple\",\"description\":\"Tasty\",\"cost\":1.99,\"quantity\":5}";
        assertEquals(expected, p1.toJSON());
    }

    @Test
    void toXMLTest() {
        String expected = "<product><ID>00000001</ID><Name>Apple</Name><Description>Tasty</Description><Cost>1.99</Cost><Quantity>5</Quantity></product>";
        assertEquals(expected, p1.toXML());
    }

    @Test
    void toStringTest() {
        String expected = "Product{"+"IDNum='00000001', name='Apple', description='Tasty', cost=1.99, quantity=5}";
        assertEquals(expected, p1.toString());
    }
}
