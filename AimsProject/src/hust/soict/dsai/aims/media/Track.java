package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable {
	private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!(o instanceof Track)) {
            return false;
        }

        Track track = (Track) o;
        return Objects.equals(title, track.title) && Objects.equals(length, track.length);
    }


}

