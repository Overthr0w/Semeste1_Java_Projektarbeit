import java.awt.*;

class BagTest {
    // TODO: add tests to the setters/getters (one assertion for each should be enough)
    @org.junit.jupiter.api.Test
    void getColor() {
        System.out.println("Farbe der Tasche: " + Bag.class.newInstance().getColor());
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        Bag.class.newInstance().setColor() = ("dunkelrot");
        System.out.println("neue Farbe: " + Bag.class.newInstance().setColor());
    }
    @org.junit.jupiter.api.Test
    void getWeight() {
        System.out.println( "Gewicht der Tasche: " + Bag.class.newInstance().getWeight());
    }

    @org.junit.jupiter.api.Test
    void setWeight() {
        Bag.class.newInstance().getWeight() = (1.1);
        System.out.println("neues Gewicht der Tasche: " + Bag.class.newInstance().getWeight());
    }

    @org.junit.jupiter.api.Test
    void isVegan() {
        System.out.println("Ist Die Tasche veagan?: " + Bag.class.newInstance().isVegan());
    }

    @org.junit.jupiter.api.Test
    void setVegan() {
        Bag.class.newInstance().setVegan();
        System.out.println("Neu Bewertung von Vegan: " + Bag.class.newInstance().isVegan());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        System.out.println("Preis der Tasche: " + Bag.class.newInstance().getPrice());
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
        Bag.class.newInstance().setPrice(9.99);
        System.out.println("Der neue Preis der Tasche beträgt: " + Bag.class.newInstance().getPrice());
    }
}