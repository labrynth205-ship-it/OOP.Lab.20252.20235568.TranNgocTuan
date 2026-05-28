package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DVD;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector = new JTextField(20);
    private JTextField tfLength = new JTextField(20);

    public AddDVDToStoreScreen(Store store) {
        super("Add DVD");
        add(new JLabel("Director:")); add(tfDirector);
        add(new JLabel("Length:")); add(tfLength);
        
        btnSubmit.addActionListener(e -> {
            DVD dvd = new DVD(tfTitle.getText(), tfCategory.getText(), 
                                                        tfDirector.getText(), Integer.parseInt(tfLength.getText()), 
                                                        Float.parseFloat(tfCost.getText()));
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(null, "DVD added to store!");
            dispose();
        });
    }
}