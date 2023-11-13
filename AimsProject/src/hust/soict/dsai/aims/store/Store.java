package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
public class Store {
	private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
    public ArrayList<DigitalVideoDisc> getItemsInStore() {
        return itemsInStore;
    }

    public int addDVD(DigitalVideoDisc disc){
        itemsInStore.add(disc);
        System.out.println("The DVD has been added");
        return 1;
    }

    public int removeDVD(DigitalVideoDisc disc){
        if(itemsInStore.contains(disc)){
            itemsInStore.remove(disc);
            System.out.println("The DVD has been removed");
            return 1;
        }
        System.out.println("The DVD is not in the store");
        return 0;
    }
    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Store Items:");
        for (DigitalVideoDisc d : itemsInStore) {
            if(d != null) {
            	System.out.println(d);
            }
        }
        System.out.println("***************************************************");
    }

    public DigitalVideoDisc getDvd(String title) {
        for (DigitalVideoDisc disc : itemsInStore) {
            if (disc.getTitle().equals(title)) {
                return disc;
            }
        }
        return null;
    }
}
