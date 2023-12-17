package hust.soict.dsai.aims.cart;

import java.util.List;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private int qtyOrdered = 0;
	 private ObservableList<Media> itemsOrdered =
	            FXCollections.observableArrayList();
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	
	 public ObservableList<Media> getItemsOrdered() {
	        return itemsOrdered;
	    }

//	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
//	       if(qtyOrdered > MAX_NUMBERS_ORDERED) {
//	           System.out.println("The cart is almost full");
//	           return;
//	       } else {
//	           qtyOrdered++;
//	           itemsOrdered.add(disc);
//	           System.out.println("The disc has been added");
//	       }
//	       return;
//	}
	 public int addMedia(Media media) throws LimitExceededException {
	        if (itemsOrdered.size() <  MAX_NUMBERS_ORDERED) {
	            itemsOrdered.add(media);
	            System.out.println("The media has been added to the cart");
	            return 1;
	        } else {
	            throw new LimitExceededException("ERROR: The cart is almost full");
	        }
	    }
	public int addMedia(Media media1, Media media2) throws LimitExceededException {
        int countAdded = 0;
        try {
            countAdded += addMedia(media1);
            countAdded += addMedia(media2);
        } catch (LimitExceededException e) {
            throw e;
        }

        return countAdded;
    }
	public int addMedia(ArrayList<Media> medias) throws LimitExceededException {
        int countAdded = 0;
        for (Media media : medias) {
            try {
                countAdded += addMedia(media);
            } catch (LimitExceededException e) {
                throw e;
            }
        }
        return countAdded;
    }
	public int removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed from the cart");
            return 1;
        }
        System.out.println("The media is not in the cart");
        return 0;
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
    
//	Chức năng thêm item may mắn khi ấn đặt hàng với số lượng >= 2
    public Media getALuckyItem() {
        if (itemsOrdered.size() >= 2) {
            int index = (int)(Math.random() * itemsOrdered.size());
            Media luckyItem = itemsOrdered.get(index);
            System.out.println("The lucky item: " + luckyItem);

            removeMedia(luckyItem);
            System.out.println("The bill of this order is now " + totalCost());

            return luckyItem;
        }
        return null;
    }
	
    public void playMedia(String title) throws PlayerException {
        for (Media d : itemsOrdered) {
            if (d.getTitle().equals(title)) {
                ((Playable)d).play();
            }
        }
    }
	
}
