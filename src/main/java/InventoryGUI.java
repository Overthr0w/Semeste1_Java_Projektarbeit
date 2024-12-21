import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class InventoryGUI extends JFrame{
    private JPanel myPanel;
    private JList itemList;
    private JScrollPane scrollPane;
    private JComboBox comboBoxColor;
    private JLabel colorLabel;
    private JLabel weightLabel;
    private JLabel priceLabel;
    private JTextField textFieldWeight;
    private JTextField textFieldPrice;
    private JCheckBox checkBoxVegan;
    private JButton createButton;
    private JButton filterButton;
    final InventorySystem inv;

    public InventoryGUI() {
        setTitle("Inventar Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(myPanel);
        setVisible(true);
        // One-time initialization of InventorySystem class
        inv = new InventorySystem();
        inv.initObjekte();
        initListeners();
    }

    // takes objects from ArrayList and displays them in the itemList on the right side.
    // must be called each time when the 'Hinzufügen' or 'Filtern' button is pressed.
    public void updateList(ArrayList<Bag> objects) {
        // TODO: https://stackoverflow.com/questions/16214480/adding-elements-to-a-jlist
        for (Bag b : inv.getBags()) {
            // TODO: find out what components are, regarding JList
            //itemList.add(b);
        }
    }

    // add bag on inventory
    // add bag on itemList by calling 'updateList'
    private void addBag() {
        // parse arguments
        String color = getInputColor();
        double weight = getInputWeight();
        double price = getInputPrice();
        boolean isVegan = getInputVegan();
        // create bag object and add it to the 'bags' list
        inv.addBag(color, weight, isVegan, price);
        // show the updated 'bags' list on the right side of the GUI
        updateList(inv.getBags());
    }

    // returns color string from 'comboBoxColor'
    // returns an empty string if no color is selected
    private String getInputColor() {
        return Objects.requireNonNull(comboBoxColor.getSelectedItem()).toString();
    }

    // parses and returns the weight specified on 'textFieldWeight'
    // throws an error message, if the weight is invalid
    private double getInputWeight() {
        // TODO: implement
        return 0;
    }

    // parses and returns the price specified on 'textFieldPrice'
    // throws an error message, if the weight is invalid
    private double getInputPrice() {
        // TODO: implement
        return 0;
    }

    // returns whether 'Vegan' is selected
    private boolean getInputVegan() {
        return checkBoxVegan.isSelected();
    }

    private void initListeners() {
        createButton.addActionListener(_ -> addBag());
        filterButton.addActionListener(_ -> {
            ArrayList<Bag> filtered = inv.filterColor(getInputColor(), inv.getBags());
            filtered = inv.filterWeight(getInputWeight(), filtered);
            filtered = inv.filterPrice(getInputPrice(), filtered);
            filtered = inv.filterVegan(getInputVegan(), filtered);
            updateList(filtered);
        });
    }

}
