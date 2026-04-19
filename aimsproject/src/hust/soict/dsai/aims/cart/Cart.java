package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DVD;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DVD[] itemsOrdered = new DVD[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DVD disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full");
            }
        } else {
            System.out.println("The cart is full. Cannot add more discs!");
        }
    }
    public void addDigitalVideoDisc(DVD[] dvdList) {
        for (DVD disc : dvdList) {
          this.addDigitalVideoDisc(disc);
        }
        }
    public void addDigitalVideoDisc(DVD dvd1, DVD dvd2) {
        this.addDigitalVideoDisc(dvd1);
        this.addDigitalVideoDisc(dvd2);
    }
    public void removeDigitalVideoDisc(DVD disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }
    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
    // Hàm in danh sách đĩa trong giỏ hàng
    public void print() {
        System.out.println("Ordered Items:");
        for (int i = 0; i < this.qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + this.totalCost() + " $");
    }
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < this.qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found by ID (" + id + "): " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < this.qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found by Title (" + title + "): " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }
}