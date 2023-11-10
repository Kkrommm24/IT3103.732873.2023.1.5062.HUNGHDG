package Lab02.src.hunghdg5062;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
//	public void DigitalVdeoDisc(String title, String category, String director, int length, float cost ){
//		this.title = title;
//		this.category = category;
//		this.director = director;
//		this.length = length;
//		this.cost = cost;
//	}
	
	 // Constructor 1: Create a DVD object by title
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // Constructor 2: Create a DVD object by category, title, and cost
    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // Constructor 3: Create a DVD object by director, category, title, and cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // Constructor 4: Create a DVD object by all attributes: title, category, director, length, and cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
}
