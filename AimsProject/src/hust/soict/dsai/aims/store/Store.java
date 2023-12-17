package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public int addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media has been added");
        return 1;
    }

    public int removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media has been removed from the store");
            return 1;
        }
        System.out.println("The media is not in the store");
        return 0;
    }
    public void displayStore() {
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }
    
    public Media searchInStore(String title) {
        for (Media m: itemsInStore){
            if(m.isMatch(title)){
                return m;
            }
        }
        return null;
    }

    public Media getMedia(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equals(title)) {
            	System.out.println(m);
                return m;
            }
        }
        return null;
    }
    
    public void playMedia(String title) throws PlayerException {
        for (Media d : itemsInStore) {
            if (d.getTitle().equals(title) && d instanceof Playable) {
                try {
                    ((Playable)d).play();
                    break;
                } catch (PlayerException e) {
                    throw e;
                }
            }else {
            	throw new PlayerException("Media is not playable: " + title);
            }
        }
    }
}
