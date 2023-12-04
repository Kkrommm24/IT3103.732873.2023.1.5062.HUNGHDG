package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	 public static void main(String[] args) {
	        Cart cart = new Cart();
	        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
	                "Animation", "Roger Allers", 87, 19.95f);
	        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
	                "Science Fiction", "George Lucas", 87, 24.95f);
	        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
	                "Animation", 18.99f);
	        cart.addDigitalVideoDisc(dvd1);
	        cart.addDigitalVideoDisc(dvd2);
	        cart.addDigitalVideoDisc(dvd3);
//	        cart.print();
//	        cart.searchDVDById(1);
//	        cart.searchDVDById(4);
//	        cart.searchDVDByTitle("The Lion King");
//	        cart.searchDVDByTitle("HungHDG5062");
	    }
	 
}
