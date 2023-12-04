package hust.soict.dsai.aims.media.comparator;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorTitleCost implements Comparator<Media> {
	@Override
    public int compare(Media o1, Media o2) {
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        int titleComparison = title1.compareTo(title2);

        if (titleComparison != 0) {
            return titleComparison;
        }

        float cost1 = o1.getCost();
        float cost2 = o2.getCost();
        return Float.compare(cost1, cost2);
    }
}
