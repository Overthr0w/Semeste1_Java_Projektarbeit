import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class InventoryGUI extends JFrame {
    private final InventorySystem inv;
    private JPanel myPanel;
    private JList<String> itemList;
    private JScrollPane scrollPane;
    private JComboBox comboBoxColor;
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
    private JComboBox comboBoxRichtung;
    private JButton priceSumButton;
    private JTextField textFieldPriceSum;

    public InventoryGUI() {
        inv = new InventorySystem(); // One-time initialization of InventorySystem class

        setTitle("Inventar Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 320);
        setContentPane(myPanel);

        itemList.setVisibleRowCount(6);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //add(new JScrollPane(itemList));
        setVisible(true);

        updateList(inv.getBags());
        initListeners();
    }

    // takes bags from ArrayList and displays them in the itemList on the right side.
    // must be called each time when the 'Hinzufügen' or 'Filtern' button is pressed.
    private void updateList(ArrayList<Bag> bags) {
        itemList.setListData(InventorySystem.toStringArray(bags));
    }

    // add bag on inventory
    // add bag on itemList by calling 'updateList'
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
        double weight = -1;
        try {
            weight = Double.parseDouble(textFieldWeight.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bitte Wert bei 'Gewicht' als Gleitkommazahl eingeben", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
        }
        return weight;
    }

    // parses and returns the price specified on 'textFieldPrice'
    // throws an error message, if the weight is invalid
    private double getInputPrice() {
        double price = -1;
        try {
            price = Double.parseDouble(textFieldPrice.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bitte Wert bei 'Preis' als Gleitkommazahl eingeben", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
        }
        return price;
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
            if (!getInputColor().isEmpty()) {
                updateList(inv.filterColor(getInputColor()));
            }
        });
        filterWeightButton.addActionListener(_ -> {
            if (getInputWeight() != -1) {
                updateList(inv.filterWeight(getInputWeight()));
            }
        });
        filterPriceButton.addActionListener(_ -> {
            if (getInputPrice() != -1) {
                updateList(inv.filterPrice(getInputPrice()));
            }
        });
        filterVeganButton.addActionListener(_ -> updateList(inv.filterVegan(getInputVegan())));
        priceButton.addActionListener(_ -> updateList(InventorySystem.orderByPrice(inv.getBags(), getAsc())));
        weightButton.addActionListener(_ -> updateList(InventorySystem.orderByWeight(inv.getBags(), getAsc())));
        priceSumButton.addActionListener(_ -> textFieldPriceSum.setText(String.format("%.2f €", inv.calcSum())));
    }
}
