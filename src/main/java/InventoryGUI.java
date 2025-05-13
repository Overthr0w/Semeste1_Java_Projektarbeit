import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class InventoryGUI extends JFrame {
    private final InventorySystem inv;
    private JPanel myPanel;
    private JList<String> itemList;
    private JScrollPane scrollPane;
    private JComboBox<String> comboBoxColor;
    private JLabel colorLabel;
    private JLabel weightLabel;
    private JLabel priceLabel;
    private JLabel priceSumLabel;
    private JTextField textFieldWeight;
    private JTextField textFieldPrice;
    private JCheckBox checkBoxVegan;
    private JButton createButton;
    private JButton filterColorButton;
    private JButton filterWeightButton;
    private JButton filterPriceButton;
    private JButton filterVeganButton;
    private JButton weightButton;
    private JButton priceButton;
    private JComboBox<String> comboBoxRichtung;
    private JButton priceSumButton;
    private JTextField textFieldPriceSum;

    public InventoryGUI() {
        inv = new InventorySystem(); // One-time initialization of InventorySystem class

        initUI();

        refreshItemList(inv.getBags());
        initListeners();
    }

    private void initUI() {
        setTitle("Inventar Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setContentPane(myPanel);

        itemList.setVisibleRowCount(6);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //add(new JScrollPane(itemList));
        setVisible(true);
    }

    // takes bags from List and displays them in the itemList on the right side.
    // must be called each time when the 'Hinzufügen' or 'Filtern' button is pressed.
    private void refreshItemList(List<Bag> bags) {
        itemList.setListData(InventorySystem.toStringArray(bags));
    }

    // add bag on inventory
    // add bag on itemList by calling 'refreshItemList'
    private void addBag() {
        // parse arguments
        String color = getInputColor();
        double weight = getInputWeight();
        double price = getInputPrice();
        boolean isVegan = getInputVegan();

        // return, if some parameters are invalid
        if (weight == -1 || price == -1) {
            return;
        }
        // create bag object and add it to the 'bags' list
        inv.addBag(color, weight, isVegan, price);
        // show the updated 'bags' list on the right side of the GUI
        refreshItemList(inv.getBags());
    }


    // returns color string from 'comboBoxColor'
    // returns an empty string if no color is selected
    private String getInputColor() {
        Object selected = comboBoxColor.getSelectedItem();
        return selected != null ? selected.toString() : "";
    }


    private double parseDoubleField(JTextField field, String fieldName) {
        try {
            return Double.parseDouble(field.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Bitte Wert bei '" + fieldName + "' als Gleitkommazahl eingeben",
                    "Ungültige Eingabe",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    // parses and returns the weight specified on 'textFieldWeight'
    // throws an error message, if the weight is invalid
    private double getInputWeight() {
        return parseDoubleField(textFieldWeight, "Gewicht");
    }

    // parses and returns the price specified on 'textFieldPrice'
    // throws an error message, if the weight is invalid
    private double getInputPrice() {
        return parseDoubleField(textFieldPrice, "Preis");
    }

    // returns whether 'Vegan' is selected
    private boolean getInputVegan() {
        return checkBoxVegan.isSelected();
    }

    // returns whether 'Aufsteigen' is selected in comboBoxRichtung or not
    private boolean getAsc() {
        return Objects.requireNonNull(comboBoxRichtung.getSelectedItem()).toString().equals("Aufsteigend");
    }

    private void initListeners() {
        createButton.addActionListener(_ -> addBag());
        filterColorButton.addActionListener(_ -> {
            if (!getInputColor().isEmpty()) refreshItemList(inv.filterColor(getInputColor()));
        });
        filterWeightButton.addActionListener(_ -> {
            if (getInputWeight() != -1) refreshItemList(inv.filterWeight(getInputWeight()));
        });
        filterPriceButton.addActionListener(_ -> {
            if (getInputPrice() != -1) refreshItemList(inv.filterPrice(getInputPrice()));
        });
        filterVeganButton.addActionListener(_ -> refreshItemList(inv.filterVegan(getInputVegan())));
        priceButton.addActionListener(_ -> refreshItemList(InventorySystem.orderByPrice(inv.getBags(), getAsc())));
        weightButton.addActionListener(_ -> refreshItemList(InventorySystem.orderByWeight(inv.getBags(), getAsc())));
        priceSumButton.addActionListener(_ -> textFieldPriceSum.setText(String.format("%.2f €", inv.calcSum())));
    }
}
