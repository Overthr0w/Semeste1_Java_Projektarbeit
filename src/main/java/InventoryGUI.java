import javax.swing.*;
import java.util.ArrayList;

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
    InventorySystem inv;

    public InventoryGUI() {
        setTitle("Inventar Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setContentPane(myPanel);
        setVisible(true);
        // One-time initialization of InventorySystem class
        inv = new InventorySystem();
        inv.initObjekte();
    }

    // takes objects from ArrayList and displays them in the itemList on the right side.
    // has to be called each time when the 'Hinzufügen' or 'Filtern' button is pressed.
    private void updateList(ArrayList<Bag> objects) {
        // TODO: https://stackoverflow.com/questions/16214480/adding-elements-to-a-jlist
        for (Bag b : inv.getBags()) {
            continue;
            // TODO: find out what components are, regarding JList
            //itemList.add(b);
        }
    }

}
