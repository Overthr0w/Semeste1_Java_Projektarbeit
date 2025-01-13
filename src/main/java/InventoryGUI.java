import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class InventoryGUI extends JFrame {
    private JPanel myPanel;
    private JList<String> itemList;
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
    private JButton filterColorButton;
    private JButton filterWeightButton;
    private JButton filterPriceButton;
    private JButton filterVeganButton;
    private JButton gewichtButton;
    private JButton preisButton;
    private JComboBox comboBoxRichtung;
    private JButton priceSumButton;
    private JTextField textFieldPriceSum;
    private JLabel priceSumLabel;
    private final InventorySystem inv;

    public InventoryGUI() {
        inv = new InventorySystem(); // One-time initialization of InventorySystem class

        setTitle("Inventar Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 300);
        setContentPane(myPanel);

        itemList.setVisibleRowCount(6);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //add(new JScrollPane(itemList));
        setVisible(true);

        updateList(inv.getBags());
        initListeners();


        priceSumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldPriceSum.setText(String.format("%.2f €", inv.calcSum()));
            }
        });
    }

    // takes objects from ArrayList and displays them in the itemList on the right side.
    // must be called each time when the 'Hinzufügen' or 'Filtern' button is pressed.
    public void updateList(ArrayList<Bag> objects) {
        itemList.setListData(InventorySystem.toStringArray(objects));
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
    private double getInputWeight () {
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
    private double getInputPrice () {
        double price = -1;
        try {
            price = Double.parseDouble(textFieldPrice.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bitte Wert bei 'Preis' als Gleitkommazahl eingeben", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
        }
        return price;
    }

    // returns whether 'Vegan' is selected
    private boolean getInputVegan () {
        return checkBoxVegan.isSelected();
    }

    private boolean getAsc() {
        if (comboBoxRichtung.getSelectedItem().toString().equals("Aufsteigend")) {
            return true;
        }
        return false;
    }

    private void initListeners () {
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
        preisButton.addActionListener(_ -> {
            updateList(inv.orderByPrice(inv.getBags(), getAsc()));
        });
        gewichtButton.addActionListener(_ -> {
            updateList(inv.orderByWeight(inv.getBags(), getAsc()));
        });
    }
}
