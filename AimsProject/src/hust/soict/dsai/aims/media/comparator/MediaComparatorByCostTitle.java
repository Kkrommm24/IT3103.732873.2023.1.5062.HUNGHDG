package hust.soict.dsai.aims.media.comparator;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	@Override
    public int compare(Media o1, Media o2) {
        float cost1 = o1.getCost();
        float cost2 = o2.getCost();
        int costComparison = Float.compare(cost1, cost2);

        if (costComparison != 0) {
            return costComparison;
        }

        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        return title1.compareTo(title2);
    }
}
