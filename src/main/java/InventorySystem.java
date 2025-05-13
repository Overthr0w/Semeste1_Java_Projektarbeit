import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class InventorySystem {
    private final List<Bag> bags = new ArrayList<>();
    private final List<Bag> listedBags = new ArrayList<>();

    public InventorySystem() {
        initObjekte();
    }

    // is used in the InventoryGUI classes updateList() method
    public static String[] toStringArray(List<Bag> bags) {
        return bags.stream().map(Bag::toString).toArray(String[]::new);
    }

    public static List<Bag> orderByPrice(List<Bag> bags, boolean isAsc) {
        return bags.stream().sorted(isAsc
                        ? Comparator.comparing(Bag::price)
                        : Comparator.comparing(Bag::price).reversed())
                .toList();
    }

    public static List<Bag> orderByWeight(List<Bag> bags, boolean isAsc) {
        return bags.stream().sorted(isAsc
                        ? Comparator.comparing(Bag::weight)
                        : Comparator.comparing(Bag::weight).reversed())
                .toList();
    }

    public void initObjekte() {
        bags.add(new Bag("Rot", 1.0, false, 4.99));
        bags.add(new Bag("Grün", 0.8, true, 14.99));
        bags.add(new Bag("Blau", 0.5, false, 9.99));
        listedBags.addAll(bags);
    }

    private List<Bag> filterAndSet(Predicate<Bag> predicate) {
        List<Bag> filtered = bags.stream().filter(predicate).toList();
        setSelectedBags(filtered);
        return filtered;
    }

    // returns an array list containing bags that have the specified color
    public List<Bag> filterColor(String color) {
        return filterAndSet(b -> b.color().equals(color));
    }

    public List<Bag> filterWeight(Double weight) {
        return filterAndSet(b -> Double.compare(b.weight(), weight) == 0.0);
    }

    public List<Bag> filterVegan(Boolean isVegan) {
        return filterAndSet(b -> b.isVegan() == isVegan);
    }

    public List<Bag> filterPrice(Double price) {
        return filterAndSet(b -> Double.compare(b.price(), price) == 0.0);
    }

    // Setter and Getter methods
    public void addBag(String color, double weight, boolean isVegan, double price) {
        bags.add(new Bag(color, weight, isVegan, price));
    }

    public boolean removeBag(Bag bag) {
        return bags.remove(bag);
    }

    public List<Bag> getBags() {
        return Collections.unmodifiableList(bags);
    }

    public List<Bag> getSelectedBags() {
        return Collections.unmodifiableList(listedBags);
    }

    public void setSelectedBags(List<Bag> listedBags) {
        this.listedBags.clear();
        this.listedBags.addAll(listedBags);
    }

    public double calcSum() {
        return this.listedBags.stream().mapToDouble(Bag::price).sum();
    }
}

