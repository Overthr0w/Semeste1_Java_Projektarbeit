// defines the class Bags and the values
public class Bag {
    private String color;
    private double weight;
    private boolean isVegan;
    private double price;

    // constructor for Bag
    public Bag(String color, double weight, boolean isVegan, double price) {
        this.color = color;
        this.weight = weight;
        this.isVegan = isVegan;
        this.price = price;
    }

    // Setter and Getter methods
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isVegan() {return isVegan;}

    public void setVegan(boolean vegan) {
        this.isVegan = vegan;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // returns the values of bag as a string
    public String toString() {
        return String.format("%s %.2f kg %.2f € Vegan: %b\n", this.color, this.weight, this.price, this.isVegan);
    }
}
