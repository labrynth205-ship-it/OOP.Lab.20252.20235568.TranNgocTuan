package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }
public static void main(String[] args) {
        store.addMedia(new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DVD("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
        store.addMedia(new DVD("Aladdin", "Animation", "John Musker", 90, 18.99f));

        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    store.print();
                    int storeChoice = -1;
                    while (storeChoice != 0) {
                        storeMenu();
                        storeChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (storeChoice) {
                            case 1:
                                System.out.print("Enter the title of the media: ");
                                String titleDetails = scanner.nextLine();
                                Media mediaDetails = store.searchByTitle(titleDetails);
                                if (mediaDetails != null) {
                                    System.out.println("Details: " + mediaDetails.toString());
                                    int detailsChoice = -1;
                                    while (detailsChoice != 0) {
                                        mediaDetailsMenu();
                                        detailsChoice = scanner.nextInt();
                                        scanner.nextLine();
                                        if (detailsChoice == 1) {
                                            cart.addMedia(mediaDetails);
                                            System.out.println("Media added to cart.");
                                        } else if (detailsChoice == 2) {
                                            if (mediaDetails instanceof Playable) {
                                                if (mediaDetails instanceof Playable) {
                                                    try {
                                                        ((Playable) mediaDetails).play();
                                                    } catch (PlayerException e) {
                                                        System.err.println("Cannot play media: " + e.getMessage());
                                                    }
                                                    } else {
                                                        System.out.println("This media cannot be played.");
                                                    }
                                            } else {
                                                System.out.println("This media cannot be played.");
                                            }
                                        } else if (detailsChoice != 0) {
                                            System.out.println("Invalid choice!");
                                        }
                                    }
                                } else {
                                    System.out.println("Media not found in store!");
                                }
                                break;

                            case 2:
                                System.out.print("Enter the title of the media to add to cart: ");
                                String titleAdd = scanner.nextLine();
                                Media mediaAdd = store.searchByTitle(titleAdd);
                                if (mediaAdd != null) {
                                    cart.addMedia(mediaAdd);
                                } else {
                                    System.out.println("Media not found in store!");
                                }
                                break;

                            case 3:
                                System.out.print("Enter the title of the media to play: ");
                                String titlePlay = scanner.nextLine();
                                Media mediaPlay = store.searchByTitle(titlePlay);
                                if (mediaPlay != null) {
                                    if (mediaPlay instanceof Playable) {
                                        if (mediaPlay instanceof Playable) {
                                            try {
                                                ((Playable) mediaPlay).play();
                                            } catch (PlayerException e) {
                                                System.err.println("Cannot play media: " + e.getMessage());
                                            }
                                            } else {
                                                System.out.println("This media cannot be played.");
                                            }
                                    } else {
                                        System.out.println("This media cannot be played.");
                                    }
                                } else {
                                    System.out.println("Media not found in store!");
                                }
                                break;

                            case 4:
                                cart.print();
                                break;

                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("Invalid choice! Please choose again.");
                        }
                    }
                    break;

                case 2:
                    // UPDATE STORE
                    System.out.println("--- UPDATE STORE ---");
                    System.out.println("1. Add a media to store");
                    System.out.println("2. Remove a media from store");
                    System.out.println("0. Back");
                    System.out.print("Please choose an option: ");
                    int updateChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (updateChoice == 1) {
                        System.out.print("Enter title of the new DVD: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Enter category: ");
                        String newCategory = scanner.nextLine();
                        System.out.print("Enter cost: ");
                        float newCost = scanner.nextFloat();
                        scanner.nextLine();
                        store.addMedia(new DVD(newCategory, newTitle, newCost));
                    } else if (updateChoice == 2) {
                        System.out.print("Enter the title of the media to remove: ");
                        String titleRemove = scanner.nextLine();
                        Media mediaToRemove = store.searchByTitle(titleRemove);
                        if (mediaToRemove != null) {
                            store.removeMedia(mediaToRemove);
                        } else {
                            System.out.println("Media not found!");
                        }
                    }
                    break;

                case 3:
                    cart.print();
                    int cartChoice = -1;
                    while (cartChoice != 0) {
                        cartMenu();
                        cartChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (cartChoice) {
                            case 1:
                                System.out.println("1. Filter by ID\n2. Filter by Title");
                                System.out.print("Choose option: ");
                                int filterChoice = scanner.nextInt();
                                scanner.nextLine();
                                if (filterChoice == 1) {
                                    System.out.print("Enter ID: ");
                                    int id = scanner.nextInt();
                                    scanner.nextLine();
                                    cart.searchById(id);
                                } else if (filterChoice == 2) {
                                    System.out.print("Enter Title: ");
                                    String title = scanner.nextLine();
                                    cart.searchByTitle(title);
                                }
                                break;

                            case 2:
                                System.out.println("1. Sort by Title\n2. Sort by Cost");
                                System.out.print("Choose option: ");
                                int sortChoice = scanner.nextInt();
                                scanner.nextLine();
                                if (sortChoice == 1) {
                                    cart.sortByTitleCost();
                                    cart.print();
                                } else if (sortChoice == 2) {
                                    cart.sortByCostTitle();
                                    cart.print();
                                } else {
                                    System.out.println("Invalid choice!");
                                }
                                break;

                            case 3:
                                System.out.print("Enter the title of the media to remove: ");
                                String titleCartRemove = scanner.nextLine();
                                Media mediaCartRemove = cart.searchMediaByTitle(titleCartRemove);
                                if (mediaCartRemove != null) {
                                    cart.removeMedia(mediaCartRemove);
                                } else {
                                    System.out.println("Media not found in cart!");
                                }
                                break;

                            case 4:
                                System.out.print("Enter the title of the media to play: ");
                                String titleCartPlay = scanner.nextLine();
                                Media mediaCartPlay = cart.searchMediaByTitle(titleCartPlay);
                                if (mediaCartPlay != null) {
                                    if (mediaCartPlay instanceof Playable) {
                                        if (mediaCartPlay instanceof Playable) {
                                            try {
                                                ((Playable) mediaCartPlay).play();
                                            } catch (PlayerException e) {
                                                // In ra thông báo lỗi thay vì để crash
                                                System.err.println("Cannot play media: " + e.getMessage());
                                            }
                                        } else {
                                            System.out.println("This media cannot be played.");
                                            }
                                    } else {
                                        System.out.println("This media cannot be played.");
                                    }
                                } else {
                                    System.out.println("Media not found in cart!");
                                }
                                break;

                            case 5:
                                System.out.println("An order has been created! Your cart is now empty.");
                                cart = new Cart();
                                break;

                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("Invalid choice!");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}