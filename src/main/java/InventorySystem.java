import java.util.ArrayList;

public class InventorySystem {
    private final ArrayList<Bag> bags = new ArrayList<Bag>();

    public InventorySystem() {
        initObjekte();
    }

    public void initObjekte() {
        bags.add(new Bag("Rot", 1.0, false, 4.99));
        bags.add(new Bag("Grün", 0.8, true, 14.99));
        bags.add(new Bag("Blau", 0.5, false, 9.99));
    }

    // takes a color and a list of bags as arguments
    // returns only the bags in the list that had the color specified in the argument
    public  ArrayList<Bag> filterColor(String color, ArrayList<Bag> bags) {
        ArrayList<Bag> filteredBags = new ArrayList<Bag>();
        for (Bag b : bags) {
            if (b.getColor().equals(color)) {
                filteredBags.add(b);
            }
        }
        return filteredBags;
    }
    // TODO: 3 more filters for filterWeight, filterVegan and filterPrice.


    // Setter and Getter methods
    public void addBag(String color, double weight, boolean isVegan, double price) {
        bags.add(new Bag(color, weight, isVegan, price));
    }

    public boolean removeBag(Bag bag) {
        return bags.remove(bag);
    }

    public ArrayList<Bag> getBags() {
        return bags;
    }
}

