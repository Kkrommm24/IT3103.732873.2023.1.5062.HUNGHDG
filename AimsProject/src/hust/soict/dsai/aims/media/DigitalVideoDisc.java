package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }
	
	 // Constructor 1: Create a DVD object by title
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor 2: Create a DVD object by category, title, and cost
    public DigitalVideoDisc(String title , String category, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

	// Constructor 3: Create a DVD object by director, category, title, and cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor 4: Create a DVD object by all attributes: title, category, director, length, and cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }
    
    //// Constructor 5:
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
	}
	public void printDetail(){
        System.out.println("------ DigitalVideoDisc Detail ------");
        System.out.println(title + " " + " " + category + " " + director + " " + length + " " + cost);
    }
    
    @Override
    public String toString() {
    	
        return this.id + ". " + "DVD" + " - " + this.getTitle() 
        	+ " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() 
        	+ ": " + this.getCost() + " $";
    }
    
    public boolean isMatch(String searchString) {
        String lowercaseTitle = title.toLowerCase();
        String lowercaseSearchString = searchString.toLowerCase();
        return lowercaseTitle.contains(lowercaseSearchString);
    }
    
    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
