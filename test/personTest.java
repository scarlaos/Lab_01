import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    person p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        String title = " ";
        p1 = new person("00000A", "Bob", "Tester1", "Mr ", 1955);
        p2 = new person("00000B", "Sally", "Tester2", "Ms ", 1975);
        person.setIDSeed(0);
        p3 = new person("Bob", "Tester3", 1960);
        p4 = new person( "Sally", "Tester4", 1965);
        p5 = new person( "Fred", "Tester5", 1970);
        p6 = new person( "Cindy", "Tester6", 1975);


    }

    @Test
    /** tests the seed generator after 4 calls, should be 4*/
    void getIDSeed() {
        assertEquals(26, person.getIDSeed());
    }

    /** Test the constructor with the first instance  p1 */

    @Test
    void getIDNum() {
        assertEquals("00000A", p1.getIDNum());
    }
     @Test
     void getFirstName() {
     assertEquals("Bob", p1.getFirstName());
     }

    @Test
    void getLastName() {
        assertEquals("Tester1", p1.getLastName());
    }

    @Test
    void getYOB() {
        assertEquals(1955, p1.getYOB());
    }

    @Test
    void setIDNum() {
        p1.setIDNum("00000B");
        assertEquals("00000B", p1.getIDNum());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Sally");
        assertEquals("Sally", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Tester2");
        assertEquals("Tester2", p1.getLastName());
    }

    @Test
    void setYOB() {
        p1.setYOB(1975);
        assertEquals(1975, p1.getYOB());
    }

    @Test
    void equals() {
        p1.setIDNum("00000B");
        p1.setFirstName("Sally");
        p1.setLastName("Tester2");
        p1.setTitle("Ms");
        p1.setYOB(1975);
        assertFalse(p1.equals(p2));
    }

    @Test
    void toStringTest() {
        String expected = "person{IDNum='00000A', firstName='Bob', lastName='Tester1', YOB=1955}";
        assertEquals(expected, p1.toString());
    }

    @Test
    void testToCSV(){
        String expected = "00000A,Bob,Tester1,Mr ,1955";
        assertEquals(expected, p1.toCSV());
    }

    @Test
    void toJSONTest(){
        String expected = "{\"id\":\"00000A\", \"firstName\":\"Bob\",\"lastName\":\"Tester1\",\"title\":\"Mr \",\"yob\":1955}";
        assertEquals(expected, p1.toJSON());
    }

    @Test
    void toXMLTest(){
        String expected = "<person><ID>00000A</ID><FirstName>Bob</FirstName><LastName>Tester1</LastName><Title>Mr </Title><YOB>1955</YOB></person>";
        assertEquals(expected, p1.toXML());
    }


}