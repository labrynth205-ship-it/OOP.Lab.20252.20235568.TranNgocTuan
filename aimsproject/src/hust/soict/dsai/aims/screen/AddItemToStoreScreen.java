package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected JTextField tfTitle = new JTextField(20);
    protected JTextField tfCategory = new JTextField(20);
    protected JTextField tfCost = new JTextField(20);
    protected JButton btnSubmit = new JButton("Add Item");

    public AddItemToStoreScreen(String title) {
        setTitle(title);
        setSize(400, 300);
        setLayout(new GridLayout(0, 2));

        add(new JLabel("Title:")); add(tfTitle);
        add(new JLabel("Category:")); add(tfCategory);
        add(new JLabel("Cost:")); add(tfCost);
        add(btnSubmit);
        
        setVisible(true);
    }
}