package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Track;

public class StoreScreenTest {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DVD dvd3 = new DVD("Aladdin", "Animation", 18.99f);

        Book book1 = new Book("The Valley of Fear", "Detective", 20.00f);
        book1.addAuthor("Arthur Conan Doyle");
        Book book2 = new Book("A Living Minstrel", "Poem", 12.00f);
        book2.addAuthor("Victor Hugo");

        CompactDisc cd1 = new CompactDisc("Adele 21", "Music", "Adele", 15.00f, "Adele");
        Track track1 = new Track("Rolling in the Deep", 228);
        Track track2 = new Track("Someone Like You", 285);
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(cd1);

        new StoreScreen(store, cart);
    }
}