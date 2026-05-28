package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist = new JTextField(20);

    public AddCompactDiscToStoreScreen(Store store) {
        super("Add CD");
        add(new JLabel("Artist:")); add(tfArtist);
        
        btnSubmit.addActionListener(e -> {
            CompactDisc cd = new CompactDisc(tfTitle.getText(), tfCategory.getText(), 
                                            tfArtist.getText(), Float.parseFloat(tfCost.getText()), "Unknown");
            store.addMedia(cd);
            JOptionPane.showMessageDialog(null, "CD added to store!");
            dispose();
        });
    }
}