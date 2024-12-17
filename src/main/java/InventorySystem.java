import java.util.ArrayList;
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

    // takes a color and a ArrayList of bags as arguments
    // returns only the bags in the ArrayList that had the color specified in the argument
    public  ArrayList<Bag> filterColor(String color, ArrayList<Bag> bags) {
        ArrayList<Bag> filteredBags = new ArrayList<Bag>();
        for (Bag b : bags) {
            if (b.getColor().equals(color)) {
                filteredBags.add(b);
            }
        }
        return filteredBags;
    }
    public ArrayList<Bag> filterWeight(Double weight) {
        ArrayList<Bag> filteredBags = new ArrayList<Bag>();
        for (Bag a : bags) {
            if (a.getWeight() == weight) {
                filteredBags.add(a);
            }
        }
        return filteredBags;
    }
    public ArrayList<Bag> filterisVegan(Boolean isVegan) {
        ArrayList<Bag> filteredBags = new ArrayList<Bag>();
        for (Bag c : bags) {
            if (c.isVegan() == isVegan){
                filteredBags.add(c);
            }
        }
        return filteredBags;
    }

    public ArrayList<Bag> filterPrice(Double price ) {
        ArrayList<Bag> filteredBags = new ArrayList<Bag>();
        for (Bag a : bags) {
            if (a.getPrice() == price) {
                filteredBags.add(a);
            }
        }
        return filteredBags;
    }




    // TODO: 1-2 new Attributes like brand and adding new Bag examples
    // TODO: 3 more filters for weight, isVegan and price.
    // TODO(optional): 2 more filter methods for the price (returning bags that are cheaper or more expensive than the specified price)

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

