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
        // Einmaliges Initialisieren der InventorySystem Klasse
        inv = new InventorySystem();
        inv.initObjekte();
    }

    // nimmt die Objekte aus der ArrayList und stellt diese in der Listenansicht rechts dar.
    // muss nach dem Erstellen oder Filtern neu aufgerufen werden.
    private void updateList(ArrayList<Bag> objects) {
        // TODO: https://stackoverflow.com/questions/16214480/adding-elements-to-a-jlist
        // find out what components are, regarding JList
        for (Bag b : inv.getBags()) {
            continue;
            //itemList.add(b);
        }
    }

}
