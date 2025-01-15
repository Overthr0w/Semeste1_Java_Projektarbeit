import java.util.ArrayList;

public class InventorySystem {
    private final ArrayList<Bag> bags = new ArrayList<>();
    private final ArrayList<Bag> listedBags = new ArrayList<>();

    public InventorySystem() {
        initObjekte();
    }

    // is used in the InventoryGUI classes updateList() method
    public static String[] toStringArray(ArrayList<Bag> bags) {
        String[] stringArray = new String[bags.size()];
        for (int i = 0; i < bags.size(); i++) {
            stringArray[i] = bags.get(i).toString();
        }
        return stringArray;
    }

    public static ArrayList<Bag> orderByPrice(ArrayList<Bag> bags, boolean isAsc) {
        Bag buffer;
        if (isAsc) {
            for(int i = 1; i < bags.size(); i++) {
                for(int j=0; j < bags.size() - i; j++) {
                    if(bags.get(j).getPrice() > bags.get(j+1).getPrice()) {
                        buffer = bags.get(j);
                        bags.set(j, bags.get(j+1));
                        bags.set(j+1, buffer);
                    }
                }
            }
        } else {
            for(int i = 1; i < bags.size(); i++) {
                for(int j=0; j < bags.size() - i; j++) {
                    if(bags.get(j).getPrice() < bags.get(j+1).getPrice()) {
                        buffer = bags.get(j);
                        bags.set(j, bags.get(j+1));
                        bags.set(j+1, buffer);
                    }
                }
            }
        }
        return bags;
    }

    public static ArrayList<Bag> orderByWeight(ArrayList<Bag> bags, boolean isAsc) {
        Bag buffer;
        if (isAsc) {
            for(int i = 1; i < bags.size(); i++) {
                for(int j=0; j < bags.size() - i; j++) {
                    if(bags.get(j).getWeight() > bags.get(j+1).getWeight()) {
                        buffer = bags.get(j);
                        bags.set(j, bags.get(j+1));
                        bags.set(j+1, buffer);
                    }
                }
            }
        } else {
            for(int i = 1; i < bags.size(); i++) {
                for(int j=0; j < bags.size() - i; j++) {
                    if(bags.get(j).getWeight() < bags.get(j+1).getWeight()) {
                        buffer = bags.get(j);
                        bags.set(j, bags.get(j+1));
                        bags.set(j+1, buffer);
                    }
                }
            }
        }
        return bags;
    }

    public void initObjekte() {
        bags.add(new Bag("Rot", 1.0, false, 4.99));
        bags.add(new Bag("Grün", 0.8, true, 14.99));
        bags.add(new Bag("Blau", 0.5, false, 9.99));
        listedBags.addAll(bags);
    }

    // returns an array list containing bags that have the specified color
    public ArrayList<Bag> filterColor(String color) {
        ArrayList<Bag> filteredBags = new ArrayList<>();
        for (Bag b : bags) {
            if (b.getColor().equals(color)) {
                filteredBags.add(b);
            }
        }
        this.setSelectedBags(filteredBags);
        return filteredBags;
    }

    public ArrayList<Bag> filterWeight(Double weight) {
        ArrayList<Bag> filteredBags = new ArrayList<>();
        for (Bag a : bags) {
            if (a.getWeight() == weight) {
                filteredBags.add(a);
            }
        }
        this.setSelectedBags(filteredBags);
        return filteredBags;
    }

    public ArrayList<Bag> filterVegan(Boolean isVegan) {
        ArrayList<Bag> filteredBags = new ArrayList<>();
        for (Bag c : bags) {
            if (c.isVegan() == isVegan) {
                filteredBags.add(c);
            }
        }
        this.setSelectedBags(filteredBags);
        return filteredBags;
    }

    public ArrayList<Bag> filterPrice(Double price) {
        ArrayList<Bag> filteredBags = new ArrayList<>();
        for (Bag a : bags) {
            if (a.getPrice() == price) {
                filteredBags.add(a);
            }
        }
        this.setSelectedBags(filteredBags);
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

    public ArrayList<Bag> getSelectedBags() {
        return listedBags;
    }

    public void setSelectedBags(ArrayList<Bag> listedBags) {
        this.listedBags.clear();
        this.listedBags.addAll(listedBags);
    }

    public double calcSum() {
        double sum = 0;
        for (Bag b : this.listedBags) {
            sum += b.getPrice();
        }
        return sum;
    }


}

