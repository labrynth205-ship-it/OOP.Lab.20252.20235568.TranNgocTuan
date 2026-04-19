package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DVD;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);
        DVD dvd3 = new DVD("Animation", "Aladin", 18.99f); 
        cart.addDigitalVideoDisc(dvd3);
        cart.print();
        System.out.println("\n search by id");
        cart.searchById(1);
        cart.searchById(5);

        System.out.println("\n search by title");
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Nemo"); 
    }
}