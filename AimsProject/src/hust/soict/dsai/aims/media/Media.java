package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

import hust.soict.dsai.aims.media.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.comparator.MediaComparatorTitleCost;

public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	private LocalDate dateAdded;
	
	private static int nbMedia = 0;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
	        new MediaComparatorTitleCost()
            .thenComparing(Media::getCost);;
	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
	        new MediaComparatorByCostTitle()
	        .thenComparing(Media::getTitle);
	public Media () {
    }

	public Media(String title) {
        this.title = title;
        this.dateAdded = LocalDate.now();
        nbMedia++;
        this.id = nbMedia;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.dateAdded = LocalDate.now();
        nbMedia++;
        this.id = nbMedia;
    }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	@Override
	public boolean equals(Object o) {
        try {
            return ((Media)o).getId() == this.id;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e1) {
            return false;
        }

    }
	
	public abstract boolean isMatch(String title);
	
	public boolean filterProperty(String filter, String type) {
        if (filter == null || filter.isEmpty()) {
            return true;
        } else {
            if (type == "title") {
                if (this.getTitle().toLowerCase().indexOf(filter.toLowerCase()) != -1) {
                    return true;
                }
            } else if (type == "id") {
                if(Integer.toString(this.getId()).toLowerCase().indexOf(filter.toLowerCase()) != -1) {
                    return true;
                }
            }
        }
        return false;
    }
	
}
