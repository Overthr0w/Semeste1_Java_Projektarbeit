import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    final Bag testBag = new Bag("schwarz", 10.0, false, 14.99);

    @org.junit.jupiter.api.Test
    void getColor() {
        assertEquals("schwarz", testBag.getColor());
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        testBag.setColor("magenta");
        assertEquals("magenta", testBag.getColor());
    }

    @org.junit.jupiter.api.Test
    void getWeight() {
        assertEquals(10.0, testBag.getWeight());
    }

    @org.junit.jupiter.api.Test
    void setWeight() {
        testBag.setWeight(10.23);
        assertEquals(10.23, testBag.getWeight());
    }

    @org.junit.jupiter.api.Test
    void isVegan() {
        assertFalse(testBag.isVegan());
    }

    @org.junit.jupiter.api.Test
    void setVegan() {
        testBag.setVegan(true);
        assertTrue(testBag.isVegan());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(14.99, testBag.getPrice());
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
        testBag.setPrice(24.99);
        assertEquals(24.99, testBag.getPrice());
    }
}
