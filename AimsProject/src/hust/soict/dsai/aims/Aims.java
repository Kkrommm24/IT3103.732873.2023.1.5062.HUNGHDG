package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("-----------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("-----------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("-----------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("-----------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("-----------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("-----------------------");
        System.out.println("Please choose a number: 0-1-2");
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
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    
    public static String generateRandomId() {
        Random random = new Random();
        int length = 8; // Desired length of the ID
        StringBuilder idBuilder = new StringBuilder();
        for (int i = 4; i < length; i++) {
            char digit = (char) (random.nextInt(10) + '0'); // Generate a random digit character
            idBuilder.append(digit);
        }
        return idBuilder.toString();
    }
    public static void defaultList(Store store) {
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track("HungHDG 1", 30));
        tracks.add(new Track("HungHDG 2", 40));
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 80, "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 83, "George Lucas");
        CompactDisc dvd3 = new CompactDisc(3, "Warriors", "Music", 15.0f, "HungHDG", "HungHDG", tracks);

        List<String> authors1 = new ArrayList<String>();
        authors1.add("lmaooooo");
        Book book1 = new Book(4, "Hello World", "Action and adventure",
                25.5f, authors1);
        List<String> authors2 = new ArrayList<>();
        authors2.add("Hello it's HungHDG");
        authors2.add("HungHDG");
        Book book2 = new Book(5, "Hello it's HungHDG", "Action",
                15.8f, authors2);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
    }
    
    private static boolean isValidType(String type) {
        return type.equalsIgnoreCase("Book") || type.equalsIgnoreCase("CompactDisc") || type.equalsIgnoreCase("DigitalVideoDisc");
    }
	public static void main(String[] args) {
		Store store = new Store();
        defaultList(store); // add default list
        Cart cart = new Cart();

        int opt = 1, storeOpt = 1, mediaOpt = 1, cartOpt = 1, filterOpt = 1, sortOpt = 1;
        String title;
        String type;
        Scanner sc = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        Scanner user = new Scanner(System.in);
        Media mediaStore, mediaCart;

        do {
            showMenu();
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    store.displayStore();
                    do {
                        storeMenu();
                        storeOpt = sc.nextInt();
                        switch (storeOpt) {
                            case 1: //1. See a media’s details
                                System.out.print("Enter title of media: ");
                                title = scString.nextLine(); //enter title of media want to view
                                mediaStore = store.searchInStore(title); //search media
                                if (mediaStore != null) {
//                                	store.getMedia(title); //display that media detail
                                	System.out.print(mediaStore.toString() + '\n'); 
                                    do {
                                        mediaDetailsMenu();
                                        mediaOpt = sc.nextInt();
                                        switch (mediaOpt) {
                                            case 1: cart.addMedia(mediaStore); System.out.println("Add media to cart successfully!"); break;
                                            case 2:
                                            	if (mediaStore instanceof CompactDisc) {
                                                    ((CompactDisc) mediaStore).play();
                                                }else if (mediaStore instanceof DigitalVideoDisc) {
                                                    ((DigitalVideoDisc) mediaStore).play();
                                                }
                                                else {
                                                    System.out.println("This media can not play !");
                                                }
                                                break;
                                            case 0: break;
                                            default: System.out.println("Option invalid !"); break;
                                        }
                                    } while (mediaOpt != 0);
                                } else {
                                    System.out.println("Media does not exits in store !");
                                }
                                break;
                            case 2: //2. Add media to cart
                                System.out.print("Enter title of media: ");
                                title = scString.nextLine(); //enter title of media want to view
                                mediaStore = store.searchInStore(title); //search media
                                if (mediaStore != null) {
                                    cart.addMedia(mediaStore);
                                    System.out.println("Add media to cart successfully!");
                                    if(mediaStore instanceof Disc){
                                        System.out.println("Current cart has " + cart.numberDVDsInCart() + " DVDs");
                                    }
                                } else {
                                    System.out.println("Media does not exits in store");
                                }
                                break;
                            case 3: // 3. Play a media
                                System.out.print("Enter title of media: ");
                                title = scString.nextLine(); //enter title of media want to view
                                mediaStore = store.searchInStore(title); //search media
                                if (mediaStore != null) {
                                    if (mediaStore instanceof DigitalVideoDisc) {
                                        ((DigitalVideoDisc) mediaStore).play();
                                    }else if (mediaStore instanceof CompactDisc) {
                                        ((CompactDisc) mediaStore).play();
                                    } else {
                                        System.out.println("This is not an DVD nor CD");
                                    }
                                } else {
                                    System.out.println("Media does not exits in store");
                                }
                                break;
                            case 4:
                                System.out.println("Current cart: ");
                                cart.displayCart();
                                break;
                            case 0: break;
                            default: System.out.println("Option invalid"); break;
                        }
                    } while (storeOpt != 0);
                    break;

                case 2:
                    updateStoreMenu();
                    int updateOpt = user.nextInt();
                    do{
                        switch (updateOpt) {
                            case 1: // add DVD
                                System.out.println("Please insert the details of the Media: ");
                                System.out.println("--------------------------------");
                                do {
                                    System.out.println("Type (Book/CompactDisc/DigitalVideoDisc): ");
                                    type = sc.nextLine();

                                    if (!isValidType(type)) {
                                        System.out.println("Invalid type. Please enter Book, CompactDisc, or DigitalVideoDisc.");
                                    }
                                } while (!isValidType(type));
                                
                                System.out.println("Title: ");
                                user.nextLine(); //consume blank
                                title = user.nextLine();
                                System.out.println("Category: ");
                                String category = user.nextLine();
                                System.out.println("Cost: ");
                                float cost = user.nextFloat();
                                String id = generateRandomId();
                                DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost);
                                store.addMedia(dvd);
                                break;
                            case 2: //remove DVD
                                System.out.println("Enter the title: ");
                                user.nextLine();
                                title = user.nextLine();
                                Media DVD = store.getMedia(title);
                                store.removeMedia(DVD);
                                break;
                            case 0: break;
                            default: System.out.println("Invalid option!");
                        }
                        updateStoreMenu();
                        updateOpt = user.nextInt();
                    } while (updateOpt != 0);
                    break;
                    
                case 3: // 3. See current cart
                    System.out.println("Current cart");
                    cart.displayCart();
                    do {
                        cartMenu();
                        cartOpt = sc.nextInt();
                        sc.nextLine();
                        switch (cartOpt) {
                            case 1: // 1. Filter medias in cart
                                System.out.println("Enter 1 to filter by id or 2 to filter by title");
                                filterOpt = sc.nextInt();
                                sc.nextLine();
                                if (filterOpt == 1) {
                                    int idToFilter = sc.nextInt();
                                    mediaCart = cart.searchInCart(idToFilter);
                                } else {
                                    String titleToFilter = sc.nextLine();
                                    mediaCart = cart.searchInCart(titleToFilter);
                                }
                                if (mediaCart != null) {
                                    System.out.println("Product found: ");
                                    System.out.print(mediaCart.toString() + '\n'); 
                                } else {
                                    System.out.println("Not found!");
                                }
                                break;
                            case 2: // 2. Sort medias in cart
                                System.out.println("Enter 1 to sort by title or 2 to sort by cost");
                                sortOpt = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Current cart after sort: ");
                                if (sortOpt == 1) {
                                    cart.sortCartByTitle();
                                    cart.displayCart();
                                } else {
                                    cart.sortCartByCost();
                                    cart.displayCart();
                                }
                                break;
                            case 3:
                                System.out.print("Enter title of media want to remove:  ");
                                title = scString.nextLine();
                                mediaCart = cart.searchInCart(title);
                                if(mediaCart != null){
                                    cart.removeMedia(mediaCart);
                                    System.out.println("Current cart: ");
                                    cart.displayCart();
                                } else {
                                    System.out.println("Media does not exist in cart!");
                                }
                                break;
                            case 4:
                                System.out.print("Enter title of media want to play:  ");
                                title = scString.nextLine();
                                mediaCart = cart.searchInCart(title);
                                if(mediaCart != null){
                                    ((DigitalVideoDisc) mediaCart).play();
                                } else {
                                    System.out.println("Media does not exist in cart!");
                                }
                                break;
                            case 5:
                                System.out.println("An order is created!");
                                cart = new Cart(); break;
                            case 0: break;
                            default: System.out.println("Invalid option!"); break;
                        }
                    } while (cartOpt != 0);
                    break;
                case 0: break;
                default: System.out.println("Invalid option!");
            }
        } while (opt != 0);
    }
}
