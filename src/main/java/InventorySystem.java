import java.util.ArrayList;

public class InventorySystem {
    private final ArrayList<Bag> bags = new ArrayList<>();

    public InventorySystem() {
        initObjekte();
    }

    public void initObjekte() {
        bags.add(new Bag("Rot", 1.0, false, 4.99));
        bags.add(new Bag("Grün", 0.8, true, 14.99));
        bags.add(new Bag("Blau", 0.5, false, 9.99));
    }

    // returns an array list containing bags that have the specified color
    public  ArrayList<Bag> filterColor(String color, ArrayList<Bag> bags) {
        ArrayList<Bag> filteredBags = new ArrayList<>();
        for (Bag b : bags) {
            if (b.getColor().equals(color)) {
                filteredBags.add(b);
            }
        }
        return filteredBags;
    }
    public ArrayList<Bag> filterWeight(Double weight, ArrayList<Bag> bags) {
        ArrayList<Bag> filteredBags = new ArrayList<>();
        for (Bag a : bags) {
            if (a.getWeight() == weight) {
                filteredBags.add(a);
            }
        }
        return filteredBags;
    }
    public ArrayList<Bag> filterVegan(Boolean isVegan, ArrayList<Bag> bags) {
        ArrayList<Bag> filteredBags = new ArrayList<>();
        for (Bag c : bags) {
            if (c.isVegan() == isVegan){
                filteredBags.add(c);
            }
        }
        return filteredBags;
    }

    public ArrayList<Bag> filterPrice(Double price, ArrayList<Bag> bags) {
        ArrayList<Bag> filteredBags = new ArrayList<>();
        for (Bag a : bags) {
            if (a.getPrice() == price) {
                filteredBags.add(a);
            }
        }
        return filteredBags;
    }

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

    public static String[] toStringArray(ArrayList<Bag> bags) {
        String[] stringArray = new String[bags.size()];
        for (int i = 0; i < bags.size(); i++) {
            stringArray[i] = bags.get(i).toString();
        }
        return stringArray;
    }
    public ArrayList<Bag> orderByPrice (ArrayList<Bag> bags, boolean isAsc) {
        ArrayList<Bag> orderedBags = bags;
        double k;
        if (isAsc) {
            for (int i = 0; i < bags.size() - 1; i++) {
                if (bags.get(i).getPrice() < bags.get(i+1).getPrice()) {
                    continue;
                }
                k = bags.get(i).getPrice();
                bags.get(i).setPrice(bags.get(i + 1).getPrice());
                bags.get(i+1).setPrice(k);
                orderByPrice(bags,isAsc);
            }
        }
        else {
            for (int i = 0; i < bags.size() - 1; i++) {
                if (bags.get(i).getPrice() > bags.get(i+1).getPrice()) {
                    continue;
                }
                k = bags.get(i).getPrice();
                bags.get(i).setPrice(bags.get(i + 1).getPrice());
                bags.get(i+1).setPrice(k);
                orderByPrice(bags,isAsc);
            }
        }
        return orderedBags;
    }

    public ArrayList<Bag> orderByWeight (ArrayList<Bag> bags, boolean isAsc) {
        ArrayList<Bag> orderedBags = bags;
        double k;
        if (isAsc) {
            for (int i = 0; i < bags.size() - 1; i++) {
                if (bags.get(i).getWeight() < bags.get(i+1).getWeight()) {
                    continue;
                }
                k = bags.get(i).getWeight();
                bags.get(i).setWeight(bags.get(i + 1).getWeight());
                bags.get(i+1).setWeight(k);
                orderByWeight(bags,isAsc);
            }
        }
        else {
            for (int i = 0; i < bags.size() - 1; i++) {
                if (bags.get(i).getWeight() > bags.get(i+1).getWeight()) {
                    continue;
                }
                k = bags.get(i).getWeight();
                bags.get(i).setWeight(bags.get(i + 1).getWeight());
                bags.get(i+1).setWeight(k);
                orderByWeight(bags,isAsc);
            }
        }
        return orderedBags;
    }



}

