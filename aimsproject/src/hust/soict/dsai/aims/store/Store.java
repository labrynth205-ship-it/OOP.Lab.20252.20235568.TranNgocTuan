package aimsproject;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 20;
    private DVD[] itemsInStore = new DVD[MAX_ITEMS_IN_STORE];
   private int qtyInStore = 0;
    public void addDVD(DVD dvd) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD '" + dvd.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }
    public void removeDVD(DVD dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The DVD '" + dvd.getTitle() + "' has been removed from the store.");
                break;
            }
        }
        
        if (!found) {
            System.out.println("The DVD '" + dvd.getTitle() + "' is not in the store.");
        }
    }
}