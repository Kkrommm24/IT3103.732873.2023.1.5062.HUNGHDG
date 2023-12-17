package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        super(title, category, cost, length, director);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public CompactDisc(String title, String category, String director, String artist, float cost, List<Track> tracks) {
        super(title, category, director, cost);
        this.tracks = tracks;
        this.artist = artist;
    }
	
	public boolean addTrack(Track newTrack) {
        if(tracks.contains(newTrack)){
            return false;
        } else {
            tracks.add(newTrack);
            return true;
        }
    }

    public boolean remoteTrack(Track track) {
        if(tracks.contains(track)){
            tracks.remove(track);
            return true;
        } else {
            return false;
        }
    }
    
    public int getLength(){
        int result = 0;
        for (Track track : tracks){
            result += track.getLength();
        }
        return result;
    }
    
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
    @Override
    public StringBuffer play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());

            StringBuffer info = new StringBuffer("");
            info.append("Playing CD: " + this.getTitle() + "\n" + "CD length: " 
            		+ this.getLength() + "\n");

            for (Track t : tracks) {
                try {
                    StringBuffer trackInfo = t.play();
                    info.append(trackInfo + "\n");
                } catch (PlayerException e) {
                    throw e;
                }
            }
            return info;
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

    }
    
    @Override
    public String toString() {
        return this.id + ". " + "CD" + " - " + this.getTitle() 
        	+ " - " + this.getCategory() + " - " + this.getDirector() + " - " 
        	+ this.getLength() + " - " + this.getArtist() + " - " 
        	+ ": " + this.getCost() + " $";
    }
	
    @Override
    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }
}
