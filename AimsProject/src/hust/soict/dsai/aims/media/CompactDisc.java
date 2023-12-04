package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc() {
		
	}
	public CompactDisc(String title) {
		this.title = title;
	}
	
	public CompactDisc(int id, String title, String category, float cost, String director, String artist, List<Track> tracks) {
		super(id, title, category, cost, director);
		this.artist = artist;
		this.tracks = tracks;
	}
	public String getArtist() {
		return artist;
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
    
    public List<Track> getTracks() {
		return tracks;
	}
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
    @Override
    public void play() {
        System.out.println("Artist: " + artist);
        for (Track track : tracks) {
            track.play();
        }
    }
    
    @Override
    public String toString() {
        return this.id + ". " + "CD" + " - " + this.getTitle() 
        	+ " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getArtist() + " - " 
        	+ ": " + this.getCost() + " $";
    }
	
    @Override
    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }
}
