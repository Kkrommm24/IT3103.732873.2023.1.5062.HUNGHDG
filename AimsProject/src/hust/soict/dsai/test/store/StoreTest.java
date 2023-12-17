package hust.soict.dsai.test.store;

import java.util.ArrayList;
import java.util.List;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreManagerScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.screen.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	 public static void main(String[] args) throws LimitExceededException {
	        Store store = new Store();
	        Cart cart = new Cart();
	        List<Track> tracks = new ArrayList<>();
	        tracks.add(new Track("HungHDG 1", 30));
	        tracks.add(new Track("HungHDG 2", 0));
	        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 80, 19.95f);
	        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 83, 24.95f);
	        CompactDisc cd3 = new CompactDisc("Warriors", "Music", "Imagine", "Dragon", 15.0f, tracks);

	        List<String> authors1 = new ArrayList<String>();
	        authors1.add("lmaooooo");
	      Book book1 = new Book("Hello World", "Action and adventure",
	                25.5f, authors1, 36, "Content1");                    
	        List<String> authors2 = new ArrayList<>();
	        authors2.add("Hello it's HungHDG");
	        authors2.add("HungHDG");
	        Book book2 = new Book("Hello it's HungHDG", "Action",
	                15.8f, authors2, 24, "Content2");

	        store.addMedia(dvd1);
	        store.addMedia(dvd2);
	        store.addMedia(cd3);
	        store.addMedia(book1);
	        store.addMedia(book2);
	        
	        cart.addMedia(dvd1);
	        cart.addMedia(cd3);
	        cart.addMedia(book2);
	        cart.displayCart();
//	        new StoreScreen(store);
//	        CartScreen cartscreen = new CartScreen(cart, store);
//	        StoreManagerScreen sms = new StoreManagerScreen(cart, store);
	    }

}
