package hust.soict.dsai.aims.media;

import java.util.Objects;

import hust.soict.dsai.aims.exception.PlayerException;

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
    public StringBuffer play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());

            StringBuffer info = new StringBuffer("");
            info.append("Playing track: " + this.getTitle() + "\n" + "Track length: " + this.getLength());
            return info;
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }

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

