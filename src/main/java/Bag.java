// defines the class Bags and the values
public record Bag(String color, double weight, boolean isVegan, double price) {
    // constructor for Bag


    // returns the values of bag as a string
    public String toString() {
        return String.format("%s %.2f kg %.2f € Vegan: %b\n", this.color, this.weight, this.price, this.isVegan);
    }
}
