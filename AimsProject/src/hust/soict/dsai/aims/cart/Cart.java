package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private int qtyOrdered = 0;
	private DigitalVideoDisc itemOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private List<DigitalVideoDisc> itemsOrdered;

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
		 if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			 	itemsOrdered.add(disc);
	            System.out.println("The disc has been added");
	        } else {
	            System.out.println("The cart is almost full");
	        }
	}
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){ //method 1
        for (int i = 0; i < dvdList.length; i++){
            if (qtyOrdered <= MAX_NUMBERS_ORDERED){
                itemsOrdered.add(dvdList[i]);
                qtyOrdered++;
            } else {
                System.out.println("The cart is almost full");
                return;
            }
        }
        System.out.println("The disc has been added");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){ // method 2
        if(qtyOrdered <= MAX_NUMBERS_ORDERED){
            itemsOrdered.add(dvd1);
            qtyOrdered++;
            if(qtyOrdered <= MAX_NUMBERS_ORDERED){
                itemsOrdered.add(dvd2);
                qtyOrdered++;
                System.out.println("The disc has been added");
            } else {
                System.out.println("The cart is almost full");
            }
        }else {
        	System.out.println("The cart is full");
        	
        }
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int find = 0;
        String discName = disc.getTitle();
        for(int i = 0; i < itemsOrdered.size(); i++ ) {
        	DigitalVideoDisc item = itemsOrdered.get(i);
            if(item.getTitle().equals(discName)) {
                find = 1;
                itemsOrdered.remove(item);
                qtyOrdered--;
                i--;
            }
        }
        if(qtyOrdered == 0) {
            System.out.println("Your cart is empty");
            return;
        }
        if(find == 0) {
            System.out.println("Not found disc");
        } else {
            System.out.println("The disc has been removed");
        }
        return;
    }

	
	public float totalCost() {
        float sum = 0f;
        for(DigitalVideoDisc item : itemsOrdered) {
            sum += item.getCost();
        }
        return sum;
    }
	
	 public void print() {
	        System.out.println("***********************CART***********************");
	        System.out.println("Ordered Items:");
	        for (DigitalVideoDisc disc : itemsOrdered){
	            if (disc != null) {
	                System.out.println(disc);
	            }
	        }
	        System.out.println("Total cost: " + this.totalCost());
	        System.out.println("***************************************************");
	    }
	 public void searchDVDById(int id) {
	        boolean found = false;
	        List<DigitalVideoDisc> matchingDVDs = new ArrayList<>();

	        for (DigitalVideoDisc dvd : itemsOrdered) {
	            if (dvd.getId() == id) {
	                found = true;
	                matchingDVDs.add(dvd);
	            }
	        }
	        System.out.println("Ket qua tim kiem voi id " + id + ":");
	        if (found) {
	            for (DigitalVideoDisc dvd : matchingDVDs) {
	            	if (dvd != null) {
		                System.out.println(dvd);
		            }
	            }
	        } else {
	            System.out.println("Not found dvd with id " + id);
	        }
	    }
	 
	 public void searchDVDByTitle(String title) {
	        boolean found = false;
	        List<DigitalVideoDisc> matchingDVDs = new ArrayList<>();

	        for (DigitalVideoDisc dvd : itemsOrdered) {
	            if (dvd.isMatch(title)) {
	                found = true;
	                matchingDVDs.add(dvd);
	            }
	        }

	        if (found) {
	            System.out.println("Ket qua tim kiem voi title \"" + title + "\":");
	            for (DigitalVideoDisc dvd : matchingDVDs) {
	            	if (dvd != null) {
		                System.out.println(dvd);
		            }
	            }
	        } else {
	            System.out.println("No DVDs found voi title \"" + title + "\"");
	        }
	    }
	 
	 public void sortCartByTitle() {
	        Collections.sort(itemsOrdered, new Comparator<DigitalVideoDisc>() {
	            @Override
	            public int compare(DigitalVideoDisc o1, DigitalVideoDisc o2) {
	                String title1 = o1.getTitle();
	                String title2 = o2.getTitle();
	                int sComp = title1.compareTo(title2);

	                if (sComp != 0) {
	                    return sComp;
	                }
	                Float cost1 = o1.getCost();
	                Float cost2 = o2.getCost();
	                return cost1.compareTo(cost2);
	            }
	        });
	    }
	
}
