package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaTest {
    public static void main(String[] args) {
        // Create an ArrayList of Media
        ArrayList<Media> mediae = new ArrayList<>();
        List<Track> tracks = new ArrayList<>();
        List<String> authors = new ArrayList<>();

        // Create a CompactDisc with tracks
        tracks.add(new Track("HungHDG 1", 30));
        tracks.add(new Track("HungHDG 2", 40));
        CompactDisc cd = new CompactDisc(1, "A", "Music", 15.0f, "HungHDG", "HungHDG", tracks);

        // Create a DigitalVideoDisc
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "C", "Movie", 25.0f, 120, "HungHDG");

        // Create a Book with authors
        authors.add("HungHDG 1");
        authors.add("HungHDG 2");
        Book book = new Book(3, "B", "Programming", 29.99f, authors);

        // Add some media objects (CD, DVD, or Book) into the list
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // Iterate through the list and print out the information using toString()
        for (Media media : mediae) {
            System.out.println(media.toString());
        }
        
        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted by Title then Cost:");
        for (Media media : mediae) {
            System.out.println(media.toString());
        }

        // Sort by cost then title
        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
        System.out.println("\nSorted by Cost then Title:");
        for (Media media : mediae) {
            System.out.println(media.toString());
        }
    }
}


