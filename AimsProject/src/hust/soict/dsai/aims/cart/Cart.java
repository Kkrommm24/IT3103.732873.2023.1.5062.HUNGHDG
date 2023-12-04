package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private int qtyOrdered = 0;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public Cart() {
        qtyOrdered = 0;
        itemsOrdered = new ArrayList<>(MAX_NUMBERS_ORDERED);
    }
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
	       if(qtyOrdered > MAX_NUMBERS_ORDERED) {
	           System.out.println("The cart is almost full");
	           return;
	       } else {
	           qtyOrdered++;
	           itemsOrdered.add(disc);
	           System.out.println("The disc has been added");
	       }
	       return;
	}
	public boolean addMedia(Media m) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            return false;
        } else {
            itemsOrdered.add(m);
            return true;
        }
    }
	public boolean addMedia(Media m1, Media m2) {
        if (itemsOrdered.size() <= MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(m1);
            if (itemsOrdered.size() <= MAX_NUMBERS_ORDERED) {
                itemsOrdered.add(m2);
                System.out.println("Add Media into cart successfully!");
                return true;
            } else {
                System.out.println("The cart is almost full");
                return false;
            }
        } else {
            return false;
        }
    }
	
	public boolean removeMedia(Media m) {
        if (itemsOrdered.contains(m)) {
            itemsOrdered.remove(m);
            System.out.println("Add Media successfully");
            return true;
        } else {
            System.out.println("This media has not been added to the cart");
            return false;
        }
    }
	public int numberDVDsInCart(){
        int count = 0;
        for (Media m : itemsOrdered){
            if (m instanceof DigitalVideoDisc){
                count++;
            }
        }
        return count;
    }
    public float totalCost() {
        float sum = 0f;
        for(Media m : itemsOrdered) {
            sum += m.getCost();
        }
        return sum;
    }

    public void displayCart() {
        int index = 0;
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media m : itemsOrdered){
            if (m != null) {
                index++;
                System.out.println(index + ". " + m);
            }
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("***************************************************");
    }

    public Media searchInCart(int id){
        for (Media m: itemsOrdered){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public Media searchInCart(String title) {
        for (Media m: itemsOrdered){
            if(m.isMatch(title)){
                return m;
            }
        }
        return null;
    }
    
    /**
     * Sort the items in the cart by title and cost.
     */
    public void sortCartByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    /**
     * Sort the items in the cart by cost, then by title.
     */
    public void sortCartByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
	 
	
}
