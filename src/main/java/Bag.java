public class Bag {
    private String color;
    private double weight;
    private boolean isVegan;
    private double price;

    public Bag(String farbe, double weight, boolean isVegan, double preis) {
        this.color = farbe;
        this.weight = weight;
        this.isVegan = isVegan;
        this.price = preis;
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

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        this.isVegan = vegan;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
