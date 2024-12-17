import java.util.ArrayList;
import java.util.List;

public class InventorySystem {
    private final List<Bag> bags = new ArrayList<Bag>();

    public InventorySystem() {
        initObjekte();
    }

    public void initObjekte() {
        bags.add(new Bag("Rot", 1.0, false, 4.99));
        bags.add(new Bag("Grün", 0.8, true, 14.99));
        bags.add(new Bag("Blau", 0.5, false, 9.99));
    }

    public  List<Bag> filterColor(String color) {
        List<Bag> filteredBags = new ArrayList<Bag>();
        for (Bag b : bags) {
            if (b.getColor().equals(color)) {
                filteredBags.add(b);
            }
        }
        return filteredBags;

    }
    public List<Bag> filterWeight(Double weight) {
        List<Bag> filteredBags = new ArrayList<Bag>();
        for (Bag a : bags) {
            if (a.getWeight() == weight) {
                filteredBags.add(a);
            }
        }
        return filteredBags;
    }
    public List<Bag> filterisVegan(Boolean isVegan) {
        List<Bag> filteredBags = new ArrayList<Bag>();
        for (Bag c : bags) {
            if (c.isVegan() == isVegan){
                filteredBags.add(c);
            }
        }
        return filteredBags;
    }

    public List<Bag> filterPrice(Double price ) {
        List<Bag> filteredBags = new ArrayList<Bag>();
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

    public List<Bag> getBags() {
        return bags;
    }
}

