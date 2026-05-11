package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        anOrder.addMedia(dvd2);
        DVD dvd3 = new DVD("Aladdin", "Animation", 18.99f);
        anOrder.addMedia(dvd3);
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        anOrder.addMedia(dvd2);
        System.out.println("Total Cost after removing Star Wars is: " + anOrder.totalCost());
    }
}