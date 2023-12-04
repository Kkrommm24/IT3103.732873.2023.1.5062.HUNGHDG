package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Objects;

import hust.soict.dsai.aims.media.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.comparator.MediaComparatorTitleCost;

public abstract class Media {
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
	        new MediaComparatorTitleCost()
            .thenComparing(Media::getCost);;
	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
	        new MediaComparatorByCostTitle()
	        .thenComparing(Media::getTitle);
	public Media () {
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
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
	    if (this == o) {
	        return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	        return false;
	    }
	    if (!(o instanceof Media)) {
	        return false;
	    }

	    Media media = (Media) o;
	    return Objects.equals(title, media.title);
	}
	
	public abstract boolean isMatch(String title);
	
}
