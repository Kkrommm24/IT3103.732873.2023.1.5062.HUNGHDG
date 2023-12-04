package hust.soict.dsai.aims.media;

public class Disc extends Media {
	protected int length;
    protected String director;
	public String getDirector() {
		return director;
	}
	
	public Disc() {

    }
	
	public Disc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost);
        this.director = director;
    }
	public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }
	
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public boolean isMatch(String title) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
