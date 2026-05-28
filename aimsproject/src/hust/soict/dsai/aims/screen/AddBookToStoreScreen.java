package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthor = new JTextField(20);

    public AddBookToStoreScreen(Store store) {
        super("Add Book");
        add(new JLabel("Author:")); add(tfAuthor);
        
        btnSubmit.addActionListener(e -> {
            Book book = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()));
            book.addAuthor(tfAuthor.getText());
            store.addMedia(book);
            JOptionPane.showMessageDialog(null, "Book added!");
            dispose();
        });
    }
}